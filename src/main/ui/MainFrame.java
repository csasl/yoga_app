package ui;

import model.YogaSequence;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
   // private Toolbar toolbar;
    private Stages poses;


//EFFECTS: Creates window that displays the 4 stages of the workout
    public MainFrame() {
        super("Home Yoga");
        setLayout(new BorderLayout());
      //  toolbar = new Toolbar();
        poses = new Stages();
      //  add(toolbar, BorderLayout.NORTH);
        add(poses);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);

    }







}
