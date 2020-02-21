package ui;

import model.YogaPose;
import model.YogaSequence;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import persistence.Reader;
import persistence.Writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ui.PoseDescriptions.*;
import static ui.PoseDescriptions.WARRIOR1;

public class YogaApp {

    private static final String QUIT = "q";
    private static final String BREATH_CMD = "breathe";
    private static final String WARM_UP_CMD = "warm";
    private static final String MAIN_CMD = "main";
    private static final String WARM_DOWN_CMD = "cool";
    private static final  String RETURN_CMD = "r";
    private static final String ADD_POSE = "a";
    private static final String BACK = "b";
    private static final String REMOVE = "d";
    private static final String LOAD = "load";
    private static final String NEW = "new";
    private static final String SAVE = "s";
    private static final String MANAGE = "m";
    public List<YogaPose> breathingExercisesYoga;
    public List<YogaPose> warmUpPosesYoga;
    public List<YogaPose> mainPosesYoga;
    public List<YogaPose> warmDownPosesYoga;
    private Scanner input;
    private boolean running;
    public YogaSequence myYogaSequence;
    public static final String SEQUENCE_FILE = "./data/sequence.txt";



    //EFFECTS: Creates new YogaApp
    public YogaApp() {
        input = new Scanner(System.in);
        running = true;
    }

    //EFFECTS: runs the YogaApp
    public void runYogaApp() {
        buildBreathingOptionsYoga();
        buildWarmUpOptionsYoga();
        buildMainOptionsYoga();
        buildWarmDownOptionsYoga();
        printWelcomeMenu();
        String cmd1 = getUserInput();
        parseInitialInput(cmd1);
        printMainMenu();
        String cmd2 = getUserInput();
        parseMainInput(cmd2);

    }

    //EFFECTS: Prints welcome menu
    public void printWelcomeMenu() {
        System.out.println("To build a new sequence enter " + NEW);
        System.out.println("To load your saved sequence enter" + LOAD);
    }

    //EFFECTS: Handles user choice for new or saved sequence
    public void parseInitialInput(String cmd1) {
        if (cmd1.equals(NEW)) {
            initializeNewSequence();
        } else if (cmd1.equals(LOAD)) {
            loadSequence();
        }
    }

    //EFFECTS: Creates a new sequence
    public void initializeNewSequence() {
        System.out.println("Give your sequence a name:");
        String seqName = getUserInput();
        System.out.println("How many minutes would you like to work out for today:");
        String input = getUserInput();
        Integer time = Integer.parseInt(input);
        myYogaSequence = new YogaSequence();
        myYogaSequence.setName(seqName);
        myYogaSequence.setAllocatedTime(time);
    }

    //EFFECTS: Loads sequence saved to file
    public void loadSequence() {
        Reader reader = new Reader();

        try {
            String jsonString = reader.readLines(SEQUENCE_FILE);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            myYogaSequence =  mapper.readValue(jsonString,YogaSequence.class);
            System.out.println("loaded sequence, returning to main");
            returnToMain();

        } catch (IOException e) {
            initializeNewSequence();
        }

    }

    //EFFECTS: display choices for browsing, saving, quitting
    public void printMainMenu() {
        System.out.println("For breathing exercises enter 'breathe'");
        System.out.println("For warm-up exercises enter 'warm' ");
        System.out.println("For your main routine exercises enter 'main'");
        System.out.println("For warm-down exercises enter 'cool'");
        System.out.println("To exit the program select 'q'");
        System.out.println("To save sequence select 's'");
        System.out.println("To manage your sequence select 'm'");

    }

    //EFFECTS: handles user input from main menu
    public void parseMainInput(String cmd2) {
        if (cmd2.equals(QUIT)) {
            quitProgram();
        } else if (cmd2.equals(SAVE)) {
            saveSequence();
        } else if (cmd2.equals(MANAGE)) {
            manageSequence();
        } else {
            handleStageSelection(cmd2);
        }
    }

    //REQUIRES: Non-empty sequence
    //EFFECTS: Displays menu for managing sequence
    public void manageSequence() {
        System.out.println("You have " + myYogaSequence.countPoses() + " in your"
                + myYogaSequence.getName());
        System.out.println("Your current sequence is: " + myYogaSequence.listAllPoses());
        System.out.println("The total time of your sequence is: " + myYogaSequence.totalTimeInSeq() + " minutes");
        if (myYogaSequence.totalTimeInSeq() >= myYogaSequence.getAllocatedTime()) {
            System.out.println("You have filled all the allocated time in your sequence!");
        } else {
            System.out.println("You have " + (myYogaSequence.getAllocatedTime() - myYogaSequence.totalTimeInSeq())
                    + " minutes remaining");
        }
        System.out.println("To delete a pose select 'd'");
        System.out.println("To return to main select 'r'");
        String cmd5 = getUserInput();
        handleManageOptions(cmd5);
    }

