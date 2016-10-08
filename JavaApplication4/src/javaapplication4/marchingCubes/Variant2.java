package javaapplication4.marchingCubes;
import Objects.*;

/**
 *
 * @author Dima
 */
public class Variant2 implements IVariant{

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
    
    public Variant2(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }

    @Override
    public Triangle[] chose() {
        switch (vertex){
        case "00001010": return Variant2_1();
        case "00000101": return Variant2_2();
        case "00011000": return Variant2_3();
        case "10000001": return Variant2_4();
        case "01010000": return Variant2_5();
        case "10100000": return Variant2_6();
        case "00100100": return Variant2_7();
        case "01000010": return Variant2_8();
        case "00100001": return Variant2_9();
        case "00010010": return Variant2_10();
        case "10000100": return Variant2_11();
        default: return Variant2_12();
        }
    }
    private Triangle[] Variant2_1()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_2()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_3()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_4()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_5()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_6()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_7()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_8()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_9()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_10()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_11()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    }
    
    private Triangle[] Variant2_12()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }
}