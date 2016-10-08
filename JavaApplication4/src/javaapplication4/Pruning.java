/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ekaterem
 */
public class Pruning {
    private int sizeSkelet;
    private ArrayList<Point> skeletArray;
    public ArrayList<Integer> leafs = new ArrayList<Integer>();
    private int root = -1;
    private int V = 0;
    
    
    public Pruning (int size, short[][][] scene)
    {
        sizeSkelet = size;
        SkeletArray(scene);
        FindRoot();
    }
    
    public ArrayList<Point> SkeletArray()
    {
        return this.skeletArray;
    }
    
    public void SkeletArray(short[][][] scene)
    {
       skeletArray = new ArrayList<Point>();
       for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                    if (scene[z][y][x]==9999)
                    {
                        skeletArray.add(new Point(x,y,z));
                    }      
    }
    
    public void FindLeafs(boolean[][] matrixAdjacency)
    {
        for(int i=0;i<matrixAdjacency.length;i++)
        {
            int count = 0;
            for (int j=0;j<matrixAdjacency.length;j++)
            {
                if (matrixAdjacency[i][j]==true) count++;
            }
            if (count == 1) leafs.add(i);
        }
    }
    
    public int IndexOfPoint(int x, int y, int z)
    {
        for(Point p : skeletArray)
        {
            if (p.GetX()== x && p.GetY() == y && p.GetZ() == z)
            {
                return skeletArray.indexOf(p);
            }
        }
        return -1;
    }
    
