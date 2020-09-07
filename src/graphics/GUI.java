package graphics;

import game_utils.Line;
import math.Coord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JPanel implements MouseListener, MouseWheelListener, ActionListener {


    private final ArrayList<Line> lines;

    //    Timer timer = new Timer(100, this);
    public GUI() {
        setBackground(Color.BLACK);
        lines = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            lines.add(Line.from(Math.random() * 1000, Math.random()*1000,
                    Math.random() * 1000, Math.random()*1000
            ));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        draw((Graphics2D) g);
    }
    private void draw(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        Point p = getMousePosition().getLocation();
        Coord center = new Coord(getWidth()/2.0, getHeight()/2.0);
        Line curr = Line.from(center.getX(), center.getY(), p.getX(), p.getY());

        for(Line line : lines) {
            g.drawLine((int) line.getA().getX(), (int) line.getA().getY(),
                    (int) line.getB().getX(), (int) line.getB().getY()
                    );
        }

        g.setColor(Color.GREEN);
        g.drawLine((int) curr.getA().getX(), (int) curr.getA().getY(),
                (int) curr.getB().getX(), (int) curr.getB().getY()
        );

        ArrayList<Coord> coords = new ArrayList<>();
        Coord c;
        g.setColor(Color.RED);
        for(Line line : lines) {
            if((c = line.intersect(curr)) != null) {
                coords.add(c);
                g.fillOval((int) c.getX() - 2, (int) c.getY() - 2, 4, 4);
            }
        }

        double dist = Double.MAX_VALUE;
        double d = 0;
        c = null;
        for(Coord coord : coords) {
            d = center.distNoSQRT(coord);
            if(d < dist) {
                dist = d;
                c = coord;
            }
        }
        if(c != null) {
            g.setColor(Color.CYAN);
            g.fillOval((int) c.getX() - 2, (int) c.getY() - 2, 4, 4);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}