//https://www.dummies.com/programming/java/how-to-use-sliders-in-java/
//https://stackoverflow.com/questions/1090098/newline-in-jlabel
//<div>Icons made by <a href="https://www.flaticon.com/authors/freepik"
// title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
//https://stackoverflow.com/questions/12260962/how-to-set-the-java-default-button-to-react-on-enter-key-released

package ui;

import exceptions.DuplicatePoseException;
import exceptions.OutOfTimeException;
import model.YogaPose;
import model.YogaSequence;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Represents the window that displays pose details
 */

public class PoseAdder extends JPanel {
    private  JButton setBtn;
    private JFrame poseWindow;
    private TimeSetter timeGUI;
    private JLabel poseDescription;


    /**
     * Initializes the window that displays the details of the pose
     */

    public PoseAdder() {
        poseWindow = new JFrame();
        poseDescription = new JLabel();
        poseWindow.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        poseWindow. setLayout(new BorderLayout());
        setBtn = new JButton("Add");
        poseWindow.getRootPane().setDefaultButton(setBtn);
        poseWindow.add(new JLabel(IconCreator.makeIcon("./data/banner.jpg", 1000, 200)),
                BorderLayout.NORTH);
        timeGUI = new TimeSetter();
    }



    /**
     * Adds JLabel of pose instructions and time slider for user to choose time
     */
    public void displayComponents(List<YogaPose> poses, int selected, YogaSequence sequence) {
        YogaPose selectedPose = poses.get(selected);
        poseWindow.setTitle(selectedPose.getName());
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
                    sucessPopup(selectedPose);
                } catch (DuplicatePoseException ex) {
                    createWarning("This pose is already in your sequence!");
                } catch (OutOfTimeException ex) {
                    createWarning("You have already allocated all your time in this sequence!");
                }
            }
        });
        poseWindow.setSize(1000,600);
        poseWindow.setVisible(true);
    }

    /**
     * Helper to create popUp that informs user, pose is already in sequence
     */

    public void createWarning(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * creates popUp to indicate that add was successful
     * @param selectedPose pose that was added to sequence
     */

    public void sucessPopup(YogaPose selectedPose) {
        JFrame popUp = new JFrame("Success!");
        popUp.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        popUp.setLayout(new BorderLayout());
        popUp.add(new JLabel(selectedPose.getName()
                        + " was added for " + selectedPose.getTime() + " minutes!", SwingConstants.CENTER),
                BorderLayout.NORTH);
        ImageIcon success = new ImageIcon("./data/success.png");
        popUp.add(new JLabel(success), BorderLayout.CENTER);
        popUp.setSize(600,600);
        playMusic();
        popUp.setVisible(true);
    }

    /**
     * Plays sound when popup that indicates add is successful is displayed
     */

    public static void playMusic() {
        InputStream music;
        try {
            music = new FileInputStream(new File("./data/sound.wav"));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");

        }
    }

}
