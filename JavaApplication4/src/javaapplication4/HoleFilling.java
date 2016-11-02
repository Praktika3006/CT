package javaapplication4;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by stiv on 28.10.16.
 */
public class HoleFilling {
     public void fillHoles(boolean[][][] binaryScene) {
         for (int z = 0; z < binaryScene.length; z++) {
             boolean[][] negativeSlice = new boolean[binaryScene[0].length][binaryScene[0][0].length];
             for (int y = 0; y < binaryScene[0].length; y++)
                 for (int x = 0; x < binaryScene[0][0].length; x++)
                     if (!binaryScene[z][y][x])
                         negativeSlice[y][x] = true;

             for (int y = 0; y < negativeSlice.length; y++) {
                 if (negativeSlice[y][0]) {
                     ArrayList<Point> surrounderAir = extract2D(negativeSlice, 0, y, z);
                     for (Point point : surrounderAir) {
                         negativeSlice[point.GetY()][point.GetX()] = false;
                     }
                 }

                 if (negativeSlice[y][negativeSlice[0].length - 1]) {
                     ArrayList<Point> surrounderAir = extract2D(negativeSlice, negativeSlice[0].length - 1, y, z);
                     for (Point point : surrounderAir) {
                         negativeSlice[point.GetY()][point.GetX()] = false;
                     }
                 }
             }

             for (int x = 0; x < negativeSlice[0].length; x++) {
                 if (negativeSlice[0][x]) {
                     ArrayList<Point> surrounderAir = extract2D(negativeSlice, x, 0, z);
                     for (Point point : surrounderAir) {
                         negativeSlice[point.GetY()][point.GetX()] = false;
                     }
                 }

                 if (negativeSlice[negativeSlice[0].length - 1][x]) {
                     ArrayList<Point> surrounderAir = extract2D(negativeSlice, x, negativeSlice[0].length - 1, z);
                     for (Point point : surrounderAir) {
                         negativeSlice[point.GetY()][point.GetX()] = false;
                     }
                 }
             }


             for (int y = 0; y < binaryScene[0].length; y++)
                 for (int x = 0; x < binaryScene[0][0].length; x++)
                     if (negativeSlice[y][x])
                         binaryScene[z][y][x] = true;

         }
     }

    private ArrayList<Point> extract2D(boolean[][] slice, int xo, int yo, int zo) {
        boolean[][] boolSlice = new boolean[slice.length][slice[0].length];
        ArrayList<Point> result = new ArrayList<Point>();
        ArrayDeque<Point> queue = new ArrayDeque<Point>();
        ArrayList<Point> neighbors = new ArrayList<Point>();

        boolSlice[yo][xo] = true;
        result.add(new Point(xo, yo, zo));
        neighbors = this.neighborPoints2D(xo, yo, zo, slice, boolSlice);
        for(Point neighbor : neighbors) {
            queue.add(neighbor);
            result.add(neighbor);
            boolSlice[neighbor.GetY()][neighbor.GetX()] = true;
        }

        neighbors.clear();

        while(queue.size() != 0)
        {
            Point currentPoint = queue.poll();
            int cx = currentPoint.GetX();
            int cy = currentPoint.GetY();

            neighbors = this.neighborPoints2D(cx, cy, zo, slice, boolSlice);
            for(Point neighbor : neighbors) {
                queue.add(neighbor);
                result.add(neighbor);
                boolSlice[neighbor.GetY()][neighbor.GetX()] = true;
            }
        }

        boolSlice = null;
        queue = null;

        return result;
    }

    private ArrayList<Point> neighborPoints2D(int ox, int oy, int oz, boolean[][] slice, boolean[][] booleanSlice)
    {
        int minX = 0, minY = 0, maxX = 0, maxY = 0;

        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;

        if(ox + 1 >= slice[0].length)
            maxX = ox;
        else
            maxX = ox + 1;

        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;

        if(oy + 1 >= slice.length)
            maxY = oy;
        else
            maxY = oy + 1;

        ArrayList<Point> neightbors = new ArrayList<Point>();
        for(int y = minY; y <= maxY; y++)
            for(int x = minX; x <= maxX; x++)
            {
                if(slice[y][x] && (x != ox || y != oy) && !booleanSlice[y][x])
                    neightbors.add(new Point(x, y, oz));
            }

        return neightbors;
    }
}
