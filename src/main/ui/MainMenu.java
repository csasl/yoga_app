//Main menu for

package ui;

import model.YogaPose;
import model.YogaSequence;
import org.codehaus.jackson.map.ObjectMapper;
import persistence.Writer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
                saveSeq();
                JOptionPane.showMessageDialog(null, "Saved sequence!");
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

    //EFFECTS: Saves sequence to text file
    public void saveSeq() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(sequence);
            Writer writer = new Writer();
            writer.write(jsonString, SEQUENCE_FILE);
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Sorry, could not save");
        }
    }

//EFFECTS: Displays window of sequence details once view button is pressed on toolbar
    public void viewSeq() {

        JFrame view = new JFrame("View Sequence");
        view.setDefaultCloseOperation(HIDE_ON_CLOSE);
        view.setLayout(new BorderLayout());
        view.setSize(500,500);
        view.add(new JLabel("Your sequence has "
                    + sequence.countPoses() +  " poses"), BorderLayout.NORTH);
        JLabel poseListLabel = new JLabel();
        poseListLabel.setText("<html>" + getListPoses()
                       .replaceAll(">", "gt").replaceAll("\n", "<br/>") + "</html>");

        view.add(poseListLabel, BorderLayout.CENTER);

        view.add(new JLabel(makeTimeText()), BorderLayout.SOUTH);
        view.pack();
        view.setVisible(true);

    }
//EFFECTS: returns a string containing the pose names of all poses in the current sequence

    public String getListPoses() {
        String allPoses = "";
        List<YogaPose> poses = sequence.getExerciseSequence();
        for (YogaPose p : poses) {
            allPoses = allPoses + "\n" + p.getName() + " - " + p.getTime() + " minutes";
        }
        return allPoses;

    }

    public int getRemainingTime() {
        int time = sequence.getAllocatedTime() - sequence.totalTimeInSeq();
        return time;
    }

    public String makeTimeText() {
        String timeLeft = "";
        int time = getRemainingTime();
        if (time > 0) {
            timeLeft = "You have " + time + " minutes remaining to allocate";
        } else {
            timeLeft = "You have allocated all the time in your sequence!";
        }
        return timeLeft;
    }
}













