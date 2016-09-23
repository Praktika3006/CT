/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 *
 * @author stiv
 */
public class Renderer implements GLEventListener, KeyListener{
    public float xRotation = 0.0f;
    public float yRotation = 0.0f;
    public float zRotation = 0.0f;
    public float scale = 1.0f;
    
    public Renderer() {
        
    }
    
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();        
        gl.glClearColor(0f, 0f, 0f, 0f);
        gl.glClearDepth(1f);
        gl.glDepthFunc(GL2.GL_LESS);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45f, 4f/3f, 0.1f, 100f);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, new float[]{1f, 1f, 1f, 1f}, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, new float[]{0f, 0f, 1f, 0f}, 0); 
    }


    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0f, 0f, -5f);
        glut.glutSolidTeapot(1);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {
        GL2 gl = drawable.getGL().getGL2();
        
        gl.glViewport(x, y, width, height);
    }
    
    @Override
    public void dispose(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
    }
    
    
    private void drawAxis(GLAutoDrawable drawable)
    {
        GL2 gl = drawable.getGL().getGL2();
        gl.glLineWidth(3.0f);
        
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        gl.glBegin(GL2.GL_LINES);
            gl.glVertex3f(1.0f, 0.0f, 0.0f);
            gl.glVertex3f(-1.0f, 0.0f, 0.0f);
        gl.glEnd();
        
        gl.glColor4f(0.0f, 0.5f, 0.0f, 1.0f);
        gl.glBegin(GL2.GL_LINES);
            gl.glVertex3f(0.0f, 1.0f, 0.0f);
            gl.glVertex3f(0.0f, -1.0f, 0.0f);
        gl.glEnd();
        
        gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
        gl.glBegin(GL2.GL_LINES);
            gl.glVertex3f(0.0f, 0.0f, 1.0f);
            gl.glVertex3f(0.0f, 0.0f, -1.0f);
        gl.glEnd();
    }
    

}
