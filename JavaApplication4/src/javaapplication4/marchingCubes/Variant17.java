/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4.marchingCubes;

import Objects.Point;
import Objects.Triangle;

/**
 *
 * @author Ekaterem
 */
public class Variant17 implements IVariant {
    private String Vertex;
    private Point vertex0;
    
    public String getVertex()
    {
        return Vertex;
    }
    
    public Point getVertex0()
    {
        return vertex0;
    }
    
    public void setVertex(String line)
    {
        Vertex=line;
    }
    
    public void setVertex0(Point point)
    {
        vertex0=point;
    }
    
    public Variant17(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }
    
    @Override
    public Triangle[] chose() {
        switch(Vertex){
            case "01011110": return Variant17_1();
            case "10101101": return Variant17_2();
            case "11011010": return Variant17_3();
            case "11100101": return Variant17_4();
            case "01011011": return Variant17_5();
            case "10110101": return Variant17_6();
            case "01111010": return Variant17_7();
            default: return Variant17_8();
        }
    }
    
    private Triangle[] Variant17_1()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant17_2()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant17_3()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant17_4()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant17_5()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant17_6()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant17_7()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant17_8()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
}
