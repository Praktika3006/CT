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
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.nio.FloatBuffer;
import java.util.ArrayList;
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
        
        float[][][] arr = JavaApplication4.ReadDICOMDir("/Volumes/WININSTALL/Снимки/BELYANIN A.V/Новая папка");
         

        
        ArrayList<ArrayList<javaapplication4.Point>> elements = new ArrayList<ArrayList<javaapplication4.Point>>();



        FatDeleter deleter = new FatDeleter();
        deleter.DeletePlusXFat(arr, -450, 1000, 10);
        deleter.DeleteMinusXFat(arr, -450, 1000, 10);
        deleter.DeletePlusYFat(arr, -450, 1000, 10);
        deleter.DeleteMinusYFat(arr, -450, 1000, 10);
        
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
        
//                                      Нужно
//        Skeletonizator sk = new Skeletonizator();
//        sk.Skeletonization(arr);
//        Pruning pr = new Pruning(sk.SizeSkelet(), arr);
//        boolean[][] matrixAdj = pr.ConvertIntoGraph(arr);
//        ArrayList<javaapplication4.Point> usingPoint = pr.Dijkstra(matrixAdj);
//        for(javaapplication4.Point i: usingPoint)
//        {
//            arr[i.GetZ()][i.GetY()][i.GetX()] = 9998;
//        }   
//        for(int z = 0; z < arr.length; z++)
//            for(int y = 0; y < arr[0].length; y++)
//                for(int x = 0; x < arr[0][0].length; x++)
//                    if(arr[z][y][x] == 9999)
//                    {
//                        arr[z][y][x] = 9000;
//                    }
//        DistanceTransformation dt = new DistanceTransformation(arr);
        
        
        
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

        int BOTTOM_LIMIT = -900;
        int TOP_LIMIT = -500;

        int zl = arr.length / 2;
        int yl = arr[0].length / 2;
        int xl = arr[0][0].length / 2;

        verteces = new ArrayList<Float>();
        colors = new ArrayList<Float>();
        
 
        for(int z = 0; z < arr.length; z++)
        //int z = 40;
            for(int y = 0; y < arr[0].length; y++)
                for(int x = 0; x < arr[0][0].length; x++)
                    if(arr[z][y][x] > 200)
                        {
                           verteces.add(1.0f / xl * (x - xl));
                           verteces.add(1.0f / yl * (y - yl));
                           verteces.add(1.0f / zl * (z - zl));
                           colors.add((float)(255.0 / 255.0));
                           colors.add((float)(255.0 / 255.0));
                           colors.add((float)(255.0 / 255.0));
                        }

//        for(int z = 0; z < arr.length; z++)
//            for(int y = 0; y < arr[0].length; y++)
//                for(int x = 0; x < arr[0][0].length; x++)
//                    if(arr[z][y][x] == 9988)
//                        {
//                           verteces.add(1.0f / xl * (x - xl));
//                           verteces.add(1.0f / yl * (y - yl));
//                           verteces.add(1.0f / zl * (z - zl));
//                           colors.add((float)(255.0 / 255.0));
//                           colors.add((float)(0.0 / 255.0));
//                           colors.add((float)(0.0 / 255.0));
//                        }
        
        
        
        
        
        
        
        
        
        
        
         
//         for(javaapplication4.Point p : elem)
//            {
//               verteces.add(1.0f / xl * (p.GetX() - xl));
//               verteces.add(1.0f / yl * (p.GetY() - yl));
//               verteces.add(1.0f / zl * (p.GetZ() - zl));
//               colors.add((float)(255.0 / 255.0));
//               colors.add((float)(255.0 / 255.0));
//               colors.add((float)(255.0 / 255.0));
//            }
//         
//         ArrayList<javaapplication4.Point> newArr = null;
//
//
//         
//         for(int i = 0; i < elements.size(); i++)
//         {
//            newArr = elements.get(i);
//         
//            for(javaapplication4.Point p : newArr)
//            {
//               verteces.add(1.0f / xl * (p.GetX() - xl));
//               verteces.add(1.0f / yl * (p.GetY() - yl));
//               verteces.add(1.0f / zl * (p.GetZ() - zl));
//               colors.add((float)(253.0 / 255.0));
//               colors.add((float)(189.0 / 255.0));
//               colors.add((float)(63.0 / 255.0));
//            }
//         }
//         
//         elements = new ArrayList<ArrayList<javaapplication4.Point>>();
//         counter = arr.length / 4;
//         
////         elements = me.Labeling2D(arr[counter], -900, -500, counter);
////         elements = me.LungExtracting2D(elements);
//         
//         while(elements.size() == 0)
//         {
//            elements = me.Labeling2D(arr[counter], -900, -500, counter);
//            elements = me.LungExtraction3D(arr, elements, -900, -500);
//            counter++;
//         }
//         
//         for(javaapplication4.Point point : elements.get(0))
//         {
//             arr[point.GetZ()][point.GetY()][point.GetX()] = 9989;
//         }
//         
//         for(javaapplication4.Point point : elements.get(1))
//         {
//             arr[point.GetZ()][point.GetY()][point.GetX()] = 9988;
//         }
//         
//         elements.clear();
//         
//         elements.add(me.ShellSelection(arr, 9989));
//         elements.add(me.ShellSelection(arr, 9988));
//         
//         
//         for(int i = 0; i < elements.size(); i++)
//         {
//             newArr = elements.get(i);
//         
//            for(javaapplication4.Point p : newArr)
//            {
//               verteces.add(1.0f / xl * (p.GetX() - xl));
//               verteces.add(1.0f / yl * (p.GetY() - yl));
//               verteces.add(1.0f / zl * (p.GetZ() - zl));
//               colors.add((float)(112.0 / 255.0));
//               colors.add((float)(183.0 / 255.0));
//               colors.add((float)(184.0 / 255.0));
//            }
//         }
//         
//         ArrayList<javaapplication4.Point> elem = new ArrayList<javaapplication4.Point>();
//         
//         for(int z = 0; z < arr.length; z++)
//             for(int y = 0; y < arr[0].length; y++)
//                 for(int x = 0; x < arr[0][0].length; x++)
//                     if(arr[z][y][x] > -1100 &&  arr[z][y][x] < -950)
//                         elem.add(new javaapplication4.Point(x, y, z));
//         
//         for(javaapplication4.Point p : elem)
//            {
//               verteces.add(1.0f / xl * (p.GetX() - xl));
//               verteces.add(1.0f / yl * (p.GetY() - yl));
//               verteces.add(1.0f / zl * (p.GetZ() - zl));
//               colors.add((float)(255.0 / 255.0));
//               colors.add((float)(255.0 / 255.0));
//               colors.add((float)(255.0 / 255.0));
//            }
         

        vertex_data = Buffers.newDirectFloatBuffer(verteces.size());
        color_data = Buffers.newDirectFloatBuffer(colors.size());

        for(int i = 0; i < verteces.size(); i++)
        {
            vertex_data.put(verteces.get(i));
            color_data.put(colors.get(i));
        }
        
        System.out.println(verteces.size());


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
