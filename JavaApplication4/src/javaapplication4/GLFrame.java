/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

//import com.jogamp.opengl.GLDrawableFactory;
//import java.awt.BorderLayout;
//import java.awt.Frame;
//import java.awt.Canvas;
//import javax.swing.JPanel;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import com.jogamp.opengl.util.Animator;
//import com.jogamp.opengl.awt.GLCanvas;


import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.Color;

/**
 *
 * @author stiv
 */
public class GLFrame extends Frame {
//    
//    private GLCanvas canvas;
//    private Animator anim;
//    
//    public GLFrame() {
//        canvas = new GLCanvas();
//        canvas.setIgnoreRepaint(true);
//        canvas.setSize(500, 500);
//        
//        setTitle("Sample OpenGL Java application");
//        setResizable(true);
//        setLayout(new BorderLayout());
//        add(canvas, BorderLayout.CENTER);
//        setSize(getPreferredSize());
//        this.setLocation(100, 100);
//        
//        canvas.addGLEventListener(new Renderer());
//        
//        anim = new Animator(canvas);
//        anim.setRunAsFastAsPossible(true);
//        
//        anim.start();
//        
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                anim.stop();
//                System.exit(0);
//            }
//        });
//    }
    
    public static void main(String[] args) {
//        GLFrame frame = new GLFrame();
//        frame.setVisible(true);
        Frame frame = new Frame("Hello World");
        GLCanvas canvas = new GLCanvas();
        frame.add(canvas);
        
        frame.setSize(300, 300);
        frame.setBackground(new Color(255, 255, 255, 255));
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        frame.show();
    }
}
