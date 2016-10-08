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
public class Variant15 implements IVariant {
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
    
    public Variant15(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }
    
    @Override
    public Triangle[] chose() {
        switch(Vertex){
            case "01011111": return Variant15_1();
            case "10101111": return Variant15_2();
            case "11011011": return Variant15_3();
            case "10111101": return Variant15_4();
            case "11111010": return Variant15_5();
            case "11110101": return Variant15_6();
            case "01111110": return Variant15_7();
            case "11100111": return Variant15_8();
            case "10110111": return Variant15_9();
            case "01111011": return Variant15_10();
            case "11011110": return Variant15_11();
            default: return Variant15_12();
        }
    }
    
    private Triangle[] Variant15_1()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_2()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_3()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_4()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_5()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_6()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_7()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_8()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_9()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_10()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_11()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant15_12()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
}
