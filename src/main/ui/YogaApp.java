package ui;
//Used TellerApp as a template for UI design

import model.YogaPose;
import model.YogaSequence;
import model.YogaStage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YogaApp {
    public static final YogaPose ALTERNATE = new YogaPose("Alternate Nostril Breathing", "Sit comfortably"
            + "cover your left nostril with your right ring finger, breathe in through your right nostril, cover "
            + "your right nostril with your thumb, now uncover your left nostril and breathe out", "All",
            YogaStage.BREATHING);

    public static final YogaPose KAPALABHATI = new YogaPose("Kapalabhati", "Inhale deeply through"
            + "your nose, as you exhale, press your belly towards your spine to force the breath out", "All",
            YogaStage.MAIN);

    public static final YogaPose COOLING = new YogaPose("Sitali", "Also known as cooling breath. "
            + "Make an O-shape with your mouth and inhale through your mouth as if drinking through a straw,"
            + " breath out " + "through " + "your nose.", "All", YogaStage.BREATHING);

    public static final YogaPose CATCOW = new YogaPose("Cat-Cow", "Start on your hands and knees, "
            + "as you inhale, lift your sit bones and chest towards the sky, allowing your belly to sink, exhale back"
            + "to a neutral spine.", "All", YogaStage.WARMUP);

    public static final YogaPose BOAT = new YogaPose("Boat", "Sit on the floor with your knees "
            + "bent, lift your feet off the floor, lean back and slowly straighten your legs if possible",
            "Beginner/ Intermediate", YogaStage.WARMUP);

    public static final YogaPose DOWNWARD_DOG = new YogaPose("Downward Dog", "Start on your hands"
            + "and knees, exhale lift your knees off the ground and your sit bones towards the ceiling",
            "All", YogaStage.MAIN);

    public static final YogaPose PLANK = new YogaPose("Plank", "Start in downward dog, inhale and "
            + "draw your torsoe forward until your shoulders are above your wrists", "All", YogaStage.MAIN);

    public static final YogaPose CHAIR = new YogaPose("Chair", "Start in a standing position, raise "
            + "your arms, bend your knees, try to get your thighs parallel to the floor and take your tailbone"
            + "down to the ground", "Intermediate", YogaStage.MAIN);

    public static final YogaPose BRIDGE = new YogaPose("Bridge", "Lay on your back, bend your knees"
            + "and bring your feet as close to your sit-bones as possible, lift your hips of the floor until the "
            + "thighs are parallel to the floor", "Intermediate", YogaStage.WARMDOWN);

    public static final YogaPose CHILD = new YogaPose("Child's pose", "Sit on your knees spread your"
            + "knees hip distance apart and fold forward", "All", YogaStage.WARMDOWN);

    public static final YogaPose CORPSE = new YogaPose("Shavasana", "Lay on your back, close your eyes"
            + "relax your muscles and breath normally. Stay here for as long as needed", "All",
            YogaStage.WARMDOWN);

    public static final YogaPose WARRIOR1 = new YogaPose("Warrior 1", "Start in a standing position,"
            + "step your feet around 4 feet apart, turn your right foot 90 degrees and your left 45 degrees, "
            + "rotate your" + "torsoe to the right and bend your right knee. "
            + "Repeat on the other side.", "Intermediate", YogaStage.MAIN);
    private static final String QUIT = "quit";
    private static final String BREATH_CMD = "breathe";
    private static final String WARM_UP_CMD = "warm";
    private static final String MAIN_CMD = "main";
    private static final String WARM_DOWN_CMD = "cool";
    private static final  String RETURN_CMD = "r";
    private static final String ADD_POSE = "a";
    private static final String BACK = "b";




    public List<YogaPose> breathingExercises;
    public List<YogaPose> warUpPoses;
    public List<YogaPose> mainPoses;
    public List<YogaPose> warmDownPoses;
    private Scanner input;
    private boolean running;
    public YogaSequence myYogaSequence;

    //EFFECTS: Runs the yoga app
    public YogaApp() {
        input = new Scanner(System.in);
        running = true;
        initializeStages();
        myYogaSequence = new YogaSequence();
    }


    //EFFECTS: Populates lists of stages of workouts with pre-defined exercises
    public void initializeStages() {
        breathingExercises = new ArrayList<>();
        breathingExercises.add(ALTERNATE);
        breathingExercises.add(KAPALABHATI);
        breathingExercises.add(COOLING);

        warUpPoses = new ArrayList<>();
        warUpPoses.add(CATCOW);
        warUpPoses.add(BOAT);

        mainPoses = new ArrayList<>();
        mainPoses.add(PLANK);
        mainPoses.add(DOWNWARD_DOG);
        mainPoses.add(CHAIR);
        mainPoses.add(WARRIOR1);

        warmDownPoses = new ArrayList<>();
        warmDownPoses.add(BRIDGE);
        warmDownPoses.add(CHILD);
        warmDownPoses.add(CORPSE);
        warmDownPoses.add(WARRIOR1);
    }

    public void manageUserInput() {
        printMenu();
        String cmd;

        while (running) {
            cmd = getUserInput();
            parseInput(cmd);
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


    private void printMenu() {
        System.out.println("Enter " + BREATH_CMD + " to browse breathing exercises");
        System.out.println("Enter " + WARM_UP_CMD + " to browse warm-up poses");
        System.out.println("Enter " + MAIN_CMD + " to browse poses that will form your main workout");
        System.out.println("Enter " + WARM_DOWN_CMD + " to browse cool down exercises");
        System.out.println("To quit at any time enter quit");
    }

    private void parseInput(String cmd) {
        if (cmd.length() > 0) {
            switch (cmd) {
                case BREATH_CMD:
                    printListOfPoses(breathingExercises);
                    break;
                case WARM_UP_CMD:
                    printListOfPoses(warUpPoses);
                    break;
                case MAIN_CMD:
                    printListOfPoses(mainPoses);
                    break;
                case WARM_DOWN_CMD:
                    printListOfPoses(warmDownPoses);
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

    private void printListOfPoses(List<YogaPose> poses) {
        System.out.println("To view the pose description, please enter its associated number");
        for (YogaPose nextPose: poses) {
            System.out.println((poses.indexOf(nextPose) + 1) + ". " + nextPose.getName());
        }

        optionToAddPose(getPoseDescription(poses), poses);
    }

    public Integer getPoseDescription(List<YogaPose> poses) {
        String cmd = getUserInput();
        if (cmd == RETURN_CMD) {
            printMenu();
        } else {
            int i = Integer.parseInt(cmd) - 1;

            System.out.println(poses.get(i).getDescription());
            return i;
        }
        return -1;

    }

    public void optionToAddPose(int i, List<YogaPose> poseList) {
        System.out.println("To add this pose to your sequence press a");
        System.out.println("To go back to browse sequences press b");
        String cmd = getUserInput();

        if (cmd.equals(ADD_POSE)) {
            YogaPose pose = poseList.get(i);
            setPoseTime(pose);
            myYogaSequence.addPose(pose);
            System.out.println("Your current sequence: " + myYogaSequence.listAllPoses());
            System.out.println("The total time in your sequence is: " + myYogaSequence.totalTimeInSeq());
        } else if (cmd.equals(BACK)) {
            printListOfPoses(poseList);
        }
        startAgain(poseList);

    }

    public int setPoseTime(YogaPose pose) {
        System.out.println("Enter the number of minutes you wish to practice this pose for: ");
        String cmd = getUserInput();
        Integer minutes = Integer.parseInt(cmd);
        pose.setTime(minutes);
        return minutes;
    }

    public void startAgain(List<YogaPose> poseList) {
        System.out.println("To return to browse more poses enter b");
        System.out.println("To return to the main menu enter r");
        String cmd = getUserInput();
        if (cmd.equals(BACK)) {
            printListOfPoses(poseList);
        } else if (cmd.equals(RETURN_CMD)) {
            printMenu();
        }
    }



//
    private void quitProgram() {
        System.out.println("Goodbye! Hope you enjoyed your practice today.");
    }

//
//

//

//
//
}