package game_utils;

import math.Coord;

import java.util.ArrayList;

public class Line {
    private final Coord A, B;
    private final double m, b;
    private double xeq, yeq;
    private final LineType type;

    enum LineType {
        VERTICAL, HORIZONTAL, NORMAL
    }

    public Line(Coord A, Coord B) {
        this.A = A;
        this.B = B;

        if(B.getY() - A.getY() == 0) {
            m = 0;
            b = B.getY();
            type = LineType.HORIZONTAL;
            yeq = B.getY();
        }
        else {
            if(B.getX() - A.getX() == 0) {
                m = Double.NaN;
                type = LineType.VERTICAL;
                xeq = B.getX();
                b = Double.NaN;
            }
            else {
                m = (B.getY() - A.getY()) / (B.getX() - A.getX());
                type = LineType.NORMAL;
                b = A.getY() - m*A.getX();
            }
        }
    }

    public Coord getA() {return A;}
    public Coord getB() {return B;}

    public Coord intersect(Line line) {
        Coord c = intersectMXB(line);
        if(c.getX() > A.getX() && c.getX() < B.getX()) {
            if(c.getY() > A.getY() && c.getY() < B.getY()) {
                return c;
            }
            else if(c.getX() < A.getY() && c.getY() > B.getY()) {
                return c;
            }
        }
        else if(c.getX() < A.getX() && c.getX() > B.getX()) {
            if(c.getY() > A.getY() && c.getY() < B.getY()) {
                return c;
            }
            else if(c.getX() < A.getY() && c.getY() > B.getY()) {
                return c;
            }
        }
        return null;
    }

    private Coord intersectMXB(Line line) {
        return switch(type) {
            case NORMAL ->
                    switch(line.type) {
                        case NORMAL -> normalToNormal(line);
                        case VERTICAL -> solveForY(line.xeq);
                        case HORIZONTAL -> solveForX(line.yeq);
                    };
            case VERTICAL ->
                    switch (line.type) {
                        case VERTICAL -> null;
                        case HORIZONTAL -> new Coord(xeq, line.yeq);
                        default -> line.intersectMXB(this);
                    };
            case HORIZONTAL ->
                    switch(line.type) {
                        case HORIZONTAL -> null;
                        default -> line.intersectMXB(this);
                    };
        };
    }

    private Coord normalToNormal(Line line) {
        //m0x+b0 = m1x+b1
        //m0x-m1x=b1-b0
        //x=(b1-b0)/(m0-m1)
        if(m - line.m == 0) {
            return null;
        }
        double x = (line.b - b) / (m - line.m);
        double y = m*x + b;
        return new Coord(x, y);
    }

    private Coord solveForY(double x) {
        return new Coord(x, m*x + b);
    }
    private Coord solveForX(double y) {
        //y = mx + b
        //x = (y - b) / m
        return new Coord((y - b)/m, y);
    }

    @Override
    public String toString() {
        return m + "x + " + b;
    }

    public static Line from(double x0, double y0, double x1, double y1) {
        return new Line(new Coord(x0, y0), new Coord(x1, y1));
    }

    public static Line[] Polygon(double... coords) {
        if(coords.length%2 == 0) {
            ArrayList<Line> lines = new ArrayList<>();
            for(int i = 2; i < coords.length; i+=2) {
                lines.add(Line.from(coords[i-2], coords[i-1], coords[i], coords[i+1]));
            }
            lines.add(Line.from(coords[coords.length-2], coords[coords.length-1], coords[0], coords[1]));
            Line[] out = new Line[lines.size()];
            for(int i = 0; i < out.length; i++) {
                out[i] = lines.get(i);
            }
            return out;
        }
        return null;
    }

    public static void main(String[] args) {
        Line l0 = Line.from(0, 0, 5, 5);
        Line l1 = Line.from(0, 10, 0, 50);

        System.out.println(l0.intersect(l1));
    }
}
