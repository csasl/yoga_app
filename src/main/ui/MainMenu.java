//https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
//https://www.baeldung.com/jackson-object-mapper-tutorial


package ui;

import model.YogaSequence;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Represents the main menu that users interact with
 */

public class MainMenu extends JFrame {
    private JToolBar toolbar;
    private Stages poses;
    private YogaSequence sequence;
    private JButton save = new JButton("Save sequence");
    private JButton manage = new JButton("Manage sequence");
    private JButton view = new JButton("View sequence");
    private ManageMenu manageMenu;
    private SequenceViewer viewSeq;
    private SequenceSaver saver;


    /**
     * Constructor initializes sequence and components on main menu
     * @param seq the sequence being built by user
     */
    public MainMenu(YogaSequence seq) {
        super("Home Yoga");
        this.sequence = seq;
        saver = new SequenceSaver();
        manageMenu = new ManageMenu(sequence);
        viewSeq = new SequenceViewer();
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

    /**
     * Helper to set up action listeners for buttons on main menu
     */
    public void addListeners() {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saver.saveSeq(sequence);
                JOptionPane.showMessageDialog(null, "Saved sequence!");
            }
        });

        manage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageMenu.showGUI();
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSeq.displaySequence(sequence);
            }
        });
    }


}













