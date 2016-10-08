package javaapplication4;

import java.util.ArrayList;

public class GeodesicDistance {

    public class Triplet<T, U, V>
    {
        private T a;
        private U b;
        private V c;

        Triplet(T a, U b, V c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        T getA() { return a; }
        U getB() { return b; }
        V getC() { return c; }
    }


    public double[][] computingDistance(short[][] slice, int sourceX, int sourceY) {
        final int sliceHeight = slice.length;
        final int sliceWidth = slice[0].length;
        final double MAX_VALUE = sliceHeight * sliceWidth * 3000.0;

        double[][] shortestPathToVertex = new double[sliceHeight][sliceWidth];
        boolean[][] verticesMarks = new boolean[sliceHeight][sliceWidth];


        for(int i = 0; i < sliceHeight; i++) {
            for (int j = 0; j < sliceWidth; j++) {
                shortestPathToVertex[i][j] = sliceHeight * sliceWidth * 2000.0;
            }
        }
        shortestPathToVertex[sourceY][sourceX] = 0;
        
        int count = 1;
        for(int iter = 0; iter < sliceWidth * sliceHeight; iter++) {
            System.out.println(count);
            count++;
            int minVertexX = -1;
            int minVertexY = -1;
            double minVertexValue = MAX_VALUE;
            for(int y = 0; y < sliceHeight; y++) {
                for (int x = 0; x < sliceWidth; x++) {
                    if(!verticesMarks[y][x]) {
                        if(shortestPathToVertex[y][x] < minVertexValue) {
                            minVertexValue = shortestPathToVertex[y][x];
                            minVertexX = x;
                            minVertexY = y;
                        }
                    }
                }
            }

            verticesMarks[minVertexY][minVertexX] = true;

            ArrayList<Triplet<Integer, Integer, Double>> neighbors =
                    this.vertexNeighborhood(slice, minVertexX, minVertexY);

            for(Triplet<Integer, Integer, Double> vertex : neighbors) {
                int neighborX = vertex.getA().intValue();
                int neighborY = vertex.getB().intValue();
                double pathToNeighbor = vertex.getC().doubleValue();
                double generalPath = shortestPathToVertex[minVertexY][minVertexX] + vertex.getC().doubleValue();

                if(shortestPathToVertex[neighborY][neighborX] > generalPath) {
                    shortestPathToVertex[neighborY][neighborX] = generalPath;
                }
            }
        }

        return shortestPathToVertex;
    }

    private double computingEuclidianDistance(short[][] slice, int x1, int y1, int x2, int y2) {
        double euclidianDistance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) +
        Math.pow(slice[y1][x1] - slice[y2][x2], 2));
        return euclidianDistance;
    }

    private ArrayList<Triplet<Integer, Integer, Double>> vertexNeighborhood(short[][] slice, int centerX, int centerY) {
        ArrayList<Triplet<Integer, Integer, Double>> neighbors =
                new ArrayList<Triplet<Integer, Integer, Double>> ();

        int minX = centerX - 1;
        if(minX < 0) {
            minX = 0;
        }

        int maxX = centerX + 1;
        if(maxX >= slice[0].length) {
            maxX = slice[0].length - 1;
        }

        int minY = centerY - 1;
        if(minY < 0) {
            minY = 0;
        }

        int maxY = centerY + 1;
        if(maxY >= slice.length) {
            maxY = slice.length - 1;
        }

        for(int y = minY; y <= maxY; y++) {
            for(int x = minX; x <= maxX; x++) {
                if(x != centerX && y != centerY) {
                    neighbors.add(new Triplet<Integer, Integer, Double>(new Integer(x),
                            new Integer(y),
                            new Double(computingEuclidianDistance(slice, centerX, centerY, x, y))));
                }
            }
        }

        return neighbors;
    }
}
