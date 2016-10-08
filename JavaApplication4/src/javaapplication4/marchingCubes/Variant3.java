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
public class Variant3 implements IVariant{
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
    
    public Variant3(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }
    
    @Override
    public Triangle[] chose() {
        switch(Vertex){
            case "10001000": return Variant3_1();
            case "00001100": return Variant3_2();
            case "01000100": return Variant3_3();
            case "11000000": return Variant3_4();
            case "10010000": return Variant3_5();
            case "00001001": return Variant3_6();
            case "00000110": return Variant3_7();
            case "01100000": return Variant3_8();
            case "00110000": return Variant3_9();
            case "00010001": return Variant3_10();
            case "00000011": return Variant3_11();
            case "00100010": return Variant3_12();
            case "01110111": return Variant3_13();
            case "11110011": return Variant3_14();
            case "10111011": return Variant3_15();
            case "00111111": return Variant3_16();
            case "01101111": return Variant3_17();
            case "11110110": return Variant3_18();
            case "11111001": return Variant3_19();
            case "10011111": return Variant3_20();
            case "11001111": return Variant3_21();
            case "11101110": return Variant3_22();
            case "11111100": return Variant3_23();
            default: return Variant3_24();
        }
    }
    
    private Triangle[] Variant3_1()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e4(vertex0),MiddlePoint.e5(vertex0),MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e1(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant3_2()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e10(vertex0))};
        return tr;
    }
    
    private Triangle[] Variant3_3()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e6(vertex0),MiddlePoint.e5(vertex0),MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0),MiddlePoint.e2(vertex0),MiddlePoint.e6(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_4()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e2(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_5()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e11(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_6()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e5(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e7(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_7()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e5(vertex0),MiddlePoint.e10(vertex0),MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_8()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e10(vertex0),MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_9()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0),MiddlePoint.e11(vertex0),MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_10()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e8(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_11()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e11(vertex0),MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e6(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_12()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e7(vertex0),MiddlePoint.e6(vertex0),MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e7(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_13()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0),MiddlePoint.e5(vertex0),MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_14()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e10(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e8(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_15()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0),MiddlePoint.e5(vertex0),MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0),MiddlePoint.e2(vertex0),MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_16()
    {
        Triangle[] tr = {
           new Triangle(MiddlePoint.e2(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e10(vertex0)),
           new Triangle(MiddlePoint.e4(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e2(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_17()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_18()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0),MiddlePoint.e9(vertex0),MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_19()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e10(vertex0),MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_20()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e3(vertex0),MiddlePoint.e10(vertex0),MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_21()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e11(vertex0),MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0),MiddlePoint.e4(vertex0),MiddlePoint.e2(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_22()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e3(vertex0),MiddlePoint.e7(vertex0),MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e8(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_23()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e6(vertex0),MiddlePoint.e8(vertex0),MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0),MiddlePoint.e11(vertex0),MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant3_24()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0),MiddlePoint.e6(vertex0),MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0),MiddlePoint.e3(vertex0),MiddlePoint.e2(vertex0))
        };
        return tr;
    }
}
