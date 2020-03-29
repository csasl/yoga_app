package ui;


import model.YogaPose;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.*;

public class TimeSelectorGUI {
    private JSlider timeSlider;
    private int selectedTime;

    public TimeSelectorGUI() {
        timeSlider = new JSlider(0,30);
        selectedTime = 0;
    }


    public JSlider createTimeSlider() {

        timeSlider.setMajorTickSpacing(10);
        timeSlider.setMinorTickSpacing(1);
        timeSlider.setPaintTicks(true);
        timeSlider.setPaintLabels(true);
        sliderAddChangeListener();
        return timeSlider;
    }



    /**
     * Detects change in slider value
     */
    public void sliderAddChangeListener() {
        timeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                selectedTime = timeSlider.getValue();
            }
        });
    }

    /**
     * Sets time to time on slider and displays popup indicating add was successful
     */
    public void setTime(YogaPose selectedPose) {
        selectedPose.setTime(selectedTime);
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
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
    }


}
