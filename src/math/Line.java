package math;

public class Line {
    private Coord p0, p1;
    public Line(double x1, double y1, double x2, double y2) {
        this.p0 = new Coord(x1, y1);
        this.p1 = new Coord(x2, y2);
    }
    public Line(Coord p0, Coord p1) {
        this.p0 = p0;
        this.p1 = p1;
    }
    public Line(Coord p0, double a, double len) {
        this.p0 = p0;
        this.p1 = new Coord(p0.getX() + Math.cos(a)*len, p0.getY() + Math.sin(a)*len);
    }

    public Coord intersection(Line line) {
        if((p1.getY() - p0.getY()) != 0) {
            double m0 = (p1.getX() - p0.getX()) / (p1.getY() - p0.getY());
            double b0 = p0.getY() - m0*p0.getX();
            if((line.p1.getY() - line.p0.getY()) != 0) {
                double m1 = (line.p1.getX() - line.p0.getX()) / (line.p1.getY() - line.p0.getY());
                double b1 = line.p0.getY() - m1*line.p0.getX();
                if(m1 == m0) {
                    return null;
                }
                double xinter = (b1-b0) / (m0-m1);
                double yinter = m0 * ((b1-b0) / (m0-m1)) + b0;
                return new Coord(xinter, yinter);
            }
        }
        else {
            if((line.p1.getY() - line.p0.getY()) != 0) {
                double m1 = (line.p1.getX() - line.p0.getX()) / (line.p1.getY() - line.p0.getY());
                double b1 = line.p0.getY() - m1*line.p0.getX();
                double xinter = p0.getX();
                double yinter = m1*xinter + b1;
                return new Coord(xinter, yinter);
            }
        }
        return null;
    }
}
