package javaapplication4.Objects;

public class Point {
    
    private float X;
    private float Y;
    private float Z;
    private float Color;
    
    public float getX(){
        return X;
    }
    
    public float getY(){
        return Y;
    }
    
    public float getZ(){
        return Z;
    }
    
    public float getColor(){
        return Color;
    }
    
    public void setX(float x){
        X = x;
    }
    public void setY(float y){
        Y = y;
    }
    public void setZ(float z){
        Z = z;
    }
    
    public void setColor(float color){
        Z = color;
    }
    
    public Point(float x, float y, float z, float color){
        setX(x);
        setY(y);
        setZ(z);
        setColor(color);
    }
}
