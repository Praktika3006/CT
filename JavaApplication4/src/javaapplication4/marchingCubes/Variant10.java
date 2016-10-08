package javaapplication4.marchingCubes;
import javaapplication4.Objects.*;

/**
 *
 * @author Dima
 */
public class Variant10 implements IVariant {
    private Point vertex0;
    
    @Override
    public Triangle[] chose(String string, Point point0) {
        this.vertex0 = point0;
        switch (string){
            case "01011010": return Variant10_1();
            case "10100101": return Variant10_2();
            default: return new Triangle[0];
        }
    }
    
    private Triangle[] Variant10_1()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    }
    
    private Triangle[] Variant10_2()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0))};
        return result;
    }
}