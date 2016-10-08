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
public class AirwaySegmentation3D {
    private Point seedVoxel;
    private double dx;
    private double dy;
    private double dz;
    private final short AIRWAY = 9000;
    
    public AirwaySegmentation3D(Point seedVoxel, double dx, double dy, double dz) {
        this.seedVoxel = seedVoxel;
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
    }
    
    public ArrayList<Point> segmentation(short[][][] originalScene) {
        ArrayList<Point> airway = new ArrayList<Point>();
        airway.add(seedVoxel);
        
        short threshold = this.minIntencity(airway, originalScene);
      
        double thresholdedVolume = this.getVolume(airway);
        
        final double explosionVolume = 75_000.0;
        
        while (thresholdedVolume < explosionVolume) {
            
            airway = this.ObjectExtraction3D(originalScene, 
                    this.seedVoxel.GetX(), 
                    this.seedVoxel.GetY(), 
                    this.seedVoxel.GetZ(), threshold);
            
            thresholdedVolume = this.getVolume(airway);
            
            threshold++;
        }
        
        threshold -= 2;
        
        airway = this.ObjectExtraction3D(originalScene, 
                    this.seedVoxel.GetX(), 
                    this.seedVoxel.GetY(), 
                    this.seedVoxel.GetZ(), threshold);
        
        double volume = this.getVolume(airway);
        System.out.println("volume= " + volume);
        
        do {
            
            threshold--;
            
            airway = this.ObjectExtraction3D(originalScene, 
                    this.seedVoxel.GetX(), 
                    this.seedVoxel.GetY(), 
                    this.seedVoxel.GetZ(), threshold);
            
            thresholdedVolume = this.getVolume(airway);
            System.out.println(thresholdedVolume);
            
        } while (thresholdedVolume >= 0.95 * volume);
        
        return airway;
    }
    
    private short minIntencity(ArrayList<Point> airwayVoxels, short[][][] scene) {
        short minI = 2000;
        for(Point point : airwayVoxels) {
            if(scene[point.GetZ()][point.GetY()][point.GetX()] < minI) {
                minI = scene[point.GetZ()][point.GetY()][point.GetX()];
            }
        }
        return minI;
    }
    
    private double getVolume(ArrayList<Point> airwayVoxels) {        
        return airwayVoxels.size() * this.dx * this.dy * this.dz;
    }
    
