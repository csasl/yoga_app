package ui;

import model.YogaSequence;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
   // private Toolbar toolbar;
    private Stages poses;
    private YogaSequence sequence;


//EFFECTS: Creates window that displays the 4 stages of the workout
    public MainMenu(YogaSequence seq) {
        super("Home Yoga");
        this.sequence = seq;
        setLayout(new BorderLayout());
      //  toolbar = new Toolbar();
        poses = new Stages(sequence);
      //  add(toolbar, BorderLayout.NORTH);
        add(poses);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);

    }







}
