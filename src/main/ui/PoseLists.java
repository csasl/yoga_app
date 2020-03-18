//Code from http://www.java2s.com/Code/Java/Swing-JFC/ListDataEventDemo.htm
//https://stackoverflow.com/questions/21029653/java-jlist-text-center-align

package ui;

import model.Stage;
import model.YogaPose;
import model.YogaSequence;

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
    private List<YogaPose> selectedSeq;
    private int selected;
    private YogaSequence sequence;
    private JFrame poseFrame;

    public PoseLists() {
        super(new BorderLayout());
        poseListModel = new DefaultListModel();
        selectedSeq = new ArrayList<>();
        selected = 0;

    }

    public void createExercisesMenu(List<YogaPose> poses, YogaSequence sequence) {
        selectedSeq = poses;
        this.sequence = sequence;
        poseFrame = new JFrame();
        poseFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        List<String> names = new ArrayList<>();
        for (YogaPose p: poses) {
            poseListModel.addElement(p.getName());
        }

        poseList = new JList(poseListModel);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) poseList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        poseList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        poseList.setSelectedIndex(0);
        poseList.addListSelectionListener(this);

        poseFrame.add(poseList);

        poseFrame.setSize(1000,1000);
        poseFrame.setVisible(true);


    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            selected = poseList.getSelectedIndex();
            new PoseDetails(selectedSeq, selected, sequence);
            poseFrame.dispose();
        }

    }
}
