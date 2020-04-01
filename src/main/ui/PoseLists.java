//Code from http://www.java2s.com/Code/Java/Swing-JFC/ListDataEventDemo.htm
//https://stackoverflow.com/questions/21029653/java-jlist-text-center-align
//http://www.java2s.com/Code/Java/Swing-JFC/AnexampleofJListwithaDefaultListModel.htm

package ui;


import model.YogaPose;
import model.YogaSequence;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

/**
 * Represents the list of poses the user can choose from after selecting workout stage
 */

public class PoseLists extends JPanel {

    private JList poseList;
    private DefaultListModel poseListModel;
    private int selected;
    private JFrame poseFrame;
    private PoseAdder options;

    /**
     * Constructs JList and DefaultListModel to contain poses in the stage of workout chosen
     */
    public PoseLists() {
        super(new BorderLayout());
        poseFrame = new JFrame();
        poseListModel = new DefaultListModel();
        selected = 0;
    }

    /**
     * Displays all poses in selected stage of workout on a window
     *
     * @param poses    the list of poses in the selected stage of workout
     * @param sequence the yoga sequence built by the user so far
     */
    public void createPoseMenu(List<YogaPose> poses, YogaSequence sequence) {
        poseFrame.setLayout(new BorderLayout());
        poseFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        for (YogaPose p : poses) {
            poseListModel.addElement(p.getName());
        }
        poseList = new JList(poseListModel);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) poseList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        poseList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        poseList.setSelectedIndex(0);
        createListener(poses, sequence);
        poseFrame.add(new JLabel("Click on a pose to view its description", SwingConstants.CENTER), BorderLayout.NORTH);
        poseFrame.add(poseList, BorderLayout.CENTER);
        poseFrame.setSize(800, 800);
        poseFrame.setVisible(true);
    }

    /**
     *  creates listener for selected pose on JList
     * @param selectedSeq the stage of workout the user selected
     * @param sequence the user's sequence so far
     */

    public void createListener(List<YogaPose> selectedSeq, YogaSequence sequence) {
        poseList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    selected = poseList.getSelectedIndex();
                    options = new PoseAdder();
                    options.displayComponents(selectedSeq, selected, sequence);
                    poseFrame.dispose();
                }
            }
        });
    }
}
