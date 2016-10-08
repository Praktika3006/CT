/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4.marchingCubes;

import javaapplication4.Objects.Point;
import javaapplication4.Objects.Triangle;

/**
 *
 * @author Ekaterem
 */
public class Variant11 implements IVariant {
    private Point vertex0;

    @Override
    public Triangle[] chose(String string, Point point0) {
        this.vertex0 = point0;
        switch(string){
            case "11001100": return Variant11_1();
            case "11110000": return Variant11_2();
            case "00110011": return Variant11_3();
            case "00001111": return Variant11_4();
            case "01100110": return Variant11_5();
            default: return Variant11_6();
        }
    }
    
    private Triangle[] Variant11_1()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e2(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant11_2()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant11_4()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant11_3()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e8(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant11_5()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant11_6()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0))
        };
        return tr;
    }
    
}
