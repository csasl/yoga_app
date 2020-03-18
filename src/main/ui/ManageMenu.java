package ui;
//https://www.macs.hw.ac.uk/cs/java-swing-guidebook/?name=JList&page=3

import model.YogaPose;
import model.YogaSequence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ManageMenu  implements ActionListener {
    private JList inSeq;
    private JList removed;
    private DefaultListModel inSeqModel;
    private DefaultListModel removedModel;
    private List<YogaPose> poses;
    private YogaSequence sequence;
    private JPanel managePanel;
    private JPanel buttonPanel;
    private JButton removeBtn;

    public ManageMenu(YogaSequence seq) {
        this.sequence = seq;
        poses = seq.getExerciseSequence();
    }

    public JPanel createPane() {
        managePanel = new JPanel();
        inSeqModel = new DefaultListModel();
        removedModel = new DefaultListModel();
        for (YogaPose p: poses) {
            inSeqModel.addElement(p.getName());
        }
        inSeq = new JList(inSeqModel);
        inSeq.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        inSeq.setVisibleRowCount(20);
        JScrollPane list1 = new JScrollPane(inSeq);
        removed = new JList(removedModel);
        JScrollPane list2 = new JScrollPane(removed);
        buttonPanel = new JPanel();
        removeBtn = new JButton("Remove >>");
        removeBtn.addActionListener(this);
        buttonPanel.add(removeBtn);
        managePanel.add(createBottomPanel(list1, list2));
        managePanel.setOpaque(true);
        return managePanel;
    }

    public JPanel createBottomPanel(JScrollPane l1, JScrollPane l2) {
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));
        bottomPanel.add(l1);
        bottomPanel.add(Box.createRigidArea(new Dimension(5,0)));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(5,0)));
        bottomPanel.add(l2);
        bottomPanel.add(Box.createRigidArea(new Dimension(10,0)));
        return bottomPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == removeBtn) {
            Object to = inSeq.getSelectedValue();
            int toIndex = inSeq.getSelectedIndex();
            sequence.removePose(poses.get(toIndex).getName());
            removedModel.addElement(to);
            inSeqModel.remove(toIndex);
        }

    }

    public void showGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Manage Sequence");
        ManageMenu menu = new ManageMenu(sequence);
        frame.setLayout(new BorderLayout());
        frame.setContentPane(menu.createPane());
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}
