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


    public List<YogaPose> breathingExercises;
    public List<YogaPose> warUpPoses;
    public List<YogaPose> mainPoses;
    public List<YogaPose> warmDownPoses;
    private Scanner input;
    public YogaSequence myYogaSequence;

    //EFFECTS: Runs the yoga app
    public YogaApp() {
        runApp();
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

    public void runApp() {
        boolean running = true;
        input = new Scanner(System.in);
        String command = null;

        initializeStages();

        displayMenu();

        while (running) {

            command = input.next();
            command = command.toLowerCase();

            if (command == "q") {
                running = false;
            } else {
                followCommand(command);
            }
        }
        System.out.println("Hope you enjoyed your practice today!");
    }


    public void displayMenu() {
        System.out.println("\nWelcome to Yoga Flow! Let's start building your very own sequence. "
                + "\n Please select" + "one of the following options");
        System.out.println("\t b to browse breathing exercises");
        System.out.println("\t w to browse warm-up poses");
        System.out.println("\t m to browse poses for your main practice");
        System.out.println("\t f to browse warm-down poses to finish off your practice");
        System.out.println("\t q to quit the application");
    }

    public void followCommand(String command) {
        if (command.equals("b")) {
            displayExercises(breathingExercises);
        } else if (command.equals("w")) {
            displayExercises(warUpPoses);
        } else if (command.equals("m")) {
            displayExercises(mainPoses);
        } else if (command.equals("f")) {
            displayExercises(warmDownPoses);
        } else {
            System.out.println("Selection invalid");
        }
    }


    public void displayExercises(List<YogaPose> poses) {
        for (YogaPose pos : poses) {
            System.out.println((poses.indexOf(pos) + 1) + "." + pos.getName());
        }
        handleExercises(poses);
    }


    private void handleExercises(List<YogaPose> poses) {
        System.out.println("To see the description for a listed pose, please enter the number of the associated pose");
        System.out.println("Press 0 to return to the main menu");

        Scanner selection = new Scanner(System.in);
        int number = selection.nextInt();
        Scanner choose = new Scanner(System.in);
        String select = choose.next();


        for (YogaPose pos : poses) {
            if (number == (poses.indexOf(pos) + 1)) {
                System.out.println(pos.getDescription());
                System.out.println("Level of difficulty: " + pos.getLevel());
            }
        }
        if (number == 0) {
            displayMenu();
        }
    }
}