//https://www.dummies.com/programming/java/how-to-use-sliders-in-java/
//https://stackoverflow.com/questions/1090098/newline-in-jlabel

package ui;

import model.YogaPose;
import model.YogaSequence;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PoseDetails extends JPanel {
    private  JButton addPose;
    private List<YogaPose> selectedPoses;
    private int selected;
    private YogaPose selectedPose;
    private JFrame poseWindow;
    private JSlider timeSlider = new JSlider(0, 30);
    private YogaSequence sequence;

    public PoseDetails(List<YogaPose> poses, int selected, YogaSequence seq) {
        this.selectedPoses = poses;
        this.selected = selected;
        this.sequence = seq;
        selectedPose = selectedPoses.get(selected);
        poseWindow = new JFrame(selectedPose.getName());
        poseWindow.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        poseWindow. setLayout(new BorderLayout());
        showDetails();
    }

    public void showDetails() {
        JLabel poseDescription = new JLabel();
        poseDescription.setText("<html>" + selectedPose.getDescription().replaceAll("<", "&lt")
                .replaceAll(">", "gt").replaceAll("\n", "<br/>") + "</html>");
        poseWindow.add(poseDescription, BorderLayout.CENTER);
        addPose = new JButton("Add to sequence");
        addPose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddSelection();
            }
        });

        poseWindow.add(addPose, BorderLayout.SOUTH);
        poseWindow.setSize(1000,500);
        poseWindow.setVisible(true);
    }

    public void handleAddSelection() {
        createTimeSlider();
    }

    public void createTimeSlider() {
        JFrame timer = new JFrame("Time selection");
        timer.setSize(500,500);
        timer.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        timer.setLayout(new FlowLayout());
        timer.add(new JLabel("Please select the number of minutes you want to work out for:"));
        JButton setBtn = new JButton("Set");
        setBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToSeq();

            }
        });

        timeSlider.setMajorTickSpacing(10);
        timeSlider.setMinorTickSpacing(1);
        timeSlider.setPaintTicks(true);
        timeSlider.setPaintLabels(true);
        timer.add(timeSlider);
        timer.add(setBtn);
        timer.setVisible(true);
    }

    public void addToSeq() {
        sequence.addPose(selectedPose);
        timeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int time = timeSlider.getValue();

                selectedPose.setTime(time);
            }
        });

        JFrame popUp = new JFrame("Success!");
        popUp.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        popUp.setLayout(new BorderLayout());
        popUp.add(new JLabel(selectedPose.getName() + " was successfully added"));
        popUp.setSize(400,400);
        popUp.setVisible(true);

    }
}