    public boolean[][] ConvertIntoGraph(short[][][] scene)
    {
        boolean[][] matrixAdjacency = new boolean[sizeSkelet][sizeSkelet];
        
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                {
                    if(scene[z][y][x] == 9999)
                    {
                        int i = IndexOfPoint(x,y,z);
                        // ----1------
                        if(x - 1 >= 0 && y - 1 >= 0 && z + 1 < scene.length)
                        {
                            if(scene[z + 1][y - 1][x - 1] == 9999)
                            {
                                int j = IndexOfPoint(x-1,y-1,z+1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }
                        // ----2------
                        if(y - 1 >= 0 && z + 1 < scene.length)
                        {
                            if(scene[z + 1][y - 1][x] == 9999)
                            {
                                int j = IndexOfPoint(x,y-1,z+1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----3------
                        if(x + 1 < scene[0][0].length && y - 1 >= 0 && z + 1 < scene.length)
                        {
                            if(scene[z + 1][y - 1][x + 1] == 9999)
                            {
                                int j = IndexOfPoint(x+1,y-1,z+1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }
                        
                        // ----4------
                        if(x - 1 >= 0 && z + 1 < scene.length)
                        {
                            if(scene[z + 1][y][x - 1] == 9999)
                            {
                                int j = IndexOfPoint(x-1,y,z+1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----5------
                        if(z + 1 < scene.length)
                        {
                            if(scene[z + 1][y][x] == 9999)
                            {
                                int j = IndexOfPoint(x,y,z+1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----6------
                        if(x + 1 < scene[0][0].length && z + 1 < scene.length)
                        {
                            if(scene[z + 1][y][x + 1] == 9999)
                            {
                                int j = IndexOfPoint(x+1,y,z+1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----7------
                        if(x - 1 >= 0 && y + 1 < scene[0].length && z + 1 < scene.length)
                        {
                            if(scene[z + 1][y + 1][x - 1] == 9999)
                            {
                                int j = IndexOfPoint(x-1,y+1,z+1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----8------
                        if(y + 1 < scene[0].length && z + 1 < scene.length)
                        {
                            if(scene[z + 1][y + 1][x] == 9999)
                            {
                                int j = IndexOfPoint(x,y+1,z+1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----9------
                        if(x + 1 < scene[0][0].length && y + 1 < scene[0].length && z + 1 < scene.length)
                        {
                            if(scene[z + 1][y + 1][x + 1] == 9999)
                            {
                                int j = IndexOfPoint(x+1,y+1,z+1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----10------
                        if(x - 1 >= 0 && y - 1 >= 0)
                        {
                            if(scene[z][y - 1][x - 1] == 9999)
                            {
                                int j = IndexOfPoint(x-1,y-1,z);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----11------
                        if(y - 1 >= 0)
                        {
                            if(scene[z][y - 1][x] == 9999)
                            {
                                int j = IndexOfPoint(x,y-1,z);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----12------
                        if(x + 1 < scene[0][0].length && y - 1 >= 0)
                        {
                            if(scene[z][y - 1][x + 1] == 9999)
                            {
                                int j = IndexOfPoint(x+1,y-1,z);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----13------
                        if(x - 1 >= 0)
                        {
                            if(scene[z][y][x - 1] == 9999)
                            {
                                int j = IndexOfPoint(x-1,y,z);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----14------
                        if(x + 1 < scene[0][0].length)
                        {
                            if(scene[z][y][x + 1] == 9999)
                            {
                                int j = IndexOfPoint(x+1,y,z);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----15------
                        if(x - 1 >= 0 && y + 1 < scene[0].length)
                        {
                            if(scene[z][y + 1][x - 1] == 9999)
                            {
                                int j = IndexOfPoint(x-1,y+1,z);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----16------
                        if(y + 1 < scene[0].length)
                        {
                            if(scene[z][y + 1][x] == 9999)
                            {
                                int j = IndexOfPoint(x,y+1,z);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----17------
                        if(x + 1 < scene[0][0].length && y + 1 < scene[0].length)
                        {
                            if(scene[z][y + 1][x + 1] == 9999)
                            {
                                int j = IndexOfPoint(x+1,y+1,z);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----18------
                        if(x - 1 >= 0 && y - 1 >= 0 && z - 1 >= 0)
                        {
                            if(scene[z - 1][y - 1][x - 1] == 9999)
                            {
                                int j = IndexOfPoint(x-1,y-1,z-1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----19------
                        if(y - 1 >= 0 && z - 1 >= 0)
                        {
                            if(scene[z - 1][y - 1][x] == 9999)
                            {
                                int j = IndexOfPoint(x,y-1,z-1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----20------
                        if(x + 1 < scene[0][0].length && y - 1 >= 0 && z - 1 >= 0)
                        {
                            if(scene[z - 1][y - 1][x + 1] == 9999)
                            {
                                int j = IndexOfPoint(x+1,y-1,z-1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----21------
                        if(x - 1 >= 0 && z - 1 >= 0)
                        {
                            if(scene[z - 1][y][x - 1] == 9999)
                            {
                                int j = IndexOfPoint(x-1,y,z-1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----22------
                        if(z - 1 >= 0)
                        {
                            if(scene[z - 1][y][x] == 9999)
                            {
                                int j = IndexOfPoint(x,y,z-1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----23------
                        if(x + 1 < scene[0][0].length && z - 1 >= 0)
                        {
                            if(scene[z - 1][y][x + 1] == 9999)
                            {
                                int j = IndexOfPoint(x+1,y,z-1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----24------
                        if(x - 1 >= 0 && y + 1 < scene[0].length && z - 1 >= 0)
                        {
                            if(scene[z - 1][y + 1][x - 1] == 9999)
                            {
                                int j = IndexOfPoint(x-1,y+1,z-1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----25------
                        if(y + 1 < scene[0].length && z - 1 >= 0)
                        {
                            if(scene[z - 1][y + 1][x] == 9999)
                            {
                                int j = IndexOfPoint(x,y+1,z-1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }

                        // ----26------
                        if(x + 1 < scene[0][0].length && y + 1 < scene[0].length && z - 1 >= 0)
                        {
                            if(scene[z - 1][y + 1][x + 1] == 9999)
                            {
                                int j = IndexOfPoint(x+1,y+1,z-1);
                                matrixAdjacency[i][j] = true;
                                matrixAdjacency[j][i] = true;
                            }
                        }
                    }
                }
        
        this.V = matrixAdjacency.length;
        return matrixAdjacency;
    }
    
    private void FindRoot()
    {
        int z = 0;
        while(this.root == -1)
        {
            for(Point p : skeletArray)
            {
                if (p.GetZ() == z)
                {
                    this.root = skeletArray.indexOf(p);
                    return;
                }
            }
            z++;
        }
        this.root = -1;
    }
    
    private int Root()
    {
        return this.root;
    }
    
    private int FindConstMark(Mark[][] matrixDijkstra, int step)
    {
        for (int i=0;i<matrixDijkstra.length;i++)
        {
            if (matrixDijkstra[step][i]!=null)
            {
                if (matrixDijkstra[step][i].GetType() == true)
                {
                    return i;
                }
            }
        }
        return -1;
    }
        
    private int minDistance(int[] dist, boolean[] sptSet)
    {
        int min = Integer.MAX_VALUE, min_index = -1;
        
        for(int v = 0; v < this.V; v++)
            if(sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
    
     public ArrayList<Point> Dijkstra(boolean[][] matrixAdjacency)
     {
         ArrayList<Point> res = new ArrayList<Point>();
         FindLeafs(matrixAdjacency);
         int[] dist = new int[V];
         boolean[] sptSet = new boolean[V];
         int[] parent = new int[V];
         
         for(int i = 0; i < V; i++)
         {
             parent[0] = -1;
             dist[i] = Integer.MAX_VALUE;
             sptSet[i] = false;
         }
         System.out.println(root);
         dist[this.root] = 0;
         
         for(int count = 0; count < V - 1; count++)
         {
             int u = minDistance(dist, sptSet);
             sptSet[u] = true;
             
             for(int v = 0; v < V; v++)
             {
                 if(!sptSet[v] && matrixAdjacency[u][v] && dist[u] + 1 < dist[v])
                 {
                     parent[v] = u;
                     dist[v] = dist[u] + 1;
                 }
             }
         }
        for (int i:this.leafs)
        {
            int a = i;
            ArrayList<Point> way = new ArrayList<Point>();
            while(a!=-1)
            {
                way.add(SkeletArray().get(a));
                a=parent[a];
            }
            way.add(SkeletArray().get(Root()));
            res.addAll(way);
        }
        return res;
     }
}
