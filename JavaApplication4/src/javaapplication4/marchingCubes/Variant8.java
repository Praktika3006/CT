package javaapplication4.marchingCubes;

import Objects.*;

/**
 *
 * @author Dima
 */

//TODO реализованноо 16/24

public class Variant8 implements IVariant {
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
    
    public Variant8(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }

    @Override
    public Triangle[] chose() {
        switch (vertex){
        case "01011100": return Variant8_1();
        case "11000101": return Variant8_2();
        case "11001010": return Variant8_3();
        case "10101100": return Variant8_4();
        case "10100011": return Variant8_5();
        case "00111010": return Variant8_6();
        case "00110101": return Variant8_7();
        case "01010011": return Variant8_8();
        case "10011010": return Variant8_9();
        case "11100001": return Variant8_10();
        case "01010110": return Variant8_11();
        case "00101101": return Variant8_12();
        case "10010101": return Variant8_13();
        case "01111000": return Variant8_14();
        case "10100110": return Variant8_15();
        default: return Variant8_16();
        }
    }
    
    private Triangle[] Variant8_1()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e2(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_2()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_3()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_4()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_5()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_6()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_7()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e2(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_8()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_9()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_10()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_11()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e1(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_12()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_13()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_14()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_15()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0))};
        return result;
    }
    
    private Triangle[] Variant8_16()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0))};
        return result;
    }
    
}