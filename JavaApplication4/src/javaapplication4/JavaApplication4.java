/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import com.sun.image.codec.jpeg.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;
import org.dcm4che2.data.*;
import org.dcm4che2.imageio.plugins.dcm.*;
import org.dcm4che2.io.*;
import org.dcm4che2.tool.dcmqr.*;
import org.dcm4che2.data.Tag;
import java.lang.*;


public class JavaApplication4 {

    public static float x;
    public static float y;
    public static float z;
    
    
    public static DicomObject GetDicomObject(File file)
    {
        DicomObject dcmObj;
        DicomInputStream din = null;
        try {            
            din = new DicomInputStream(file);
            dcmObj = din.readDicomObject();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try {
                din.close();
            }
            catch (IOException ignore){                
            }
        }
        return dcmObj;
    }
    
    
    
    
    public static float[][] ReadDICOMFile(DicomObject dcmObj)
    {    
        float rescaleSlope = dcmObj.getFloat(Tag.RescaleSlope);
        float rescaleIntercept = dcmObj.getFloat(Tag.RescaleIntercept);
        short[] pixelData = dcmObj.getShorts(Tag.PixelData);
        short pixelRepresentation = (short)dcmObj.getInt(Tag.PixelRepresentation);
        
        
        
        
        
        int columnNumber = dcmObj.getInt(Tag.Columns);
        int rowsNumber = dcmObj.getInt(Tag.Rows);
        
        float[][] convertedValues = new float[rowsNumber][columnNumber];
        
        float val;
        short datum;
        for(int i = 0; i<pixelData.length; i++)
        {
            int x = i % columnNumber;
            int y = (i-x) / rowsNumber;
            datum = (short)pixelData[i];
            val = rescaleSlope * ((~datum + 1) * (-1)) + rescaleIntercept;
            convertedValues[y][x] = val;
        }

        return convertedValues;
    }
    
    public static short[][][] ReadDICOMDir(String dirName)
    {
        File myFolder = new File(dirName);
        File[] files = myFolder.listFiles(new FilenameFilter(){
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(".dcm");
            }
        });
        
        DicomObject dcmObj = GetDicomObject(files[0]);
        
        float[] pixelSpacing = dcmObj.getFloats(Tag.PixelSpacing);
        x = pixelSpacing[0];
        y = pixelSpacing[1];
        z = dcmObj.getFloat(Tag.SliceThickness);
        
        
        float[][][] dicomData = null;
        int count = 0;
        int xSize = 0;
        int ySize = 0;
        for (int i = 0; i < files.length; i++)
        {
            dcmObj = GetDicomObject(files[i]);
            pixelSpacing = dcmObj.getFloats(Tag.PixelSpacing);
            float zpix = dcmObj.getFloat(Tag.SliceThickness);
            if(x != pixelSpacing[0] || y != pixelSpacing[1] || z !=zpix)
                break;    
            
            count++;
            
            float [][] arr2 = ReadDICOMFile(dcmObj);
            xSize = arr2[0].length;
            ySize = arr2.length;
            if (i == 0)
            {
                dicomData = new float[files.length][arr2.length][arr2[0].length];
            }
            for (int j = 0; j<arr2.length; j++)
                for (int k = 0; k<arr2[0].length; k++)
                    dicomData[i][j][k] = arr2[j][k];
        }
        
        short[][][] dicomData1 = new short[count][ySize][xSize];
        
        for(int i = 0; i < count; i++)
            for (int j = 0; j<ySize; j++)
                for (int k = 0; k<xSize; k++)
                    dicomData1[i][j][k] = (short)dicomData[i][j][k];
        
        return dicomData1;
    }
    
}
