package javaapplication4.marchingCubes;
import javaapplication4.Objects.*;

/**
 *
 * @author Dima
 */
public class MiddlePoint {
    
    private static final float StepX = 1.0f;
    private static final float StepY = 1.0f;
    private static final float StepZ = 1.0f;
    private static final float Middle = 0.5f;
    private Point Vertex;
    
    public Point getVrtex()
    {
        return Vertex;
    }
    
    public void setVertex(Point vertex)
    {
        Vertex=vertex;
    }
    
    public MiddlePoint(Point vertex)
    {
        setVertex(vertex);
    }
    
    public static Point e1(Point vertex)
    {
        return(new Point(vertex.getX() + Middle, 
                vertex.getY(), 
                vertex.getZ(), 
                vertex.getColorR(), 
                vertex.getColorG(),
                vertex.getColorB()));
    }
    
    public static Point e2(Point vertex)
    {
        return(new Point(vertex.getX() + StepX, 
                vertex.getY() + Middle, 
                vertex.getZ(), 
                vertex.getColorR(), 
                vertex.getColorG(), 
                vertex.getColorB()));
    }
    
    public static Point e3(Point vertex)
    {
        return(new Point(vertex.getX() + Middle, 
                vertex.getY() + StepY, 
                vertex.getZ(), 
                vertex.getColorR(), 
                vertex.getColorG(), 
                vertex.getColorB()));
    }
    
    public static Point e4(Point vertex)
    {
        return(new Point(vertex.getX(), 
                vertex.getY() + Middle, 
                vertex.getZ(), 
                vertex.getColorR(), 
                vertex.getColorG(),
                vertex.getColorB()));
    }
    
    public static Point e5(Point vertex)
    {
        return(new Point(vertex.getX() + Middle, 
                vertex.getY(), 
                vertex.getZ() + StepZ, 
                vertex.getColorR(), 
                vertex.getColorG(), 
                vertex.getColorB()));
    }
    
    public static Point e6(Point vertex)
    {
        return(new Point(vertex.getX() + StepX, 
                vertex.getY() + Middle, 
                vertex.getZ() + StepZ,
                vertex.getColorR(),
                vertex.getColorG(), 
                vertex.getColorB()));
    }
    
    public static Point e7(Point vertex)
    {
        return(new Point(vertex.getX() + Middle, 
                vertex.getY() + StepY, 
                vertex.getZ() + StepZ,
                vertex.getColorR(), 
                vertex.getColorG(),
                vertex.getColorB()));
    }
    
    public static Point e8(Point vertex)
    {
        return(new Point(vertex.getX(), 
                vertex.getY() + Middle, 
                vertex.getZ() + StepZ, 
                vertex.getColorR(), 
                vertex.getColorG(), 
                vertex.getColorB()));
    }
    
    public static Point e9(Point vertex)
    {
        return(new Point(vertex.getX(), 
                vertex.getY(), 
                vertex.getZ() + Middle, 
                vertex.getColorR(), 
                vertex.getColorG(),
                vertex.getColorB()));
    }
    
    public static Point e10(Point vertex)
    {
        return(new Point(vertex.getX() + StepX, 
                vertex.getY(), 
                vertex.getZ() + Middle, 
                vertex.getColorR(), 
                vertex.getColorG(),
                vertex.getColorB()));
    }
    
    public static Point e11(Point vertex)
    {
        return(new Point(vertex.getX(), 
                vertex.getY() + StepX, 
                vertex.getZ() + Middle, 
                vertex.getColorR(), 
                vertex.getColorG(), 
                vertex.getColorB()));
    }
    
    public static Point e12(Point vertex)
    {
        return(new Point(vertex.getX() + StepX, 
                vertex.getY() + StepY, 
                vertex.getZ() + Middle,
                vertex.getColorR(),
                vertex.getColorG(),
                vertex.getColorB()));
    }
}
