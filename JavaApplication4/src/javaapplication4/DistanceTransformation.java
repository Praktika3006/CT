/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.ArrayList;

/**
 *
 * @author stiv
 */
public class DistanceTransformation {
    private int[][][] distanceScene = null;
    public int[][][] skeletalDistanceMap = null;
    private Point root = null;
    
    private int B = 9995;
    private int m = 9994;
    
    public DistanceTransformation(float[][][] scene)
    {
        this.distanceScene = new int[scene.length][scene[0].length][scene[0][0].length]; 
        this.FindRoot(scene);
        
        System.out.println("Инициализация");
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                {
                    if(scene[z][y][x] < 9000)
                        distanceScene[z][y][x] = 0;
                    else
                        distanceScene[z][y][x] = 2000000;
                }
        
        System.out.println("Прямой проход");
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                {
                    this.ComputingForwardDistance(x, y, z, scene, this.distanceScene);
                }
        
        System.out.println("Обратный проход");
        for(int z = scene.length - 1; z >= 0; z--)
            for(int y = scene[0].length - 1; y >= 0 ; y--)
                for(int x = scene[0][0].length - 1; x >= 0 ; x--)
                {
                    this.ComputingBackwardDistance(x, y, z, scene, this.distanceScene);
                }
        
      
        for(int i = 0; i < 4; i++)
        {
            System.out.println("Создание карты скелета");
            this.SkeletalDistanceMap(scene, 0);
            System.out.println("Вычисление расстояний в скелете");
            this.DistancePropagation(scene);
            System.out.println("Удаление ветвей");
            this.BranchDeletion(scene, 15);
        }
        for(int i = 0; i < 4; i++)
        {
            System.out.println("Создание карты скелета");
            this.SkeletalDistanceMap(scene, 5);
            System.out.println("Вычисление расстояний в скелете");
            this.DistancePropagation(scene);
            System.out.println("Удаление ветвей");
            this.BranchDeletion(scene, 20);
        }
      
        for(int i = 0; i < 4; i++)
        {
            System.out.println("Создание карты скелета");
            this.SkeletalDistanceMap(scene, 10);
            System.out.println("Вычисление расстояний в скелете");
            this.DistancePropagation(scene);
            System.out.println("Удаление ветвей");
            this.BranchDeletion(scene, 200);
        }
   

    }
    
    private void FindRoot(float[][][] scene)
    {
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                    if(scene[z][y][x] > 9990)
                    {
                        root = new Point(x, y, z);
                        return;
                    }
    }
    
    
    
    private boolean IsDeletableLinePoint(int ox, int oy, int oz, float[][][] scene)
    {
        if(this.IsEndpoint(ox, oy, oz, scene) || this.IsBranchPoint(ox, oy, oz, scene))
            return false;
        
        int minX = 0, minY = 0, minZ = 0, maxX = 0, maxY = 0, maxZ = 0;
        
        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;
        
        if(ox + 1 >= scene[0][0].length)
            maxX = ox;
        else
            maxX = ox + 1;
        
        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;
        
        if(oy + 1 >= scene[0].length)
            maxY = oy;
        else
            maxY = oy + 1;
  
        if(oz - 1 < 0)
            minZ = 0;
        else
            minZ = oz - 1;
        
        if(oz + 1 >= scene.length)
            maxZ = oz;
        else
            maxZ = oz + 1;
        
        ArrayList<Point> points = new ArrayList<Point>();
        
        int countNeightbors = 0;
        for(int z = minZ; z <= maxZ; z++)
            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    if(scene[z][y][x] > 9990 && (x != ox || y != oy || z != oz))
                        points.add(new Point(x, y, z));
                }
        
