package graphics;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class App extends JFrame {
    public GUI gui;

    public App() {
        gui = new GUI();
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
//        setResizable(false);
        setFocusable(true);
        addMouseListener(gui);
        addMouseWheelListener(gui);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(gui);
        pack();
        setVisible(true);
    }

}