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
public class Variant13 implements IVariant {
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
    
    public Variant13(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }
    
    @Override
    public Triangle[] chose() {
        switch(Vertex){
            case "10001110": return Variant13_1();
            case "11001001": return Variant13_2();
            case "11010100": return Variant13_3();
            case "01101100": return Variant13_4();
            case "01110001": return Variant13_5();
            case "01000111": return Variant13_6();
            case "00011101": return Variant13_7();
            case "10111000": return Variant13_8();
            case "11100010": return Variant13_9();
            case "00101011": return Variant13_10();
            case "00110110": return Variant13_11();
            default: return Variant13_12();
        }
    }
    
    private Triangle[] Variant13_1()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_2()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_3()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e6(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_4()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e8(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_5()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_6()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_7()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_8()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_9()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_10()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_11()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant13_12()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    
}
