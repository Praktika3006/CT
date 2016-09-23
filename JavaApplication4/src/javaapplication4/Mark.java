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
public class Mark {
    private float value;
    private boolean type;
    
    public Mark(float v, boolean t)
    {
        this.value = v;
        this.type = t;
    }
    
    public float GetValue()
    {
        return this.value;
    }
    
    public boolean GetType()
    {
        return this.type;
    }
        
    public void SetValue(float v)
    {
        this.value = v;
    }
    
    public void SetType(boolean t)
    {
        this.type = t;
    }
}
