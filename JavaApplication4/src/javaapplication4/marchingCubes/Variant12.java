package javaapplication4.marchingCubes;
import Objects.*;

/**
 *
 * @author Dima
 */

//TODO реализованно 8/12
//последний треугольник в 7

public class Variant12 implements IVariant {
    private Point vertex0;

    @Override
    public Triangle[] chose(String string, Point point0) {
        this.vertex0 = point0;
        switch (string){
            case "01001101": return Variant12_1();
            case "11000110": return Variant12_2();
            case "11101000": return Variant12_3();
            case "10011100": return Variant12_4();
            case "00101011": return Variant12_5();
            case "00110110": return Variant12_6();
            case "01110001": return Variant12_7();
            case "10010011": return Variant12_8();
            default: return new Triangle[0];
        }
    }
    
    private Triangle[] Variant12_1()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e11(vertex0))};
        return result;
    }
    
    private Triangle[] Variant12_2()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0))};
        return result;
    }
    
    private Triangle[] Variant12_3()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e4(vertex0))};
        return result;
    }
    
    private Triangle[] Variant12_4()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0))};
        return result;
    }
    
    private Triangle[] Variant12_5()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0))};
        return result;
    }
    
    private Triangle[] Variant12_6()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e2(vertex0))};
        return result;
    }
    
    //!!!! последний треугольник
    private Triangle[] Variant12_7()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }    
    
    private Triangle[] Variant12_8()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0))};
        return result;
    }
}