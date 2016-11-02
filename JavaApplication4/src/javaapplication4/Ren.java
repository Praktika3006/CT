/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.common.nio.Buffers;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import javaapplication4.marchingCubes.*;
import javaapplication4.Objects.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ren implements GLEventListener{
    private static GraphicsEnvironment graphicsEnvironment;
    private static boolean isFullScreen = false;
    public static DisplayMode dm, dm_old;
    private static Dimension xgraphic;
    private static Point point = new Point(0, 0);
    
    private static float xRotation = 0.0f;
    private static float yRotation = 0.0f;
    private static float zRotation = 0.0f;
    private static float scale = 1.0f;
    private static Point mousePos = null;
    
    private static GLCanvas glcanvas = null;
    
    private static ArrayList<Float> verteces = null;
    private static FloatBuffer vertex_data = null;
    
    private static ArrayList<Float> colors = null;
    private static FloatBuffer color_data = null;
    
    private GLU glu = new GLU();
    
    
    

    @Override
    public void init(GLAutoDrawable drawable) {
         final GL2 gl = drawable.getGL().getGL2();
         
         gl.glClearColor(0, 0, 0, 1);
         gl.glEnable(GL2.GL_DEPTH_TEST);
         gl.glShadeModel(GL2.GL_SMOOTH);
         gl.glEnable(GL2.GL_CULL_FACE);
         gl.glPolygonMode(GL2.GL_FRONT, GL2.GL_FILL);
         gl.glEnable(GL2.GL_NORMALIZE);
         
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
       final GL2 gl = drawable.getGL().getGL2();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        
        gl.glScalef(scale, scale, scale);
        gl.glRotatef(xRotation, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(yRotation, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(zRotation, 0.0f, 0.0f, 1.0f);
        
        //gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertexPointer(3, GL.GL_FLOAT, 0, vertex_data);
        gl.glColorPointer(3, GL.GL_FLOAT, 0, color_data);
        
        gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL2.GL_COLOR_ARRAY);
        gl.glDrawArrays(GL2.GL_POINTS, 0, verteces.size() / 3);
        gl.glDisableClientState(GL2.GL_COLOR_ARRAY);
        gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
        
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
        if(height <= 0)
            height = 1;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
    }
    
    
    public static void main(String[] args) {
        
        short[][][] arr = JavaApplication4.ReadDICOMDir("/Volumes/WININSTALL/Snim/Antropova/Antropova M.P/Ser3");
        
//        Thresholding t = new Thresholding();
//        int threshold = t.GetThreshold(arr);
//        
//        boolean[][][] thresholdedVolume = new boolean[arr.length][arr[0].length][arr[0][0].length];
//        for(int z = 0; z < arr.length; z++)
//            for(int y = 0; y < arr[0].length; y++)
//                for(int x = 0; x < arr[0][0].length; x++)
//                    if(arr[z][y][x] < threshold) {
//                        thresholdedVolume[z][y][x] = true;
//                    }
//        
//        LungsExtracting extractor = new LungsExtracting();
//        boolean[][][] lungs = extractor.extract(thresholdedVolume);
//        
//        HoleFilling  hf = new HoleFilling();
//        hf.fillHoles(lungs);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //---------------------СГЛАЖИВАНИЕ--------------------------------------
        GaussianFilter gf = new GaussianFilter(JavaApplication4.x, 
                JavaApplication4.y, JavaApplication4.z);
        short[][][] smoothedScene = gf.applyFilter(arr);
        //----------------------------------------------------------------------
        
        //---------------------ПОИСК 2D УЧАСТКА ТРАХЕИ--------------------------
        ExtractionOfTrahea extractor = new ExtractionOfTrahea(); 
        int slice = 0;
        ArrayList<ArrayList<javaapplication4.Point>> regions = new ArrayList<ArrayList<javaapplication4.Point>>();
        while(regions.size() == 0 && slice < arr.length) {
            regions = extractor.findPotentialRegions(smoothedScene, slice, JavaApplication4.x, JavaApplication4.y);
            slice++;
        }
        
        ArrayList<javaapplication4.Point> trahea2D = null;
        int maxSize = 0;
        for(ArrayList<javaapplication4.Point> region: regions) {
            if(region.size() > maxSize) {
                trahea2D = region;
                maxSize = region.size();
            }
        }
        //----------------------------------------------------------------------
        
        //------------------------ПРОЦЕДУРА 3D РОСТА ОБЛАСТЕЙ-------------------
        AirwaySegmentation3D segmentator = new AirwaySegmentation3D(trahea2D.get(0), 
                JavaApplication4.x,
                JavaApplication4.y,
                JavaApplication4.z);
        
        ArrayList<javaapplication4.Point> airway3D = segmentator.segmentation(smoothedScene);
        
        for(javaapplication4.Point p: airway3D) {
            smoothedScene[p.GetZ()][p.GetY()][p.GetX()] = 9000;
        }
        //----------------------------------------------------------------------
        
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        
        
//        ArrayList<ArrayList<javaapplication4.Point>> elements = new ArrayList<ArrayList<javaapplication4.Point>>();
//
//
//
//        FatDeleter deleter = new FatDeleter();
//        deleter.DeletePlusXFat(arr, -450, 1000, 10);
//        deleter.DeleteMinusXFat(arr, -450, 1000, 10);
//        deleter.DeletePlusYFat(arr, -450, 1000, 10);
//        deleter.DeleteMinusYFat(arr, -450, 1000, 10);
        
//        Extractor e = new Extractor(arr);
//        char[][][] scene = e.Scene();
         
         
        
//         Statistics s = new Statistics();
//         s.Variance(arr);
//         boolean [][][] lowVariance = s.DencityDistribution(arr);
         

         
         //elements = me.Labeling2D(arr[counter], -900, -500, counter);
         
        ////////////////////////
//        MyExtractor me = new MyExtractor();
//        int counter = 0;
//        
//        while(elements.size() == 0)
//        {
//           elements = me.Labeling2D(arr[counter], -1000, -900, counter);
//           elements = me.TraheaExtraction3D(arr, elements, -1700, -930);
//           counter++;
//        }
//                  
//        for(javaapplication4.Point point : elements.get(0))
//        {
//            arr[point.GetZ()][point.GetY()][point.GetX()] = 9000;
//        }
        
//        TracheaFilling tf = new TracheaFilling(arr);
//        tf.FillScene(me.GetToptraheaIntens());
//        arr = tf.GetNewScene();
        //////////////////////////////
       //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++== 
//                                      Нужно
        Skeletonizator sk = new Skeletonizator();
        sk.Skeletonization(smoothedScene);
        Pruning pr = new Pruning(sk.SizeSkelet(), smoothedScene);
        boolean[][] matrixAdj = pr.ConvertIntoGraph(smoothedScene);
        HashSet<javaapplication4.Point> usingPoint = pr.Dijkstra(matrixAdj);
        for(javaapplication4.Point i: usingPoint)
        {
            smoothedScene[i.GetZ()][i.GetY()][i.GetX()] = 9998;
        }   
        for(int z = 0; z < arr.length; z++)
            for(int y = 0; y < arr[0].length; y++)
                for(int x = 0; x < arr[0][0].length; x++)
                    if(smoothedScene[z][y][x] == 9999)
                    {
                        smoothedScene[z][y][x] = 9000;
                    }
        DistanceTransformation dt = new DistanceTransformation(smoothedScene); // Здесь Происходит удаление ненужных ветвей
        
        Smoothing smoo = new Smoothing();
        smoo.smooth(smoothedScene);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        
        
//        int[][][] distanceMap = dt.GetDistanceMap();
//        int[][][] sdistanceMap = dt.skeletalDistanceMap;
        
        //sk.Skeletonization(arr, elements.get(0));
//         
//         me.TraheaCapacity(arr, elements);
//         
//         for(javaapplication4.Point point : elements.get(0))
//         {
//             arr[point.GetZ()][point.GetY()][point.GetX()] = 9999;
//         }
//         
//         me.TraheaCapacity(arr, elements);
//         
//         for(javaapplication4.Point point : elements.get(0))
//         {
//             arr[point.GetZ()][point.GetY()][point.GetX()] = 9999;
//         }
//         
//         Skeletonizator sk = new Skeletonizator();
//         boolean[][][] binaryScene = sk.binarizator(arr, elements.get(0));
//         float[][][] dictanceScene = sk.SquaredEDT(binaryScene);
//         binaryScene = null;
//         boolean[][][] skeleton = sk.ExtractionOfSkeleton(dictanceScene);
//         dictanceScene = null;
         
         
         
         
        int STEPX = 1;
        int STEPY = 1;
        int STEPZ = 1;



        int zl = arr.length / 2;
        int yl = arr[0].length / 2;
        int xl = arr[0][0].length / 2;

        verteces = new ArrayList<Float>();
        colors = new ArrayList<Float>();
        
        //int z = 190;
        for(int z = 0; z < arr.length; z++)
            for(int y = 0; y < arr[0].length; y++)
                for(int x = 0; x < arr[0][0].length; x++)
                    if(smoothedScene[z][y][x] == 9998)
                        {
                           verteces.add(1.0f / xl * (x - xl));
                           verteces.add(1.0f / yl * (y - yl));
                           verteces.add(1.0f / zl * (z - zl));
                           
//                           colors.add((float)((smoothedScene[z][y][x] + 1024) / 2048.0));
//                           colors.add((float)((smoothedScene[z][y][x] + 1024) / 2048.0));
//                           colors.add((float)((smoothedScene[z][y][x] + 1024) / 2048.0));
                           
                           colors.add((float)(255.0 / 255.0));
                           colors.add((float)(255.0 / 255.0));
                           colors.add((float)(255.0 / 255.0));
                        }
        
        //int z = 150;
//        for(int z = 0; z < arr.length; z++)
//            for(int y = 0; y < arr[0].length; y++)
//                for(int x = 0; x < arr[0][0].length; x++)
//                    if(smoothedScene[z][y][x] == 9998)
//                        {
//                           verteces.add(1.0f / xl * (x - xl));
//                           verteces.add(1.0f / yl * (y - yl));
//                           verteces.add(1.0f / zl * (z - zl));
//                           
////                           colors.add((float)((smoothedScene[z][y][x] + 1024) / 2048.0));
////                           colors.add((float)((smoothedScene[z][y][x] + 1024) / 2048.0));
////                           colors.add((float)((smoothedScene[z][y][x] + 1024) / 2048.0));
//                           
//                           colors.add((float)(255.0 / 255.0));
//                           colors.add((float)(255.0 / 255.0));
//                           colors.add((float)(255.0 / 255.0));
//                        }

        
        
//        final short BOTTOM_LIMIT = 2000;
//        final short TOP_LIMIT = 10000;
//        ArrayList<IVariant> varians = new ArrayList<IVariant>();
//        varians.add(new Variant0());
//        varians.add(new Variant1());
//        
//        for(int z = 0; z < arr.length - 2; z++)
//            for(int y = 0; y < arr[0].length - 2; y++)
//                for(int x = 0; x < arr[0][0].length - 2; x++) {
//                    String str = "00000000";
//                    
//                    short v1 = smoothedScene[z][y][x];
//                    if(v1 > BOTTOM_LIMIT && v1 < TOP_LIMIT) {
//                        str = "1" + str.substring(1);
//                    }
//                    
//                    short v2 = smoothedScene[z][y][x + 1];
//                    if(v2 > BOTTOM_LIMIT && v2 < TOP_LIMIT) {
//                        str = str.charAt(0) + "1" + str.substring(2);
//                    }
//                    
//                    short v3 = smoothedScene[z][y + 1][x + 1];
//                    if(v3 > BOTTOM_LIMIT && v3 < TOP_LIMIT) {
//                        str = str.substring(0,1) + "1" + str.substring(3);
//                    }
//                    
//                    short v4 = smoothedScene[z][y + 1][x];
//                    if(v3 > BOTTOM_LIMIT && v3 < TOP_LIMIT) {
//                        str = str.substring(0,2) + "1" + str.substring(4);
//                    }
//                    
//                    short v5 = smoothedScene[z + 1][y][x];
//                    if(v5 > BOTTOM_LIMIT && v5 < TOP_LIMIT) {
//                        str = str.substring(0, 3) + "1" + str.substring(5);
//                    }
//                    
//                    short v6 = smoothedScene[z + 1][y][x + 1];
//                    if(v6 > BOTTOM_LIMIT && v6 < TOP_LIMIT) {
//                        str = str.substring(0, 4) + "1" + str.substring(6);
//                    }
//                    
//                    short v7 = smoothedScene[z + 1][y + 1][x + 1];
//                    if(v7 > BOTTOM_LIMIT && v7 < TOP_LIMIT) {
//                        str = str.substring(0,5) + "1" + str.charAt(7);
//                    }
//                    
//                    short v8 = smoothedScene[z + 1][y + 1][x];
//                    if(v8 > BOTTOM_LIMIT && v8 < TOP_LIMIT) {
//                        str = str.substring(0,6) + "1";
//                    }
//                    
//                    Triangle[] polygons = new Triangle[0];
//                    Triangle[] finalPolygons = new Triangle[0];
//                    for(IVariant variant : varians) {
//                        polygons = variant.chose(str, 
//                                new javaapplication4.Objects.Point(x, y, z, 100));
//                        System.arraycopy(polygons, 0, finalPolygons, finalPolygons.length, polygons.length);
//                    }
//                }
        
        
         

        vertex_data = Buffers.newDirectFloatBuffer(verteces.size());
        color_data = Buffers.newDirectFloatBuffer(colors.size());

        for(int i = 0; i < verteces.size(); i++)
        {
            vertex_data.put(verteces.get(i));
            color_data.put(colors.get(i));
        }


        vertex_data.rewind();
        color_data.rewind();
         
         
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        
        glcanvas = new GLCanvas(capabilities);
        Ren r = new Ren();
        glcanvas.addGLEventListener(r);
        
        
        glcanvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {                
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                xRotation += 180 / scale * (e.getY() - mousePos.y) / glcanvas.getHeight();
                yRotation += 180 / scale * (e.getX() - mousePos.x) / glcanvas.getWidth();
                mousePos = e.getPoint();
            }
        });
        
        glcanvas.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                mousePos = e.getPoint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePos = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
           
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        });
        
        
        
        glcanvas.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(e.getWheelRotation() > 0)
                    scale *= 1.1;
                else
                    if (e.getWheelRotation() < 0)
                        scale /= 1.1;
            }       
        });
        
        
        
        glcanvas.setSize(1000, 1000);
        
        final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
        
        final JFrame frame = new JFrame("Lesson 1");
        
        frame.getContentPane().add(glcanvas);
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                if(animator.isStarted())
                    animator.stop();
                System.exit(0);
            }
        });
        
        frame.setSize(frame.getContentPane().getPreferredSize());
        
        graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        GraphicsDevice[] devices = graphicsEnvironment.getScreenDevices();
        
        dm_old = devices[0].getDisplayMode();
        dm = dm_old;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int windowX = Math.max(0, (screenSize.width - frame.getWidth()) / 2);
        int windowY = Math.max(0, (screenSize.height - frame.getHeight()) / 2);
        
        frame.setLocation(windowY, windowY);
        
        frame.setVisible(true);
        
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(0, 0));
        frame.add(p, BorderLayout.SOUTH);
        
        animator.start();
    }
    
    
//    private static void keyBindings(JPanel p, final JFrame frame, final Ren r)
//    {
//        ActionMap actionMap = p.getActionMap();
//        InputMap inputMap = p.getInputMap();
//        
//        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1");
//        actionMap.put("F1", new AbstractAction(){
//            
//            @Override
//            public void actionPerformed(ActionEvent drawable) {
//                fullScreen(frame);
//            }
//        });
//    }
//    
//    
//    protected static void fullScreen(JFrame f) {
//        if(!isFullScreen){
//            f.dispose();
//            f.setUndecorated(true);
//            f.setVisible(true);
//            f.setResizable(false);
//            xgraphic = f.getSize();
//            point = f.getLocation();
//            f.setLocation(0, 0);
//            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//            f.setSize((int) screenSize.width, (int)screenSize.height);
//            isFullScreen = true;
//        } else {
//            f.dispose();
//            f.setUndecorated(true);
//            f.setResizable(true);
//            f.setLocation(point);
//            f.setSize(xgraphic);
//            f.setVisible(true);
//            
//            isFullScreen = false;
//        }
//    }
    
}
