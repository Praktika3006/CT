package javaapplication4;
/**
 * Created by stiv on 20.10.16.
 */
public class Smoothing {

    public void smooth(short[][][] scene) {
        int count = 0;

        do {
            count = 0;
            for(int z = 1; z < scene.length - 1; z++)
                for(int y = 1; y < scene[0].length - 1; y++)
                    for(int x = 1; x < scene[0][0].length - 1; x++) {
                        int t = 0;

                        t = f1(scene, x, y, z);
                        if(t > 0) {
                            count++;
                            continue;
                        }

                        t = f2(scene, x, y, z);
                        if(t > 0) {
                            count++;
                            continue;
                        }

                        t = f3(scene, x, y, z);
                        if(t > 0) {
                            count++;
                            continue;
                        }

                        t = f4(scene, x, y, z);
                        if(t > 0) {
                            count++;
                            continue;
                        }

                        t = f5(scene, x, y, z);
                        if(t > 0) {
                            count++;
                            continue;
                        }
                    }
            System.out.println("smooth = " + count);
        } while(count != 0);
    }

    private int f5(short[][][] scene, int x, int y, int z) {
        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y + 1][x + 1] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y + 1][x - 1] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y - 1][x - 1] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y - 1][x + 1] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y + 1][x - 1] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x - 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x + 1] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y + 1][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y - 1][x - 1] == 9998 &&
                scene[z + 1][y][x] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y + 1][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z - 1][y + 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z - 1][y - 1][x - 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y][x] == 9998 &&
                scene[z + 1][y + 1][x + 1] == 9998 &&
                scene[z][y][x - 1] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y + 1][x + 1] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y - 1][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x + 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y - 1][x - 1] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x + 1] == 9998 &&
                scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y - 1][x + 1] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y - 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y][x] == 9998 &&
                scene[z + 1][y + 1][x - 1] == 9998 &&
                scene[z][y - 1][x] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y + 1][x + 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y][x] == 9998 &&
                scene[z - 1][y + 1][x + 1] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y + 1][x - 1] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------
        //--------------------------------------------------------

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y + 1][x - 1] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y - 1][x - 1] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y - 1][x + 1] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y + 1][x + 1] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y - 1][x - 1] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x + 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y + 1][x + 1] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y + 1][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z][y][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z + 1][y + 1][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x - 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y - 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998 &&
                scene[z - 1][y + 1][x + 1] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y + 1][x + 1] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x + 1] == 9998 &&
                scene[z + 1][y][x] == 9998 &&
                scene[z][y][x - 1] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y - 1][x + 1] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y - 1][x + 1] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y - 1][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y - 1][x - 1] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x - 1] == 9998 &&
                scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y][x] == 9998 &&
                scene[z + 1][y + 1][x + 1] == 9998 &&
                scene[z][y - 1][x] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y + 1][x + 1] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y][x] == 9998 &&
                scene[z - 1][y + 1][x - 1] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y + 1][x - 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        return 0;
    }

    private int f4(short[][][] scene, int x, int y, int z) {
        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x + 1] == 9998 &&
                scene[z - 1][y][x + 1] == 9998) {
            scene[z][y - 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x + 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z][y + 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x - 1] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z][y + 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x - 1] == 9998 &&
                scene[z - 1][y - 1][x] == 9998) {
            scene[z][y - 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y - 1][x] == 9998 &&
                scene[z][y - 1][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y - 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x + 1] == 9998 &&
                scene[z][y + 1][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y + 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y + 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y + 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x - 1] == 9998 &&
                scene[z][y - 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y - 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x - 1] == 9998 &&
                scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z + 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x + 1] == 9998 &&
                scene[z][y + 1][x - 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z - 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y - 1][x] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z - 1][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y - 1][x] == 9998 &&
                scene[z + 1][y][x + 1] == 9998 &&
                scene[z][y][x - 1] == 9998) {
            scene[z + 1][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z][y + 1][x + 1] == 9998) {
            scene[z + 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y][x + 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z - 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x + 1] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y - 1][x] == 9998 &&
                scene[z + 1][y][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z + 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x + 1] == 9998 &&
                scene[z][y - 1][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z + 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y - 1][x] == 9998 &&
                scene[z - 1][y][x + 1] == 9998) {
            scene[z - 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z - 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y][x + 1] == 9998 &&
                scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y - 1][x] == 9998) {
            scene[z + 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x + 1] == 9998 &&
                scene[z - 1][y][x + 1] == 9998) {
            scene[z - 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y][x - 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z - 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x - 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x - 1] == 9998) {
            scene[z + 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x - 1] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z][y - 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x + 1] == 9998 &&
                scene[z - 1][y - 1][x] == 9998) {
            scene[z][y - 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x + 1] == 9998 &&
                scene[z - 1][y][x + 1] == 9998) {
            scene[z][y + 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x - 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z][y + 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y + 1][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y + 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x - 1] == 9998 &&
                scene[z][y + 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y + 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x] == 9998 &&
                scene[z][y - 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y - 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x + 1] == 9998 &&
                scene[z][y - 1][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y - 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z][y + 1][x - 1] == 9998) {
            scene[z + 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y][x - 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z - 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y - 1][x] == 9998) {
            scene[z - 1][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x] == 9998 &&
                scene[z + 1][y][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z + 1][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y][x + 1] == 9998 &&
                scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998) {
            scene[z + 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x - 1] == 9998 &&
                scene[z][y + 1][x + 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z - 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y - 1][x] == 9998 &&
                scene[z - 1][y][x + 1] == 9998) {
            scene[z - 1][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x] == 9998 &&
                scene[z][y - 1][x + 1] == 9998 &&
                scene[z][y][x - 1] == 9998) {
            scene[z + 1][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y][x - 1] == 9998 &&
                scene[z][y - 1][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z + 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y - 1][x] == 9998 &&
                scene[z + 1][y][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z + 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x + 1] == 9998) {
            scene[z - 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y - 1][x] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z - 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if(scene[z + 1][y][x - 1] == 9998 &&
                scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y - 1][x] == 9998) {
            scene[z + 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z + 1][y][x + 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x + 1] == 9998) {
            scene[z + 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y][x + 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z - 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if(scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x - 1] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z - 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        return 0;
    }

    private int f3(short[][][] scene, int x, int y, int z) {
        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y - 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y + 1][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y + 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y - 1][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if (scene[z + 1][y - 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z + 1][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z + 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z][y][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z - 1][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z][y][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y - 1][x] == 9998) {
            scene[z - 1][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if (scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x + 1] == 9998) {
            scene[z - 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z - 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x - 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z + 1][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x + 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z + 1][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        return 0;
    }

    private int f2(short[][][] scene, int x, int y, int z) {
        if (scene[z + 1][y][x - 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y][x + 1] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y - 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y - 1][x] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x - 1] == 9998 &&
                scene[z][y - 1][x + 1] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z][y - 1][x - 1] == 9998 &&
                scene[z][y + 1][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if (scene[z + 1][y][x + 1] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y][x - 1] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if (scene[z + 1][y][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x + 1] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y - 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y + 1][x] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y + 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y - 1][x] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x + 1] == 9998 &&
                scene[z][y - 1][x - 1] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z][y - 1][x + 1] == 9998 &&
                scene[z][y + 1][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        return 0;
    }

    private int f1(short[][][] scene, int x, int y, int z) {
        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if (scene[z][y][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z][y][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z][y + 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z][y - 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z][y][x + 1] == 9998) {
            scene[z][y - 1][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        //--------------------------------------------------------

        if (scene[z][y - 1][x] == 9998 &&
                scene[z][y][x + 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z][y][x + 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x] == 9998 &&
                scene[z - 1][y][x] == 9998) {
            scene[z - 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z][y - 1][x] == 9998 &&
                scene[z][y][x - 1] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z][y][x - 1] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        if (scene[z + 1][y][x] == 9998 &&
                scene[z][y - 1][x] == 9998 &&
                scene[z][y + 1][x] == 9998) {
            scene[z + 1][y][x] = 9000;
            scene[z][y][x] = 9998;
            return 1;
        }

        return 0;
    }

}
