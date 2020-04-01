package ui;
//https://www.macs.hw.ac.uk/cs/java-swing-guidebook/?name=JList&page=3

import model.YogaPose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Represents menu to manage sequence, allows user to remove any unwanted poses
 */

public class SequenceManager {
    private JList inSeq;
    private JList removed;
    private DefaultListModel inSeqModel;
    private DefaultListModel removedModel;
    private JPanel buttonPanel;
    private JButton removeBtn;

    /**
     * Constructor creates a new menu with sequence so far

     */

    public SequenceManager() { }

    /**
     * Creates all components for the scroll pane of names of poses in sequence
     * @return JPanel that contains scrollPanes
     */

    public JPanel createPane() {
        List<YogaPose> poses = App.getInstance().getSequence().getExerciseSequence();
        JPanel managePanel = new JPanel();
        inSeqModel = new DefaultListModel();
        removedModel = new DefaultListModel();
        for (YogaPose p: poses) {
            inSeqModel.addElement(p.getName());
        }
        inSeq = new JList(inSeqModel);
        formatSeqList();
        JScrollPane list1 = new JScrollPane(inSeq);
        removed = new JList(removedModel);
        formatRemovedList();
        JScrollPane list2 = new JScrollPane(removed);
        buttonPanel = new JPanel();
        buttonPanel.add(createRemoveButton());
        managePanel.add(createBottomPanel(list1, list2));
        managePanel.setOpaque(true);
        return managePanel;
    }

    public JButton createRemoveButton() {
        removeBtn = new JButton("Remove>>");
        removeBtn.addActionListener(new ActionListener() {
            /**
             * Removes the pose that the user has selected once the remove button is clicked
             * @param e The pose that the user has selected on the JList of poses in the sequence
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                List<YogaPose> poses = App.getInstance().getSequence().getExerciseSequence();

                if (e.getSource() == removeBtn) {
                    Object to = inSeq.getSelectedValue();
                    int toIndex = inSeq.getSelectedIndex();
                    try {
                        App.getInstance().getSequence().removePose(poses.get(toIndex).getName());
                    } catch (Exception ex) {
                        DialogCreator.createWarning("You do not have any poses in your sequence");
                    }
                    removedModel.addElement(to);
                    inSeqModel.remove(toIndex);
                }
            }
        });
        return removeBtn;
    }


    /**
     * Helper to format the JList of poses in the sequence so far
     */

    public void formatSeqList() {
        inSeq.setVisibleRowCount(20);
        inSeq.setFixedCellHeight(30);
        inSeq.setFixedCellWidth(140);
        inSeq.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }

    /**
     * Helper to format the JList of poses the user has removed
     */

    public void formatRemovedList() {
        removed.setVisibleRowCount(20);
        removed.setFixedCellHeight(30);
        removed.setFixedCellWidth(140);

    }

    /**
     * Creates the panels where the Jlists of poses in and out of the sequence are displayed
     * @param l1 JList of poses in the sequence
     * @param l2 JList of poses that have been removed
     * @return JPanel of the JLists separated by a solid block
     */

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


    /**
     * Displays the scroll panes with the JLists
     */

    public void showGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Manage Sequence");
        SequenceManager menu = new SequenceManager();
        frame.setLayout(new BorderLayout());
        frame.setContentPane(menu.createPane());
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}
