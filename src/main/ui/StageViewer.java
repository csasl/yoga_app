//https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
//<div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from
// <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>

package ui;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Represents Menu for the 4 stages of the workout
 */

public class StageViewer extends JPanel {

    private JButton breatheBtn;
    private JButton warmBtn;
    private JButton mainBtn;
    private JButton coolBtn;
    private PoseLists poseList;
    private PoseLists warmList;
    private PoseLists mainList;
    private PoseLists coolList;

    /**
     * Constructor builds the list of poses and buttons for each stage of the workout
     *
     */
    public StageViewer() {
        setLayout(new GridLayout(2,2));
        this.setBackground(Color.BLACK);
        breatheBtn = new JButton(IconCreator.makeIcon("./data/breathe.jpg", 470, 470));
        warmBtn = new JButton(IconCreator.makeIcon("./data/warmup.jpg", 470, 470));
        mainBtn = new JButton(IconCreator.makeIcon("./data/flow.jpg", 470, 470));
        coolBtn = new JButton(IconCreator.makeIcon("./data/cool.jpg", 470, 470));
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
     * Helper to detect when the breathe JButton is selected, deploys exercise menu with breathing exercises
     */

    public void addBreatheBtnListener() {
        breatheBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                poseList = new PoseLists();
                poseList.createPoseMenu(PresetPoses.buildBreathingOptionsYoga());
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
                warmList = new PoseLists();
                warmList.createPoseMenu(PresetPoses.buildWarmUpOptionsYoga());
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
                mainList = new PoseLists();
                mainList.createPoseMenu(PresetPoses.buildMainOptionsYoga());
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
                coolList = new PoseLists();
                coolList.createPoseMenu(PresetPoses.buildWarmDownOptionsYoga());
            }
        });
    }


}
