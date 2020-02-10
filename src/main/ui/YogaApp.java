package ui;
//Used TellerApp as a template for UI design

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YogaApp {
    public static final YogaPose ALTERNATE = new YogaPose("Alternate Nostril Breathing", "Sit comfortably"
            + "cover your left nostril with your right ring finger, breathe in through your right nostril, cover "
            + "your right nostril with your thumb, now uncover your left nostril and breathe out", "All",
            Stage.BREATHING);

    public static final YogaPose KAPALABHATI = new YogaPose("Kapalabhati", "Inhale deeply through"
            + "your nose, as you exhale, press your belly towards your spine to force the breath out", "All",
            Stage.MAIN);

    public static final YogaPose COOLING = new YogaPose("Sitali", "Also known as cooling breath. "
            + "Make an O-shape with your mouth and inhale through your mouth as if drinking through a straw,"
            + " breath out " + "through " + "your nose.", "All", Stage.BREATHING);

    public static final YogaPose CATCOW = new YogaPose("Cat-Cow", "Start on your hands and knees, "
            + "as you inhale, lift your sit bones and chest towards the sky, allowing your belly to sink, exhale back"
            + "to a neutral spine.", "All", Stage.WARMUP);

    public static final YogaPose BOAT = new YogaPose("Boat", "Sit on the floor with your knees "
            + "bent, lift your feet off the floor, lean back and slowly straighten your legs if possible",
            "Beginner/ Intermediate", Stage.WARMUP);

    public static final YogaPose DOWNWARD_DOG = new YogaPose("Downward Dog", "Start on your hands"
            + "and knees, exhale lift your knees off the ground and your sit bones towards the ceiling",
            "All", Stage.MAIN);

    public static final YogaPose PLANK = new YogaPose("Plank", "Start in downward dog, inhale and "
            + "draw your torsoe forward until your shoulders are above your wrists", "All", Stage.MAIN);

    public static final YogaPose CHAIR = new YogaPose("Chair", "Start in a standing position, raise "
            + "your arms, bend your knees, try to get your thighs parallel to the floor and take your tailbone"
            + "down to the ground", "Intermediate", Stage.MAIN);

    public static final YogaPose BRIDGE = new YogaPose("Bridge", "Lay on your back, bend your knees"
            + "and bring your feet as close to your sit-bones as possible, lift your hips of the floor until the "
            + "thighs are parallel to the floor", "Intermediate", Stage.WARMDOWN);

    public static final YogaPose CHILD = new YogaPose("Child's pose", "Sit on your knees spread your"
            + "knees hip distance apart and fold forward", "All", Stage.WARMDOWN);

    public static final YogaPose CORPSE = new YogaPose("Shavasana", "Lay on your back, close your eyes"
            + "relax your muscles and breath normally. Stay here for as long as needed", "All",
            Stage.WARMDOWN);

    public static final YogaPose WARRIOR1 = new YogaPose("Warrior 1", "Start in a standing position,"
            + "step your feet around 4 feet apart, turn your right foot 90 degrees and your left 45 degrees, "
            + "rotate your" + "torsoe to the right and bend your right knee. "
            + "Repeat on the other side.", "Intermediate", Stage.MAIN);

    public static final Pilates POSE_1 = new Pilates("Pose1", "description", "Advanced",
            Stage.BREATHING);

    public static final Pilates POSE_2 = new Pilates("Pose2", "description", "Advanced",
            Stage.WARMUP);

    public static final Pilates POSE_3 = new Pilates("Pose3", "description", "Advanced",
            Stage.MAIN);
    public static final Pilates POSE_4 = new Pilates("Pose4", "description", "Advanced",
            Stage.WARMDOWN);


    private static final String QUIT = "quit";
    private static final String BREATH_CMD = "breathe";
    private static final String WARM_UP_CMD = "warm";
    private static final String MAIN_CMD = "main";
    private static final String WARM_DOWN_CMD = "cool";
    private static final  String RETURN_CMD = "r";
    private static final String ADD_POSE = "a";
    private static final String BACK = "b";
    private static final String REVIEW = "v";
    private static final String REMOVE = "d";
    private static final String YOGA = "yoga";
    private static final String PILATES = "pilates";




    public List<Exercise> breathingexercisesYoga;
    public List<Exercise> warUpPosesYoga;
    public List<Exercise> mainPosesYoga;
    public List<Exercise> warmDownPosesYoga;
    public List<Exercise> breathingExercisePilates;
    public List<Exercise> warmUpPosesPilates;
    public List<Exercise> mainPosesPilates;
    public List<Exercise> warmDownPosesPilates;
    private Scanner input;
    private boolean running;
    public ExerciseSequence myExerciseSequence;

    //EFFECTS: Runs the yoga app
    public YogaApp() {
        input = new Scanner(System.in);
        running = true;
        buildExerciseListsYoga();
        buildExerciseListsPilates();
    }


    //EFFECTS: Populates lists of stages of workouts with pre-defined exercises

    public void buildExerciseListsYoga() {
        breathingexercisesYoga = new ArrayList<>();
        breathingexercisesYoga.add(ALTERNATE);
        breathingexercisesYoga.add(KAPALABHATI);
        breathingexercisesYoga.add(COOLING);
        warUpPosesYoga = new ArrayList<>();
        warUpPosesYoga.add(CATCOW);
        warUpPosesYoga.add(BOAT);
        mainPosesYoga = new ArrayList<>();
        mainPosesYoga.add(PLANK);
        mainPosesYoga.add(DOWNWARD_DOG);
        mainPosesYoga.add(CHAIR);
        mainPosesYoga.add(WARRIOR1);
        warmDownPosesYoga = new ArrayList<>();
        warmDownPosesYoga.add(BRIDGE);
        warmDownPosesYoga.add(CHILD);
        warmDownPosesYoga.add(CORPSE);
        warmDownPosesYoga.add(WARRIOR1);

    }

    public void buildExerciseListsPilates() {
        breathingExercisePilates = new ArrayList<>();
        breathingExercisePilates.add(POSE_1);
        warmUpPosesPilates = new ArrayList<>();
        warmUpPosesPilates.add(POSE_2);
        mainPosesPilates = new ArrayList<>();
        mainPosesPilates.add(POSE_3);

        warmDownPosesPilates = new ArrayList<>();
        warmDownPosesPilates.add(POSE_4);
    }

    public void manageUserInput() {
        printMainMenu();
        String cmd;

        while (running) {
            cmd = getUserInput();
            handleInitalInput(cmd);
        }
    }

    private String getUserInput() {
        String cmd = " ";
        if (input.hasNext()) {
            cmd = input.nextLine();
            cmd.toLowerCase();
        }
        return cmd;
    }

    public void printMainMenu() {
        System.out.println("To build a yoga sequence enter yoga, to build a pilates sequence enter pilates");
    }

    public void handleInitalInput(String cmd) {
        switch (cmd) {
            case YOGA:
                myExerciseSequence = new YogaSequence();
                printStageMenu();
                String yogaInput = getUserInput();
                parseYogaInput(yogaInput);
                break;
            case PILATES:
                myExerciseSequence = new PilatesSequence();
                printStageMenu();
                String pilatesInput = getUserInput();
                parsePilatesInput(pilatesInput);
        }
    }




    private void printStageMenu() {
        System.out.println("Enter " + BREATH_CMD + " to browse breathing exercises");
        System.out.println("Enter " + WARM_UP_CMD + " to browse warm-up poses");
        System.out.println("Enter " + MAIN_CMD + " to browse poses that will form your main workout");
        System.out.println("Enter " + WARM_DOWN_CMD + " to browse cool down exercises");
        System.out.println("To quit at any time enter quit");
    }

    private void parseYogaInput(String cmd) {
        if (cmd.length() > 0) {
            switch (cmd) {
                case BREATH_CMD:
                    printListOfPoses(breathingexercisesYoga);
                    break;
                case WARM_UP_CMD:
                    printListOfPoses(warUpPosesYoga);
                    break;
                case MAIN_CMD:
                    printListOfPoses(mainPosesYoga);
                    break;
                case WARM_DOWN_CMD:
                    printListOfPoses(warmDownPosesYoga);
                    break;
                case QUIT:
                    running = false;
                    quitProgram();
                    break;
                default:
                    System.out.println("Invalid input, please try again");
            }
        }
    }

    private void parsePilatesInput(String cmd) {
        if (cmd.length() > 0) {
            switch (cmd) {
                case BREATH_CMD:
                    printListOfPoses(breathingExercisePilates);
                    break;
                case WARM_UP_CMD:
                    printListOfPoses(warmUpPosesPilates);
                    break;
                case MAIN_CMD:
                    printListOfPoses(mainPosesPilates);
                    break;
                case WARM_DOWN_CMD:
                    printListOfPoses(warmDownPosesPilates);
                    break;
                case QUIT:
                    running = false;
                    quitProgram();
                    break;
                default:
                    System.out.println("Invalid input, please try again");
            }
        }
    }

    private void printListOfPoses(List<Exercise> poses) {
        System.out.println("To view the pose description, please enter its associated number");
        for (Exercise nextPose: poses) {
            System.out.println((poses.indexOf(nextPose) + 1) + ". " + nextPose.getName());
        }

        optionToAddPose(getPoseDescription(poses), poses);
    }

    public Integer getPoseDescription(List<Exercise> poses) {
        String cmd = getUserInput();
        if (cmd == RETURN_CMD) {
            printStageMenu();
        } else {
            int i = Integer.parseInt(cmd) - 1;

            System.out.println(poses.get(i).getDescription());
            return i;
        }
        return -1;
    }

    public void optionToAddPose(int i, List<Exercise> poseList) {
        System.out.println("To add this pose to your sequence press a");
        System.out.println("To go back to browse sequences press b");
        String cmd = getUserInput();

        if (cmd.equals(ADD_POSE)) {
            Exercise pose = poseList.get(i);
            setPoseTime(pose);
            myExerciseSequence.addPose(pose);
            System.out.println("Your current sequence: " + myExerciseSequence.listAllPoses());
            System.out.println("The total time in your sequence is: "
                    + myExerciseSequence.totalTimeInSeq() + " minutes.");
        } else if (cmd.equals(BACK)) {
            printListOfPoses(poseList);
        }
        secondaryMenu(poseList);
    }

    public int setPoseTime(Exercise pose) {
        System.out.println("Enter the number of minutes you wish to practice this pose for: ");
        String cmd = getUserInput();
        Integer minutes = Integer.parseInt(cmd);
        pose.setTime(minutes);
        return minutes;
    }

    public void secondaryMenu(List<Exercise> poseList) {
        System.out.println("To return to browse more poses enter b");
        System.out.println("To return to the main menu enter r");
        System.out.println("To view your sequence enter v");

        String cmd = getUserInput();
        switch (cmd) {
            case BACK:
                printListOfPoses(poseList);
                break;
            case RETURN_CMD:
                printStageMenu();
                break;
            case REVIEW:
                reviewSequence();
                break;
        }
    }

    public void reviewSequence() {
        System.out.println("Your current sequence:" + myExerciseSequence.listAllPoses());
        System.out.println("To remove a pose from your sequence press d");
        String cmd = getUserInput();
        if (cmd.equals(REMOVE)) {
            removePose();
        }
    }

    public void removePose() {
        System.out.println("Enter the name of the pose you wish to remove: ");
        String pose = getUserInput();
        if (myExerciseSequence.sequenceContainsPose(pose)) {
            myExerciseSequence.removePose(pose);
        }
        System.out.println("Your current sequence:" + myExerciseSequence.listAllPoses());
    }



    private void quitProgram() {
        System.out.println("Goodbye! Hope you enjoyed your practice today.");
    }

//
//

//

//
//
}