//Main menu for

package ui;

import model.YogaPose;
import model.YogaSequence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class MainMenu extends JFrame {
    private JToolBar toolbar;
    private Stages poses;
    private YogaSequence sequence;
    private JButton save = new JButton("Save sequence");
    private JButton manage = new JButton("Manage sequence");
    private JButton view = new JButton("View sequence");
    private static final String SEQUENCE_FILE = "./data/sequence.txt";


//EFFECTS: Creates window that displays the 4 stages of the workout
    public MainMenu(YogaSequence seq) {
        super("Home Yoga");
        this.sequence = seq;
        setLayout(new BorderLayout());
        toolbar = new JToolBar();
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        toolbar.add(save);
        toolbar.add(manage);
        toolbar.add(view);
        addListeners();
        poses = new Stages(sequence);
        add(toolbar, BorderLayout.NORTH);
        add(poses);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);

    }
//EFFECTS: Creates listeners for the toolbar buttons

    public void addListeners() {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        manage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageMenu menu = new ManageMenu(sequence);
                menu.showGUI();
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSeq();
            }
        });


    }

//EFFECTS: Displays window of sequence details once view button is pressed on toolbar
    public void viewSeq() {
        JFrame view = new JFrame("View Sequence");
        view.setDefaultCloseOperation(HIDE_ON_CLOSE);
        view.setLayout(new FlowLayout());
        view.setSize(500,500);
        view.add(new JLabel("Your sequence has "
                    + sequence.countPoses() + ": " + getListPoses()));
        view.add(new JLabel("You have" + (sequence.getAllocatedTime() - sequence.totalTimeInSeq())
                    + " minutes to allocate in your sequence"));
        view.setVisible(true);

    }
//EFFECTS: returns a string containing the pose names of all poses in the current sequence

    public String getListPoses() {
        String allPoses = "";
        List<YogaPose> poses = sequence.getExerciseSequence();
        for (YogaPose p : poses) {
            allPoses = allPoses + "\n" + p.getName();
        }
        return allPoses;
    }
}













