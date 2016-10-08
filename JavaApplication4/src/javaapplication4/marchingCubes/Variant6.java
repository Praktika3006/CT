package javaapplication4.marchingCubes;

import Objects.*;

/**
 *
 * @author Dima
 */

//TODO проверить 6_24

public class Variant6 implements IVariant {
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
    
    public Variant6(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }

    @Override
    public Triangle[] chose() {
        switch (vertex){
        case "11000010": return Variant6_1();
        case "01000101": return Variant6_2();
        case "00011100": return Variant6_3();
        case "10101000": return Variant6_4();
        case "00110100": return Variant6_5();
        case "01000011": return Variant6_6();
        case "00101100": return Variant6_7();
        case "10010100": return Variant6_8();
        case "00111000": return Variant6_9();
        case "01100001": return Variant6_10();
        case "11000001": return Variant6_11();
        case "10001010": return Variant6_12();
        case "10000110": return Variant6_13();
        case "01010100": return Variant6_14();
        case "00101001": return Variant6_15();
        case "10000011": return Variant6_16();
        case "00010110": return Variant6_17();
        case "10010010": return Variant6_18();
        case "01001001": return Variant6_19();
        case "01101000": return Variant6_20();
        case "00101010": return Variant6_21();        
        case "01010001": return Variant6_22();        
        case "10100010": return Variant6_23();
        default: return Variant6_24();
        }
    }
    
    private Triangle[] Variant6_1()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_2()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_3()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_4()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_5()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_6()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_7()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_8()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_9()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_10()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_11()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_12()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_13()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_14()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_15()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_16()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_17()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_18()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_19()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_20()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_21()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_22()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0))};
        return result;
    }
    
    private Triangle[] Variant6_23()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0))};
        return result;
    }
    
    //проверить! 
    private Triangle[] Variant6_24()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0))};
        return result;
    }
}