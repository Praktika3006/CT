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
public class Variant1 implements IVariant {
    private Point vertex0;

    @Override
    public Triangle[] chose(String string, Point point0) {
        this.vertex0 = point0;
        switch(string){
            case "10000000": return Variant1_1();
            case "01000000": return Variant1_2();
            case "00100000": return Variant1_3();
            case "00010000": return Variant1_4();
            case "00001000": return Variant1_5();
            case "00000100": return Variant1_6();
            case "00000010": return Variant1_7();
            case "00000001": return Variant1_8();
            case "01111111": return Variant1_9();
            case "10111111": return Variant1_10();
            case "11011111": return Variant1_11();
            case "11101111": return Variant1_12();
            case "11110111": return Variant1_13();
            case "11111011": return Variant1_14();
            case "11111101": return Variant1_15();
            default: return Variant1_16();
        }
    }
    
    private Triangle[] Variant1_1()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e9(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e1(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_2()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e1(vertex0),MiddlePoint.e2(vertex0),MiddlePoint.e10(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_3()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e2(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e12(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_4()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e3(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e11(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_5()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e8(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e5(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_6()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e10(vertex0),MiddlePoint.e6(vertex0),MiddlePoint.e5(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_7()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e6(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_8()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e11(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e7(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_9()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e9(vertex0),MiddlePoint.e1(vertex0),MiddlePoint.e4(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_10()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e10(vertex0),MiddlePoint.e2(vertex0),MiddlePoint.e1(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_11()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e2(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_12()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e11(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e3(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_13()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e9(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e5(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_14()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e5(vertex0),MiddlePoint.e6(vertex0),MiddlePoint.e10(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_15()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e6(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e12(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant1_16()
    {
        Triangle[] tr = {new Triangle(MiddlePoint.e7(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e11(vertex0))};
        return tr;
    }
}
