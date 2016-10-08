package javaapplication4.marchingCubes;
import Objects.*;

/**
 *
 * @author Dima
 */
public class Variant16 implements IVariant
{
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
    
    public Variant16(String line, Point point)
    {
        setVertex(line);
        setVertex0(point);
    }
    
    @Override
    public Triangle[] chose() {
        switch(Vertex){
            case "01011101": return Variant16_1();
            case "11000111": return Variant16_2();
            case "11101010": return Variant16_3();
            case "10111100": return Variant16_4();
            case "11101001": return Variant16_5();
            case "10111010": return Variant16_6();
            case "10010111": return Variant16_7();
            case "10101011": return Variant16_8();
            case "01010111": return Variant16_9();
            case "10101110": return Variant16_10();
            case "10110110": return Variant16_11();
            case "11010011": return Variant16_12();
            case "00111110": return Variant16_13();
            case "01111100": return Variant16_14();
            case "01110101": return Variant16_15();
            case "11010101": return Variant16_16();
            case "00111101": return Variant16_17();
            case "11001011": return Variant16_18();
            case "11100011": return Variant16_19();
            case "01111001": return Variant16_20();
            case "01101011": return Variant16_21();
            case "10011110": return Variant16_22();
            case "11010110": return Variant16_23();
            case "01101101": return Variant16_24();
            default: return new Triangle[0];
        }
    }
    
    private Triangle[] Variant16_1()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0))};
        return result;
    }
    
    private Triangle[] Variant16_2()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e5(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0))};
        return result;
    }
    
    private Triangle[] Variant16_3()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    } 
    
    private Triangle[] Variant16_4()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e10(vertex0))};
        return result;
    } 
    
    private Triangle[] Variant16_5()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0))};
        return result;
    } 
    
    private Triangle[] Variant16_6()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e8(vertex0))};
        return result;
    }
    
    private Triangle[] Variant16_7()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    } 
    
    private Triangle[] Variant16_8()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e11(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0))};
        return result;
    } 
    
    private Triangle[] Variant16_9()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e1(vertex0))};
        return result;
    }    
    
    private Triangle[] Variant16_10()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e7(vertex0))};
        return result;
    }    
    
    private Triangle[] Variant16_11()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e5(vertex0))};
        return result;
    } 
    
    private Triangle[] Variant16_12()
    {
        Triangle[] result = {new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e2(vertex0))};
        return result;
    } 
    
    private Triangle[] Variant16_13()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e8(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_14()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e1(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e9(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_15()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e5(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_16()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e4(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e9(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e2(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_17()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_18()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e4(vertex0), MiddlePoint.e2(vertex0)),
            new Triangle(MiddlePoint.e7(vertex0), MiddlePoint.e2(vertex0), MiddlePoint.e10(vertex0))
        };
        return result;
    }
    private Triangle[] Variant16_19()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e8(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e6(vertex0), MiddlePoint.e8(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e6(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e3(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e4(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_20()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e7(vertex0)),
            new Triangle(MiddlePoint.e4(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e9(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_21()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e1(vertex0), MiddlePoint.e10(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e5(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_22()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e10(vertex0), MiddlePoint.e12(vertex0)),
            new Triangle(MiddlePoint.e8(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_23()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e5(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e9(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e7(vertex0), MiddlePoint.e5(vertex0)),
            new Triangle(MiddlePoint.e2(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e7(vertex0))
        };
        return result;
    }
    
    private Triangle[] Variant16_24()
    {
        Triangle[] result = {
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e12(vertex0), MiddlePoint.e3(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e3(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e1(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e9(vertex0), MiddlePoint.e11(vertex0)),
            new Triangle(MiddlePoint.e6(vertex0), MiddlePoint.e11(vertex0), MiddlePoint.e7(vertex0))
        };
        return result;
    }
}
