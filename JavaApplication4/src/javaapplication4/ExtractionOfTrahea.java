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
public class ExtractionOfTrahea {
    
    private ArrayList<Point> regionGroving2D(short[][][] scene, Point startPoint, int topThreshold)
    {
        boolean[][] scene0 = new boolean[scene[0].length][scene[0][0].length];
        ArrayList<Point> result = new ArrayList<Point>();
        ArrayDeque<Float> Q = new ArrayDeque<Float>();
        
        scene0[startPoint.GetY()][startPoint.GetX()] = true;
        result.add(new Point(startPoint.GetX(), startPoint.GetY(), startPoint.GetZ()));
        
        int maxX = startPoint.GetX() + 1;
        int minX = startPoint.GetX() - 1;
        int maxY = startPoint.GetY() + 1;
        int minY = startPoint.GetY() - 1;
        
        if(maxX >= scene[0][0].length)
            maxX = scene[0][0].length - 1;
        if(minX < 0)
            minX = 0;
        if(maxY >= scene[0].length)
            maxY = scene[0].length - 1;
        if(minY < 0)
            minY = 0;
        
        for(int y = minY; y <= maxY; y++)
            for(int x = minX; x <= maxX; x++)
            {
                if(scene[startPoint.GetZ()][y][x] <= topThreshold && 
                            !scene0[y][x]){
                    scene0[y][x] = true;
                    result.add(new Point(x, y, startPoint.GetZ()));
                    Q.addLast(new Float(x));
                    Q.addLast(new Float(y));
                }
            }
        
        while(Q.size() != 0)
        {
            int cx = Q.poll().intValue();
            int cy = Q.poll().intValue();
            
            maxX = cx + 1;
            minX = cx - 1;
            maxY = cy + 1;
            minY = cy - 1;

            if(maxX >= scene[0][0].length)
                maxX = scene[0][0].length - 1;
            if(minX < 0)
                minX = 0;
            if(maxY >= scene[0].length)
                maxY = scene[0].length - 1;
            if(minY < 0)
                minY = 0;

            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    if(scene[startPoint.GetZ()][y][x] <= topThreshold && 
                            !scene0[y][x]){
                        scene0[y][x] = true;
                        result.add(new Point(x, y, startPoint.GetZ()));
                        Q.addLast(new Float(x));
                        Q.addLast(new Float(y));
                    }
                }
        }
        return result;
    }
    
    
    public ArrayList<ArrayList<Point>> findPotentialRegions(short[][][] scene, int slice, float xDistance, float yDistance)
    {
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
        int topBronhealThreshold = -900;
        int topAreaThreshold = 400;
        int bottomAreaThreshold = 80;
        float oneVoxelArea = xDistance * yDistance;
        boolean[][] scene0 = new boolean[scene[0].length][scene[0][0].length];
        
        
        for(int y=0; y<scene[0].length; y++)
            for(int x=0; x<scene[0][0].length; x++)
            {
                if(scene[slice][y][x] <= topBronhealThreshold && !scene0[y][x]) {
                    ArrayList<Point> region = this.regionGroving2D(scene, new Point(x, y, slice), topBronhealThreshold);
                    if(region.size() * oneVoxelArea > 80 && region.size() * oneVoxelArea < 400)
                    {
                        Point regionCenter = this.CenterOfMass(region);
                        Point imageCenter = new Point(scene[0][0].length / 2, scene[0].length / 2, 0);
                        double xDist = (regionCenter.GetX() - imageCenter.GetX()) * xDistance;
                        double yDist = (regionCenter.GetY() - imageCenter.GetY()) * yDistance;
                        
                        if(xDist < 10 && yDist < 10)
                            result.add(region);
                    }
                    for(Point p: region) {
                        scene0[p.GetY()][p.GetX()] = true;
                    }
                }
            }
        return result;
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
    
}
