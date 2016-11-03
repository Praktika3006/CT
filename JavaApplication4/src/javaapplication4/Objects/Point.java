package javaapplication4.Objects;

public class Point {
    
    private float X;
    private float Y;
    private float Z;
    private float ColorR;
    private float ColorG;
    private float ColorB;
    
    public float getX(){
        return X;
    }
    
    public float getY(){
        return Y;
    }
    
    public float getZ(){
        return Z;
    }
    
    public float getColorR(){
        return ColorR;
    }
    
    public float getColorG(){
        return ColorG;
    }
    
    public float getColorB(){
        return ColorB;
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
    
    public void setColorR(float colorR){
        this.ColorR = colorR;
    }
    
    public void setColorG(float colorG){
        this.ColorG = colorG;
    }
    
    public void setColorB(float colorB){
        this.ColorB = colorB;
    }
    
    public Point(float x, float y, float z, float colorR, float colorG, float colorB){
        setX(x);
        setY(y);
        setZ(z);
        setColorR(colorR);
        setColorG(colorG);
        setColorB(colorB);
    }
}
