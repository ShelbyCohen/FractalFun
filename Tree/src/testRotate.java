/**
 * Created by Jon on 3/1/15.
 */
public class testRotate {
    public static void drawGradient(int sR, int sG, int sB, int eR, int eG, int eB, int n){
        int xMin = -130; int xMax = 130; int yMin = -130; int yMax = 130;

        int dR = eR - sR; int dG = eG - sG; int dB = eB - sB;

        double halfheight = 130/(double)n; double halfwidth = 130;

        int r; int g; int b;
        double x = 0; double y = yMin;


        for (int i = 0; i <= n; i++) {
            double ratio =(double)i/(double)n;
            r = sR+(int)(dR*((double)i/(double)n));
            g = sG+(int)(dG*((double)i/(double)n));
            b = sB+(int)(dB*((double)i/(double)n));
            y = yMin+(260*((double)i/(double)n));
            StdDraw.setPenColor(r,g,b);
            StdDraw.filledRectangle(x, y, halfwidth,halfheight);

        }

    }
    public static void main(String[] args){
        StdDraw.setXscale(-130,130);
        StdDraw.setYscale(-130, 130);

        drawGradient(158,211,255,1,48,152,1100);
    }
}
