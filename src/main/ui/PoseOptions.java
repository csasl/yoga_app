//https://www.dummies.com/programming/java/how-to-use-sliders-in-java/
//https://stackoverflow.com/questions/1090098/newline-in-jlabel
//<div>Icons made by <a href="https://www.flaticon.com/authors/freepik"
// title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
//https://stackoverflow.com/questions/12260962/how-to-set-the-java-default-button-to-react-on-enter-key-released

package ui;

import exceptions.DuplicatePoseException;
import model.YogaPose;
import model.YogaSequence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * Represents the window that displays pose details
 */

public class PoseOptions extends JPanel {
    private  JButton setBtn;
    private JFrame poseWindow;
    private TimeSelectorGUI timeGUI;


    /**
     * Initializes the window that displays the details of the pose
     * @param poses List contains all exercises in the stage the user has chosen
     * @param selected the index of the pose the user chose from the poseList
     * @param seq the sequence the user has built so far
     */

    public PoseOptions(List<YogaPose> poses, int selected, YogaSequence seq) {

        YogaPose selectedPose = poses.get(selected);
        poseWindow = new JFrame(selectedPose.getName());
        poseWindow.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        poseWindow. setLayout(new BorderLayout());
        setBtn = new JButton("Add");
        poseWindow.getRootPane().setDefaultButton(setBtn);
        ImageIcon banner = new ImageIcon("./data/banner.jpg");
        Image bannerImage = banner.getImage();
        Image bannerResize = bannerImage.getScaledInstance(1000, 200, Image.SCALE_SMOOTH);
        ImageIcon finalBanner = new ImageIcon(bannerResize);
        poseWindow.add(new JLabel(finalBanner), BorderLayout.NORTH);
        timeGUI = new TimeSelectorGUI();
        showDetails(selectedPose, seq);
    }


    /**
     * Adds JLabel of pose instructions and time slider for user to choose time
     */
    public void showDetails(YogaPose selectedPose, YogaSequence sequence) {
        JLabel poseDescription = new JLabel();
        poseDescription.setText("<html>" + selectedPose.getDescription()
                .replaceAll(">", "gt").replaceAll("\n", "<br/>") + "</html>");

        poseWindow.add(poseDescription, BorderLayout.LINE_START);
        poseWindow.add(timeGUI.createTimeSlider(), BorderLayout.LINE_END);
        poseWindow.add(setBtn, BorderLayout.SOUTH);
        setBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeGUI.setTime(selectedPose);
                try {
                    sequence.addPose(selectedPose);
                } catch (DuplicatePoseException ex) {
                    ex.printStackTrace();
                }

            }
        });
        poseWindow.setSize(1000,600);
        poseWindow.setVisible(true);
    }


}
