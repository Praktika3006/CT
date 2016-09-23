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
public class FatDeleter {
    
    public void DeletePlusXFat(float[][][] arr, int bottomIntenceLimit, int topIntenceLimit, int maxValue)
    {
        for(int z = 0; z < arr.length; z++)
            for(int y = 0; y < arr[0].length; y++)
            {
                boolean beginFat = false;
                int count = 0;
                int countFat = 0;
                for(int x = 0; x < arr[0][0].length; x++)
                {
                    if(arr[z][y][x] >= bottomIntenceLimit && arr[z][y][x] <= topIntenceLimit)
                    {
                        if(!beginFat)
                        {
                            beginFat = true;
                            countFat++;
                        }
                        else
                        {
                            countFat++;
                        }
                    }
                    else
                    {
                        if(!beginFat)
                            count++;
                        else
                        {
                            if(countFat > maxValue)
                                break;
                            else
                            {
                                beginFat = false;
                                count += countFat;
                                countFat = 0;
                            }
                        }
                    }             
                }
                for(int x = 0; x < count; x++)
                    arr[z][y][x] = -2048;
            }
    }
    
    public void DeleteMinusXFat(float[][][] arr, int bottomIntenceLimit, int topIntenceLimit, int maxValue)
    {
        for(int z = 0; z < arr.length; z++)
            for(int y = 0; y < arr[0].length; y++)
            {
                boolean beginFat = false;
                int count = 0;
                int countFat = 0;
                for(int x = arr[0][0].length - 1; x >= 0; x--)
                {
                    if(arr[z][y][x] >= bottomIntenceLimit && arr[z][y][x] <= topIntenceLimit)
                    {
                        if(!beginFat)
                        {
                            beginFat = true;
                            countFat++;
                        }
                        else
                        {
                            countFat++;
                        }
                    }
                    else
                    {
                        if(!beginFat)
                            count++;
                        else
                        {
                            if(countFat > maxValue)
                                break;
                            else
                            {
                                beginFat = false;
                                count += countFat;
                                countFat = 0;
                            }
                        }
                    }             
                }
                for(int x = arr[0][0].length - 1; x > arr[0][0].length - 1 - count; x--)
                    arr[z][y][x] = -2048;
            }
    }
    
    public void DeletePlusYFat(float[][][] arr, int bottomIntenceLimit, int topIntenceLimit, int maxValue)
    {
        for(int z = 0; z < arr.length; z++)
            for(int x = 0; x < arr[0][0].length; x++)
            {
                boolean beginFat = false;
                int count = 0;
                int countFat = 0;
                for(int y = 0; y < arr[0].length; y++)
                {
                    if(arr[z][y][x] >= bottomIntenceLimit && arr[z][y][x] <= topIntenceLimit)
                    {
                        if(!beginFat)
                        {
                            beginFat = true;
                            countFat++;
                        }
                        else
                        {
                            countFat++;
                        }
                    }
                    else
                    {
                        if(!beginFat)
                            count++;
                        else
                        {
                            if(countFat > maxValue)
                                break;
                            else
                            {
                                beginFat = false;
                                count += countFat;
                                countFat = 0;
                            }
                        }
                    }             
                }
                for(int y = 0; y < count; y++)
                    arr[z][y][x] = -2048;
            }
    }
    
    public void DeleteMinusYFat(float[][][] arr, int bottomIntenceLimit, int topIntenceLimit, int maxValue)
    {
        for(int z = 0; z < arr.length; z++)
            for(int x = 0; x < arr[0][0].length; x++)
            {
                boolean beginFat = false;
                int count = 0;
                int countFat = 0;
                for(int y = arr[0].length - 1; y >= 0; y--)
                {
                    if(arr[z][y][x] >= bottomIntenceLimit && arr[z][y][x] <= topIntenceLimit)
                    {
                        if(!beginFat)
                        {
                            beginFat = true;
                            countFat++;
                        }
                        else
                        {
                            countFat++;
                        }
                    }
                    else
                    {
                        if(!beginFat)
                            count++;
                        else
                        {
                            if(countFat > maxValue)
                                break;
                            else
                            {
                                beginFat = false;
                                count += countFat;
                                countFat = 0;
                            }
                        }
                    }             
                }
                for(int y = arr[0].length - 1; y > arr[0].length - 1 - count; y--)
                    arr[z][y][x] = -2048;
            }
    }
}
