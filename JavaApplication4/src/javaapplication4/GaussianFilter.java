package javaapplication4;

public class GaussianFilter {
    
    private double dx;
    private double dy;
    private double dz;
    private final double DEVIATION = 0.55;
    private double [][][] mask = new double[5][5][5];
    
    public GaussianFilter(double dx, double dy, double dz) {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
        initializeMask();
    }
    
    private void initializeMask() {
        final int xc = 2;
        final int yc = 2;
        final int zc = 2;

        double sum = 0;
        for(int z = 0; z < 5; z++) {
            for(int y = 0; y < 5; y++) {
                for(int x = 0; x < 5; x++) {
                    double d = Math.pow((xc - x) * dx, 2.0) +
                            Math.pow((yc - y) * dy, 2.0) +
                            Math.pow((zc - z) * dz, 2.0);
                    double g = Math.pow(Math.E, -d / (2.0 * this.DEVIATION * this.DEVIATION));
                    this.mask[z][y][x] = g;
                    sum += g;
                }
            }
        }

        for(int z = 0; z < 5; z++) {
            for(int y = 0; y < 5; y++) {
                for(int x = 0; x < 5; x++) {
                    this.mask[z][y][x] /= sum;
                }
            }
        }
    }

    public short[][][] applyFilter(short[][][] originalScene) {
        this.clamping(originalScene);

        int xLength = originalScene[0][0].length;
        int yLength = originalScene[0].length;
        int zLength = originalScene.length;

        short[][][] finalScene = new short[zLength][yLength][xLength];
        for(int z = 0; z < zLength; z++) {
            for (int y = 0; y < yLength; y++) {
                for (int x = 0; x < xLength; x++) {
                    finalScene[z][y][x] = originalScene[z][y][x];
                }
            }
        }

        for(int z = 2; z < zLength - 2; z++) {
            for (int y = 2; y < yLength - 2; y++) {
                for (int x = 2; x < xLength - 2; x++) {
                    finalScene[z][y][x] = (short)this.onePointFilter(originalScene, x, y, z);
                }
            }
        }

        return finalScene;
    }
    
    private double onePointFilter(short[][][] scene, int xCenter, int yCenter, int zCenter) {
        double sum = 0.0;
        for(int z = zCenter - 2; z <= zCenter + 2; z++) {
            for(int y = yCenter - 2; y <= yCenter + 2; y++) {
                for(int x = xCenter - 2; x <= xCenter + 2; x++) {
                    sum += scene[z][y][x] * this.mask[z - (zCenter - 2)][y - (yCenter - 2)][x - (xCenter - 2)];
                }
            }
        }
        return sum;
    }
    
    private void clamping(short[][][] givenScene) {
        for (int z = 0; z < givenScene.length; z++) {
            for (int y = 0; y < givenScene[0].length; y++) {
                for (int x = 0; x < givenScene[0][0].length; x++) {
                    if (givenScene[z][y][x] > -500 || givenScene[z][y][x] < -1024) {
                        givenScene[z][y][x] = -500;
                    }
                }
            }
        }
    }
}
