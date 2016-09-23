/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author Ekaterem
 */
public class Tuple {
    private float value;
    private int index;
    
    public Tuple(float v, int i)
    {
        this.value = v;
        this.index = i;
    }
    
    public float GetValue()
    {
        return this.value;
    }
    
    public int GetIndex()
    {
        return this.index;
    }
        
    public void SetValue(float v)
    {
        this.value = v;
    }
    
    public void SetType(int i)
    {
        this.index = i;
    }
}
