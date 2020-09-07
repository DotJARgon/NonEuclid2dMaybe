package game_utils;

import math.Coord;

public class Line {
    private final Coord A, B;

    public Line(Coord A, Coord B) {
        this.A = A;
        this.B = B;
    }

    public Coord getA() {return A;}
    public Coord getB() {return B;}

    @Override
    public String toString() {
        return "(" + A + ", " + B + ")";
    }

    public static Line from(double x0, double y0, double x1, double y1) {
        return new Line(new Coord(x0, y0), new Coord(x1, y1));
    }

    public Coord intersect(Line line) {
        return lineIntersect(
                A.getX(), A.getY(), B.getX(), B.getY(),
                line.A.getX(), line.A.getY(), line.B.getX(), line.B.getY()
        );
    }

    public static Coord lineIntersect(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        if (denom == 0.0) { // Lines are parallel.
            return null;
        }
        double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
        double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))/denom;
        if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
            // Get the intersection point.
            return new Coord((x1 + ua*(x2 - x1)), (y1 + ua*(y2 - y1)));
        }

        return null;
    }

    public static void main(String[] args) {
        Line l0 = Line.from(0, 0, 5, 5);
        Line l1 = Line.from(0, 10, 0, 50);

        System.out.println(l0.intersect(l1));
    }
}
