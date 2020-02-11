package ui;
//Used TellerApp as a template for UI design

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YogaLatesApp {
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

    public static final YogaPose LION = new YogaPose("Lion", "Sit cross legged, with your hands "
            + "resting on your knees, take a deep breath in to your nose, open your mouth and stretch your tongue"
            + "towards your chin, exhale through your mouth.", "All", Stage.BREATHING);

    public static final YogaPose CATCOW = new YogaPose("Cat-Cow", "Start on your hands and knees, "
            + "as you inhale, lift your sit bones and chest towards the sky, allowing your belly to sink, exhale back"
            + "to a neutral spine.", "All", Stage.WARMUP);

    public static final YogaPose BOAT = new YogaPose("Boat", "Sit on the floor with your knees "
            + "bent, lift your feet off the floor, lean back and slowly straighten your legs if possible",
            "Beginner/ Intermediate", Stage.WARMUP);

    public static final YogaPose SEATEDFORWARDBEND = new YogaPose("Seated forward bend", "Sit tall"
            + "with your legs streched out in front of you, lean forward with your hips making sure to nor round your"
            + "spine. If possible grab your feet or rest your hands on your shin.", "All", Stage.WARMUP);

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

    public static final YogaPose FISHTWIST = new YogaPose("Half Lord of the Fish Twist", "Start in a "
            + "seated position with your legs streched in front of you. Bend your knees, bring your left foot under"
            + "your right hip. Step the right foot over the left leg so that your knee points up. Twist towards the "
            + "left and set your left upper arm on the outside of the right knee. Repeat on"
            + "the other side.", "All", Stage.WARMUP);

    public static final YogaPose PUPPY = new YogaPose("Puppy", "Start on your hands and knees, walk"
            + "your hands a few inches higher, curl your toes then lift your knees of the ground, drop your forehead "
            + "towards the ground", "All", Stage.WARMUP);

    public static final YogaPose BUTTERFLY = new YogaPose("Butterfly", "Sit with your legs extended"
            + "out infront of you, bring your heels as close to your pelvis as possible. Use your thumb and first 2"
            + "fingers to hold your big toes", "Intermediate", Stage.WARMUP);

    public static final YogaPose EAGLE = new YogaPose("Eagle", "Start in standing, bend your knees "
            + "slightly, lift up your left foot and cross your left thigh over the right. Hook your left foot on "
            + "the right calf. Spread your arms straight in front of you, sweep your right arm abve the left, bend"
            + "your elbows and left your elbows stretching your fingers to the ceiling.", "Intermdiate",
            Stage.MAIN);

    public static final YogaPose GATE = new YogaPose("Gate", "Kneel on the floor, extend your right"
            + "leg to the right side of the room, bring your arms up towards the ceiling, as you exhale bend toward "
            + "the right, rest your right hand on your right leg, bring your left arm up to the ceiling.", "All",
            Stage.MAIN);

    public static final YogaPose LOW_LUNGE = new YogaPose("Low lunge", "From Downward Dog, step"
            + "your right foot betwwen your hands, rest your left knee on the floor. "
            + "Raise your arms towards the ceiling. Repeat on the other side.", "All", Stage.MAIN);

    public static final YogaPose HIGH_LUNGE = new YogaPose("High lunge", "From Downward Dog, step"
            + "your right foot betwwen your hands, rest your left knee on the floor. "
            + "Raise your arms towards the ceiling, now raise your left knee of the ground. "
            + "Repeat on the other side", "All", Stage.MAIN);

    public static final YogaPose TRIANGLE = new YogaPose("Triagnle", "Start in standing, step your"
            + "feet about 4 feet apart. Turn your right foot 90 degrees to face the front and turn your left foot"
            + "slightly to the right. Raise your arms to the side, bend your torsoe towards the right side.  Rest"
            + "your right arm on your right foot, shin or thigh and lift your left arm up to the ceiling. "
            + "Repeat on the other side", "Intermediate", Stage.MAIN);

    public static final YogaPose GARLAND = new YogaPose("Garland", "Squat with your feet as close "
            + "together as possible, spread your knees wider than your torsoe, press your elbows towards the knee "
            + "and bring your palms together.", "Intermediate", Stage.MAIN);




    public static final PilatesPose POSE_1 = new PilatesPose("Pose1", "description", "Advanced",
            Stage.BREATHING);

    public static final PilatesPose POSE_2 = new PilatesPose("Pose2", "description", "Advanced",
            Stage.WARMUP);

    public static final PilatesPose POSE_3 = new PilatesPose("Pose3", "description", "Advanced",
            Stage.MAIN);
    public static final PilatesPose POSE_4 = new PilatesPose("Pose4", "description", "Advanced",
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
    public List<Exercise> warmUpPosesYoga;
    public List<Exercise> mainPosesYoga;
    public List<Exercise> warmDownPosesYoga;
    public List<Exercise> breathingExercisePilates;
    public List<Exercise> warmUpPosesPilates;
    public List<Exercise> mainPosesPilates;
    public List<Exercise> warmDownPosesPilates;
    private Scanner input;
    private boolean running;
    public ExerciseSequence myExerciseSequence;

    //EFFECTS: Creates a new Yoga App
    public YogaLatesApp() {
        input = new Scanner(System.in);
        running = true;



    }

    public void runYogaApp() {
        buildBreathingOptionsYoga();
        buildWarmUpOptionsYoga();
        buildMainOptionsYoga();
        buildWarmDownOptionsYoga();
        buildExerciseListsPilates();
        printWelcomeMenu();
        String cmd1 = getUserInput();
        initializeSequence(cmd1);
        printStageMenu(cmd1);
        String cmd2 = getUserInput();
        displayExercises(handleStageSelection(cmd1, cmd2), cmd1);
        String cmd5 = getUserInput();
        displayExercises(handleStageSelection(cmd1, cmd5), cmd1);
        String cmd6 = getUserInput();
        displayExercises(handleStageSelection(cmd1, cmd6), cmd1);

    }

    public void initializeSequence(String cmd1) {
        if (cmd1.equals(YOGA)) {
            myExerciseSequence = new YogaSequence();
        } else if (cmd1.equals(PILATES)) {
            myExerciseSequence = new PilatesSequence();
        }
    }



    private void handlePoseSelection(List<Exercise> exercises, String option, String cmd1) {
        if (option.equals(RETURN_CMD)) {
            returnToMain(option, cmd1);
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

    public void returnToMain(String option, String cmd1) {
        if (option.equals(RETURN_CMD)) {
            printStageMenu(cmd1);
        }
    }

    private void handlePoseOptions(String cmd4,Integer poseNumber, List<Exercise> exercises, String cmd1) {
        if (cmd4.equals(ADD_POSE)) {
            Exercise pose = exercises.get(poseNumber);
            myExerciseSequence.addPose(pose);
            setPoseTime(pose);
            System.out.println("Your current sequence:" + myExerciseSequence.listAllPoses());
            System.out.println("Total time of your sequence: " + myExerciseSequence.totalTimeInSeq() + " minutes.");
            System.out.println("Press 'b' to browse more poses");
            System.out.println("To delete a pose press  'd'");
            String cmd5 = getUserInput();
            handlePoseListOptions(cmd5, exercises, cmd1);
        } else if (cmd4.equals(BACK)) {
            displayExercises(exercises, cmd1);
        }
    }

    private void handlePoseListOptions(String cmd5, List<Exercise> exercises, String cmd1) {
        if (cmd5.equals(BACK)) {
            displayExercises(exercises, cmd1);
        } else if (cmd5.equals(REMOVE)) {
            removePoseFromList(cmd1);
        }
    }

    private void removePoseFromList(String cmd1) {
        System.out.println("Please enter the name of the pose you wish to delete: ");
        String poseToRemove = getUserInput();
        myExerciseSequence.removePose(poseToRemove);
        System.out.println("Your updated sequence: " + myExerciseSequence.listAllPoses());
        System.out.println("To return to the main menu press 'r'");
        String option = getUserInput();
        returnToMain(option, cmd1);
    }

    public void setPoseTime(Exercise pose) {
        System.out.println("Enter the number of minutes you want to practice this pose for: ");
        String cmd5 = getUserInput();
        Integer poseTime = Integer.parseInt(cmd5);
        pose.setTime(poseTime);
    }

    private List<Exercise> handleStageSelection(String cmd1, String cmd2) {
        List<Exercise> exercises = new ArrayList<>();
        if (cmd1.equals(YOGA)) {
            switch (cmd2) {
                case BREATH_CMD: exercises = breathingexercisesYoga;
                    break;
                case WARM_UP_CMD: exercises = warmUpPosesYoga;
                    break;
                case MAIN_CMD: exercises = mainPosesYoga;
                    break;
                case WARM_DOWN_CMD: exercises = warmDownPosesYoga;
                    break;
            } } else if (cmd1.equals(PILATES)) {
            switch (cmd2) {
                case WARM_UP_CMD: exercises = warmUpPosesPilates;
                    break;
                case MAIN_CMD: exercises = mainPosesPilates;
                    break;
                case WARM_DOWN_CMD: exercises = warmDownPosesPilates;
                    break; }
        }
        return exercises;
    }

    private void displayExercises(List<Exercise> exercises, String cmd1) {
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
    private void printStageMenu(String input) {
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
    }

    //EFFECTS: Dsiplays menu of exercise options
    private void printWelcomeMenu() {
        System.out.println("To build a yoga routine, enter 'yoga', to build a pilates routine enter 'pilates'.");
    }


    //EFFECTS: Populates lists of stages of workouts with pre-defined exercises
    public void buildBreathingOptionsYoga() {
        breathingexercisesYoga = new ArrayList<>();
        breathingexercisesYoga.add(ALTERNATE);
        breathingexercisesYoga.add(KAPALABHATI);
        breathingexercisesYoga.add(COOLING);
        breathingexercisesYoga.add(LION);
    }

    public void buildWarmUpOptionsYoga() {
        warmUpPosesYoga = new ArrayList<>();
        warmUpPosesYoga.add(CATCOW);
        warmUpPosesYoga.add(BOAT);
        warmUpPosesYoga.add(SEATEDFORWARDBEND);
        warmUpPosesYoga.add(FISHTWIST);
        warmUpPosesYoga.add(PUPPY);
        warmUpPosesYoga.add(BUTTERFLY);
    }

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

    public void  buildWarmDownOptionsYoga() {
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



    private String getUserInput() {
        String cmd = " ";
        if (input.hasNext()) {
            cmd = input.nextLine();
            cmd.toLowerCase();
        }
        return cmd;
    }


    private void quitProgram() {
        System.out.println("Goodbye! Hope you enjoyed your practice today.");
    }

}