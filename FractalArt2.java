/**
 * Created by ShelbyCohen on 4/18/16.
 */
public class FractalArt2 {

    public static void sierpinski(int i, double[] x, double[] y) {
        if (i == 0)
            return;
        triangle(x, y);

        double[] x1 = {((x[1] + x[0]) / 2), ((x[2] + x[1]) / 2),
                ((x[2] + x[0]) / 2)};
        double[] y1 = {((y[1] + y[0]) / 2), ((y[2] + y[1]) / 2), ((y[2] + y[0]) / 2)};

        triangle(x1, y1);

        double[] x2 = {((x1[0] + x[0]) / 2), ((x1[2] + x1[0]) / 2), ((x1[2] + x[0]) / 2)};
        double[] y2 = {((y1[0] + y[0]) / 2), ((y1[2] + y1[0]) / 2), ((y1[2] + y[0]) / 2)};

        double[] x3 = {((x1[1] + x1[2]) / 2), ((x1[1] + x[2]) / 2), ((x[2] + x1[2]) / 2)};
        double[] y3 = {((y1[1] + y1[2]) / 2), ((y1[1] + y[2]) / 2), ((y[2] + y1[2]) / 2)};

        double[] x4 = {((x[1] + x1[0]) / 2), ((x[1] + x1[1]) / 2), ((x1[1] + x1[0]) / 2)};
        double[] y4 = {((y[1] + y1[0]) / 2), ((y[1] + y1[1]) / 2), ((y1[1] + y1[0]) / 2)};

        if (Math.random() > 0) {
            int red = (int) (Math.random() * 50) + 1;
            int g = (int) (Math.random() * 255) + 1;
            int b = (int) (Math.random() * 255) + 1;
           // StdDraw.setPenRadius(Math.random() / 70);
            StdDraw.setPenColor(red, g, b);
        }

        sierpinski(i - 1, x1, y1);
        sierpinski(i - 1, x2, y2);
        sierpinski(i - 1, x3, y3);
        sierpinski(i - 1, x4, y4);
    }

    public static void triangle(double[] x0, double[] y0) {
        StdDraw.filledPolygon(x0, y0);

    }

    public static void main(String[] args) {
        int N = 8;

        double[] x = { 0, 0.5, 1 };
        double[] y = { 0, (Math.sqrt(3) / 2), 0 };
        sierpinski(N, x, y);
    }

}