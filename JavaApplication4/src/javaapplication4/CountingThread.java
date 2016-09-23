/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author stiv
 */
public class CountingThread implements Runnable{
    
    CommonResources res;
    Semaphore sem;
    
    CountingThread(CommonResources res, Semaphore sem)
    {
        this.res = res;
        this.sem = sem;
    }
    

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
