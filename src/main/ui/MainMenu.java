package ui;

import model.YogaSequence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JToolBar toolbar;
    private Stages poses;
    private YogaSequence sequence;
    private JButton save = new JButton("Save sequence");
    private JButton manage = new JButton("Manage sequence");
    private JButton view = new JButton("View sequence");


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

            }
        });
    }









}