    private ArrayList<Point> ObjectExtraction3D(short[][][] b, int xo, int yo, int zo, short topIntenceLimit)
    {
        boolean[][][] b0 = new boolean[b.length][b[0].length][b[0][0].length];
        ArrayList<Point> result = new ArrayList<Point>();
        ArrayDeque<Float> Q = new ArrayDeque<Float>();

        b0[zo][yo][xo] = true;
        result.add(new Point(xo, yo, zo));

        //------------------------------------------------

        if(zo + 1 < b.length)
            if(!b0[zo + 1][yo][xo] &&
                    b[zo + 1][yo][xo] < topIntenceLimit) {
                b0[zo + 1][yo][xo] = true;
                result.add(new Point(xo, yo, zo + 1));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo + 1));
            }


        if(yo + 1 < b[0].length)
            if(!b0[zo][yo + 1][xo] &&
                    b[zo][yo + 1][xo] < topIntenceLimit) {
                b0[zo][yo + 1][xo] = true;
                result.add(new Point(xo, yo + 1, zo));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo + 1));
                Q.addLast(new Float(zo));
            }


        if(xo + 1 < b[0][0].length)
            if(!b0[zo][yo][xo + 1] &&
                    b[zo][yo][xo + 1] < topIntenceLimit) {
                b0[zo][yo][xo + 1] = true;
                result.add(new Point(xo + 1, yo, zo));
                Q.addLast(new Float(xo + 1));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo));
            }

        if(xo - 1 >= 0)
            if(!b0[zo][yo][xo - 1] &&
                    b[zo][yo][xo - 1] < topIntenceLimit) {
                b0[zo][yo][xo - 1] = true;
                result.add(new Point(xo - 1, yo, zo));
                Q.addLast(new Float(xo - 1));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo));
            }

        if(yo - 1 >= 0)
            if(!b0[zo][yo - 1][xo] &&
                    b[zo][yo - 1][xo] < topIntenceLimit) {
                b0[zo][yo - 1][xo] = true;
                result.add(new Point(xo, yo - 1, zo));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo - 1));
                Q.addLast(new Float(zo));
            }


        if(zo - 1 >= 0)
            if(!b0[zo - 1][yo][xo] &&
                    b[zo - 1][yo][xo] < topIntenceLimit) {
                b0[zo - 1][yo][xo] = true;
                result.add(new Point(xo, yo, zo - 1));
                Q.addLast(new Float(xo));
                Q.addLast(new Float(yo));
                Q.addLast(new Float(zo - 1));
            }


        //------------------------------------------------

        while(Q.size() != 0)
        {
            int cx = Q.poll().intValue();
            int cy = Q.poll().intValue();
            int cz = Q.poll().intValue();

            //------------------------------------------------

            if(cz + 1 < b.length)
                if(!b0[cz + 1][cy][cx] &&
                        b[cz + 1][cy][cx] < topIntenceLimit) {
                    b0[cz + 1][cy][cx] = true;
                    result.add(new Point(cx, cy, cz + 1));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz + 1));
                }


            if(cy + 1 < b[0].length)
                if(!b0[cz][cy + 1][cx] &&
                        b[cz][cy + 1][cx] < topIntenceLimit) {
                    b0[cz][cy + 1][cx] = true;
                    result.add(new Point(cx, cy + 1, cz));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy + 1));
                    Q.addLast(new Float(cz));
                }


            if(cx + 1 < b[0][0].length)
                if(!b0[cz][cy][cx + 1] &&
                        b[cz][cy][cx + 1] < topIntenceLimit) {
                    b0[cz][cy][cx + 1] = true;
                    result.add(new Point(cx + 1, cy, cz));
                    Q.addLast(new Float(cx + 1));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz));
                }

            if(cx - 1 >= 0)
                if(!b0[cz][cy][cx - 1] &&
                        b[cz][cy][cx - 1] < topIntenceLimit) {
                    b0[cz][cy][cx - 1] = true;
                    result.add(new Point(cx - 1, cy, cz));
                    Q.addLast(new Float(cx - 1));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz));
                }


            if(cy - 1 >= 0)
                if(!b0[cz][cy - 1][cx] &&
                        b[cz][cy - 1][cx] < topIntenceLimit) {
                    b0[cz][cy - 1][cx] = true;
                    result.add(new Point(cx, cy - 1, cz));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy - 1));
                    Q.addLast(new Float(cz));
                }

            if(cz - 1 >= 0)
                if(!b0[cz - 1][cy][cx] &&
                        b[cz - 1][cy][cx] < topIntenceLimit) {
                    b0[cz - 1][cy][cx] = true;
                    result.add(new Point(cx, cy, cz - 1));
                    Q.addLast(new Float(cx));
                    Q.addLast(new Float(cy));
                    Q.addLast(new Float(cz - 1));
                }

            //------------------------------------------------
        }

        b0 = null;
        Q = null;
        
        System.gc();
        
        return result;
    }
    
    private void ungrow(short[][][] scene, ArrayList<Point> airwayVoxels, short topIntencityLimit) {
        ArrayList<Point> deletableIndexes = new ArrayList<Point>();
        
        for(int i = 0; i < airwayVoxels.size(); i++) {
            if(scene[airwayVoxels.get(i).GetZ()]
                    [airwayVoxels.get(i).GetY()]
                    [airwayVoxels.get(i).GetX()] == topIntencityLimit) {
                deletableIndexes.add(airwayVoxels.get(i));
            }
        }
        System.out.println(deletableIndexes.size());
        System.out.println("+++ " + airwayVoxels.size());
        for(Point point : deletableIndexes) {
            airwayVoxels.remove(point);
        }
        System.out.println("--- " + airwayVoxels.size());
    }
}
