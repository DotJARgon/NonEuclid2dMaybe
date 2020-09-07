package math;

public class Util {

    public static Coord rayToLine(double rx, double ry, double a, double x1, double y1, double x2, double y2) {
        double m0 = Math.tan(a);
        double b0 = ry - m0*rx;

        double m1 = (x2 - x1) / (y2 - y1);
        double b1 = y1 - m1*x1;

        return new Coord(((b1-b0) / (m0-m1)), (m0 * ((b1-b0) / (m0-m1)) + b0));
    }

}
