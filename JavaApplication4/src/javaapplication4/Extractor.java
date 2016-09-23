/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author stiv
 */
public class Extractor {
    char[][][] scene_8bit = null;
    
    byte standard_deviation = 100;
    byte mean = 0;
    
    public Extractor(float[][][] scene_12bit) {
        this.scene_8bit = 
                new char[scene_12bit.length][scene_12bit[0].length][scene_12bit[0][0].length];
        
        for(int z = 0; z < scene_12bit.length; z++)
            for(int y = 0; y < scene_12bit[0].length; y++)
                for(int x = 0; x < scene_12bit[0][0].length; x++) {
                    if(scene_12bit[z][y][x] < -1000) {
                        this.scene_8bit[z][y][x] = 0;
                        continue;
                    }
                    
                    if(scene_12bit[z][y][x] >= -1000 && scene_12bit[z][y][x] <= -800) {
                        this.scene_8bit[z][y][x] = (char)(scene_12bit[z][y][x] + 1000);
                        continue;
                    }
                    
                    if(scene_12bit[z][y][x] > -800 && scene_12bit[z][y][x] <= 0) {
                        this.scene_8bit[z][y][x] = (char)(scene_12bit[z][y][x] * 55 / 800 + 255);
                        continue;
                    }
                    
                    if(scene_12bit[z][y][x] > 0) {
                        this.scene_8bit[z][y][x] = 255;
                        continue;
                    }
                }
    }
    
    public char[][][] Scene() {
        return this.scene_8bit;
    }
   
    private double ForegroundAffinity(char gray_value) {
        int expNumerator = (int)Math.pow((gray_value - this.mean), 2);
        int expDenominator = (int)(2 * Math.pow(this.standard_deviation, 2));
        double result = Math.pow(Math.E, (-expNumerator / expDenominator));
        return result;
    }
    
    private double BackgroundAffinity1(char gray_value1, char gray_value2) {
        double difference = (gray_value1 - gray_value2) / 2.0;
        int expNumerator = (int)Math.pow((difference - this.mean), 2);
        int expDenominator = (int)(2 * Math.pow(this.standard_deviation, 2));
        double result = Math.pow(Math.E, (-expNumerator / expDenominator));
        return result;
    }
    
    private double BackgroundAffinity(int x1, int y1, int z1, int x2, int y2, int z2) {
        double distance = 
                Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
        double result = 0;
        if(distance < Math.sqrt(3))
            result = this.BackgroundAffinity1(this.scene_8bit[z1][y1][x1], this.scene_8bit[z2][y2][x2]);
        return result;
    }
}