    //EFFECTS: handles user options from manage sequence menu
    public void handleManageOptions(String cmd5) {
        if (cmd5.equals(RETURN_CMD)) {
            returnToMain();
        } else if (cmd5.equals(REMOVE)) {
            deletePose();
        }
    }

    //MODIFIES: YogaSequence
    //EFFECTS: removes selected pose from sequence
    public void deletePose() {
        System.out.println("Your current sequence is: " + myYogaSequence.listAllPoses());
        System.out.println("Please enter the name of the pose you wish to delete:");
        String toRemove = getUserInput();
        myYogaSequence.removePose(toRemove);
        System.out.println("Your updated sequence is:" + myYogaSequence.listAllPoses());
        System.out.println("Select r to return to the main menu");
        String input = getUserInput();
        returnToMain();
    }

    //EFFECTS: saves sequence to file
    public void saveSequence() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(myYogaSequence);
            Writer writer = new Writer();
            writer.write(jsonString, SEQUENCE_FILE);
            writer.close();
            System.out.println("Sequence saved to " + SEQUENCE_FILE);
            returnToMain();
        } catch (IOException e) {
            System.out.println("Could not save sequence to file");
        }


    }

    //EFFECTS: handles user stage selection
    public void handleStageSelection(String cmd2) {
        List<YogaPose> exercises = new ArrayList<>();
        switch (cmd2) {
            case BREATH_CMD:
                exercises = breathingExercisesYoga;
                break;
            case WARM_UP_CMD:
                exercises = warmUpPosesYoga;
                break;
            case MAIN_CMD:
                exercises = mainPosesYoga;
                break;
            case WARM_DOWN_CMD:
                exercises = warmDownPosesYoga;
                break;
        }
        displayExercises(exercises);
    }

    //EFFECTS: displays exercises in each stage
    public void displayExercises(List<YogaPose> exercises) {
        for (YogaPose nextExercise: exercises) {
            int index = exercises.indexOf(nextExercise) + 1;
            System.out.println(index + ". " + nextExercise.getName());
        }
        System.out.println("To view a pose description please enter its associated number.");
        System.out.println("To return to the main menu press 'r'");
        String cmd3 = getUserInput();
        handleExerciseSelection(cmd3, exercises);

    }

    //EFFECTS: handles user selection from exercise list
    public void handleExerciseSelection(String cmd3, List<YogaPose> exercises) {
        if (cmd3.equals(RETURN_CMD)) {
            returnToMain();
        } else {
            Integer poseNumber = Integer.parseInt(cmd3) - 1;
            System.out.println(exercises.get(poseNumber).getDescription());
            System.out.println("Difficulty level: " + exercises.get(poseNumber).getLevel());
            System.out.println("To add this pose to your routine enter 'a'");
            System.out.println("To browse more sequences press 'b'");
            String cmd4 = getUserInput();
            handlePoseSelection(cmd4, exercises, poseNumber);
        }

    }

    //EFFECTS: handles user input from pose view
    public void handlePoseSelection(String cmd4, List<YogaPose> exercises, Integer poseNumber) {
        if (cmd4.equals(BACK)) {
            returnToMain();
        } else if (cmd4.equals(ADD_POSE)) {
            addPose(exercises, poseNumber);
        }
    }

    //MODIFIES: YogaSequence
    //EFFECTS: adds pose to sequence
    public void addPose(List<YogaPose> exercises, Integer poseNumber) {
        YogaPose pose = exercises.get(poseNumber);
        myYogaSequence.addPose(pose);
        setPoseTime(pose);
        System.out.println("Your current sequence is: " + myYogaSequence.listAllPoses());
        System.out.println("Enter 'r' to return to main menu");
        String input = getUserInput();
        returnToMain();
    }

    //MODIFIES: YogaPose
    //EFFECTS: sets pose time to user selection
    public void setPoseTime(YogaPose pose) {
        System.out.println("Please enter the number of minutes you want to practice this pose for: ");
        String input = getUserInput();
        Integer time = Integer.parseInt(input);
        pose.setTime(time);

    }



    //EFFECTS: Returns user to main menu
    public void returnToMain() {
        printMainMenu();
        String option = getUserInput();
        parseMainInput(option);
    }










    //EFFECTS: Populates Yoga breathing exercise list with pre-defined exercises
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

//EFFECTS: Populates Yoga warm-down exercise list with pre-defined exercises

    public void  buildWarmDownOptionsYoga() {
        warmDownPosesYoga = new ArrayList<>();
        warmDownPosesYoga.add(BRIDGE);
        warmDownPosesYoga.add(CHILD);
        warmDownPosesYoga.add(CORPSE);
        warmDownPosesYoga.add(WARRIOR1);
    }

    //EFFECTS: gets input from user
    private String getUserInput() {
        String cmd = " ";
        if (input.hasNext()) {
            cmd = input.nextLine();
            cmd.toLowerCase();
        }
        return cmd;
    }

    //MODIFIES: this
    //EFFECTS: Ends program
    private void quitProgram() {
        running = false;
        System.out.println("Goodbye! Hope you enjoyed your practice today.");
        System.exit(0);
    }





}
