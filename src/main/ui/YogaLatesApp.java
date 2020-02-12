//YogaLates App runs the UI portion of the app
//Used code from: https://github.com/UBCx-Software-Construction/long-form-problem-starters.git UI package
// and from: https://github.students.cs.ubc.ca/CPSC210/TellerApp.git UI package as a template
//for this UI package

package ui;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ui.PoseDescriptions.*;

public class YogaLatesApp {
    private static final String QUIT = "q";
    private static final String BREATH_CMD = "breathe";
    private static final String WARM_UP_CMD = "warm";
    private static final String MAIN_CMD = "main";
    private static final String WARM_DOWN_CMD = "cool";
    private static final  String RETURN_CMD = "r";
    private static final String ADD_POSE = "a";
    private static final String BACK = "b";
    private static final String REMOVE = "d";
    private static final String YOGA = "yoga";
    private static final String PILATES = "pilates";
    public List<Exercise> breathingExercisesYoga;
    public List<Exercise> warmUpPosesYoga;
    public List<Exercise> mainPosesYoga;
    public List<Exercise> warmDownPosesYoga;
    public List<Exercise> warmUpPosesPilates;
    public List<Exercise> mainPosesPilates;
    public List<Exercise> warmDownPosesPilates;
    private Scanner input;
    private boolean running;
    public ExerciseSequence myExerciseSequence;

//EFFECTS: Creates a new YogaLates App
    public YogaLatesApp() {
        input = new Scanner(System.in);
        running = true;
    }

//EFFECTS: Runs the YogaLates App
    public void runYogaApp() {
        buildBreathingOptionsYoga();
        buildWarmUpOptionsYoga();
        buildMainOptionsYoga();
        buildWarmDownOptionsYoga();
        buildWarmUpExercisesPilates();
        buildMainExercisesPilates();
        buildWarmDownExcercisesPilates();
        printWelcomeMenu();
        String cmd1 = getUserInput();
        initializeSequence(cmd1);
        printStageMenu(cmd1);
    }

//MODIFIES: ExerciseSequence
//EFFECTS: Given a user selection of Yoga or Pilates, creates either a new YogaSequence or Pilates Sequence

    public void initializeSequence(String cmd1) {
        System.out.println("Give your sequence a name:");
        String seqName = getUserInput();
        System.out.println("Please enter the number of minutes you want to work out for today: ");
        String input = getUserInput();
        Integer time = Integer.parseInt(input);
        if (cmd1.equals(YOGA)) {
            myExerciseSequence = new YogaSequence();
            myExerciseSequence.setName(seqName);
            myExerciseSequence.setAllocatedTime(time);
        } else if (cmd1.equals(PILATES)) {
            myExerciseSequence = new PilatesSequence();
            myExerciseSequence.setName(seqName);
            myExerciseSequence.setAllocatedTime(time);
        }
    }

//REQUIRES: Non-empty list of exercises
//EFFECTS: Given user input from list of pose selection, handles input appropriately by returning to main or
//displaying pose description
    private void handlePoseSelection(List<Exercise> exercises, String option, String cmd1) {
        if (option.equals(RETURN_CMD)) {
            returnToMain(cmd1);
        } else {
            Integer poseNumber = Integer.parseInt(option) - 1;
            System.out.println(exercises.get(poseNumber).getDescription());
            System.out.println("Difficulty level: " + exercises.get(poseNumber).getLevel());
            System.out.println("To add this pose to your routine enter 'a'");
            System.out.println("To browse more sequences press 'b'");
            String cmd4 = getUserInput();
            handlePoseOptions(cmd4, poseNumber, exercises, cmd1);
        }
    }

//EFFECTS: Given user input to return to main, prints appropriate menu depending on whether yoga or pilates was
//initially selected
    public void returnToMain(String cmd1) {
        printStageMenu(cmd1);
    }

//REQUIRES: Non-empty list of exercises
//EFFECTS: Given user input from pose description, manages input by either adding pose or going back to pose list
    public void handlePoseOptions(String cmd4,Integer poseNumber, List<Exercise> exercises, String cmd1) {
        if (cmd4.equals(ADD_POSE)) {
            Exercise pose = exercises.get(poseNumber);
            myExerciseSequence.addPose(pose);
            setPoseTime(pose);
            System.out.println("You have " + myExerciseSequence.getNumberOfPoses() + " poses in your sequence.");
            System.out.println("Your current " + myExerciseSequence.getNameOfSeq()
                    + " sequence is:" + myExerciseSequence.listAllPoses());
            System.out.println("Total time of your sequence: " + myExerciseSequence.totalTimeInSeq() + " minutes.");
            if ((myExerciseSequence.getAllocatedTime() - myExerciseSequence.totalTimeInSeq()) <= 0) {
                System.out.println("You have filled all your allocated time!");
            } else {
                System.out.println("You have "
                        + (myExerciseSequence.getAllocatedTime() - myExerciseSequence.totalTimeInSeq()) + " minutes"
                        + "left in your sequence");
            }

            System.out.println("Press 'b' to browse more poses");
            System.out.println("To delete a pose press  'd'");
            String cmd5 = getUserInput();
            handlePoseListOptions(cmd5, exercises, cmd1);
        } else if (cmd4.equals(BACK)) {
            displayExercises(exercises, cmd1);
        }
    }

//REQUIRES: Non-empty list of exercises
//EFFECTS: Given input from user after adding pose to ExerciseSequence, either returns back to main or removes pose

