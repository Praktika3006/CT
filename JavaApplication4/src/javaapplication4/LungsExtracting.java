package javaapplication4;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by stiv on 28.10.16.
 */
public class LungsExtracting {

    public boolean[][][] extract(boolean[][][] scene) {
        int z = scene.length / 2;
        boolean[][] slice = scene[z];
        System.out.println("1");
        for (int y = 0; y < scene[0].length; y++) {
            if (slice[y][0]) {
                ArrayList<Point> surrounderAir = extract2D(slice, 0, y, z);
                for (Point point : surrounderAir) {
                    slice[point.GetY()][point.GetX()] = false;
                }
            }

            if (slice[y][slice[0].length - 1]) {
                ArrayList<Point> surrounderAir = extract2D(slice, slice[0].length - 1, y, z);
                for (Point point : surrounderAir) {
                    slice[point.GetY()][point.GetX()] = false;
                }
            }
        }
        System.out.println("2");
        for (int x = 0; x < scene[0][0].length; x++) {
            if (slice[0][x]) {
                ArrayList<Point> surrounderAir = extract2D(slice, x, 0, z);
                for (Point point : surrounderAir) {
                    slice[point.GetY()][point.GetY()] = false;
                }
            }

            if (slice[slice[0].length - 1][x]) {
                ArrayList<Point> surrounderAir = extract2D(slice, x, slice[0].length - 1, z);
                for (Point point : surrounderAir) {
                    slice[point.GetY()][point.GetY()] = false;
                }
            }
        }

        System.out.println("3");
        ArrayList<ArrayList<Point>> objectsOnSlice = this.labeling2D(slice, z);
        
        System.out.println("4");
        int maxSize = 0;
        ArrayList<Point> maxObject = null;
        for (ArrayList<Point> object2D : objectsOnSlice) {
            if (object2D.size() > maxSize) {
                maxSize = object2D.size();
                maxObject = object2D;
            }
        }
        
        System.out.println("4");
        ArrayList<Point> pointsOfFirstLung = this.extract3D(scene, maxObject.get(0).GetX(),
                maxObject.get(0).GetY(), maxObject.get(0).GetZ());
        
        System.out.println("5");
        objectsOnSlice.remove(maxObject);
        ArrayList<Point> secondBySizeObject = null;
        maxSize = 0;
        for (ArrayList<Point> object2D : objectsOnSlice) {
            if (object2D.size() > maxSize) {
                maxSize = object2D.size();
                secondBySizeObject = object2D;
            }
        }
        
        System.out.println("6");
        ArrayList<Point> pointsOfSecondLung = null;
        if (secondBySizeObject.size() > maxObject.size() / 2) {
            pointsOfSecondLung = this.extract3D(scene, secondBySizeObject.get(0).GetX(),
                    secondBySizeObject.get(0).GetY(), secondBySizeObject.get(0).GetZ());
        }
        
        System.out.println("7");
        boolean[][][] sceneWithLungs = new boolean [scene.length][scene[0].length][scene[0][0].length];
        for(Point point : pointsOfFirstLung) {
            sceneWithLungs[point.GetZ()][point.GetY()][point.GetX()] = true;
        }

        if (pointsOfSecondLung != null) 
            for(Point point : pointsOfSecondLung) {
                sceneWithLungs[point.GetZ()][point.GetY()][point.GetX()] = true;
            }

        return sceneWithLungs;
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

    private ArrayList<ArrayList<Point>> labeling2D(boolean[][] slice, int z) {
        boolean[][] boolSlice = new boolean[slice.length][slice[0].length];
        ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();

        for (int y = 0; y < slice.length; y++)
            for (int x = 0; x < slice[0].length; x++) {
                if (!boolSlice[y][x] && slice[y][x]) {
                    ArrayList<Point> object = this.extract2D(slice, x, y, z);
                    for (Point point : object) {
                        boolSlice[point.GetY()][point.GetX()] = true;
                    }
                    result.add(object);
                }
            }

        return result;
    }

    private ArrayList<Point> neighborPoints3D(int ox, int oy, int oz, boolean[][][] scene, boolean[][][] booleanScene)
    {
        int minX = 0, minY = 0, maxX = 0, maxY = 0, minZ = 0, maxZ = 0;

        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;

        if(ox + 1 >= scene[0][0].length)
            maxX = ox;
        else
            maxX = ox + 1;

        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;

        if(oy + 1 >= scene[0].length)
            maxY = oy;
        else
            maxY = oy + 1;

        if(oz - 1 < 0)
            minZ = 0;
        else
            minZ = oz - 1;

        if(oz + 1 >= scene.length)
            maxZ = oz;
        else
            maxZ = oz + 1;

        ArrayList<Point> neightbors = new ArrayList<Point>();
        for(int z = minZ; z <= maxZ; z++)
            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    if(scene[z][y][x] && 
                            (x != ox || y != oy || z != oz) && 
                            !booleanScene[z][y][x] &&
                            Math.sqrt(Math.pow(oz - z, 2) + Math.pow(oy - y, 2) + Math.pow(ox - x, 2)) < Math.sqrt(3))
                        neightbors.add(new Point(x, y, z));
                }

        return neightbors;
    }

    private ArrayList<Point> extract3D(boolean[][][] scene, int xo, int yo, int zo) {
        boolean[][][] boolScene = new boolean[scene.length][scene[0].length][scene[0][0].length];
        ArrayList<Point> result = new ArrayList<Point>();
        ArrayDeque<Point> queue = new ArrayDeque<Point>();
        ArrayList<Point> neighbors = new ArrayList<Point>();

        boolScene[zo][yo][xo] = true;
        result.add(new Point(xo, yo, zo));
        neighbors = this.neighborPoints3D(xo, yo, zo, scene, boolScene);
        for(Point neighbor : neighbors) {
            queue.add(neighbor);
            result.add(neighbor);
            boolScene[neighbor.GetZ()][neighbor.GetY()][neighbor.GetX()] = true;
        }

        neighbors.clear();

        while(queue.size() != 0)
        {
            Point currentPoint = queue.poll();
            int cx = currentPoint.GetX();
            int cy = currentPoint.GetY();
            int cz = currentPoint.GetZ();

            neighbors = this.neighborPoints3D(cx, cy, cz, scene, boolScene);
            for(Point neighbor : neighbors) {
                queue.add(neighbor);
                result.add(neighbor);
                boolScene[neighbor.GetZ()][neighbor.GetY()][neighbor.GetX()] = true;
            }
        }

        boolScene = null;
        queue = null;

        return result;
    }
}