        if(Math.sqrt(Math.pow(points.get(0).GetX() - points.get(1).GetX(), 2) + 
                        Math.pow(points.get(0).GetY() - points.get(1).GetY(), 2) +
                        Math.pow(points.get(0).GetZ() - points.get(1).GetZ(), 2)) < 1.8)
            return true;
        else
            return false;       
    }
    
    private boolean IsDeletableBranchPoint(int ox, int oy, int oz, float[][][] scene)
    {
        if(!this.IsBranchPoint(ox, oy, oz, scene))
            return false;
        
        int minX = 0, minY = 0, minZ = 0, maxX = 0, maxY = 0, maxZ = 0;
        
        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;
        
        if(ox + 1 >= scene[0][0].length)
            maxX = ox;
        else
            maxX = ox + 1;
        
        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;
        
        if(oy + 1 >= scene[0].length)
            maxY = oy;
        else
            maxY = oy + 1;
  
        if(oz - 1 < 0)
            minZ = 0;
        else
            minZ = oz - 1;
        
        if(oz + 1 >= scene.length)
            maxZ = oz;
        else
            maxZ = oz + 1;
        
        ArrayList<Point> points = new ArrayList<Point>();
        
        int countNeightbors = 0;
        for(int z = minZ; z <= maxZ; z++)
            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    if(scene[z][y][x] > 9990 && (x != ox || y != oy || z != oz))
                        points.add(new Point(x, y, z));
                }
        
        ArrayList<Point> points1 = new ArrayList<Point>();
        points1.add(points.get(0));
        ArrayList<Point> Q = new ArrayList<Point>();
        Q.add(points.get(0));
        
        while(!Q.isEmpty())
        {
            Point p = Q.get(0);
            Q.remove(p);
            
            for(Point p1 : points)
            {
                if(Math.sqrt(Math.pow(p1.GetX() - p.GetX(), 2) + 
                        Math.pow(p1.GetY() - p.GetY(), 2) +
                        Math.pow(p1.GetZ() - p.GetZ(), 2)) < 1.8)
                    if(points1.indexOf(p1) == -1)
                    {
                        points1.add(p1);
                        Q.add(p1);
                    }
            }     
        }
        
        if(points1.size() == points.size())
            return true;
        else
            return false;
    }
    
    private void ComputingForwardDistance(int xo, int yo, int zo, float[][][] b, int[][][] distanceMap)
    {
        int[] sum = new int[14];
        
        sum[13] = distanceMap[zo][yo][xo];
        
        if (xo - 1 >= 0)
            sum[12] = distanceMap[zo][yo][xo - 1] + 3;
        else
            sum[12] = 3;
        
        if (xo + 1 < b[0][0].length && yo - 1 >= 0)
            sum[11] = distanceMap[zo][yo - 1][xo + 1] + 4;
        else
            sum[11] = 4;
        
        if (yo - 1 >= 0)
            sum[10] = distanceMap[zo][yo - 1][xo] + 3;
        else
            sum[10] = 3;
        
        if (xo - 1 >= 0 && yo - 1 >= 0)
            sum[9] = distanceMap[zo][yo - 1][xo - 1] + 4;
        else
            sum[9] = 4;
        
        //++++++++++++++++++++++
        
        if (xo + 1 < b[0][0].length && yo + 1 < b[0].length && zo - 1 >= 0)
            sum[8] = distanceMap[zo - 1][yo + 1][xo + 1] + 5;
        else
            sum[8] = 5;
        
        if (yo + 1 < b[0].length && zo - 1 >= 0)
            sum[7] = distanceMap[zo - 1][yo + 1][xo] + 4;
        else
            sum[7] = 4;
        
        if (xo - 1 >= 0 && yo + 1 < b[0].length && zo - 1 >= 0)
            sum[6] = distanceMap[zo - 1][yo + 1][xo - 1] + 5;
        else
            sum[6] = 5;
        
        if (xo + 1 < b[0][0].length && zo - 1 >= 0)
            sum[5] = distanceMap[zo - 1][yo][xo + 1] + 4;
        else
            sum[5] = 4;
        
        if (zo - 1 >= 0)
            sum[4] = distanceMap[zo - 1][yo][xo] + 3;
        else
            sum[4] = 3;
        
        if (xo - 1 >= 0 && zo - 1 >= 0)
            sum[3] = distanceMap[zo - 1][yo][xo - 1] + 4;
        else
            sum[3] = 4;
        
        if (xo + 1 < b[0][0].length && yo - 1 >= 0 && zo - 1 >= 0)
            sum[2] = distanceMap[zo - 1][yo - 1][xo + 1] + 5;
        else
            sum[2] = 5;
        
        if (yo - 1 >= 0 && zo - 1 >= 0)
            sum[1] = distanceMap[zo - 1][yo - 1][xo] + 4;
        else
            sum[1] = 4;
        
        if (xo - 1 >= 0 && yo - 1 >= 0 && zo - 1 >= 0)
            sum[0] = distanceMap[zo - 1][yo - 1][xo - 1] + 5;
        else
            sum[0] = 5;
        //----------------------------------------------------
        
        int minSum = Integer.MAX_VALUE;
        for(int i : sum)
        {
            if(i < minSum)
                minSum = i;
        }
        
        distanceMap[zo][yo][xo] = minSum;
    }
    
    
    private void ComputingBackwardDistance(int xo, int yo, int zo, float[][][] b, int[][][] distanceMap)
    {
        int[] sum = new int[14];
        
        sum[0] = distanceMap[zo][yo][xo];
        
        // ------------------------------------------------
        if (xo + 1 < b[0][0].length && yo + 1 < b[0].length && zo + 1 < b.length)
            sum[13] = distanceMap[zo + 1][yo + 1][xo + 1] + 5;
        else
            sum[13] = 5;
        
        if (yo + 1 < b[0].length && zo + 1 < b.length)
            sum[12] = distanceMap[zo + 1][yo + 1][xo] + 4;
        else
            sum[12] = 4;
        
        if (xo - 1 >= 0 && yo + 1 < b[0].length && zo + 1 < b.length)
            sum[11] = distanceMap[zo + 1][yo + 1][xo - 1] + 5;
        else
            sum[11] = 5;
        
        if (xo + 1 < b[0][0].length && zo + 1 < b.length)
            sum[10] = distanceMap[zo + 1][yo][xo + 1] + 4;
        else
            sum[10] = 4;
        
        if (zo + 1 < b.length)
            sum[9] = distanceMap[zo + 1][yo][xo] + 3;
        else
            sum[9] = 3;
        
        if (xo - 1 >= 0 && zo + 1 < b.length)
            sum[8] = distanceMap[zo + 1][yo][xo - 1] + 4;
        else
            sum[8] = 4;
        
        if (xo + 1 < b[0][0].length && yo - 1 >= 0 && zo + 1 < b.length)
            sum[7] = distanceMap[zo + 1][yo - 1][xo + 1] + 5;
        else
            sum[7] = 5;
        
        if (yo - 1 >= 0 && zo + 1 < b.length)
            sum[6] = distanceMap[zo + 1][yo - 1][xo] + 4;
        else
            sum[6] = 4;
        
        if (xo - 1 >= 0 && yo - 1 >= 0 && zo + 1 < b.length)
            sum[5] = distanceMap[zo + 1][yo - 1][xo - 1] + 5;
        else
            sum[5] = 5;
        
        //++++++++++++++
        
        if (xo + 1 < b[0][0].length && yo + 1 < b[0].length)
            sum[4] = distanceMap[zo][yo + 1][xo + 1] + 4;
        else
            sum[4] = 4;
        
        if (yo + 1 < b[0].length)
            sum[3] = distanceMap[zo][yo + 1][xo] + 3;
        else
            sum[3] = 3;
        
        if (xo - 1 >= 0 && yo + 1 < b[0].length)
            sum[2] = distanceMap[zo][yo + 1][xo - 1] + 4;
        else
            sum[2] = 4;
        
        if (xo + 1 < b[0][0].length)
            sum[1] = distanceMap[zo][yo][xo + 1] + 3;
        else
            sum[1] = 3;
        
        // ------------------------------------------------
        
        int minSum = Integer.MAX_VALUE;
        for(int i : sum)
        {
            if(i < minSum)
                minSum = i;
        }
        
        distanceMap[zo][yo][xo] = minSum;
        
    }
    
    public int[][][] GetDistanceMap()
    {
        return this.distanceScene;
    }
    
    private boolean IsEndpoint(int ox, int oy, int oz, float[][][] scene)
    {
        int minX = 0, minY = 0, minZ = 0, maxX = 0, maxY = 0, maxZ = 0;
        
        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;
        
        if(ox + 1 >= scene[0][0].length)
            maxX = ox;
        else
            maxX = ox + 1;
        
        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;
        
        if(oy + 1 >= scene[0].length)
            maxY = oy;
        else
            maxY = oy + 1;
  
        if(oz - 1 < 0)
            minZ = 0;
        else
            minZ = oz - 1;
        
        if(oz + 1 >= scene.length)
            maxZ = oz;
        else
            maxZ = oz + 1;
        
        int countNeightbors = 0;
        for(int z = minZ; z <= maxZ; z++)
            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    if(scene[z][y][x] > 9990)
                        countNeightbors++;
                }
        
        if(countNeightbors == 2)
            return true;
        else
            return false;      
    }
    
    
    private boolean IsBranchPoint(int ox, int oy, int oz, float[][][] scene)
    {
        int minX = 0, minY = 0, minZ = 0, maxX = 0, maxY = 0, maxZ = 0;
        
        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;
        
        if(ox + 1 >= scene[0][0].length)
            maxX = ox;
        else
            maxX = ox + 1;
        
        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;
        
        if(oy + 1 >= scene[0].length)
            maxY = oy;
        else
            maxY = oy + 1;
  
        if(oz - 1 < 0)
            minZ = 0;
        else
            minZ = oz - 1;
        
        if(oz + 1 >= scene.length)
            maxZ = oz;
        else
            maxZ = oz + 1;
        
        int countNeightbors = 0;
        for(int z = minZ; z <= maxZ; z++)
            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    if(scene[z][y][x] == 9998)
                        countNeightbors++;
                }
        
        if(countNeightbors > 3)
            return true;
        else
            return false;      
    }
    
    
    private boolean Is0Point(int ox, int oy, int oz, int td, float[][][] scene)
    {
        if(this.IsBranchPoint(ox, oy, oz, scene) 
                && this.distanceScene[oz][oy][ox] >= td)
        {
            return true;
        }
        return false;
    }
    
    private boolean IsBPoint(int ox, int oy, int oz, int td, float[][][] scene)
    {
        if(this.IsBranchPoint(ox, oy, oz, scene) 
                && this.distanceScene[oz][oy][ox] < td)
        {
            return true;
        }
        
        if(ox == this.root.GetX() && 
                oy == this.root.GetY() && 
                oz == this.root.GetZ())
        {
            return true;
        }
        
        return false;            
    }
    
    private void SkeletalDistanceMap(float[][][] scene, int td)
    {
        this.skeletalDistanceMap = new int[scene.length][scene[0].length][scene[0][0].length];
        
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                {
                    if(scene[z][y][x] == 9998)
                    {
                        if(this.Is0Point(x, y, z, td, scene))
                            this.skeletalDistanceMap[z][y][x] = 0;
                        else
                        {
                            if(this.IsBPoint(x, y, z, td, scene))
                                this.skeletalDistanceMap[z][y][x] = 1000000;
                            else
                                this.skeletalDistanceMap[z][y][x] = 2000000;
                        }
                    }
                    else
                    {
                        this.skeletalDistanceMap[z][y][x] = 2000000;
                    }
                }
    }
    
    public void DistancePropagation(float[][][] scene)
    {
        for(int i = 0; i < 3; i++) {
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                    if(scene[z][y][x] == 9998 && this.skeletalDistanceMap[z][y][x] != 1000000)
                    {
                        this.ComputingForwardDistance(x, y, z, scene, this.skeletalDistanceMap);
                    }
        
        for(int z = scene.length - 1; z >= 0; z--)
            for(int y = scene[0].length - 1; y >= 0 ; y--)
                for(int x = scene[0][0].length - 1; x >= 0 ; x--)
                    if(scene[z][y][x] == 9998 && this.skeletalDistanceMap[z][y][x] != 1000000)
                    {
                        this.ComputingBackwardDistance(x, y, z, scene, this.skeletalDistanceMap);
                    }
        }
    }
    
    
    public void BranchDeletion(float[][][] scene, int t1)
    {
        for(int i = t1; i >= 0; i--)
        {
            for(int z = 0; z < scene.length; z++)
                for(int y = 0; y < scene[0].length; y++)
                    for(int x = 0; x < scene[0][0].length; x++)
                        if(scene[z][y][x] == 9998)
                            if(this.IsEndpoint(x, y, z, scene) || 
                                    this.IsDeletableBranchPoint(x, y, z, scene) ||
                                    this.IsDeletableLinePoint(x, y, z, scene))
                            {
                                if(this.skeletalDistanceMap[z][y][x] == i)
                                    scene[z][y][x] = 9988;
                            }
        }
    }
}
