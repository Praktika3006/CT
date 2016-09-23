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
public class Point {
    private int x = 0;
    private int y = 0;
    private int z = 0;
    
    public Point(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public int GetX()
    {
        return this.x;
    }
    
    public int GetY()
    {
        return this.y;
    }
    
    public int GetZ()
    {
        return this.z;
    }
    
    public void SetX(int x)
    {
        this.x = x;
    }
    
    public void SetY(int y)
    {
        this.y = y;
    }
    
    public void SetZ(int z)
    {
        this.z = z;
    } 
}
