package graphics;

import game_utils.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class GUI extends JPanel implements MouseListener, MouseWheelListener, ActionListener {


    private ArrayList<Line> lines;
    private Line curr;
//    Timer timer = new Timer(100, this);
    public GUI() {
        lines = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            lines.add(Line.from(Math.random() * 1000, Math.random()*1000,
                    Math.random() * 1000, Math.random()*1000
            ));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        draw((Graphics2D) g);
    }
    private void draw(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);
        Point p = MouseInfo.getPointerInfo().getLocation();
        curr = Line.from(getWidth()/2.0, getHeight()/2.0, p.getX(), p.getY());

        for(Line line : lines) {
            g.drawLine((int) line.getA().getX(), (int) line.getA().getY(),
                    (int) line.getB().getX(), (int) line.getB().getY()
                    );
        }

        g.setColor(Color.GREEN);
        g.drawLine((int) curr.getA().getX(), (int) curr.getA().getY(),
                (int) curr.getB().getX(), (int) curr.getB().getY()
        );
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