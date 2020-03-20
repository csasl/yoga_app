//https://www.dummies.com/programming/java/how-to-use-sliders-in-java/
//https://stackoverflow.com/questions/1090098/newline-in-jlabel
//<div>Icons made by <a href="https://www.flaticon.com/authors/freepik"
// title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>

package ui;

import model.YogaPose;
import model.YogaSequence;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class PoseDetails extends JPanel {
    private  JButton setBtn;
    private List<YogaPose> selectedPoses;
    private int selected;
    private YogaPose selectedPose;
    private JFrame poseWindow;
    private JSlider timeSlider = new JSlider(0, 30);
    private YogaSequence sequence;
    private int selectedTime;
    private JFrame popUp;

    public PoseDetails(List<YogaPose> poses, int selected, YogaSequence seq) {
        this.selectedPoses = poses;
        this.selected = selected;
        this.sequence = seq;
        selectedPose = selectedPoses.get(selected);
        poseWindow = new JFrame(selectedPose.getName());
        poseWindow.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        poseWindow. setLayout(new BorderLayout());
        ImageIcon banner = new ImageIcon("./data/banner.jpg");
        Image bannerImage = banner.getImage();
        Image bannerResize = bannerImage.getScaledInstance(1000, 200, Image.SCALE_SMOOTH);
        ImageIcon finalBanner = new ImageIcon(bannerResize);
        poseWindow.add(new JLabel(finalBanner), BorderLayout.NORTH);
        selectedTime = 0;
        showDetails();
    }

    public void showDetails() {
        JLabel poseDescription = new JLabel();
        poseDescription.setText("<html>" + selectedPose.getDescription()
                .replaceAll(">", "gt").replaceAll("\n", "<br/>") + "</html>");

        poseWindow.add(poseDescription, BorderLayout.LINE_START);


        createTimeSlider();
        poseWindow.add(timeSlider, BorderLayout.LINE_END);
        poseWindow.add(setBtn, BorderLayout.SOUTH);
        poseWindow.setSize(1000,600);
        poseWindow.setVisible(true);
    }


    public void createTimeSlider() {
        setBtn = new JButton("Set");
        timeSlider.setMajorTickSpacing(10);
        timeSlider.setMinorTickSpacing(1);
        timeSlider.setPaintTicks(true);
        timeSlider.setPaintLabels(true);
        sliderAddChangeListener();
        setBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sequence.addPose(selectedPose);
                setTime();
            }
        });
    }

    public void sliderAddChangeListener() {
        timeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                selectedTime = timeSlider.getValue();
                }
        });
    }


    public void setTime() {
        selectedPose.setTime(selectedTime);
        popUp = new JFrame("Success!");
        popUp.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        popUp.setLayout(new BorderLayout());
        popUp.add(new JLabel(selectedPose.getName() + " was added for " + selectedPose.getTime() + " minutes"),
                BorderLayout.CENTER);
        popUp.setSize(400,400);
        popUp.setVisible(true);
        playMusic();
        poseWindow.dispose();

    }

    public static void playMusic() {
        InputStream music;
        try {
            music = new FileInputStream(new File("./data/sound.wav"));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }


    }
}
