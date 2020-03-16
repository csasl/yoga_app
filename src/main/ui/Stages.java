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


    public Stages(YogaSequence sequence) {
        initializePoseLists();
        this.myYogaSeq = sequence;
        setLayout(new GridLayout(2,2));
        setBackground(Color.DARK_GRAY);
        makeIcons();
        breatheBtn = new JButton(breatheFinal);
        warmBtn = new JButton(warmUpFinal);
        mainBtn = new JButton(flowFinal);
        coolBtn = new JButton(coolFinal);
        add(breatheBtn);
        add(warmBtn);
        add(mainBtn);
        add(coolBtn);
        addButtonListeners();

    }

    public void makeIcons() {
        ImageIcon flow = new ImageIcon("flow.png");
        Image flowImage = flow.getImage();
        Image flowResize = flowImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        flowFinal = new ImageIcon(flowResize);
        ImageIcon breathe = new ImageIcon("breathe.png");
        Image breatheImage = breathe.getImage();
        Image breatheResize = breatheImage.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        breatheFinal = new ImageIcon(breatheResize);
        ImageIcon warmup = new ImageIcon("warmup.png");
        Image warmImage = warmup.getImage();
        Image warmResize = warmImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        warmUpFinal = new ImageIcon(warmResize);
        ImageIcon cool = new ImageIcon("cool.png");
        Image coolImage = cool.getImage();
        Image coolResize = coolImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        coolFinal = new ImageIcon(coolResize);

    }

    public void addButtonListeners() {
        breatheBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists poseList = new PoseLists();
                poseList.createExercisesMenu(breathingExercisesYoga, myYogaSeq);
            }
        });

        warmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists warmList = new PoseLists();
                warmList.createExercisesMenu(warmUpPosesYoga, myYogaSeq);
            }
        });

        mainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PoseLists mainList = new PoseLists();
                mainList.createExercisesMenu(mainPosesYoga, myYogaSeq);
            }
        });



    }

    public void initializePoseLists() {
        breathingExercisesYoga = new ArrayList<>();
        warmUpPosesYoga = new ArrayList<>();
        mainPosesYoga = new ArrayList<>();
        warmDownPosesYoga = new ArrayList<>();
        buildBreathingOptionsYoga();
        buildMainOptionsYoga();
        buildWarmUpOptionsYoga();

    }



  //  EFFECTS: Populates Yoga breathing exercise list with pre-defined exercises
    public void buildBreathingOptionsYoga() {
        breathingExercisesYoga = new ArrayList<>();
        breathingExercisesYoga.add(PoseDescriptions.ALTERNATE);
        breathingExercisesYoga.add(KAPALABHATI);
        breathingExercisesYoga.add(PoseDescriptions.COOLING);
        breathingExercisesYoga.add(LION);
    }

    //EFFECTS: Populates Yoga warm-up exercise list with pre-defined exercises
    public void buildWarmUpOptionsYoga() {
        warmUpPosesYoga = new ArrayList<>();
        warmUpPosesYoga.add(CATCOW);
        warmUpPosesYoga.add(BOAT);
        warmUpPosesYoga.add(SEATEDFORWARDBEND);
        warmUpPosesYoga.add(FISHTWIST);
        warmUpPosesYoga.add(PUPPY);
        warmUpPosesYoga.add(BUTTERFLY);
    }

    //EFFECTS: Populates Yoga main exercise list with pre-defined exercises
    public void buildMainOptionsYoga() {
        mainPosesYoga = new ArrayList<>();
        mainPosesYoga.add(PLANK);
        mainPosesYoga.add(DOWNWARD_DOG);
        mainPosesYoga.add(CHAIR);
        mainPosesYoga.add(WARRIOR1);
        mainPosesYoga.add(EAGLE);
        mainPosesYoga.add(GATE);
        mainPosesYoga.add(LOW_LUNGE);
        mainPosesYoga.add(HIGH_LUNGE);
        mainPosesYoga.add(TRIANGLE);
        mainPosesYoga.add(GARLAND);
    }



}
