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
import static ui.PoseDescriptions.*;

/**
 * Represents JButtons for each of the four workout stages
 */

public class Stages extends JPanel {
    public List<YogaPose> breathingExercisesYoga;
    public List<YogaPose> warmUpPosesYoga;
    public List<YogaPose> mainPosesYoga;
    public List<YogaPose> warmDownPosesYoga;

    private JButton breatheBtn;
    private JButton warmBtn;
    private JButton mainBtn;
    private JButton coolBtn;
    private YogaSequence myYogaSeq;
    private ImageIcon flowFinal;
    private ImageIcon breatheFinal;
    private ImageIcon warmUpFinal;
    private ImageIcon coolFinal;

    /**
     * Constructor builds the list of poses and buttons for each stage of the workout
     * @param sequence the sequence the user has built so far
     */
    public Stages(YogaSequence sequence) {
        initializePoseLists();
        this.myYogaSeq = sequence;
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
        addBreatheBtnListener();
        addWarmBtnListener();
        addMainBtnListener();
        addCoolButtonListeners();
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

    public void addBreatheBtnListener() {
        breatheBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists poseList = new PoseLists();
                poseList.createExercisesMenu(breathingExercisesYoga, myYogaSeq);
            }
        });
    }

    /**
     * Helper to detect when the warm-up JButton is selected, deploys exercise menu with warm up exercises
     */

    public void addWarmBtnListener() {
        warmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists warmList = new PoseLists();
                warmList.createExercisesMenu(warmUpPosesYoga, myYogaSeq);
            }
        });

    }

    /**
     * Helper to detect when the main JButton is selected, deploys exercise menu with main exercises
     */

    public void addMainBtnListener() {
        mainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists mainList = new PoseLists();
                mainList.createExercisesMenu(mainPosesYoga, myYogaSeq);
            }
        });
    }

    /**
     * Helper to detect when the cool JButton is selected, deploys exercise menu with cool down  exercises
     */

    public void addCoolButtonListeners() {

        coolBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists coolList = new PoseLists();
                coolList.createExercisesMenu(warmDownPosesYoga, myYogaSeq);
            }
        });
    }

    /**
     * Helper that initalizes the list of poses in each stage
     */
    public void initializePoseLists() {
        breathingExercisesYoga = new ArrayList<>();
        warmUpPosesYoga = new ArrayList<>();
        mainPosesYoga = new ArrayList<>();
        warmDownPosesYoga = new ArrayList<>();
        buildBreathingOptionsYoga();
        buildMainOptionsYoga();
        buildWarmUpOptionsYoga();
        buildWarmDownOptionsYoga();

    }


    /**
     * Helper that populates the breathing exercises list with pre-defined exercises
     */
    public void buildBreathingOptionsYoga() {
        breathingExercisesYoga = new ArrayList<>();
        breathingExercisesYoga.add(PoseDescriptions.ALTERNATE);
        breathingExercisesYoga.add(KAPALABHATI);
        breathingExercisesYoga.add(PoseDescriptions.COOLING);
        breathingExercisesYoga.add(LION);
        breathingExercisesYoga.add(CONQUEROR);
        breathingExercisesYoga.add(SOUND);

    }

    /**
     * Helper that populates the warm-up exercises list with pre-defined exercises
     */
    public void buildWarmUpOptionsYoga() {
        warmUpPosesYoga = new ArrayList<>();
        warmUpPosesYoga.add(CATCOW);
        warmUpPosesYoga.add(BOAT);
        warmUpPosesYoga.add(SEATEDFORWARDBEND);
        warmUpPosesYoga.add(FISHTWIST);
        warmUpPosesYoga.add(PUPPY);
        warmUpPosesYoga.add(BUTTERFLY);
        warmUpPosesYoga.add(LOCUST);


    }

    /**
     * Helper that populates the main exercises list with pre-defined exercises
     */
    public void buildMainOptionsYoga() {
        mainPosesYoga = new ArrayList<>();
        mainPosesYoga.add(PLANK);
        mainPosesYoga.add(DOWNWARD_DOG);
        mainPosesYoga.add(CHAIR);
        mainPosesYoga.add(WARRIOR1);
        mainPosesYoga.add(WARRIORII);
        mainPosesYoga.add(EAGLE);
        mainPosesYoga.add(GATE);
        mainPosesYoga.add(LOW_LUNGE);
        mainPosesYoga.add(HIGH_LUNGE);
        mainPosesYoga.add(TRIANGLE);
        mainPosesYoga.add(GARLAND);
        mainPosesYoga.add(DOLPHIN);
        mainPosesYoga.add(DPLANK);
        mainPosesYoga.add(UPPLANK);


    }

    /**
     * Helper that populates the warm-down exercises list with pre-defined exercises
     */

    public void buildWarmDownOptionsYoga() {
        warmDownPosesYoga = new ArrayList<>();
        warmDownPosesYoga.add(BRIDGE);
        warmDownPosesYoga.add(CHILD);
        warmDownPosesYoga.add(CORPSE);
        warmDownPosesYoga.add(LOCUST);
        warmDownPosesYoga.add(BIGTOE);
        warmDownPosesYoga.add(STAFF);
        warmDownPosesYoga.add(BABY);
        warmDownPosesYoga.add(ANGLE);

    }



}
