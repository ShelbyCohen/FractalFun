import java.awt.*;

/**
 * Created by Jon on 2/24/15.
 */
public class eye_fractal {
    public static double calcDist(double x1, double y1, double x2, double y2) {
        double dist = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        return dist;
    }

    public static double calcMid(double v1, double v2) {
        double mid = (v1 + v2) / 2.0;
        return (mid);

    }

    public static double[][] calcNewCoords(double[] xVals, double[] yVals, double xOrigin, double yOrigin, double theta) {
        /*
        x′=(x−p)cos(θ)−(y−q)sin(θ)+p,
        y′=(x−p)sin(θ)+(y−q)cos(θ)+q.
         */
        double[] newXVals = new double[4];
        double[] newYVals = new double[4];
        for (int i = 0; i < xVals.length; i++) {
            newXVals[i] = (xVals[i] - xOrigin) * Math.cos(theta) - (yVals[i] - yOrigin) * Math.sin(theta) + xOrigin;
            newYVals[i] = (xVals[i] - xOrigin) * Math.sin(theta) + (yVals[i] - yOrigin) * Math.cos(theta) + yOrigin;

        }
        double[][] coords = {newXVals, newYVals};
        return (coords);


    }

    public static void drawSquare(double[] xVals, double[] yVals, int n, double dist) {
        if (n == 0) return;
        n -= 1;

        double[][] coords = calcNewCoords(xVals,yVals,xVals[3],yVals[3],3.14*3/4.0);


        double[] xVals1 = coords[0];
        double[] yVals1 = coords[1];

        double[][] coords1 = calcNewCoords(xVals1,yVals1,xVals1[2],yVals1[2],90);
        double[] xVals2 = coords1[0];
        double[] yVals2 = coords1[1];

        StdDraw.polygon(xVals,yVals);
        StdDraw.polygon(xVals1,yVals1);
        StdDraw.polygon(xVals2,yVals2);



    }

    public static void main(String[] args) {
        //Draw an arc of radius r, centered on (x, y), from angle1 to angle2 (in degrees).
        StdDraw.setXscale(-5, 5);
        StdDraw.setYscale(-5, 5);
        double[] xVals = {-.5, .5, .5, -.5};
        double[] yVals = {-1, -1, 0, 0};
        StdDraw.filledPolygon(xVals, yVals);
        double dist = calcDist(xVals[2], yVals[2], xVals[3], yVals[3]);
        drawSquare(xVals, yVals, 10, dist);


    }

}
