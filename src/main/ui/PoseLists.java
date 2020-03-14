//Code from http://www.java2s.com/Code/Java/Swing-JFC/ListDataEventDemo.htm

package ui;

import model.Stage;
import model.YogaPose;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PoseLists extends JPanel implements ListSelectionListener {

    private JList poseList;
    private DefaultListModel poseListModel;
    private JButton viewButton;
    private List<YogaPose> selectedSeq;
    private int selected;

    public PoseLists() {
        super(new BorderLayout());
        poseListModel = new DefaultListModel();
        selectedSeq = new ArrayList<>();
        selected = 0;

    }

    public void createExercisesMenu(List<YogaPose> poses) {
        selectedSeq = poses;
        JFrame poseFrame = new JFrame();
        poseFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        List<String> names = new ArrayList<>();
        for (YogaPose p: poses) {
            poseListModel.addElement(p.getName());
        }

        poseList = new JList(poseListModel);
        poseList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        poseList.setSelectedIndex(0);
        poseList.addListSelectionListener(this);

        poseFrame.add(poseList);
        viewButton = new JButton("View");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        poseFrame.setSize(1000,1000);
        poseFrame.setVisible(true);


    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        selected = poseList.getSelectedIndex();
        PoseDetails details = new PoseDetails();
        details.showDetails(selectedSeq, selected);


    }
}
