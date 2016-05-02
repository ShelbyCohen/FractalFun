import java.awt.*;
import java.util.Scanner;

/**
 * Created by Jon on 2/23/15.
 */
public class triangle_fractal {
    public static void drawTri(double height, double x, double y){
        double[] xVals = {x-(height/2.0),x,x+(height/2.0)};
        double[] yVals = {y+(height/2.0),y-(height/2.0),y+(height/2.0)};
        StdDraw.filledPolygon(xVals, yVals);



   }

    public static void draw3(int n,double height, double x, double y){
        if(n <= 1)return;
        double newHeight = height/2.0;
        double x1 = x+(height/2.0);
        double y1 = y-(height/4);
        double x2 = x-(height/2.0);
        double y2 = y-(height/4);
        double x3 = x;
        double y3 = y+(height*3/4);
        drawTri(newHeight,x1,y1);
        drawTri(newHeight,x2,y2);
        drawTri(newHeight,x3,y3);
        n -= 1;
        draw3(n,newHeight,x1,y1);
        draw3(n,newHeight,x2,y2);
        draw3(n,newHeight,x3,y3);
        /*
        draw3(newHeight,x1,y1);
        draw3(newHeight,x2,y2);
        draw3(newHeight,x3,y3);*/

    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        System.out.print("N:");
        int n = scanner.nextInt();
        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1, 1);
        double[] xVals = {-1,0,1};
        double[] yVals = {-1,1,-1};
        StdDraw.setPenColor(Color.red);
        StdDraw.filledPolygon(xVals, yVals);
        StdDraw.setPenColor(Color.black);
        drawTri(1.0,0.0,-.5);
        draw3(n,1.0,0.0,-.5);

    }
}
