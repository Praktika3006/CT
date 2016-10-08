package javaapplication4.marchingCubes;
import Objects.*;

/**
 *
 * @author Dima
 */
public class Variant4 implements IVariant {
    private String vertex;
    private Point vertex0;
    
    public String getVertex()
    {
        return vertex;
    }
    
    public Point getVertex0()
    {
        return vertex0;
    }
    
    public void setVertex(String line)
    {
        vertex=line;
    }
    
    public void setVertex0(Point point)
    {
        vertex0=point;
    }
    
    public Variant4(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }

    @Override
    public Triangle[] chose() {
        switch (vertex){
        case "00101000": return Variant4_1();
        case "00010100": return Variant4_2();
        case "10000010": return Variant4_3();
        case "01000001": return Variant4_4();
        case "11010111": return Variant4_5();
        case "11101011": return Variant4_6();
        case "01111101": return Variant4_7();
        default: return Variant4_8();
        }
    }
    
    private Triangle[] Variant4_1()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0))};
        return result;
    }
    
    private Triangle[] Variant4_2()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    }
    
    private Triangle[] Variant4_3()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant4_4()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0))};
        return result;
    }
    
    private Triangle[] Variant4_5()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    }
    
    private Triangle[] Variant4_6()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }
    
    private Triangle[] Variant4_7()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0))};
        return result;
    }
    
    private Triangle[] Variant4_8()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0))};
        return result;
    }
}