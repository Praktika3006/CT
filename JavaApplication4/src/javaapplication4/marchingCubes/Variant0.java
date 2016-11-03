package javaapplication4.marchingCubes;
import java.util.LinkedList;
import javaapplication4.Objects.*;

/**
 *
 * @author Dima
 */
public class Variant0 {
    private Point vertex0;
    
    public LinkedList<Triangle> chose(String string, Point point0) {
        this.vertex0 = point0;
        LinkedList<Triangle> tr = null;
        switch(string){
            case "00000000": 
                tr = Variant0_1();
                break;
            case "11111111": 
                tr = Variant0_2();
                break;
        }
        return tr;
    }
    
    private LinkedList<Triangle> Variant0_1()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        return tr;
    }
    
    private LinkedList<Triangle> Variant0_2()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        return tr;
    }
}
