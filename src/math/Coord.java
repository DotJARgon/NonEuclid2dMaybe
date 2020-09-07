package math;

public class Coord {
    private double x,  y;
    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Coord() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {return x;}
    public double getY() {return y;}

    public double distNoSQRT(Coord c) {
        return (x-c.x)*(x-c.x) + (y-c.y)*(y-c.y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
