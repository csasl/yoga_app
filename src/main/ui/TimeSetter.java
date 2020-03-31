package ui;


import model.YogaPose;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TimeSetter {
    private JSlider timeSlider;
    private int selectedTime;

    /**
     * Constructs time setter
     */
    public TimeSetter() {
        timeSlider = new JSlider(0,30);
        selectedTime = 0;
    }

    /**
     *  Sets up time slider component
     * @return Slider to set time of pose
     */


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
    }


}
