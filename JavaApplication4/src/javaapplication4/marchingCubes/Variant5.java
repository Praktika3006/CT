/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4.marchingCubes;

import Objects.*;

/**
 *
 * @author Ekaterem
 */
public class Variant5 implements IVariant{
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
    
    public Variant5(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }
    
    @Override
    public Triangle[] chose() {
        switch(Vertex){
            case "01001100": return Variant5_1();
            case "10001100": return Variant5_2();
            case "11001000": return Variant5_3();
            case "11000100": return Variant5_4();
            case "01100010": return Variant5_5();
            case "00100110": return Variant5_6();
            case "01000110": return Variant5_7();
            case "01100100": return Variant5_8();
            case "00001011": return Variant5_9();
            case "00000111": return Variant5_10();
            case "00001110": return Variant5_11();
            case "00001101": return Variant5_12();
            case "10001001": return Variant5_13();
            case "10011000": return Variant5_14();
            case "00011001": return Variant5_15();
            case "10010001": return Variant5_16();
            case "10110000": return Variant5_17();
            case "01110000": return Variant5_18();
            case "11100000": return Variant5_19();
            case "11010000": return Variant5_20();
            case "00010011": return Variant5_21();
            case "00100011": return Variant5_22();
            case "00110010": return Variant5_23();
            case "00110001": return Variant5_24();
            case "10110011": return Variant5_25();
            case "01110011": return Variant5_26();
            case "00110111": return Variant5_27();
            case "00111011": return Variant5_28();
            case "10011101": return Variant5_29();
            case "11011001": return Variant5_30();
            case "10111001": return Variant5_31();
            case "10011011": return Variant5_32();
            case "11110100": return Variant5_33();
            case "11111000": return Variant5_34();
            case "11110001": return Variant5_35();
            case "11110010": return Variant5_36();
            case "01110110": return Variant5_37();
            case "01100111": return Variant5_38();
            case "11100110": return Variant5_39();
            case "01101110": return Variant5_40();
            case "01001111": return Variant5_41();
            case "10001111": return Variant5_42();
            case "00011111": return Variant5_43();
            case "00101111": return Variant5_44();
            case "11101100": return Variant5_45();
            case "11011100": return Variant5_46();
            case "11001101": return Variant5_47();
            default: return Variant5_48();        
        }
    }
    
    private Triangle[] Variant5_1()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0),  MiddlePoint.e6(vertex0),  MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0),  MiddlePoint.e8(vertex0),  MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0),  MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_2()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e4(vertex0),   MiddlePoint.e6(vertex0),  MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0),  MiddlePoint.e4(vertex0),  MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0),  MiddlePoint.e6(vertex0),  MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_3()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0),  MiddlePoint.e4(vertex0),  MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0),  MiddlePoint.e8(vertex0),  MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0),  MiddlePoint.e8(vertex0),   MiddlePoint.e10(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_4()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_5()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_6()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0), MiddlePoint. e3(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e10(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_7()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_8()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_9()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_10()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_11()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_12()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e10(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_13()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint. e11(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_14()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_15()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    private Triangle[] Variant5_16()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint. e7(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_17()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_18()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_19()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint. e10(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint. e9(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_20()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e2(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_21()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_22()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e2(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_23()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint. e11(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_24()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_25()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_26()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_27()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_28()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_29()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e10(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_30()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_31()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_32()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint. e3(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_33()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_34()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint. e10(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_35()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_36()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_37()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_38()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e5(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_39()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    private Triangle[] Variant5_40()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_41()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_42()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e1(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_43()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_44()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint. e11(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_45()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_46()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e2(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_47()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0))
        };
        return tr;
    }
    
    private Triangle[] Variant5_48()
    {
        Triangle[] tr = {
            new Triangle(MiddlePoint. e8(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e2(vertex0))
        };
        return tr;
    }
}
