/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;

/**
 *
 * @author stiv
 */
public class Test {
    public static void main(String[] args)
    {
        long st, en;
        float[][][] b0 = new float[512][512][512];
        float[][][] b = new float[512][512][512];
        
        System.out.println(b0[0][0][0]);
        
        st = System.nanoTime();
        
        for(int z = 0; z < 512; z++)
             for(int y = 0; y < 512; y++)
                 for(int x = 0; x < 512; x++)
                     b[z][y][x] = b0[z][y][x];
        
        en = System.nanoTime();
        System.out.println(en - st);
        
        
        b0[0][0][0] = 3;
        
        System.out.println(b0[0][0][0]);
        System.out.println(b[0][0][0]);
    }

    
}
