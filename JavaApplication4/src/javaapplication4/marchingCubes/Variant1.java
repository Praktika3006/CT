/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4.marchingCubes;

import java.util.ArrayList;
import java.util.LinkedList;
import javaapplication4.Objects.Point;
import javaapplication4.Objects.Triangle;

/**
 *
 * @author Ekaterem
 */
public class Variant1 {
    private Point vertex0;

    public LinkedList<Triangle> chose(String string, Point point0) {
        this.vertex0 = point0;
        LinkedList<Triangle> tr = null;
        switch(string){
            case "10000000": 
                tr = Variant1_1();
                break;
            case "01000000": 
                tr = Variant1_2();
                break;
            case "00100000": 
                tr = Variant1_3();
                break;
            case "00010000": 
                tr = Variant1_4();
                break;
            case "00001000": 
                tr = Variant1_5();
                break;
            case "00000100": 
                tr =  Variant1_6();
                break;
            case "00000010":
                tr =  Variant1_7();
                break;
            case "00000001": 
                tr =  Variant1_8();
                break;
            case "01111111": 
                tr =  Variant1_9();
                break;
            case "10111111": 
                tr =  Variant1_10();
                break;
            case "11011111": 
                tr =  Variant1_11();
                break;
            case "11101111": 
                tr =  Variant1_12();
                break;
            case "11110111": 
                tr =  Variant1_13();
                break;
            case "11111011": 
                tr =  Variant1_14();
                break;
            case "11111101": 
                tr =  Variant1_15();
                break;
            case "11111110": 
                tr = Variant1_16();
                break;
        }
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_1()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e9(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e1(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_2()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e1(vertex0),MiddlePoint.e2(vertex0),MiddlePoint.e10(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_3()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e2(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e12(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_4()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e3(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e11(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_5()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e8(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e5(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_6()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e10(vertex0),MiddlePoint.e6(vertex0),MiddlePoint.e5(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_7()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e6(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_8()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e11(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e7(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_9()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e9(vertex0),MiddlePoint.e1(vertex0),MiddlePoint.e4(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_10()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e10(vertex0),MiddlePoint.e2(vertex0),MiddlePoint.e1(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_11()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e2(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_12()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e11(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e3(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_13()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e9(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e5(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_14()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e5(vertex0),MiddlePoint.e6(vertex0),MiddlePoint.e10(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_15()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e6(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e12(vertex0)));
        return tr;
    }
    
    private LinkedList<Triangle> Variant1_16()
    {
        LinkedList<Triangle> tr = new LinkedList<Triangle>();
        tr.add(new Triangle(MiddlePoint.e7(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e11(vertex0)));
        return tr;
    }
}
