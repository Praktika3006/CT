/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author stiv
 */
public class MyExtractor {
    
    public int TopTraheaBorder = -1000;
    
    public int GetToptraheaIntens()
    {
        return this.TopTraheaBorder;
    }
    
    private ArrayList<Point> ObjectExtraction3D(float[][][] b, int xo, int yo, int zo, int bottomIntenceLimit, int topIntenceLimit)
    {
        float[][][] b0 = new float[b.length][b[0].length][b[0][0].length];
        ArrayList<Point> result = new ArrayList<Point>();
        ArrayDeque<Float> Q = new ArrayDeque<Float>();
        
        
        b0[zo][yo][xo] = 1;
        result.add(new Point(xo, yo, zo));
        
        //------------------------------------------------
        if(xo + 1 < b[0][0].length && yo + 1 < b[0].length && zo + 1 < b.length)
            if(b0[zo + 1][yo + 1][xo + 1] != 1 && 
                    b[zo + 1][yo + 1][xo + 1] > bottomIntenceLimit &&
                    b[zo + 1][yo + 1][xo + 1] < topIntenceLimit)
            {
                b0[zo + 1][yo + 1][xo + 1] = 1;
                result.add(new Point(xo + 1, yo + 1, zo + 1));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo + 1));
            }
        
        if(yo + 1 < b[0].length && zo + 1 < b.length)
            if(b0[zo + 1][yo + 1][xo] != 1 && 
                    b[zo + 1][yo + 1][xo] > bottomIntenceLimit &&
                    b[zo + 1][yo + 1][xo] < topIntenceLimit)
            {
                b0[zo + 1][yo + 1][xo] = 1;
                result.add(new Point(xo, yo + 1, zo + 1));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo + 1));
            }
        
        if(xo - 1 >= 0 && yo + 1 < b[0].length && zo + 1 < b.length)
            if(b0[zo + 1][yo + 1][xo - 1] != 1 && 
                    b[zo + 1][yo + 1][xo - 1] > bottomIntenceLimit &&
                    b[zo + 1][yo + 1][xo - 1] < topIntenceLimit)
            {
                b0[zo + 1][yo + 1][xo - 1] = 1;
                result.add(new Point(xo - 1, yo + 1, zo + 1));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo + 1));
            }
        
        if(xo + 1 < b[0][0].length && zo + 1 < b.length)
            if(b0[zo + 1][yo][xo + 1] != 1 && 
                    b[zo + 1][yo][xo + 1] > bottomIntenceLimit &&
                    b[zo + 1][yo][xo + 1] < topIntenceLimit)
            {
                b0[zo + 1][yo][xo + 1] = 1;
                result.add(new Point(xo + 1, yo, zo + 1));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo + 1));
            }
        
        if(zo + 1 < b.length)
            if(b0[zo + 1][yo][xo] != 1 && 
                    b[zo + 1][yo][xo] > bottomIntenceLimit &&
                    b[zo + 1][yo][xo] < topIntenceLimit)
            {
                b0[zo + 1][yo][xo] = 1;
                result.add(new Point(xo, yo, zo + 1));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo + 1));
            }
        
        if(xo - 1 >= 0  && zo + 1 < b.length)
            if(b0[zo + 1][yo][xo - 1] != 1 && 
                    b[zo + 1][yo][xo - 1] > bottomIntenceLimit &&
                    b[zo + 1][yo][xo - 1] < topIntenceLimit)
            {
                b0[zo + 1][yo][xo - 1] = 1;
                result.add(new Point(xo - 1, yo, zo + 1));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo + 1));
            }
        
        if(xo + 1 < b[0][0].length && yo - 1 >= 0 && zo + 1 < b.length)
            if(b0[zo + 1][yo - 1][xo + 1] != 1 && 
                    b[zo + 1][yo - 1][xo + 1] > bottomIntenceLimit &&
                    b[zo + 1][yo - 1][xo + 1] < topIntenceLimit)
            {
                b0[zo + 1][yo - 1][xo + 1] = 1;
                result.add(new Point(xo + 1, yo - 1, zo + 1));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo + 1));
            }
        
        if(yo - 1 >= 0 && zo + 1 < b.length)
            if(b0[zo + 1][yo - 1][xo] != 1 && 
                    b[zo + 1][yo - 1][xo] > bottomIntenceLimit &&
                    b[zo + 1][yo - 1][xo] < topIntenceLimit)
            {
                b0[zo + 1][yo - 1][xo] = 1;
                result.add(new Point(xo, yo - 1, zo + 1));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo + 1));
            }
        
        if(xo - 1 >= 0 && yo - 1 >= 0 && zo + 1 < b.length)
            if(b0[zo + 1][yo - 1][xo - 1] != 1 && 
                    b[zo + 1][yo - 1][xo - 1] > bottomIntenceLimit &&
                    b[zo + 1][yo - 1][xo - 1] < topIntenceLimit)
            {
                b0[zo + 1][yo - 1][xo - 1] = 1;
                result.add(new Point(xo - 1, yo - 1, zo + 1));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo + 1));
            }
        
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        if(xo + 1 < b[0][0].length && yo + 1 < b[0].length)
            if(b0[zo][yo + 1][xo + 1] != 1 && 
                    b[zo][yo + 1][xo + 1] > bottomIntenceLimit &&
                    b[zo][yo + 1][xo + 1] < topIntenceLimit)
            {
                b0[zo][yo + 1][xo + 1] = 1;
                result.add(new Point(xo + 1, yo + 1, zo));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo));
            }
        
        if(yo + 1 < b[0].length)
            if(b0[zo][yo + 1][xo] != 1 && 
                    b[zo][yo + 1][xo] > bottomIntenceLimit &&
                    b[zo][yo + 1][xo] < topIntenceLimit)
            {
                b0[zo][yo + 1][xo] = 1;
                result.add(new Point(xo, yo + 1, zo));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo));
            }
        
        if(xo - 1 >= 0 && yo + 1 < b[0].length)
            if(b0[zo][yo + 1][xo - 1] != 1 && 
                    b[zo][yo + 1][xo - 1] > bottomIntenceLimit &&
                    b[zo][yo + 1][xo - 1] < topIntenceLimit)
            {
                b0[zo][yo + 1][xo - 1] = 1;
                result.add(new Point(xo - 1, yo + 1, zo));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo));
            }
        
        if(xo + 1 < b[0][0].length)
            if(b0[zo][yo][xo + 1] != 1 && 
                    b[zo][yo][xo + 1] > bottomIntenceLimit &&
                    b[zo][yo][xo + 1] < topIntenceLimit)
            {
                b0[zo][yo][xo + 1] = 1;
                result.add(new Point(xo + 1, yo, zo));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo));
            }
        
        if(xo - 1 >= 0)
            if(b0[zo][yo][xo - 1] != 1 && 
                    b[zo][yo][xo - 1] > bottomIntenceLimit &&
                    b[zo][yo][xo - 1] < topIntenceLimit)
            {
                b0[zo][yo][xo - 1] = 1;
                result.add(new Point(xo - 1, yo, zo));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo));
            }
        
        if(xo + 1 < b[0][0].length && yo - 1 >= 0)
            if(b0[zo][yo - 1][xo + 1] != 1 && 
                    b[zo][yo - 1][xo + 1] > bottomIntenceLimit &&
                    b[zo][yo - 1][xo + 1] < topIntenceLimit)
            {
                b0[zo][yo - 1][xo + 1] = 1;
                result.add(new Point(xo + 1, yo - 1, zo));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo));
            }
        
        if(yo - 1 >= 0)
            if(b0[zo][yo - 1][xo] != 1 && 
                    b[zo][yo - 1][xo] > bottomIntenceLimit &&
                    b[zo][yo - 1][xo] < topIntenceLimit)
            {
                b0[zo][yo - 1][xo] = 1;
                result.add(new Point(xo, yo - 1, zo));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo));
            }
        
        if(xo - 1 >= 0 && yo - 1 >= 0)
            if(b0[zo][yo - 1][xo - 1] != 1 && 
                    b[zo][yo - 1][xo - 1] > bottomIntenceLimit &&
                    b[zo][yo - 1][xo - 1] < topIntenceLimit)
            {
                b0[zo][yo - 1][xo - 1] = 1;
                result.add(new Point(xo - 1, yo - 1, zo));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo));
            }
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        if(xo + 1 < b[0][0].length && yo + 1 < b[0].length && zo - 1 >= 0)
            if(b0[zo - 1][yo + 1][xo + 1] != 1 && 
                    b[zo - 1][yo + 1][xo + 1] > bottomIntenceLimit &&
                    b[zo - 1][yo + 1][xo + 1] < topIntenceLimit)
            {
                b0[zo - 1][yo + 1][xo + 1] = 1;
                result.add(new Point(xo + 1, yo + 1, zo - 1));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo - 1));
            }
        
        if(yo + 1 < b[0].length && zo - 1 >= 0)
            if(b0[zo - 1][yo + 1][xo] != 1 && 
                    b[zo - 1][yo + 1][xo] > bottomIntenceLimit &&
                    b[zo - 1][yo + 1][xo] < topIntenceLimit)
            {
                b0[zo - 1][yo + 1][xo] = 1;
                result.add(new Point(xo, yo + 1, zo - 1));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo - 1));
            }
        
        if(xo - 1 >= 0 && yo + 1 < b[0].length && zo - 1 >= 0)
            if(b0[zo - 1][yo + 1][xo - 1] != 1 && 
                    b[zo - 1][yo + 1][xo - 1] > bottomIntenceLimit &&
                    b[zo - 1][yo + 1][xo - 1] < topIntenceLimit)
            {
                b0[zo - 1][yo + 1][xo - 1] = 1;
                result.add(new Point(xo - 1, yo + 1, zo - 1));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo - 1));
            }
        
        if(xo + 1 < b[0][0].length && zo - 1 >= 0)
            if(b0[zo - 1][yo][xo + 1] != 1 && 
                    b[zo - 1][yo][xo + 1] > bottomIntenceLimit &&
                    b[zo - 1][yo][xo + 1] < topIntenceLimit)
            {
                b0[zo - 1][yo][xo + 1] = 1;
                result.add(new Point(xo + 1, yo, zo - 1));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo - 1));
            }
        
        if(zo - 1 >= 0)
            if(b0[zo - 1][yo][xo] != 1 && 
                    b[zo - 1][yo][xo] > bottomIntenceLimit &&
                    b[zo - 1][yo][xo] < topIntenceLimit)
            {
                b0[zo - 1][yo][xo] = 1;
                result.add(new Point(xo, yo, zo - 1));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo - 1));
            }
        
        if(xo - 1 >= 0  && zo - 1 >= 0)
            if(b0[zo - 1][yo][xo - 1] != 1 && 
                    b[zo - 1][yo][xo - 1] > bottomIntenceLimit &&
                    b[zo - 1][yo][xo - 1] < topIntenceLimit)
            {
                b0[zo - 1][yo][xo - 1] = 1;
                result.add(new Point(xo - 1, yo, zo - 1));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo - 1));
            }
        
        if(xo + 1 < b[0][0].length && yo - 1 >= 0 && zo - 1 >= 0)
            if(b0[zo - 1][yo - 1][xo + 1] != 1 && 
                    b[zo - 1][yo - 1][xo + 1] > bottomIntenceLimit &&
                    b[zo - 1][yo - 1][xo + 1] < topIntenceLimit)
            {
                b0[zo - 1][yo - 1][xo + 1] = 1;
                result.add(new Point(xo + 1, yo - 1, zo - 1));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo - 1));
            }
        
        if(yo - 1 >= 0 && zo - 1 >= 0)
            if(b0[zo - 1][yo - 1][xo] != 1 && 
                    b[zo - 1][yo - 1][xo] > bottomIntenceLimit &&
                    b[zo - 1][yo - 1][xo] < topIntenceLimit)
            {
                b0[zo - 1][yo - 1][xo] = 1;
                result.add(new Point(xo, yo - 1, zo - 1));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo - 1));
            }
        
        if(xo - 1 >= 0 && yo - 1 >= 0 && zo - 1 >= 0)
            if(b0[zo - 1][yo - 1][xo - 1] != 1 && 
                    b[zo - 1][yo - 1][xo - 1] > bottomIntenceLimit &&
                    b[zo - 1][yo - 1][xo - 1] < topIntenceLimit)
            {
                b0[zo - 1][yo - 1][xo - 1] = 1;
                result.add(new Point(xo - 1, yo - 1, zo - 1));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo - 1));
            }
        
        
        //------------------------------------------------
        
        while(Q.size() != 0)
        {
            int cx = Q.poll().intValue();
            int cy = Q.poll().intValue();
            int cz = Q.poll().intValue();
            
            //------------------------------------------------
            if(cx + 1 < b[0][0].length && cy + 1 < b[0].length && cz + 1 < b.length)
                if(b0[cz + 1][cy + 1][cx + 1] != 1 && 
                        b[cz + 1][cy + 1][cx + 1] > bottomIntenceLimit &&
                        b[cz + 1][cy + 1][cx + 1] < topIntenceLimit)
                {
                    b0[cz + 1][cy + 1][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy + 1, cz + 1));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz + 1));
                }

            if(cy + 1 < b[0].length && cz + 1 < b.length)
                if(b0[cz + 1][cy + 1][cx] != 1 && 
                        b[cz + 1][cy + 1][cx] > bottomIntenceLimit &&
                        b[cz + 1][cy + 1][cx] < topIntenceLimit)
                {
                    b0[cz + 1][cy + 1][cx] = 1;
                    result.add(new Point(cx, cy + 1, cz + 1));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz + 1));
                }

            if(cx - 1 >= 0 && cy + 1 < b[0].length && cz + 1 < b.length)
                if(b0[cz + 1][cy + 1][cx - 1] != 1 && 
                        b[cz + 1][cy + 1][cx - 1] > bottomIntenceLimit &&
                        b[cz + 1][cy + 1][cx - 1] < topIntenceLimit)
                {
                    b0[cz + 1][cy + 1][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy + 1, cz + 1));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz + 1));
                }

            if(cx + 1 < b[0][0].length && cz + 1 < b.length)
                if(b0[cz + 1][cy][cx + 1] != 1 && 
                        b[cz + 1][cy][cx + 1] > bottomIntenceLimit &&
                        b[cz + 1][cy][cx + 1] < topIntenceLimit)
                {
                    b0[cz + 1][cy][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy, cz + 1));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz + 1));
                }

            if(cz + 1 < b.length)
                if(b0[cz + 1][cy][cx] != 1 && 
                        b[cz + 1][cy][cx] > bottomIntenceLimit &&
                        b[cz + 1][cy][cx] < topIntenceLimit)
                {
                    b0[cz + 1][cy][cx] = 1;
                    result.add(new Point(cx, cy, cz + 1));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz + 1));
                }

            if(cx - 1 >= 0  && cz + 1 < b.length)
                if(b0[cz + 1][cy][cx - 1] != 1 && 
                        b[cz + 1][cy][cx - 1] > bottomIntenceLimit &&
                        b[cz + 1][cy][cx - 1] < topIntenceLimit)
                {
                    b0[cz + 1][cy][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy, cz + 1));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz + 1));
                }

            if(cx + 1 < b[0][0].length && cy - 1 >= 0 && cz + 1 < b.length)
                if(b0[cz + 1][cy - 1][cx + 1] != 1 && 
                        b[cz + 1][cy - 1][cx + 1] > bottomIntenceLimit &&
                        b[cz + 1][cy - 1][cx + 1] < topIntenceLimit)
                {
                    b0[cz + 1][cy - 1][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy - 1, cz + 1));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz + 1));
                }

            if(cy - 1 >= 0 && cz + 1 < b.length)
                if(b0[cz + 1][cy - 1][cx] != 1 && 
                        b[cz + 1][cy - 1][cx] > bottomIntenceLimit &&
                        b[cz + 1][cy - 1][cx] < topIntenceLimit)
                {
                    b0[cz + 1][cy - 1][cx] = 1;
                    result.add(new Point(cx, cy - 1, cz + 1));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz + 1));
                }

            if(cx - 1 >= 0 && cy - 1 >= 0 && cz + 1 < b.length)
                if(b0[cz + 1][cy - 1][cx - 1] != 1 && 
                        b[cz + 1][cy - 1][cx - 1] > bottomIntenceLimit &&
                        b[cz + 1][cy - 1][cx - 1] < topIntenceLimit)
                {
                    b0[cz + 1][cy - 1][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy - 1, cz + 1));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz + 1));
                }

            // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            if(cx + 1 < b[0][0].length && cy + 1 < b[0].length)
                if(b0[cz][cy + 1][cx + 1] != 1 && 
                        b[cz][cy + 1][cx + 1] > bottomIntenceLimit &&
                        b[cz][cy + 1][cx + 1] < topIntenceLimit)
                {
                    b0[cz][cy + 1][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy + 1, cz));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz));
                }

            if(cy + 1 < b[0].length)
                if(b0[cz][cy + 1][cx] != 1 && 
                        b[cz][cy + 1][cx] > bottomIntenceLimit &&
                        b[cz][cy + 1][cx] < topIntenceLimit)
                {
                    b0[cz][cy + 1][cx] = 1;
                    result.add(new Point(cx, cy + 1, cz));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz));
                }

            if(cx - 1 >= 0 && cy + 1 < b[0].length)
                if(b0[cz][cy + 1][cx - 1] != 1 && 
                        b[cz][cy + 1][cx - 1] > bottomIntenceLimit &&
                        b[cz][cy + 1][cx - 1] < topIntenceLimit)
                {
                    b0[cz][cy + 1][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy + 1, cz));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz));
                }

            if(cx + 1 < b[0][0].length)
                if(b0[cz][cy][cx + 1] != 1 && 
                        b[cz][cy][cx + 1] > bottomIntenceLimit &&
                        b[cz][cy][cx + 1] < topIntenceLimit)
                {
                    b0[cz][cy][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy, cz));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz));
                }

            if(cx - 1 >= 0)
                if(b0[cz][cy][cx - 1] != 1 && 
                        b[cz][cy][cx - 1] > bottomIntenceLimit &&
                        b[cz][cy][cx - 1] < topIntenceLimit)
                {
                    b0[cz][cy][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy, cz));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz));
                }

            if(cx + 1 < b[0][0].length && cy - 1 >= 0)
                if(b0[cz][cy - 1][cx + 1] != 1 && 
                        b[cz][cy - 1][cx + 1] > bottomIntenceLimit &&
                        b[cz][cy - 1][cx + 1] < topIntenceLimit)
                {
                    b0[cz][cy - 1][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy - 1, cz));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz));
                }

            if(cy - 1 >= 0)
                if(b0[cz][cy - 1][cx] != 1 && 
                        b[cz][cy - 1][cx] > bottomIntenceLimit &&
                        b[cz][cy - 1][cx] < topIntenceLimit)
                {
                    b0[cz][cy - 1][cx] = 1;
                    result.add(new Point(cx, cy - 1, cz));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz));
                }

            if(cx - 1 >= 0 && cy - 1 >= 0)
                if(b0[cz][cy - 1][cx - 1] != 1 && 
                        b[cz][cy - 1][cx - 1] > bottomIntenceLimit &&
                        b[cz][cy - 1][cx - 1] < topIntenceLimit)
                {
                    b0[cz][cy - 1][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy - 1, cz));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz));
                }

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            if(cx + 1 < b[0][0].length && cy + 1 < b[0].length && cz - 1 >= 0)
                if(b0[cz - 1][cy + 1][cx + 1] != 1 && 
                        b[cz - 1][cy + 1][cx + 1] > bottomIntenceLimit &&
                        b[cz - 1][cy + 1][cx + 1] < topIntenceLimit)
                {
                    b0[cz - 1][cy + 1][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy + 1, cz - 1));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz - 1));
                }

            if(cy + 1 < b[0].length && cz - 1 >= 0)
                if(b0[cz - 1][cy + 1][cx] != 1 && 
                        b[cz - 1][cy + 1][cx] > bottomIntenceLimit &&
                        b[cz - 1][cy + 1][cx] < topIntenceLimit)
                {
                    b0[cz - 1][cy + 1][cx] = 1;
                    result.add(new Point(cx, cy + 1, cz - 1));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz - 1));
                }

            if(cx - 1 >= 0 && cy + 1 < b[0].length && cz - 1 >= 0)
                if(b0[cz - 1][cy + 1][cx - 1] != 1 && 
                        b[cz - 1][cy + 1][cx - 1] > bottomIntenceLimit &&
                        b[cz - 1][cy + 1][cx - 1] < topIntenceLimit)
                {
                    b0[cz - 1][cy + 1][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy + 1, cz - 1));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz - 1));
                }

            if(cx + 1 < b[0][0].length && cz - 1 >= 0)
                if(b0[cz - 1][cy][cx + 1] != 1 && 
                        b[cz - 1][cy][cx + 1] > bottomIntenceLimit &&
                        b[cz - 1][cy][cx + 1] < topIntenceLimit)
                {
                    b0[cz - 1][cy][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy, cz - 1));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz - 1));
                }

            if(cz - 1 >= 0)
                if(b0[cz - 1][cy][cx] != 1 && 
                        b[cz - 1][cy][cx] > bottomIntenceLimit &&
                        b[cz - 1][cy][cx] < topIntenceLimit)
                {
                    b0[cz - 1][cy][cx] = 1;
                    result.add(new Point(cx, cy, cz - 1));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz - 1));
                }

            if(cx - 1 >= 0  && cz - 1 >= 0)
                if(b0[cz - 1][cy][cx - 1] != 1 && 
                        b[cz - 1][cy][cx - 1] > bottomIntenceLimit &&
                        b[cz - 1][cy][cx - 1] < topIntenceLimit)
                {
                    b0[cz - 1][cy][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy, cz - 1));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz - 1));
                }

            if(cx + 1 < b[0][0].length && cy - 1 >= 0 && cz - 1 >= 0)
                if(b0[cz - 1][cy - 1][cx + 1] != 1 && 
                        b[cz - 1][cy - 1][cx + 1] > bottomIntenceLimit &&
                        b[cz - 1][cy - 1][cx + 1] < topIntenceLimit)
                {
                    b0[cz - 1][cy - 1][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy - 1, cz - 1));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz - 1));
                }

            if(cy - 1 >= 0 && cz - 1 >= 0)
                if(b0[cz - 1][cy - 1][cx] != 1 && 
                        b[cz - 1][cy - 1][cx] > bottomIntenceLimit &&
                        b[cz - 1][cy - 1][cx] < topIntenceLimit)
                {
                    b0[cz - 1][cy - 1][cx] = 1;
                    result.add(new Point(cx, cy - 1, cz - 1));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz - 1));
                }

            if(cx - 1 >= 0 && cy - 1 >= 0 && cz - 1 >= 0)
                if(b0[cz - 1][cy - 1][cx - 1] != 1 && 
                        b[cz - 1][cy - 1][cx - 1] > bottomIntenceLimit &&
                        b[cz - 1][cy - 1][cx - 1] < topIntenceLimit)
                {
                    b0[cz - 1][cy - 1][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy - 1, cz - 1));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz - 1));
                }


            //------------------------------------------------
        }
        
        b0 = null;
        Q = null;
        
        if(result.size() > 1)
        {
            System.out.println(result.size()) ;
            return result;
        }
        else
        {
            return null;
        } 
    }
    
    public ArrayList<ArrayList<Point>> Labeling3D(float[][][] b, ArrayList<ArrayList<Point>> objects, int bottomIntenceLimit, int topIntenceLimit)
    {
        ArrayList<ArrayList<Point>> listOfObjects = new ArrayList<ArrayList<Point>>();
        float[][][] b0 = new float[b.length][b[0].length][b[0][0].length];
        
        for(int z = 0; z < b.length; z++)
             for(int y = 0; y < b[0].length; y++)
                 for(int x = 0; x < b[0][0].length; x++)
                         b0[z][y][x] = b[z][y][x];
        
        for(ArrayList<Point> object : objects)
        {
            ArrayList<Point> elementsOfTheObject = 
                    ObjectExtraction3D(b0, object.get(0).GetX(), object.get(0).GetY(), object.get(0).GetZ(), bottomIntenceLimit, topIntenceLimit);
                    
            if(elementsOfTheObject != null)
            {
                if(elementsOfTheObject.size() > 30000 && elementsOfTheObject.size() < 200000)
                {
                    listOfObjects.add(elementsOfTheObject);
                    System.out.println("-------------------------------------------") ;
                }
                for(Point p : elementsOfTheObject)
                {
                    b0[p.GetZ()][p.GetY()][p.GetX()] = 9999;
                }
            }
        }
        
        return listOfObjects;
    }
    
    public ArrayList<Point> SmallObjectDeleting(float[][][] arr, int bottomIntenceLimit, int topIntenceLimit)
    {
        float[][][] b0 = new float[arr.length][arr[0].length][arr[0][0].length];
        
        for(int z = 0; z < arr.length; z++)
             for(int y = 0; y < arr[0].length; y++)
                 for(int x = 0; x < arr[0][0].length; x++)
                         b0[z][y][x] = arr[z][y][x];
        
        for(int z = 0; z < arr.length; z++)
            for(int y = 0; y < arr[0].length; y++)
                for(int x = 0; x < arr[0][0].length; x++)
                {
                    if(b0[z][y][x] > bottomIntenceLimit && b0[z][y][x] < topIntenceLimit)
                    {
                        System.out.print("(" + x + " " + y + " " + z + ") ");
                        ArrayList<Point> elementsOfTheObject = 
                                ObjectExtraction3D(b0, x, y, z, bottomIntenceLimit, topIntenceLimit);
                         
                        if(elementsOfTheObject != null)
                        {
                            if(elementsOfTheObject.size() < 2000000)
                            {
                                for(Point p : elementsOfTheObject)
                                {
                                    arr[p.GetZ()][p.GetY()][p.GetX()] = -2048;
                                }
                            }
                            else
                            {
                                return elementsOfTheObject;
                            }
                            for(Point p : elementsOfTheObject)
                            {
                                b0[p.GetZ()][p.GetY()][p.GetX()] = 9999;
                            }
                        }
                     }

                 }
        return null;
    }
    

    
    private ArrayList<Point> ObjectExtraction2D(float[][] b, int xo, int yo, int bottomIntenceLimit, int topIntenceLimit, int coordZ)
    {
        float[][] b0 = new float[b.length][b[0].length];
        ArrayList<Point> result = new ArrayList<Point>();
        ArrayDeque<Float> Q = new ArrayDeque<Float>();
        
        b0[yo][xo] = 1;
        result.add(new Point(xo, yo, coordZ));
        
        //------------------------------------------------
        
        if(xo + 1 < b[0].length && yo + 1 < b.length)
            if(b0[yo + 1][xo + 1] != 1 && 
                    b[yo + 1][xo + 1] > bottomIntenceLimit &&
                    b[yo + 1][xo + 1] < topIntenceLimit)
            {
                b0[yo + 1][xo + 1] = 1;
                result.add(new Point(xo + 1, yo + 1, coordZ));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo + 1));
            }
        
        if(yo + 1 < b.length)
            if(b0[yo + 1][xo] != 1 && 
                    b[yo + 1][xo] > bottomIntenceLimit &&
                    b[yo + 1][xo] < topIntenceLimit)
            {
                b0[yo + 1][xo] = 1;
                result.add(new Point(xo, yo + 1, coordZ));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo + 1));
            }
        
        if(xo - 1 >= 0 && yo + 1 < b.length)
            if(b0[yo + 1][xo - 1] != 1 && 
                    b[yo + 1][xo - 1] > bottomIntenceLimit &&
                    b[yo + 1][xo - 1] < topIntenceLimit)
            {
                b0[yo + 1][xo - 1] = 1;
                result.add(new Point(xo - 1, yo + 1, coordZ));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo + 1));
            }
        
        if(xo + 1 < b[0].length)
            if(b0[yo][xo + 1] != 1 && 
                    b[yo][xo + 1] > bottomIntenceLimit &&
                    b[yo][xo + 1] < topIntenceLimit)
            {
                b0[yo][xo + 1] = 1;
                result.add(new Point(xo + 1, yo, coordZ));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo));
            }
        
        if(xo - 1 >= 0)
            if(b0[yo][xo - 1] != 1 && 
                    b[yo][xo - 1] > bottomIntenceLimit &&
                    b[yo][xo - 1] < topIntenceLimit)
            {
                b0[yo][xo - 1] = 1;
                result.add(new Point(xo - 1, yo, coordZ));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo));
            }
        
        if(xo + 1 < b[0].length && yo - 1 >= 0)
            if(b0[yo - 1][xo + 1] != 1 && 
                    b[yo - 1][xo + 1] > bottomIntenceLimit &&
                    b[yo - 1][xo + 1] < topIntenceLimit)
            {
                b0[yo - 1][xo + 1] = 1;
                result.add(new Point(xo + 1, yo - 1, coordZ));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo - 1));
            }
        
        if(yo - 1 >= 0)
            if(b0[yo - 1][xo] != 1 && 
                    b[yo - 1][xo] > bottomIntenceLimit &&
                    b[yo - 1][xo] < topIntenceLimit)
            {
                b0[yo - 1][xo] = 1;
                result.add(new Point(xo, yo - 1, coordZ));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo - 1));
            }
        
        if(xo - 1 >= 0 && yo - 1 >= 0)
            if(b0[yo - 1][xo - 1] != 1 && 
                    b[yo - 1][xo - 1] > bottomIntenceLimit &&
                    b[yo - 1][xo - 1] < topIntenceLimit)
            {
                b0[yo - 1][xo - 1] = 1;
                result.add(new Point(xo - 1, yo - 1, coordZ));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo - 1));
            }
        
        //------------------------------------------------
        
        while(Q.size() != 0)
        {
            int cx = Q.poll().intValue();
            int cy = Q.poll().intValue();
            
            if(cx + 1 < b[0].length && cy + 1 < b.length)
                if(b0[cy + 1][cx + 1] != 1 && 
                        b[cy + 1][cx + 1] > bottomIntenceLimit &&
                        b[cy + 1][cx + 1] < topIntenceLimit)
                {
                    b0[cy + 1][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy + 1, coordZ));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy + 1));
                }

            if(cy + 1 < b.length)
                if(b0[cy + 1][cx] != 1 && 
                        b[cy + 1][cx] > bottomIntenceLimit &&
                        b[cy + 1][cx] < topIntenceLimit)
                {
                    b0[cy + 1][cx] = 1;
                    result.add(new Point(cx, cy + 1, coordZ));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy + 1));
                }

            if(cx - 1 >= 0 && cy + 1 < b.length)
                if(b0[cy + 1][cx - 1] != 1 && 
                        b[cy + 1][cx - 1] > bottomIntenceLimit &&
                        b[cy + 1][cx - 1] < topIntenceLimit)
                {
                    b0[cy + 1][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy + 1, coordZ));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy + 1));
                }

            if(cx + 1 < b[0].length)
                if(b0[cy][cx + 1] != 1 && 
                        b[cy][cx + 1] > bottomIntenceLimit &&
                        b[cy][cx + 1] < topIntenceLimit)
                {
                    b0[cy][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy, coordZ));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy));
                }

            if(cx - 1 >= 0)
                if(b0[cy][cx - 1] != 1 && 
                        b[cy][cx - 1] > bottomIntenceLimit &&
                        b[cy][cx - 1] < topIntenceLimit)
                {
                    b0[cy][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy, coordZ));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy));
                }

            if(cx + 1 < b[0].length && cy - 1 >= 0)
                if(b0[cy - 1][cx + 1] != 1 && 
                        b[cy - 1][cx + 1] > bottomIntenceLimit &&
                        b[cy - 1][cx + 1] < topIntenceLimit)
                {
                    b0[cy - 1][cx + 1] = 1;
                    result.add(new Point(cx + 1, cy - 1, coordZ));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy - 1));
                }

            if(cy - 1 >= 0)
                if(b0[cy - 1][cx] != 1 && 
                        b[cy - 1][cx] > bottomIntenceLimit &&
                        b[cy - 1][cx] < topIntenceLimit)
                {
                    b0[cy - 1][cx] = 1;
                    result.add(new Point(cx, cy - 1, coordZ));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy - 1));
                }

            if(cx - 1 >= 0 && cy - 1 >= 0)
                if(b0[cy - 1][cx - 1] != 1 && 
                        b[cy - 1][cx - 1] > bottomIntenceLimit &&
                        b[cy - 1][cx - 1] < topIntenceLimit)
                {
                    b0[cy - 1][cx - 1] = 1;
                    result.add(new Point(cx - 1, cy - 1, coordZ));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy - 1));
                }
        }
        
        b0 = null;
        Q = null;
        
        if(result.size() > 1)
        {
            
            return result;
        }
        else
        {
            return null;
        } 
    }
    
    public ArrayList<ArrayList<Point>> Labeling2D(float[][] b, int bottomIntenceLimit, int topIntenceLimit, int coordZ)
    {
        boolean[][] b0 = new boolean[b.length][b[0].length];
        ArrayList<ArrayList<Point>> listOfObjects = new ArrayList<ArrayList<Point>>();
        
        for(int y = 0; y < b.length; y++)
            for(int x = 0; x < b[0].length; x++)
            {
                if(!b0[y][x] && b[y][x] < topIntenceLimit && b[y][x] > bottomIntenceLimit)
                {
                    ArrayList<Point> elementsOfTheObject = ObjectExtraction2D(b, x, y, bottomIntenceLimit, topIntenceLimit, coordZ);
                    b0[y][x] = true;
                    if(elementsOfTheObject != null)
                    {
                        if(elementsOfTheObject.size() > 40 && elementsOfTheObject.size() < 100000)
                        {
                                listOfObjects.add(elementsOfTheObject);
                                System.out.println(elementsOfTheObject.size()) ;
                                System.out.println("-------------------------------------------") ;
                        }
                        
                        for(Point point : elementsOfTheObject)
                        {
                            b0[point.GetY()][point.GetX()] = true;
                        }
                    }
                }
            }
        
        return listOfObjects;
    }
    
    
    private ArrayList<Point> TraheaExtracting2D(ArrayList<ArrayList<Point>> objects2D, Point centerOfImage)
    {
        Point[] centersOfMass = new Point[objects2D.size()];
        for(int i = 0; i < objects2D.size(); i++)
        {
            centersOfMass[i] = CenterOfMass(objects2D.get(i));
        }
        
        
        double minDistance = centerOfImage.GetX() * 2;
        int indexOfTrachea = -1;

        
        for(int i = 0; i < objects2D.size(); i++)
        {
            double distance = Math.sqrt(
                    Math.pow(centersOfMass[i].GetX() - centerOfImage.GetX(), 2) + 
                            Math.pow(centersOfMass[i].GetY() - centerOfImage.GetY(), 2));
            if(minDistance > distance)
            {
                minDistance = distance;
                indexOfTrachea = i;
            }
        }

        return objects2D.get(indexOfTrachea);
    }
    
    
    
    private Point CenterOfMass(ArrayList<Point> object2D)
    {
        float x = 0.0f;
        float y = 0.0f;
        for(Point point : object2D)
        {
            x += point.GetX();
            y += point.GetY();
        }
        return new Point((int)(x / object2D.size()), (int)(y / object2D.size()), object2D.get(0).GetZ());
    }
    
    public ArrayList<ArrayList<Point>> TraheaExtraction3D(float[][][] b, ArrayList<ArrayList<Point>> objects, int bottomIntenceLimit, int topIntenceLimit)
    {
        ArrayList<Point> object = TraheaExtracting2D(objects, new Point(b[0][0].length / 2, b[0].length / 2, 0));
        ArrayList<Point> object3D = null;
        
        int topBorderHU = topIntenceLimit;
        int k = b.length * 1000;
        ArrayList<Point> elementsOfTheObject = new ArrayList<Point>();
        
        while(elementsOfTheObject.size() < k)
        {
            object3D = (ArrayList<Point>)elementsOfTheObject.clone();
            elementsOfTheObject = 
                    ObjectExtraction3D(b, object.get(0).GetX(), object.get(0).GetY(), object.get(0).GetZ(), bottomIntenceLimit, topBorderHU);
                    
            if(elementsOfTheObject == null)
            {
                elementsOfTheObject = new ArrayList<Point>();
            }            
            topBorderHU++;
        }
        
        this.TopTraheaBorder = topBorderHU - 1;
        
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        result.add(object3D);
        return result;
    }
    
    
    private ArrayList<ArrayList<Point>> LungExtracting2D(ArrayList<ArrayList<Point>> objects2D)
    {
        int maxCountOfPoints = 0;
        int indexOfMaxElement = -1;
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        
        for(int i = 0; i < objects2D.size(); i++)
        {
            if(objects2D.get(i).size() > maxCountOfPoints)
            {
                maxCountOfPoints = objects2D.get(i).size();
                indexOfMaxElement = i;
            }
        }
        
        if(maxCountOfPoints < 1000)
            return null;
        else
            result.add(objects2D.get(indexOfMaxElement));
        
        objects2D.remove(indexOfMaxElement);
        
        maxCountOfPoints = 0;
        indexOfMaxElement = -1;
        
        for(int i = 0; i < objects2D.size(); i++)
        {
            if(objects2D.get(i).size() > maxCountOfPoints)
            {
                maxCountOfPoints = objects2D.get(i).size();
                indexOfMaxElement = i;
            }
        }
        
        if(maxCountOfPoints < 1000)
            return null;
        else
            result.add(objects2D.get(indexOfMaxElement));
        
        return result;        
    }
    
    
    
    
    public ArrayList<ArrayList<Point>> LungExtraction3D(float[][][] b, ArrayList<ArrayList<Point>> objects, int bottomIntenceLimit, int topIntenceLimit)
    {
        ArrayList<ArrayList<Point>> lungs = this.LungExtracting2D(objects);
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        
        if(lungs == null)
            return result;
        
        ArrayList<Point> firstLung = ObjectExtraction3D(b, lungs.get(0).get(0).GetX(), 
                lungs.get(0).get(0).GetY(), lungs.get(0).get(0).GetZ(), bottomIntenceLimit, topIntenceLimit);
        
        ArrayList<Point> secondLung = ObjectExtraction3D(b, lungs.get(1).get(0).GetX(), 
                lungs.get(1).get(0).GetY(), lungs.get(1).get(0).GetZ(), bottomIntenceLimit, topIntenceLimit);
        
        if(firstLung.size() < b.length * 500 || secondLung.size() < b.length * 500)
            return result;
        
        result.add(firstLung);
        result.add(secondLung);
        
        return result;
    }
    

    
    // Функция, которая наращивает бронхиальное дерево
    public void TraheaCapacity(float[][][] b, ArrayList<ArrayList<Point>> elements)
    {
        int TOP_LIMIT = -500;
        int BOTTOM_LIMIT = -900;
        
        for(int z = 0; z < b.length; z++)
            for(int y = 0; y < b[0].length; y++)
                for(int x = 0; x < b[0][0].length; x++)
                {
                    if(b[z][y][x] < TOP_LIMIT && b[z][y][x] > BOTTOM_LIMIT)
                    {
                        if(x + 1 < b[0][0].length && y + 1 < b[0].length && z + 1 < b.length)
                            if(b[z + 1][y + 1][x + 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(y + 1 < b[0].length && z + 1 < b.length)
                            if(b[z + 1][y + 1][x] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x - 1 >= 0 && y + 1 < b[0].length && z + 1 < b.length)
                            if(b[z + 1][y + 1][x - 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x + 1 < b[0][0].length && z + 1 < b.length)
                            if(b[z + 1][y][x + 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(z + 1 < b.length)
                            if(b[z + 1][y][x] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x - 1 >= 0  && z + 1 < b.length)
                            if(b[z + 1][y][x - 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x + 1 < b[0][0].length && y - 1 >= 0 && z + 1 < b.length)
                            if(b[z + 1][y - 1][x + 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(y - 1 >= 0 && z + 1 < b.length)
                            if(b[z + 1][y - 1][x] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x - 1 >= 0 && y - 1 >= 0 && z + 1 < b.length)
                            if(b[z + 1][y - 1][x - 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                        if(x + 1 < b[0][0].length && y + 1 < b[0].length)
                            if(b[z][y + 1][x + 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(y + 1 < b[0].length)
                            if(b[z][y + 1][x] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x - 1 >= 0 && y + 1 < b[0].length)
                            if(b[z][y + 1][x - 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x + 1 < b[0][0].length)
                            if(b[z][y][x + 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x - 1 >= 0)
                            if(b[z][y][x - 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x + 1 < b[0][0].length && y - 1 >= 0)
                            if(b[z][y - 1][x + 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(y - 1 >= 0)
                            if(b[z][y - 1][x] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x - 1 >= 0 && y - 1 >= 0)
                            if(b[z][y - 1][x - 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                        if(x + 1 < b[0][0].length && y + 1 < b[0].length && z - 1 >= 0)
                            if(b[z - 1][y + 1][x + 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(y + 1 < b[0].length && z - 1 >= 0)
                            if(b[z - 1][y + 1][x] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x - 1 >= 0 && y + 1 < b[0].length && z - 1 >= 0)
                            if(b[z - 1][y + 1][x - 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x + 1 < b[0][0].length && z - 1 >= 0)
                            if(b[z - 1][y][x + 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(z - 1 >= 0)
                            if(b[z - 1][y][x] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x - 1 >= 0  && z - 1 >= 0)
                            if(b[z - 1][y][x - 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x + 1 < b[0][0].length && y - 1 >= 0 && z - 1 >= 0)
                            if(b[z - 1][y - 1][x + 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(y - 1 >= 0 && z - 1 >= 0)
                            if(b[z - 1][y - 1][x] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }

                        if(x - 1 >= 0 && y - 1 >= 0 && z - 1 >= 0)
                            if(b[z - 1][y - 1][x - 1] == 9999 && b[z][y][x] != 9998)
                            {
                                b[z][y][x] = 9998;
                                elements.get(0).add(new Point(x, y, z));
                            }


                        //------------------------------------------------
                    }
                }
    }
    
    

    
    
}
