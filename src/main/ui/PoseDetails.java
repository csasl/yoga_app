package ui;

import model.YogaPose;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PoseDetails {

    public void showDetails(List<YogaPose> poses, int selection) {
        JFrame poseWindow = new JFrame(poses.get(selection).getName());
        poseWindow.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        poseWindow. setLayout(new BorderLayout());
        poseWindow.add(new JLabel(poses.get(selection).getDescription()));
       // ImageIcon image = new ImageIcon(poses.get(selection).image);
       // JLabel imageLabel = new JLabel(image);
        //poseWindow.add(imageLabel);
        poseWindow.setSize(1000,500);
        poseWindow.setVisible(true);
    }
}
