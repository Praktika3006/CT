package javaapplication4.Objects;
/**
 *
 * @author Dima
 */
public class Triangle {
    private Point First;
    private Point Second;
    private Point Third;
    
    public Point getFirst(){
        return First;
    }
    
    public Point getSecond(){
        return Second;
    }
    
    public Point getThird(){
        return Third;
    }
    
    public void setFirst(Point first){
        First = first;
    }
    public void setSecond(Point second){
        Second = second;
    }
    public void setThird(Point third){
        Third = third;
    }
    public Triangle(Point first, Point second, Point third){
        setFirst(first);
        setSecond(second);
        setThird(third);        
    }
}