package javaapplication4.marchingCubes;
import javaapplication4.Objects.*;

/**
 *
 * @author Dima
 */
public class Variant0 implements IVariant{

    @Override
    public Triangle[] chose(String string, Point point0) {
        switch(string){
            case"00000000": return Variant0_1();
            default: return Variant0_2();
        }
    }
    
    private Triangle[] Variant0_1()
    {
        return new Triangle[0];
    }
    
    private Triangle[] Variant0_2()
    {
        return new Triangle[0];
    }
}
