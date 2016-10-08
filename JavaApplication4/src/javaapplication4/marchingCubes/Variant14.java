package javaapplication4.marchingCubes;
import Objects.*;

/**
 *
 * @author Dima
 */
public class Variant14 implements IVariant {
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
    
    public Variant14(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }

    @Override
    public Triangle[] chose() {
        switch (vertex){
        case "10001101": return Variant14_1();
        case "11100100": return Variant14_2();
        case "01001110": return Variant14_3();
        case "11011000": return Variant14_4();
        case "00011011": return Variant14_5();
        case "00100111": return Variant14_6();
        case "01110010": return Variant14_7();
        case "10110001": return Variant14_8();
        default: return new Triangle[0];
        }
    }
    
    private Triangle[] Variant14_1()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }
    
    private Triangle[] Variant14_2()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant14_3()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e2(vertex0))};
        return result;
    }
    
    private Triangle[] Variant14_4()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }
    
    private Triangle[] Variant14_5()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant14_6()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    }
    
    private Triangle[] Variant14_7()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }
    
    private Triangle[] Variant14_8()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    }
}