//https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
//<div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from
// <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>

package ui;


import model.YogaPose;
import model.YogaSequence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import static ui.PresetPoses.*;

/**
 * Represents JButtons for each of the four workout stages
 */

public class StageViewer extends JPanel {

    private PresetPoses presetPoses;
    private JButton breatheBtn;
    private JButton warmBtn;
    private JButton mainBtn;
    private JButton coolBtn;
    private ImageIcon flowFinal;
    private ImageIcon breatheFinal;
    private ImageIcon warmUpFinal;
    private ImageIcon coolFinal;

    /**
     * Constructor builds the list of poses and buttons for each stage of the workout
     * @param sequence the sequence the user has built so far
     */
    public StageViewer(YogaSequence sequence) {
        presetPoses = new PresetPoses();
        setLayout(new GridLayout(2,2));
        this.setBackground(Color.BLACK);
        makeIcons();
        breatheBtn = new JButton(breatheFinal);
        warmBtn = new JButton(warmUpFinal);
        mainBtn = new JButton(flowFinal);
        coolBtn = new JButton(coolFinal);
        add(breatheBtn);
        add(warmBtn);
        add(mainBtn);
        add(coolBtn);
        addBreatheBtnListener(sequence);
        addWarmBtnListener(sequence);
        addMainBtnListener(sequence);
        addCoolButtonListeners(sequence);
    }

    /**
     * Helper method to make the icons for the JButtons
     */

    public void makeIcons() {
        ImageIcon flow = new ImageIcon("./data/flow.jpg");
        Image flowImage = flow.getImage();
        Image flowResize = flowImage.getScaledInstance(470, 470, Image.SCALE_SMOOTH);
        flowFinal = new ImageIcon(flowResize);
        ImageIcon breathe = new ImageIcon("./data/breathe.jpg");
        Image breatheImage = breathe.getImage();
        Image breatheResize = breatheImage.getScaledInstance(470,470,Image.SCALE_SMOOTH);
        breatheFinal = new ImageIcon(breatheResize);
        ImageIcon warmup = new ImageIcon("./data/warmup.jpg");
        Image warmImage = warmup.getImage();
        Image warmResize = warmImage.getScaledInstance(470, 470, Image.SCALE_SMOOTH);
        warmUpFinal = new ImageIcon(warmResize);
        ImageIcon cool = new ImageIcon("./data/cool.jpg");
        Image coolImage = cool.getImage();
        Image coolResize = coolImage.getScaledInstance(465, 465, Image.SCALE_SMOOTH);
        coolFinal = new ImageIcon(coolResize);
    }

    /**
     * Helper to detect when the breathe JButton is selected, deploys exercise menu with breathing exercises
     */

    public void addBreatheBtnListener(YogaSequence myYogaSeq) {
        breatheBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists poseList = new PoseLists();
                poseList.createExercisesMenu(presetPoses.buildBreathingOptionsYoga(), myYogaSeq);
            }
        });
    }

    /**
     * Helper to detect when the warm-up JButton is selected, deploys exercise menu with warm up exercises
     */

    public void addWarmBtnListener(YogaSequence myYogaSeq) {
        warmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists warmList = new PoseLists();
                warmList.createExercisesMenu(presetPoses.buildWarmUpOptionsYoga(), myYogaSeq);
            }
        });

    }

    /**
     * Helper to detect when the main JButton is selected, deploys exercise menu with main exercises
     */

    public void addMainBtnListener(YogaSequence myYogaSeq) {
        mainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists mainList = new PoseLists();
                mainList.createExercisesMenu(presetPoses.buildMainOptionsYoga(), myYogaSeq);
            }
        });
    }

    /**
     * Helper to detect when the cool JButton is selected, deploys exercise menu with cool down  exercises
     */

    public void addCoolButtonListeners(YogaSequence myYogaSeq) {

        coolBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists coolList = new PoseLists();
                coolList.createExercisesMenu(presetPoses.buildWarmDownOptionsYoga(), myYogaSeq);
            }
        });
    }


}
