/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author stiv
 */
public class Skeletonizator {
    
    private int TRAHEA = 9000;
    private int sizeSkelet;
    
    public int SizeSkelet()
    {
        return this.sizeSkelet;
    }
    
    public void Skeletonization(float[][][] scene)
    {
        boolean[][][] binaryScene = new boolean[scene.length][scene[0].length][scene[0][0].length];
        
        int vsego = 0;
        
        ArrayList<Point> points = new ArrayList<Point>();
        
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                    if(scene[z][y][x] == this.TRAHEA)
                    {
                        binaryScene[z][y][x] = true;
                        vsego++;
                    }
        
        int count = 1;
        
        while(count != 0)
        {
            count = 0;
            //----------------------U------------------------
            for(int z = 0; z < scene.length; z++)
                for(int y = 0; y < scene[0].length; y++)
                    for(int x = 0; x < scene[0][0].length; x++)
                    {
                        if(binaryScene[z][y][x] == true)
                        {
                            String neighbors = this.GetPointNeighbors(x, y, z, binaryScene);
                            if(this.IsDeletableU(neighbors))
                            {
                                //count++;
                                //binaryScene[z][y][x] = false;
                                points.add(new Point(x, y, z));
                            }
                        }
                    }
            for(Point p : points)
            {
                if(binaryScene[p.GetZ()][p.GetY()][p.GetX()])
                {
                    binaryScene[p.GetZ()][p.GetY()][p.GetX()] = false;
                    count++;
                }
            }
            points.clear();
            
            //----------------------D------------------------
            for(int z = 0; z < scene.length; z++)
                for(int y = 0; y < scene[0].length; y++)
                    for(int x = 0; x < scene[0][0].length; x++)
                    {
                        if(binaryScene[z][y][x] == true)
                        {
                            String neighbors = this.GetPointNeighbors(x, y, z, binaryScene);
                            if(this.IsDeletableD(neighbors))
                            {
                                //count++;
                                //binaryScene[z][y][x] = false;
                                points.add(new Point(x, y, z));
                            }
                        }
                    }
            for(Point p : points)
            {
                if(binaryScene[p.GetZ()][p.GetY()][p.GetX()])
                {
                    binaryScene[p.GetZ()][p.GetY()][p.GetX()] = false;
                    count++;
                }
            }
            points.clear();
            
            //----------------------N------------------------
            for(int z = 0; z < scene.length; z++)
                for(int y = 0; y < scene[0].length; y++)
                    for(int x = 0; x < scene[0][0].length; x++)
                    {
                        if(binaryScene[z][y][x] == true)
                        {
                            String neighbors = this.GetPointNeighbors(x, y, z, binaryScene);
                            if(this.IsDeletableN(neighbors))
                            {
                                //count++;
                                //binaryScene[z][y][x] = false;
                                points.add(new Point(x, y, z));
                            }
                        }
                    }
            for(Point p : points)
            {
                if(binaryScene[p.GetZ()][p.GetY()][p.GetX()])
                {
                    binaryScene[p.GetZ()][p.GetY()][p.GetX()] = false;
                    count++;
                }
            }
            points.clear();
            
            //----------------------E------------------------
            for(int z = 0; z < scene.length; z++)
                for(int y = 0; y < scene[0].length; y++)
                    for(int x = 0; x < scene[0][0].length; x++)
                    {
                        if(binaryScene[z][y][x] == true)
                        {
                            String neighbors = this.GetPointNeighbors(x, y, z, binaryScene);
                            if(this.IsDeletableE(neighbors))
                            {
                                //count++;
                                //binaryScene[z][y][x] = false;
                                points.add(new Point(x, y, z));
                            }
                        }
                    }
            for(Point p : points)
            {
                if(binaryScene[p.GetZ()][p.GetY()][p.GetX()])
                {
                    binaryScene[p.GetZ()][p.GetY()][p.GetX()] = false;
                    count++;
                }
            }
            points.clear();
            
            //----------------------S------------------------
            for(int z = 0; z < scene.length; z++)
                for(int y = 0; y < scene[0].length; y++)
                    for(int x = 0; x < scene[0][0].length; x++)
                    {
                        if(binaryScene[z][y][x] == true)
                        {
                            String neighbors = this.GetPointNeighbors(x, y, z, binaryScene);
                            if(this.IsDeletableS(neighbors))
                            {
                                //count++;
                                //binaryScene[z][y][x] = false;
                                points.add(new Point(x, y, z));
                            }
                        }
                    }
            for(Point p : points)
            {
                if(binaryScene[p.GetZ()][p.GetY()][p.GetX()])
                {
                    binaryScene[p.GetZ()][p.GetY()][p.GetX()] = false;
                    count++;
                }
            }
            points.clear();
            
            //----------------------W------------------------
            for(int z = 0; z < scene.length; z++)
                for(int y = 0; y < scene[0].length; y++)
                    for(int x = 0; x < scene[0][0].length; x++)
                    {
                        if(binaryScene[z][y][x] == true)
                        {
                            String neighbors = this.GetPointNeighbors(x, y, z, binaryScene);
                            if(this.IsDeletableW(neighbors))
                            {
                                //count++;
                                //binaryScene[z][y][x] = false;
                                points.add(new Point(x, y, z));
                            }
                        }
                    }
            
            for(Point p : points)
            {
                if(binaryScene[p.GetZ()][p.GetY()][p.GetX()])
                {
                    binaryScene[p.GetZ()][p.GetY()][p.GetX()] = false;
                    count++;
                }
            }
            points.clear();
            
            vsego = vsego - count;
            
            System.out.print("Осталось: " + vsego);
            System.out.println(" Удалено: " + count);
        }
        sizeSkelet = vsego;
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                    if(binaryScene[z][y][x] == true)
                        scene[z][y][x] = 9999;
    }
    
    
    private String GetPointNeighbors(int xp, int yp, int zp, boolean[][][] scene)
    {
        // ----0------
        String result = "1";
        
        // ----1------
        if(xp - 1 >= 0 && yp - 1 >= 0 && zp + 1 < scene.length)
        {
            if(scene[zp + 1][yp - 1][xp - 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----2------
        if(yp - 1 >= 0 && zp + 1 < scene.length)
        {
            if(scene[zp + 1][yp - 1][xp] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----3------
        if(xp + 1 < scene[0][0].length && yp - 1 >= 0 && zp + 1 < scene.length)
        {
            if(scene[zp + 1][yp - 1][xp + 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----4------
        if(xp - 1 >= 0 && zp + 1 < scene.length)
        {
            if(scene[zp + 1][yp][xp - 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----5------
        if(zp + 1 < scene.length)
        {
            if(scene[zp + 1][yp][xp] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----6------
        if(xp + 1 < scene[0][0].length && zp + 1 < scene.length)
        {
            if(scene[zp + 1][yp][xp + 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----7------
        if(xp - 1 >= 0 && yp + 1 < scene[0].length && zp + 1 < scene.length)
        {
            if(scene[zp + 1][yp + 1][xp - 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----8------
        if(yp + 1 < scene[0].length && zp + 1 < scene.length)
        {
            if(scene[zp + 1][yp + 1][xp] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----9------
        if(xp + 1 < scene[0][0].length && yp + 1 < scene[0].length && zp + 1 < scene.length)
        {
            if(scene[zp + 1][yp + 1][xp + 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----10------
        if(xp - 1 >= 0 && yp - 1 >= 0)
        {
            if(scene[zp][yp - 1][xp - 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----11------
        if(yp - 1 >= 0)
        {
            if(scene[zp][yp - 1][xp] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----12------
        if(xp + 1 < scene[0][0].length && yp - 1 >= 0)
        {
            if(scene[zp][yp - 1][xp + 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----13------
        if(xp - 1 >= 0)
        {
            if(scene[zp][yp][xp - 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----14------
        if(xp + 1 < scene[0][0].length)
        {
            if(scene[zp][yp][xp + 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----15------
        if(xp - 1 >= 0 && yp + 1 < scene[0].length)
        {
            if(scene[zp][yp + 1][xp - 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----16------
        if(yp + 1 < scene[0].length)
        {
            if(scene[zp][yp + 1][xp] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----17------
        if(xp + 1 < scene[0][0].length && yp + 1 < scene[0].length)
        {
            if(scene[zp][yp + 1][xp + 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----18------
        if(xp - 1 >= 0 && yp - 1 >= 0 && zp - 1 >= 0)
        {
            if(scene[zp - 1][yp - 1][xp - 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----19------
        if(yp - 1 >= 0 && zp - 1 >= 0)
        {
            if(scene[zp - 1][yp - 1][xp] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----20------
        if(xp + 1 < scene[0][0].length && yp - 1 >= 0 && zp - 1 >= 0)
        {
            if(scene[zp - 1][yp - 1][xp + 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----21------
        if(xp - 1 >= 0 && zp - 1 >= 0)
        {
            if(scene[zp - 1][yp][xp - 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----22------
        if(zp - 1 >= 0)
        {
            if(scene[zp - 1][yp][xp] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----23------
        if(xp + 1 < scene[0][0].length && zp - 1 >= 0)
        {
            if(scene[zp - 1][yp][xp + 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----24------
        if(xp - 1 >= 0 && yp + 1 < scene[0].length && zp - 1 >= 0)
        {
            if(scene[zp - 1][yp + 1][xp - 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----25------
        if(yp + 1 < scene[0].length && zp - 1 >= 0)
        {
            if(scene[zp - 1][yp + 1][xp] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        // ----26------
        if(xp + 1 < scene[0][0].length && yp + 1 < scene[0].length && zp - 1 >= 0)
        {
            if(scene[zp - 1][yp + 1][xp + 1] == true)
                result += "1";
            else
                result += "0";
        }
        else
            result += "0";
        
        return result;                
    }
    
    private boolean IsDeletableU(String config)
    {
        
        //-----------M1---------------
        Pattern p = Pattern.compile("^1000000000[01]{12}1[01]{4}$");
        Matcher m = p.matcher(config);
        
        if(m.matches())
        {
            int count = 0;
            for(int i = 10; i <= 21; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 23; i <= 26; i++)
                if(config.charAt(i) == '1')
                    count++;
            
            if(count > 0)
                return true;
        }
        
        //-----------M2---------------
        p = Pattern.compile("^1[01]{3}000000[01]1[01]{10}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^100[01]00[01]00[01]{5}1[01]{7}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1000000[01]{9}1[01]{5}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]00[01]00[01]00[01]{3}1[01]{8}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //-----------M3---------------
        p = Pattern.compile("^1[01]{3}00[01]00[01]{2}1[01]{2}1[01]{7}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^100[01]00[01]{8}1[01]1[01]{5}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]00[01]00[01]{6}1[01]{2}1[01]{5}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}00[01]00[01]1[01]1[01]{8}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //-----------M4---------------
        p = Pattern.compile("^1001000000[01]{2}1[01]{9}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1000000001[01]{7}1[01]{4}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1000000100[01]{5}1[01]{6}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^11000000001[01]{11}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //-----------M5---------------
        p = Pattern.compile("^1000000000[01]{5}000[01]1[01]{2}0[01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 10; i <= 14; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(18) == '1')
                count++;
            for(int i = 20; i <= 21; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(23) == '1')
                count++;
            
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10000000000[01]{2}0[01]0[01]{2}0[01]{2}0010[01]{2}$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 11; i <= 12; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(14) == '1')
                count++;
            for(int i = 16; i <= 17; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 19; i <= 20; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 25; i <= 26; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^1000000000000[01]{5}000[01]0[01]{2}1[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 13; i <= 17; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(21) == '1')
                count++;
            for(int i = 23; i <= 24; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(26) == '1')
                count++;
            
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^1000000000[01]{2}0[01]0[01]{2}0[01]{2}0100[01]{2}0$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 10; i <= 11; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(13) == '1')
                count++;
            for(int i = 15; i <= 16; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 18; i <= 19; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 24; i <= 25; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        //-----------M5---------------
        p = Pattern.compile("^1000000000[01]{3}0[01]00[01]{2}1[01]00100[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^100000000000[01]0[01]{4}00[01]001[01]1[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1000000000[01]00[01]0[01]{4}00100[01]1[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1000000000[01]{4}0[01]00[01]1[01]100[01]00$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
               
        return false;
    }
    
    private boolean IsDeletableD(String config)
    {
        //--------------M1-------------------
        Pattern p = Pattern.compile("^1[01]{4}1[01]{12}0{9}$");
        Matcher m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 1; i <= 4; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 6; i <= 17; i++)
                if(config.charAt(i) == '1')
                    count++;
            
            if(count > 0)
                return true;
        }
        
        //-----------------M2----------------
        p = Pattern.compile("^1[01]{4}1[01]{5}1[01]{9}0{6}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{8}1[01]{3}0{2}[01]0{2}[01]0{2}[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{10}1[01]0{6}[01]{3}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{7}1[01]{5}0{2}[01]0{2}[01]0{2}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //-----------M3----------
        p = Pattern.compile("^1[01]{4}1[01]{5}1[01]{2}1[01]{6}00[01]00[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{8}1[01]1[01]00[01]00[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{7}1[01]{2}1[01]{2}00[01]00[01]{3}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{5}1[01]1[01]{8}00[01]00$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //----------------M4------------------
        p = Pattern.compile("^1[01]{4}1[01]{6}1[01]{5}001000000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{11}1000000001$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{9}1[01]{2}000000100$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{4}1[01]{7}100000000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //--------------M5---------------
        p = Pattern.compile("^1[01]1[01]{2}0[01]000[01]{5}0{12}$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            if(config.charAt(1) == '1')
                    count++;
            if(config.charAt(6) == '1')
                count++;
            for(int i = 3; i <= 4; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 10; i <= 14; i++)
                if(config.charAt(i) == '1')
                    count++;
            
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10[01]{2}0010[01]{2}0[01]{2}0[01]0[01]{2}0{9}$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 2; i <= 3; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(14) == '1')
                count++;
            for(int i = 8; i <= 9; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 11; i <= 12; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 16; i <= 17; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^1000[01]0[01]{2}1[01]000[01]{5}0{9}$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 6; i <= 7; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(4) == '1')
                count++;
            for(int i = 13; i <= 17; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(9) == '1')
                count++;
            
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^1[01]{2}0100[01]{2}0[01]{2}0[01]0[01]{2}0{10}$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 1; i <= 2; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(13) == '1')
                count++;
            for(int i = 7; i <= 8; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 10; i <= 11; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 15; i <= 16; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        //-----------M6------------
        p = Pattern.compile("^1[01]1[01]00100[01]{4}0[01]00[01]0{9}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^100[01]001[01]1[01]00[01]0[01]{4}0{9}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]00100[01]1[01]{2}00[01]0[01]{3}0{9}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]1[01]100[01]00[01]{4}0[01]0{11}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        return false;
    }
    
    private boolean IsDeletableN(String config)
    {
        //--------------M1-------------------
        Pattern p = Pattern.compile("^1000[01]{6}000[01]{3}1[01]000[01]{6}$");
        Matcher m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 4; i <= 9; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 13; i <= 15; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 21; i <= 26; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(17) == '1')
                    count++;
            
            if(count > 0)
                return true;
        }
        
        //-----------------M2----------------
        p = Pattern.compile("^1000[01]{6}000[01]{3}1[01]{5}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^100[01]{7}00[01]{2}1[01]1[01]00[01]{7}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{4}000[01]{3}1[01]00[01]{6}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]00[01]{7}001[01]{2}1[01]{2}00[01]{6}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //-----------M3----------
        p = Pattern.compile("^1[01]{4}1[01]{4}00[01]{2}1[01]1[01]00[01]{7}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^100[01]{7}00[01]{2}1[01]1[01]{5}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]00[01]{7}001[01]{2}1[01]{5}1[01]{4}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{4}1[01]{5}001[01]{2}1[01]{2}00[01]{6}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //----------------M4------------------
        p = Pattern.compile("^1001[01]{2}1[01]{3}000[01]{3}1[01]000[01]{6}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1000[01][01][01][01][01][01]000[01][01][01]1[01]001[01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1000[01][01][01][01][01][01]000[01][01][01]1[01]1001[01][01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^11001[01][01][01][01][01]000[01][01][01]1[01]000[01][01][01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //--------------M5---------------
        p = Pattern.compile("^1000[01][01][01][01]1[01]000[01][01][01]0[01]000000000$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            if(config.charAt(9) == '1')
                    count++;
            if(config.charAt(17) == '1')
                count++;
            for(int i = 4; i <= 7; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 13; i <= 15; i++)
                if(config.charAt(i) == '1')
                    count++;
            
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10000[01][01]0[01][01]0000[01]0010000[01][01]0[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 5; i <= 6; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(14) == '1')
                count++;
            for(int i = 8; i <= 9; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 22; i <= 23; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 25; i <= 26; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10{12}[01][01][01]0[01]000[01][01][01][01]1[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 13; i <= 15; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(17) == '1')
                count++;
            for(int i = 21; i <= 24; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(26) == '1')
                count++;
            
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^1000[01][01]0[01][01]0{4}[01]0100000[01][01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 4; i <= 5; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(13) == '1')
                count++;
            for(int i = 7; i <= 8; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 21; i <= 22; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 24; i <= 25; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        //-----------M6------------
        p = Pattern.compile("^1000[01][01][01][01]1[01]0000[01]00100000[01]00[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10{5}[01]00[01]0000[01]001000[01][01][01][01]1[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1000[01]00[01]00000[01]0100000[01][01][01][01]1[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1000[01][01][01][01]1[01]000[01]0100000[01]00[01]00$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        return false;
    }
    
    private boolean IsDeletableE(String config)
    {
        //--------------M1-------------------
        Pattern p = Pattern.compile("^1[01][01]0[01][01]0[01][01]0[01][01]010[01][01]0[01][01]0$");
        Matcher m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 1; i <= 2; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 4; i <= 5; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 7; i <= 8; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 10; i <= 11; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 15; i <= 16; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 18; i <= 19; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 21; i <= 22; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 24; i <= 25; i++)
                if(config.charAt(i) == '1')
                    count++;
            
            if(count > 0)
                return true;
        }
        
        //-----------------M2----------------
        p = Pattern.compile("^1[01][01][01][01][01]0[01][01]0[01]1[01]10[01][01]0[01][01][01][01][01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01]0[01][01]0[01][01]0[01][01]010[01][01]0[01][01][01][01]1[01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01]0[01][01]0[01][01][01][01][01]010[01]1[01][01][01]0[01][01]0[01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01][01]1[01][01][01][01][01][01]010[01][01]0[01][01]0[01][01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //-----------M3----------
        p = Pattern.compile("^1[01][01][01][01][01]0[01][01]0[01]1[01]10[01][01]0[01][01][01][01]1[01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01]0[01][01]0[01][01][01][01][01]010[01]1[01][01][01][01][01]1[01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01][01]1[01][01][01][01][01][01]010[01]1[01][01][01]0[01][01]0[01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01][01]1[01][01][01][01][01]1[01]10[01][01]0[01][01][01][01][01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //----------------M4------------------
        p = Pattern.compile("^1[01][01]0[01][01]0[01][01]0[01][01]010[01][01]0[01]11[01][01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01]0[01][01]0[01][01]0[01][01]010[01][01]0[01][01]0[01][01]0[01]11$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01]0[01][01]0[01]11[01][01]010[01][01]0[01][01]0[01][01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]11[01][01]0[01][01]0[01][01]010[01][01]0[01][01]0[01][01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //--------------M5---------------
        p = Pattern.compile("^1[01][01]0[01][01]00001[01]000000[01][01]0[01][01]0000$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            if(config.charAt(11) == '1')
                    count++;
            for(int i = 1; i <= 2; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 4; i <= 5; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 18; i <= 19; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 21; i <= 22; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10{9}[01][01]000[01][01]0[01][01]01[01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 10; i <= 11; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(22) == '1')
                count++;
            for(int i = 15; i <= 16; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 18; i <= 19; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 24; i <= 25; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^1000[01][01]0[01][01]0000001[01]0000[01][01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 4; i <= 5; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(16) == '1')
                count++;
            for(int i = 7; i <= 8; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 21; i <= 22; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 24; i <= 25; i++)
                if(config.charAt(i) == '1')
                    count++;
            
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^1[01][01]01[01]0[01][01]0[01][01]000[01][01]0{10}$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 1; i <= 2; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(5) == '1')
                count++;
            for(int i = 7; i <= 8; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 10; i <= 11; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 15; i <= 16; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        //-----------M6------------
        p = Pattern.compile("^1[01][01]0{7}1[01]000000[01][01]01[01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10{6}[01][01]0000001[01]0[01][01]01[01]0[01][01]01[01]0[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01]01[01]0[01][01]0000001[01]0000000[01][01]0$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01]01[01]0[01][01]01[01]000000[01][01]0{7}$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        return false;
    }
    
    private boolean IsDeletableS(String config)
    {
        //--------------M1-------------------
        Pattern p = Pattern.compile("^1[01]{6}000[01]1[01][01][01]000[01]{6}000$");
        Matcher m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 1; i <= 6; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(10) == '1')
                    count++;
            for(int i = 12; i <= 13; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(14) == '1')
                    count++;
            for(int i = 18; i <= 23; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        //-----------------M2----------------
        p = Pattern.compile("^1[01][01][01][01]1[01][01][01][01][01]1[01][01][01]000[01][01][01][01][01][01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{6}00[01][01]1[01][01]100[01]{7}00[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{6}000[01]1[01][01][01]000[01][01][01][01]1[01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{7}00[01]1[01]1[01][01]00[01]{7}00$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //-----------M3----------
        p = Pattern.compile("^1[01][01][01][01]1[01][01][01][01][01]1[01][01]100[01]{7}00[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{6}00[01][01]1[01][01]100[01][01][01][01][01]1[01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]{7}00[01]1[01]1[01][01]00[01][01][01][01]1[01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01][01]1[01][01][01][01][01]1[01]1[01][01]00[01]{7}00$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //----------------M4------------------
        p = Pattern.compile("^1[01][01][01][01][01]1001[01]1[01][01][01]000[01][01][01][01][01][01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01][01][01][01]000[01]1[01][01][01]000[01][01][01][01][01]1001$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01][01][01][01]000[01]1[01][01][01]000[01][01][01]1[01][01]100$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01]1[01][01]100[01]1[01][01][01]000[01][01][01][01][01][01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //--------------M5---------------
        p = Pattern.compile("^1[01]1[01][01][01][01]000[01]0[01][01][01]0000{9}$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            if(config.charAt(1) == '1')
                    count++;
            for(int i = 3; i <= 6; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(10) == '1')
                    count++;
            for(int i = 12; i <= 14; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10[01][01]0[01][01]0000010[01]0000[01][01]0[01][01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 2; i <= 3; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(14) == '1')
                count++;
            for(int i = 4; i <= 5; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 19; i <= 20; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 22; i <= 23; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10{9}[01]0[01][01][01]000[01]1[01][01][01][01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 12; i <= 14; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(10) == '1')
                count++;
            if(config.charAt(18) == '1')
                    count++;
            for(int i = 20; i <= 23; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^1[01][01]0[01][01]0000100[01]0000[01][01]0[01][01]0000$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 1; i <= 2; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(13) == '1')
                count++;
            for(int i = 4; i <= 5; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 18; i <= 19; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 21; i <= 22; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        //-----------M6------------
        p = Pattern.compile("^1[01]1[01][01][01][01]0000010[01]00000[01]00[01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^100[01]00[01]0000010[01]000[01]1[01][01][01][01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]00[01]00000100[01]0000[01]1[01][01][01][01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01]1[01][01][01][01]000100[01]0000[01]00[01]00000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        return false;
    }
    
    private boolean IsDeletableW(String config)
    {
        //--------------M1-------------------
        Pattern p = Pattern.compile("^10[01][01]0[01][01]0[01][01]0[01][01]010[01][01]0[01][01]0[01][01]0[01][01]$");
        Matcher m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 2; i <= 3; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 5; i <= 6; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 8; i <= 9; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 11; i <= 12; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 16; i <= 17; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 19; i <= 20; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 22; i <= 23; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 25; i <= 26; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        //-----------------M2----------------
        p = Pattern.compile("^1[01][01][01]0[01][01]0[01][01][01]1[01]010[01][01][01][01][01]0[01][01]0[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01][01]1[01][01][01][01]0[01][01]010[01][01]0[01][01]0[01][01]0[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10[01][01]0[01][01][01][01][01]0[01][01]01[01]1[01]0[01][01]0[01][01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10[01][01]0[01][01]0[01][01]0[01][01]010[01][01][01][01][01][01]1[01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //-----------M3----------
        p = Pattern.compile("^1[01][01][01][01]1[01][01][01][01][01]1[01]010[01][01][01][01][01]0[01][01]0[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01][01]1[01][01][01][01]0[01][01]01[01]1[01]0[01][01]0[01][01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10[01][01]0[01][01][01][01][01]0[01][01]01[01]1[01][01][01][01][01]1[01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^1[01][01][01]0[01][01]0[01][01][01]1[01]010[01][01][01][01][01][01]1[01][01][01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //----------------M4------------------
        p = Pattern.compile("^11100[01][01]0[01][01]0[01][01]010[01][01]0[01][01]0[01][01]0[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10[01][01]0[01][01]11[01]0[01][01]010[01][01]0[01][01]0[01][01]0[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10[01][01]0[01][01]0[01][01]0[01][01]010[01][01]0[01][01]0[01][01]11[01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10[01][01]0[01][01]0[01][01]0[01][01]010[01][01]11[01]0[01][01]0[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        //--------------M5---------------
        p = Pattern.compile("^10[01][01]0[01][01]0000[01]1000000[01][01]0[01][01]000$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            if(config.charAt(11) == '1')
                    count++;
            for(int i = 2; i <= 3; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 5; i <= 6; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 19; i <= 20; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 22; i <= 23; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10[01][01]0[01]10[01][01]0[01][01]000[01][01]0{9}$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 2; i <= 3; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(5) == '1')
                count++;
            for(int i = 8; i <= 9; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 11; i <= 12; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 16; i <= 17; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10000[01][01]0[01][01]000000[01]10000[01][01]0[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 5; i <= 6; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 8; i <= 9; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(16) == '1')
                    count++;
            for(int i = 22; i <= 23; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 25; i <= 26; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        p = Pattern.compile("^10{10}[01][01]000[01][01]0[01][01]0[01]10[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            int count = 0;
            for(int i = 11; i <= 12; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(config.charAt(22) == '1')
                count++;
            for(int i = 16; i <= 17; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 19; i <= 20; i++)
                if(config.charAt(i) == '1')
                    count++;
            for(int i = 25; i <= 26; i++)
                if(config.charAt(i) == '1')
                    count++;
            if(count > 0)
                return true;
        }
        
        //-----------M6------------
        p = Pattern.compile("^10[01][01]0[01]10[01][01]0[01]1000000[01][01]000000$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10[01][01]0[01]10[01][01]000000[01]10000000[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10{7}[01][01]000000[01]10[01][01]0[01]10[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        
        p = Pattern.compile("^10[01][01]0000000[01]1000000[01][01]0[01]10[01][01]$");
        m = p.matcher(config);
        if(m.matches())
        {
            return true;
        }
        return false;
    }        
}
