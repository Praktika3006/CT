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
public class TracheaFilling {
    float[][][] scene = null;
    boolean[][][] binScene = null;
    
    public TracheaFilling(float[][][] scene)
    {
        this.scene = scene;
        this.binScene = new boolean[scene.length][scene[0].length][scene[0][0].length];
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
        
        return result;
    }
    
    public void FillScene(int topBorderTrahea)
    {
        System.out.println("-----------------------------");
        System.out.println(this.scene.length);
        int TOP_BORDER = -500;
        int BOTTOM_BORDER = topBorderTrahea + 1;
        ArrayList<Point> object = null;
        for(int z = 0; z < 110; z++)
            for(int y = 0; y < this.scene[0].length; y++)
                for(int x = 0; x < this.scene[0][0].length; x++)
                    if(scene[z][y][x] < TOP_BORDER && scene[z][y][x] > BOTTOM_BORDER && this.binScene[z][y][x] != true)
                    {
                        object = this.ObjectExtraction3D(scene, x, y, z, BOTTOM_BORDER, TOP_BORDER);
                        
                        System.out.print(z + " ");
                        if(object.size() <= 30 && this.func1(object))
                        {
                            System.out.print("+");
                            for(Point p : object)
                            {
                                scene[p.GetZ()][p.GetY()][p.GetX()] = 9000;
                            }
                        }
                        
                        System.out.println(object.size());
                        for(Point p : object)
                        {
                            this.binScene[p.GetZ()][p.GetY()][p.GetX()] = true;
                        }
                    }
    }
    
    public float[][][] GetNewScene()
    {
        return this.scene;
    }
    
    private boolean func1(ArrayList<Point> object)
    {
        int count = 0;
        for(Point p : object)
            if(this.SurrenderTrahea(p.GetX(), p.GetY(), p.GetZ()))
                count++;
        
        if(count == object.size())
            return true;
        else
            return false;
    }
    
    private boolean SurrenderTrahea(int xo, int yo, int zo)
    {      
        int count = 0;
        if(xo + 1 < scene[0][0].length && yo + 1 < scene[0].length && zo + 1 < scene.length)
            if(scene[zo + 1][yo + 1][xo + 1] == 9000)
            {
                count++;
            }
        
        if(yo + 1 < scene[0].length && zo + 1 < scene.length)
            if(scene[zo + 1][yo + 1][xo] == 9000)
            {
                count++;
            }
        
        if(xo - 1 >= 0 && yo + 1 < scene[0].length && zo + 1 < scene.length)
            if(scene[zo + 1][yo + 1][xo - 1] == 9000)
            {
                count++;
            }
        
        if(xo + 1 < scene[0][0].length && zo + 1 < scene.length)
            if(scene[zo + 1][yo][xo + 1] == 9000)
            {
                count++;
            }
        
        if(zo + 1 < scene.length)
            if(scene[zo + 1][yo][xo] == 9000)
            {
                count++;
            }
        
        if(xo - 1 >= 0  && zo + 1 < scene.length)
            if(scene[zo + 1][yo][xo - 1] == 9000)
            {
                count++;
            }
        
        if(xo + 1 < scene[0][0].length && yo - 1 >= 0 && zo + 1 < scene.length)
            if(scene[zo + 1][yo - 1][xo + 1] == 9000)
            {
                count++;
            }
        
        if(yo - 1 >= 0 && zo + 1 < scene.length)
            if(scene[zo + 1][yo - 1][xo] == 9000)
            {
                count++;
            }
        
        if(xo - 1 >= 0 && yo - 1 >= 0 && zo + 1 < scene.length)
            if(scene[zo + 1][yo - 1][xo - 1] == 9000)
            {
                count++;
            }
        
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        if(xo + 1 < scene[0][0].length && yo + 1 < scene[0].length)
            if(scene[zo][yo + 1][xo + 1] == 9000)
            {
                count++;
            }
        
        if(yo + 1 < scene[0].length)
            if(scene[zo][yo + 1][xo] == 9000)
            {
                count++;
            }
        
        if(xo - 1 >= 0 && yo + 1 < scene[0].length)
            if(scene[zo][yo + 1][xo - 1] == 9000)
            {
                count++;
            }
        
        if(xo + 1 < scene[0][0].length)
            if(scene[zo][yo][xo + 1] == 9000)
            {
                count++;
            }
        
        if(xo - 1 >= 0)
            if(scene[zo][yo][xo - 1] == 9000)
            {
                count++;
            }
        
        if(xo + 1 < scene[0][0].length && yo - 1 >= 0)
            if(scene[zo][yo - 1][xo + 1] == 9000)
            {
                count++;
            }
        
        if(yo - 1 >= 0)
            if(scene[zo][yo - 1][xo] == 9000)
            {
                count++;
            }
        
        if(xo - 1 >= 0 && yo - 1 >= 0)
            if(scene[zo][yo - 1][xo - 1] == 9000)
            {
                count++;
            }
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        if(xo + 1 < scene[0][0].length && yo + 1 < scene[0].length && zo - 1 >= 0)
            if(scene[zo - 1][yo + 1][xo + 1] == 9000)
            {
                count++;
            }
        
        if(yo + 1 < scene[0].length && zo - 1 >= 0)
            if(scene[zo - 1][yo + 1][xo] == 9000)
            {
                count++;
            }
        
        if(xo - 1 >= 0 && yo + 1 < scene[0].length && zo - 1 >= 0)
            if(scene[zo - 1][yo + 1][xo - 1] == 9000)
            {
                count++;
            }
        
        if(xo + 1 < scene[0][0].length && zo - 1 >= 0)
            if(scene[zo - 1][yo][xo + 1] == 9000)
            {
                count++;
            }
        
        if(zo - 1 >= 0)
            if(scene[zo - 1][yo][xo] == 9000)
            {
                count++;
            }
        
        if(xo - 1 >= 0  && zo - 1 >= 0)
            if(scene[zo - 1][yo][xo - 1] == 9000)
            {
                count++;
            }
        
        if(xo + 1 < scene[0][0].length && yo - 1 >= 0 && zo - 1 >= 0)
            if(scene[zo - 1][yo - 1][xo + 1] == 9000)
            {
                count++;
            }
        
        if(yo - 1 >= 0 && zo - 1 >= 0)
            if(scene[zo - 1][yo - 1][xo] == 9000)
            {
                count++;
            }
        
        if(xo - 1 >= 0 && yo - 1 >= 0 && zo - 1 >= 0)
            if(scene[zo - 1][yo - 1][xo - 1] == 9000)
            {
                count++;
            }
        
        if(count > 0)
            return true;
        else
            return false;       
    }
    
}
