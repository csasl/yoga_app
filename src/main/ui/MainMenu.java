//https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
//https://www.baeldung.com/jackson-object-mapper-tutorial


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
    private static final String SEQUENCE_FILE = "./data/sequence.txt";


    /**
     * Constructor initializes sequence and components on main menu
     * @param seq the sequence being built by user
     */
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

    /**
     * Helper to set up action listeners for buttons on main menu
     */
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

    /**
     * Saves sequence to text file when save button selected
     */
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

    /**
     * Creates window of sequence details so far
     */
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

    /**
     * Helper to get the names and times set for each pose in the sequence so far for JLabel
     * @return String of all pose names and set times
     */

    public String getListPoses() {
        String allPoses = "";
        List<YogaPose> poses = sequence.getExerciseSequence();
        for (YogaPose p : poses) {
            allPoses = allPoses + "\n" + p.getName() + " - " + p.getTime() + " minutes";
        }
        return allPoses;
    }

    /**
     * Helper to calculate time left for user to allocate
     * @return time left to allocate
     */

    public int getRemainingTime() {
        int time = sequence.getAllocatedTime() - sequence.totalTimeInSeq();
        return time;
    }

    /**
     * Helper to make text for JLabel of time remaining
     * @return Message of how much time is left to allocate
     */
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













