package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Toolbar toolbar;
    private Stages poses;

    public MainFrame() {
        super("Home Yoga");
        setLayout(new BorderLayout());
        toolbar = new Toolbar();
        poses = new Stages();
        add(toolbar, BorderLayout.NORTH);
        add(poses);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);

    }







}
