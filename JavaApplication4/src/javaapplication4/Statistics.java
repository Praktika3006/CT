/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author stiv
 */
public class Statistics {
    
    private int threshold = 0;
    private double[][][] varianceMap = null;
    
    private int[] dencityDistribution = null;
    private int leftDencityPeak = 0;
    private int rightBorderOfPeak = 0;
    private double ENDstandardDeviation = 0;
    private double ENDmean = 0;
    
    public double VarianceOnePoint(float[][][] arr, int ox, int oy, int oz)
    {
        int xst = 0, xend = 0, yst = 0, yend = 0, zst = 0, zend = 0;
        
        if(ox - 2 < 0)
            xst = ox;
        else
            xst = ox - 2;
        if(ox + 2 >= arr[0][0].length)
            xend = arr[0][0].length - 1 - ox;
        else
            xend = ox + 2;
        
        if(oy - 2 < 0)
            yst = oy;
        else
            yst = oy - 2;
        if(oy + 2 >= arr[0].length)
            yend = arr[0].length - 1 - oy;
        else
            yend = oy + 2;
        
        if(oz - 2 < 0)
            zst = oz;
        else
            zst = oz - 2;
        if(oz + 2 >= arr.length)
            zend = arr.length - 1 - oz;
        else
            zend = oz + 2;
        
        int count = 0;
        int summ = 0;
        
        
        for(int z = zst; z <= zend; z++)
            for(int y = yst; y <= yend; y++)
                for(int x = xst; x <= xend; x++)
                {
                    count++;
                    summ += arr[z][y][x];
                }
        
        float mean = (float)summ / (float)count;
        
        int summOfQuadr = 0;
        
        for(int z = zst; z <= zend; z++)
            for(int y = yst; y <= yend; y++)
                for(int x = xst; x <= xend; x++)
                {
                    float dev = arr[z][y][x] - mean;
                    summOfQuadr += dev * dev;
                }
        
        return (double)summOfQuadr / (double)count;
    }
    
    public boolean[][][] Variance(float[][][] arr)
    {
        varianceMap = new double[arr.length][arr[0].length][arr[0][0].length];
        
        int[] histogram = new int[10000000];
        
        for(int z = 0; z < arr.length; z++)
             for(int y = 0; y < arr[0].length; y++)
                 for(int x = 0; x < arr[0][0].length; x++)
                 {
                     if(arr[z][y][x] > -1100)
                     {
                        double variance = this.VarianceOnePoint(arr, x, y, z);
                        histogram[(int)variance] += 1;
                        varianceMap[z][y][x] = variance;
                     }
                 }
        
        int peakVariance = 0;
        int maxValue = 0;
        for(int i = 0; i < 10000000; i++)
        {
            if(histogram[i] > maxValue)
            {
                maxValue = histogram[i];
                peakVariance = i;
            }
        }
        
        int minIndex = 0;
        
        for(int i = 0; i < 10000000; i++) 
        {
            if(histogram[i] > maxValue / 10.0)
                minIndex = i;
        }
         
        this.threshold = minIndex;
        
        boolean[][][] result = new boolean[arr.length][arr[0].length][arr[0][0].length];
        for(int z = 0; z < arr.length; z++)
             for(int y = 0; y < arr[0].length; y++)
                 for(int x = 0; x < arr[0][0].length; x++)
                 {
                     if(arr[z][y][x] > -1100 && this.varianceMap[z][y][x] <= this.threshold)
                     {
                         result[z][y][x] = true;
                     }
                 }
        return result;
    }
    
    
    public boolean[][][] DencityDistribution(float[][][] arr)
    {
        this.dencityDistribution = new int[2100];
        for(int z = 0; z < arr.length; z++)
             for(int y = 0; y < arr[0].length; y++)
                 for(int x = 0; x < arr[0][0].length; x++)
                 {
                     if(this.varianceMap[z][y][x] < this.threshold && arr[z][y][x] > -1100)
                        this.dencityDistribution[(int)arr[z][y][x] + 1100] += 1;
                 }
        
        this.FindingLeftPeak();
        this.CalculatingStandardDeviation();
        
        boolean[][][] binaryScene = new boolean[arr.length][arr[0].length][arr[0][0].length];
        for(int z = 0; z < arr.length; z++)
             for(int y = 0; y < arr[0].length; y++)
                 for(int x = 0; x < arr[0][0].length; x++)
                     if(this.varianceMap[z][y][x] < this.threshold && 
                             arr[z][y][x] > -1100 &&
                             arr[z][y][x] < this.ENDmean + 2 * this.ENDstandardDeviation - 1100)
                         binaryScene[z][y][x] = true;
        return binaryScene;
    }
    
    public void FindingLeftPeak()
    {
        int dencityOfMax = -1;
        int max = 0;
        boolean leftPeakFinding = false;
        int count = 200;
        for(int i = 0; i < 2100; i++)
        {
            if(this.dencityDistribution[i] > max)
            {
                dencityOfMax = i;
                max = this.dencityDistribution[i];
            }
            
            if(dencityDistribution[i] <= dencityDistribution[i])
                count--;
            
            if(count <= 0)
                break;
        }
        this.leftDencityPeak = dencityOfMax - 1100;
        
        for(int i = this.leftDencityPeak + 1100; i < 2100; i++)
        {
            if(this.dencityDistribution[i] < 20)
            {
                this.rightBorderOfPeak = i;
                break;
            }
        }
    }
    
    private void CalculatingStandardDeviation()
    {
        double summ = 0;
        int number = 0;
        
        for(int i = 0; i < this.rightBorderOfPeak; i++)
        {
            summ += this.dencityDistribution[i] * i;
            number += this.dencityDistribution[i];
        }
        
        double mean = summ / (double)number;
        this.ENDmean = mean;
        System.out.println(mean);
        summ = 0;
        
        for(int i = 0; i < this.rightBorderOfPeak; i++)
        {
            double sqr = Math.pow(i - mean, 2);
            summ += sqr * this.dencityDistribution[i];
        }
        
        this.ENDstandardDeviation = Math.sqrt(summ / (double)number);
        System.out.println(this.ENDstandardDeviation);
    }
    
    
    
    
}