    public void handlePoseListOptions(String cmd5, List<Exercise> exercises, String cmd1) {
        if (cmd5.equals(BACK)) {
            displayExercises(exercises, cmd1);
        } else if (cmd5.equals(REMOVE)) {
            removePoseFromList(cmd1);
        }
    }

//EFFECTS: Given a pose name, removes the pose from ExerciseSequence
    public void removePoseFromList(String cmd1) {
        System.out.println("Please enter the name of the pose you wish to delete: ");
        String poseToRemove = getUserInput();
        myExerciseSequence.removePose(poseToRemove);
        System.out.println("Your updated " + myExerciseSequence.getNameOfSeq()
                + "sequence: " + myExerciseSequence.listAllPoses());
        System.out.println("To return to the main menu press 'r'");
        String option = getUserInput();
        returnToMain(cmd1);
    }

//MODIFIES: Exercise
//EFFECTS: Given a pose to add to ExerciseSequence, sets the time in minutes the pose will be practiced for
    public void setPoseTime(Exercise pose) {
        System.out.println("Enter the number of minutes you want to practice this pose for: ");
        String cmd5 = getUserInput();
        Integer poseTime = Integer.parseInt(cmd5);
        pose.setTime(poseTime);
    }

//EFFECTS: Given user input from the Welcome menu, either ends program or displays Stage list
    public void handleExerciseTypeSelection(String cmd1, String cmd2) {
        if (cmd2.equals(QUIT)) {
            quitProgram();
        } else if (cmd1.equals(YOGA)) {
            parseYogaInput(cmd1, cmd2);
        } else if (cmd1.equals(PILATES)) {
            parsePilatesInput(cmd1, cmd2);
        }
    }

//EFFECTS: Initializes list of yoga exercises to display given user selection of stage of exercise
    public void parseYogaInput(String cmd1, String cmd2) {
        List<Exercise> exercises = new ArrayList<>();
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
        displayExercises(exercises, cmd1);
    }

//EFFECTS: Initializes list of pilates exercises to display given user selection of stage of exercise
    public void parsePilatesInput(String cmd1, String cmd2) {
        List<Exercise> exercises = new ArrayList<>();
        switch (cmd2) {
            case WARM_UP_CMD:
                exercises = warmUpPosesPilates;
                break;
            case MAIN_CMD:
                exercises = mainPosesPilates;
                break;
            case WARM_DOWN_CMD:
                exercises = warmDownPosesPilates;
                break;
        }
        displayExercises(exercises, cmd1);
    }

//REQUIRES: Non-empty list of selected exercises
//EFFECTS: Displays names of all exercises in user's selected stage of workout
    public void displayExercises(List<Exercise> exercises, String cmd1) {
        for (Exercise nextExercise: exercises) {
            int index = exercises.indexOf(nextExercise) + 1;
            System.out.println(index + ". " + nextExercise.getName());
        }
        System.out.println("To view a pose description please enter its associated number.");
        System.out.println("To return to the main menu press 'r'");
        String cmd3 = getUserInput();
        handlePoseSelection(exercises, cmd3, cmd1);
    }


//EFFECTS: Prints the appropriate stage menu depending on which exercise the user selected
    public void printStageMenu(String input) {
        if (input.equals(YOGA)) {
            System.out.println("For breathing exercises enter 'breathe'");
            System.out.println("For warm-up exercises enter 'warm' ");
            System.out.println("For your main routine exercises enter 'main'");
            System.out.println("For warm-down exercises enter 'cool'");

        } else if (input.equals(PILATES)) {
            System.out.println("For warm-up exercises enter 'warm' ");
            System.out.println("For your main routine exercises enter 'main'");
            System.out.println("For warm-down exercises enter 'cool'");
        }
        System.out.println("To exit the program select 'q'");
        String cmd2 = getUserInput();
        handleExerciseTypeSelection(input, cmd2);
    }

//EFFECTS: Dsiplays menu of exercise options- either yoga or pilates
    public void printWelcomeMenu() {
        System.out.println("To build a yoga routine, enter 'yoga', to build a pilates routine enter 'pilates'.");
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

//EFFECTS: Populates Pilates exercise lists with pre-defined exercises

    public void buildWarmUpExercisesPilates() {

        warmUpPosesPilates = new ArrayList<>();
        warmUpPosesPilates.add(IMPRINTING);
        warmUpPosesPilates.add(ARM_REACH);
        warmUpPosesPilates.add(PELVIC_CURL);
        warmUpPosesPilates.add(SWAN);
    }

    public void buildMainExercisesPilates() {
        mainPosesPilates = new ArrayList<>();
        mainPosesPilates.add(ROLL_OVER);
        mainPosesPilates.add(CIRCLES);
        mainPosesPilates.add(SINGLE_lEG);
        mainPosesPilates.add(DOUBLE_LEG);
        mainPosesPilates.add(ROCKER);
        mainPosesPilates.add(CRISS_CROSS);
        mainPosesPilates.add(SAW);
        mainPosesPilates.add(ARM_LEG_REACH);

    }

    public void buildWarmDownExcercisesPilates() {
        warmDownPosesPilates = new ArrayList<>();
        warmDownPosesPilates.add(SEATED_TWIST);
        warmDownPosesPilates.add(SPINE_STRETCH);
        warmDownPosesPilates.add(BRIDGE_PILATES);
        warmDownPosesPilates.add(CORPSE_PILATES);

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