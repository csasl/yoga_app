package ui;

import model.YogaPose;
import model.YogaSequence;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class SequenceViewer {

    public SequenceViewer() { }

    /**
     * Creates window of sequence details so far
     */

    public void displaySequence(YogaSequence sequence) {
        JFrame view = new JFrame("View Sequence");
        view.setDefaultCloseOperation(HIDE_ON_CLOSE);
        view.setLayout(new BorderLayout());
        view.setSize(500,500);
        view.add(new JLabel("Your sequence has "
                + sequence.countPoses() +  " poses"), BorderLayout.NORTH);
        JLabel poseListLabel = new JLabel();
        poseListLabel.setText("<html>" + getNamesOfPoses(sequence)
                .replaceAll(">", "gt").replaceAll("\n", "<br/>") + "</html>");
        view.add(poseListLabel, BorderLayout.CENTER);
        view.add(new JLabel(makeTimeText(sequence)), BorderLayout.SOUTH);
        view.pack();
        view.setVisible(true);
    }

    /**
     * Helper to get the names and times set for each pose in the sequence so far for JLabel
     * @return String of all pose names and set times
     */

    public String getNamesOfPoses(YogaSequence sequence) {
        String allPoses = "";
        List<YogaPose> poses = sequence.getExerciseSequence();
        for (YogaPose p : poses) {
            allPoses = allPoses + "\n" + p.getName() + " - " + p.getTime() + " minutes";
        }
        return allPoses;
    }

    /**
     //     * Helper to make text for JLabel of time remaining
     //     * @return Message of how much time is left to allocate
     //     */

    public String makeTimeText(YogaSequence sequence) {
        String timeLeft = "";
        if (sequence.updateRemainingTime() > 0) {
            timeLeft = "You have " + sequence.getRemainingTime() + " minutes remaining to allocate";
        } else {
            timeLeft = "You have allocated all the time in your sequence!";
        }
        return timeLeft;
    }




}
