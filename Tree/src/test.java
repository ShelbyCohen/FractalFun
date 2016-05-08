import java.util.Scanner;

/**
 * Created by Jon on 2/25/15.
 */
public class test {
    public static double calcDist(double x1, double y1, double x2, double y2) {
        double dist = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        return dist;
    }
    public static void calcShrink (double[] xVals, double[] yVals, double theta, int n,int oN){
        if(n == 0){
            return;
        }
        //semi-con


        /*if(Math.random() > .6 ){
            theta = ((Math.PI/2.0)-theta);

        }*/



        /*//rand angles
        if(Math.random() > .6 ){
            theta = ((Math.PI/(3+2*Math.random())));

        }*/

        //square

        if(n != 0){
            theta = ((Math.PI/2.0)-theta);

        }


        double alpha = -((Math.PI/2.0)-theta);

        n -= 1;
        int lRed;
        int lGreen;
        int lBlue;
        int rRed;
        int rGreen;
        int rBlue;
        int tRed;
        int tGreen;
        int tBlue;

        if((oN - n)<12){
            lRed = 110+(int)(50*Math.random());
            lGreen = 70;
            lBlue = (int)(40*Math.random());
            rRed = 110+(int)(50*Math.random());
            rGreen = 70;
            rBlue = (int)(40*Math.random());
            tRed = 110+(int)(50*Math.random());
            tGreen = 70;
            tBlue = (int)(40*Math.random());
        }
        else{
            lRed = 40+(int)(60*Math.random());
            lGreen = 130+(int)(100*Math.random());
            lBlue = (int)(50*Math.random());
            rRed = 40+(int)(60*Math.random());
            rGreen = 130+(int)(100*Math.random());
            rBlue = (int)(50*Math.random());
            tRed = 40+(int)(60*Math.random());
            tGreen = 130+(int)(100*Math.random());
            tBlue = (int)(50*Math.random());
        }


        double dist = calcDist(xVals[0],yVals[0],xVals[1],yVals[1]);
        double lDist = dist*Math.cos(theta);
        double rDist = dist*Math.cos(alpha);


        double lScale = lDist/dist;
        double rScale = rDist/dist;

        double xCent = (xVals[0]+xVals[2])/2.0;
        double yCent = (yVals[0]+yVals[2])/2.0;

        double[] lXVals = new double[4];
        double[] lYVals = new double[4];

        double[] rXVals = new double[4];
        double[] rYVals = new double[4];

        for (int i = 0; i < xVals.length; i++) {
            lXVals[i]=(xVals[i]-xCent)*lScale;
            lYVals[i]=(yVals[i]-yCent)*lScale;

            rXVals[i]=(xVals[i]-xCent)*rScale;
            rYVals[i]=(yVals[i]-yCent)*rScale;
        }
        //StdDraw.polygon(lXVals,lYVals);
        for (int i = 0; i < 4; i++) {
            double tempLX = lXVals[i];
            lXVals[i] = (lXVals[i]*Math.cos(theta))-(lYVals[i]*Math.sin(theta));
            lYVals[i] = (tempLX*Math.sin(theta))+(lYVals[i]*Math.cos(theta));
            double tempRX = rXVals[i];
            rXVals[i] = (rXVals[i]*Math.cos(alpha))-(rYVals[i]*Math.sin(alpha));
            rYVals[i] = (tempRX*Math.sin(alpha))+(rYVals[i]*Math.cos(alpha));

        }
        double lDX = xVals[3]-lXVals[0];
        double lDY = yVals[3]-lYVals[0];

        double rDX = xVals[2]-rXVals[1];
        double rDY = yVals[2]-rYVals[1];

        for (int i = 0; i < 4; i++) {
            lXVals[i] += lDX;
            lYVals[i] += lDY;

            rXVals[i] += rDX;
            rYVals[i] += rDY;

        }
        double[] tXVals = {xVals[3],xVals[2],lXVals[1]};
        double[] tYVals = {yVals[3],yVals[2],lYVals[1]};
        StdDraw.setPenColor(lRed,lGreen,lBlue);
        StdDraw.filledPolygon(lXVals,lYVals);
        StdDraw.setPenColor(tRed,tGreen,tBlue);
        StdDraw.filledPolygon(tXVals,tYVals);
        calcShrink(lXVals,lYVals,theta,n,oN);
        StdDraw.setPenColor(rRed,rGreen,rBlue);
        StdDraw.filledPolygon(rXVals,rYVals);
        calcShrink(rXVals,rYVals,theta,n,oN);

    }
    public static void drawGradient(int sR, int sG, int sB, int eR, int eG, int eB, int n){
        int xMin = -140; int xMax = 140; int yMin = -140; int yMax = 140;

        int dR = eR - sR; int dG = eG - sG; int dB = eB - sB;

        double halfheight = 140/(double)n; double halfwidth = 140;

        int r; int g; int b;
        double x = 0; double y = yMin;


        for (int i = 0; i <= n; i++) {
            double ratio =(double)i/(double)n;
            r = sR+(int)(dR*((double)i/(double)n));
            g = sG+(int)(dG*((double)i/(double)n));
            b = sB+(int)(dB*((double)i/(double)n));
            y = yMin+(280*((double)i/(double)n));
            StdDraw.setPenColor(r,g,b);
            StdDraw.filledRectangle(x, y, halfwidth,halfheight);

        }

    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        System.out.print("N:");
        int n = scanner.nextInt();
        //was 100x 100
        StdDraw.setXscale(-130,130);
        StdDraw.setYscale(-130, 130);


        //StdDraw.line(0,-3,0,3);
        //StdDraw.line(-3,0,3,0);

        double pi = Math.PI;

        double theta = pi/5;
        int squareWidth = 2;
        int squareHeight = 18;
        int squareX = 0;
        int squareY = -110;

        double[] xVals = {squareX-squareWidth,squareX+squareWidth,squareX+squareWidth,squareX-squareWidth};
        double[] yVals = {squareY-squareHeight,squareY-squareHeight,squareY+squareHeight,squareY+squareHeight};
        drawGradient(0,255,0,0,255,0,10);
        StdDraw.setPenColor(153,83,26);
        StdDraw.filledPolygon(xVals,yVals);


        calcShrink(xVals,yVals,theta,n,n);
        }
        //StdDraw.polygon(xVals1,yVals1);
        //StdDraw.filledPolygon(newXVals,newYVals);
    }
