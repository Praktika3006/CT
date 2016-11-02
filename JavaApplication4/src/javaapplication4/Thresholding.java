package javaapplication4;
/**
 * Created by stiv on 25.10.16.
 */
public class Thresholding {
    private int[] arrayOfIntence = new int[3072];
    private int threshold = 0;

    public int GetThreshold(short [][][] scene) {

        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++) {
                    if(scene[z][y][x] >= -1024)
                        arrayOfIntence[scene[z][y][x] + 1024]++;
                }


        double newThreshold = -500.0;

        while((int)newThreshold != this.threshold) {

            this.threshold = (int)newThreshold;

            int i = -1024;
            double objectSumm = 0;
            double objectCount = 0;
            while (i < threshold) {
                objectSumm += arrayOfIntence[i + 1024] * i;
                objectCount += arrayOfIntence[i + 1024];
                i++;
            }

            double backgroundSumm = 0;
            double backgroundCount = 0;
            while (i < 2028) {
                backgroundSumm += arrayOfIntence[i + 1024] * i;
                backgroundCount += arrayOfIntence[i + 1024];
                i++;
            }

            newThreshold = (objectSumm / objectCount + backgroundSumm / backgroundCount) / 2.0;
        }


        return this.threshold;
    }
}
