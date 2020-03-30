//Pilates poses and descriptions from: https://www.verywellfit.com/the-first-10-pilates-mat-exercises-and-more-2704611
//Yoga poses and descriptions from: https://www.yogajournal.com/
//PoseDescriptions class contains all the poses the user can select from to add to their sequence


package ui;

import model.Stage;
import model.YogaPose;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents all the poses that the user can choose from to build their sequence
 */

public class PresetPoses {

    private static final YogaPose ALTERNATE = new YogaPose("Alternate Nostril Breathing",
            "\n 1.Sit comfortably in a cross legged position"
                    + "\n 2. Cover your left nostril with your right ring finger and breathe in "
                    + "through your right nostril"
                    + "\n 3.Cover your right nostril with your thumb, "
                    + "\n 4.now uncover your left nostril and breathe out", "All",
            Stage.BREATHING);

    private static final YogaPose KAPALABHATI = new YogaPose("Kapalabhati", "\n 1.Inhale deeply through"
            + "your nose \n 2. As you exhale, press your belly towards your spine "
            + "\nto force the breath out", "All",
            Stage.MAIN);

    private static final YogaPose COOLING = new YogaPose("Sitali",
            "\n 1.Make an O-shape with your mouth and inhale through your mouth "
                    + "\nas if drinking through a straw,"
            + " \n 2.breath out through your nose.", "All", Stage.BREATHING);

    private static final YogaPose LION = new YogaPose("Lion", "\n 1.Sit cross legged, with your hands "
            + "resting on your knees \n 2.Take a deep breath in to your nose, open your mouth and "
            + "\n stretch your tongue"
            + "towards your chin \n 3. Exhale through your mouth.", "All", Stage.BREATHING);



    private static final YogaPose CATCOW = new YogaPose("Cat-Cow", " \n 1.Start on your hands and knees, "
            + "\n 2. As you inhale, lift your sit bones and chest towards the sky "
            + "\n 3. Allow your belly to sink  exhale backto a neutral spine.",
            "All", Stage.WARMUP);

    private static final YogaPose BOAT = new YogaPose("Boat", " \n 1.Sit on the floor with your knees "
            + "bent \n 2. Lift your feet off the floor, lean back and slowly straighten your legs if possible",
            "Beginner/ Intermediate", Stage.WARMUP);

    private static final YogaPose SEATEDFORWARDBEND = new YogaPose("Seated forward bend",
            "\n 1.Sit tall with your legs streched out in front of you "
                    + "\n 2. Lean forward with your hips making sure to nor round your spine. "
                    + "\n 3.If possible grab your feet or rest your hands on your shin.", "All", Stage.WARMUP);

    private static final YogaPose DOWNWARD_DOG = new YogaPose("Downward Dog",
            "\n 1.Start on your hands and knees, "
                    + "\n 2.Exhale lift your knees off the ground and your sit bones towards the ceiling",
            "All", Stage.MAIN);

    private static final YogaPose PLANK = new YogaPose("Plank", "\n 1.Start in downward dog"
            + "\n 2.Inhale and draw your torsoe forward until your shoulders are above your wrists",
            "All", Stage.MAIN);

    private static final YogaPose CHAIR = new YogaPose("Chair", "\n 1.Start in a standing position"
            + " \n 2.Raise your arms, bend your knees, "
            + "\ntry to get your thighs parallel to the floor \n 3. Take your "
            + "tailbone" + "down to the ground", "Intermediate", Stage.MAIN);

    private static final YogaPose BRIDGE = new YogaPose("Bridge", "\n 1.Lay on your back, "
            + "bend your knees" + "\n 2. Bring your feet as close to your sit-bones as possible"
            + "\n 3.Lift your hips of the floor until the " + "thighs are parallel to the floor",
            "Intermediate", Stage.WARMDOWN);

    private static final YogaPose CHILD = new YogaPose("Child's pose",
            "\n 1.Sit on your knees spread your"
            + "knees hip distance apart and fold forward "
                    + "\n 2.Touch your forehead to the ground",
            "All", Stage.WARMDOWN);

    private static final YogaPose CORPSE = new YogaPose("Shavasana",
            "\n 1.Lay on your back, close your eyes"
            + "\n 2.Relax your muscles and breath normally \n 3.Stay here for as long as needed", "All",
            Stage.WARMDOWN);

    private static final YogaPose WARRIOR1 = new YogaPose("Warrior 1",
            "\n 1.Start in a standing position,"
            + "\n 2.Step your feet around 4 feet apart \n 3.Turn your right foot 90 degrees and your left 45 degrees, "
            + "\n 4.rotate your" + "torsoe to the right and bend your right knee. "
            + "\n 5.Repeat on the other side.", "Intermediate", Stage.MAIN);

    private static final YogaPose FISHTWIST = new YogaPose("Half Lord of the Fish Twist",
            "\n 1.Start in a "
            + "seated position with your legs streched in front of you \n 2.Bend your knees, bring your left foot under"
            + "your right hip \n 3.Step the right foot over the left leg so that your knee points up. "
                    + "\n 4.Twist towards the "
            + "left and set your left upper arm on the outside of the right knee \n 4.Repeat on"
            + "the other side.", "All", Stage.WARMUP);

    private static final YogaPose PUPPY = new YogaPose("Puppy",
            "\n 1.Start on your hands and knees \n 2.Walk"
            + "your hands a few inches higher \n 3.Curl your toes then lift your knees of the ground, "
                    + "\n 3.Drop your forehead "
            + "towards the ground", "All", Stage.WARMUP);

    private static final YogaPose BUTTERFLY = new YogaPose("Butterfly",
            "\n 1.Sit with your legs extended"
            + "out infront of you \n 2.Bring your heels as close to your pelvis as possible."
                    + "\n 3.Use your thumb and first 2"
            + "fingers to hold your big toes", "Intermediate", Stage.WARMUP);

    private static final YogaPose EAGLE = new YogaPose("Eagle", "\n 1.Start standing, bend "
            + "your knees "
            + "slightly \n 2.Lift up your left foot and cross your left thigh over the right. "
            + "\n 3.Hook your left foot on "
            + "the right calf \n 3.Spread your arms straight in front of you \n 4.Sweep your right arm above "
            + "the left \n 5.Bend" + "your elbows and left your elbows stretching your "
            + "\nfingers to the ceiling.",
            "Intermdiate",
            Stage.MAIN);

    private static final YogaPose GATE = new YogaPose("Gate", "\n 1.Kneel on the floor"
            + "\n 2.Extend your right" + "leg to the right side of the room"
            + "\n 3.Bring your arms up towards the ceiling, \n 4.As you exhale bend toward "
            + "the right \n 5.Rest your right hand on your right leg "
            + "\n 6.bring your left arm up to the ceiling.", "All", Stage.MAIN);

    private static final YogaPose LOW_LUNGE = new YogaPose("Low lunge", "\n 1.From Downward Dog, step"
            + "your right foot between your hands \n 2.Rest your left knee on the floor. "
            + "\n 3.Raise your arms towards the ceiling. \n 4.Repeat on the other side.", "All", Stage.MAIN);

    private static final YogaPose HIGH_LUNGE = new YogaPose("High lunge", "\n 1.From Downward Dog, step"
            + "your right foot betwwen your hands \n 2.Rest your left knee on the floor. "
            + "\n 3.Raise your arms towards the ceiling, now raise your left knee of the ground. "
            + "\n 4.Repeat on the other side", "All", Stage.MAIN);

    private static final YogaPose TRIANGLE = new YogaPose("Triangle", "\n 1.Start in standing "
            + "\n 2.Step your"
            + "feet about 4 feet apart. \n 3.Turn your right foot 90 degrees to face the front and turn your left foot"
            + "slightly to the right. \n 4.Raise your arms to the side, bend your torsoe towards the right side. "
            + "\n 5. Rest" + "your right arm on your right foot, shin or thigh and lift your left"
            + " arm up to the ceiling. " + "\n 6.Repeat on the other side", "Intermediate", Stage.MAIN);

    private static final YogaPose GARLAND = new YogaPose("Garland",
            " \n 1.Squat with your feet as close "
            + "together as possible \n 2.Spread your knees wider than your torsoe "
                    + "\n 3. press your elbows towards the knee "
            + "and bring your palms together.", "Intermediate", Stage.MAIN);


    private static final YogaPose CONQUEROR = new YogaPose("Conqueror", "1 .Inhale through your nose"
            + "\n 2. then exhale slowly through a wide-open mouth. "
            + "\n 3.Direct the out-going breath slowly across the back of your throat with a drawn-out HA sound. "
            + "\n 4.Repeat several times, then close your mouth. "
            + "\n 5. Now, as you both inhale and exhale through your nose, "
            + "\n direct the breath again slowly across the back of your throat.", "All", Stage.BREATHING);


    private static final YogaPose SOUND = new YogaPose("Yoga of Sound",
            "\n 1.Breathe normally for 30 seconds."
                    + "\n 2. Begin to channel your inhales through your inner nostrils. "
                    + "\n 3. Breathe normally again for 30 seconds"
                    + "\n 3. Then channel your exhales beneath your outer nostrils "
                    + "\n 4.Combine the inner and outer breath" + "for a few minutes", "All", Stage.BREATHING);


    private static final YogaPose LOCUST = new YogaPose("Locust", "1. Lie on your belly with your arms along "
            + "the sides of your torso," + " \npalms up, forehead resting on the floor."
            + "\n 2. Exhale and lift your head, upper torso, arms, and legs away from the floor "
            + "\n 3. Raise your arms parallel to the floor and stretch back actively through your fingertips"
            + "\n 4. Gaze forward or slightly upward, being careful not to jut "
            + "\nyour chin forward and crunch the back of your neck.", "Intermediate", Stage.WARMDOWN);

    private static final YogaPose BIGTOE = new YogaPose("Big Toe",
            "1. Stand upright with your inner feet parallel and about six inches apart "
                    + "\n 2.Keeping your legs straight, exhale and bend forward from your hip "
                    + "\n 3. Slide the index and middle fingers of each hand between the big toes and the second toes"
                    + "\n grip the big toes firmly \n 4. Inhale and lift your torsoe and straighten your elbows"
                    + "\n 5. Exhale back down and repeat a few times.", "All", Stage.WARMDOWN);

    private static final YogaPose STAFF = new YogaPose("Staff",
            "1. Sit on the floor with your legs together and extended in front of your torso."
                    + "\n 2. Flex your ankles, pressing out through your heels. \n 3. Rest your hands on the floor,"
                    + "fingers pointing towards your toes \n 4. Sit up tall, stay for a few minutes", "All",
            Stage.WARMDOWN);

    private static final YogaPose BABY = new YogaPose("Happy Baby",
            "1. Lie on your back. With an exhale, bend your knees into your belly "
                    + "\n 2 .Inhale, grip the outsides of your feet with your hands"
                    + "\n 3 .Open your knees slightly wider than your torso, then bring them up toward your armpits"
                    + "\n 4. Position each ankle directly over the knee, flex your feet,"
                    + "\n push your feet into your hands", "All", Stage.WARMDOWN);

    private static final YogaPose ANGLE = new YogaPose("Bound Angle",
            "1. Sit with your legs straight out in front of you"
                    + "\n 2. Bring your heels as close to your pelvis as you comfortably can. "
                    + "\n 3. With the first and second finger and thumb, grasp the big toe of each foot "
                    + "\n 4. Stay for a few minutes, then straighten your legs in front of you.", "All",
            Stage.WARMDOWN);

    private static final YogaPose DOLPHIN = new YogaPose("Dolphin", "1. Come onto the floor on your hands and knees. "
            + "\n Set your knees directly below your hips and your forearms on "
            + "the floor with your shoulders directly above your wrists "
            + "\n 2. Curl your toes under, then exhale and lift your knees away from the floor"
            + "\n 3. Press the forearms actively into the floor, straighten your knees if possible",
            "All", Stage.MAIN);

    private static final YogaPose DPLANK = new YogaPose("Dolphin Plank", "1. Start in Dolphin with your knees bent"
            + "\n 2. Then walk your feet back until your shoulders are directly over the elbows "
            + "\n and your torso is parallel to the floor \n 3. Press your inner forearms and elbows "
            + "firmly against the floor \n 4. Stay for 30s to 1 minute, then release your knees to the floor",
            "All", Stage.MAIN);

    private static final YogaPose UPPLANK = new YogaPose("Upward Plank", "1. Start in Staff pose"
            + "\n 2. Bend your knees and place your feet on the floor, big toes turned inward"
            + "\n 3. Exhale, press your inner feet and hands down against the floor, and lift your hips"
            + "\n 4. Straighten your legs one at a time. Lift your hips still higher "
            + "\n 5. Slowly drop your head back", "all", Stage.MAIN);

    private static final YogaPose WARRIORII = new YogaPose("Warrior 2", "1. Start standing tall"
            + "\n 2. With an exhalation, step or lightly jump your feet 3 1/2 to 4 feet apart. "
            + "\n 3. Raise your arms parallel to the floor and reach them actively out to the sides, "
            + "\n palms down" + "\n 4. Turn your right foot slightly to the right and your "
            + "\n left foot out to the left 90 degrees"
            + "\n 5.Exhale and bend your left knee over the left ankle, "
            + "\n so that the shin is perpendicular to the floor \n 6. Stretch arms out parallel to floor"
            + "\n 7. Repeat on other side", "All", Stage.MAIN);


    public PresetPoses() {




    }

    /**
     * Helper that populates the breathing exercises list with pre-defined exercises
     */
    public static List<YogaPose> buildBreathingOptionsYoga() {
        List<YogaPose> breathingPoses = new ArrayList<>();

        breathingPoses.add(PresetPoses.ALTERNATE);
        breathingPoses.add(KAPALABHATI);
        breathingPoses.add(PresetPoses.COOLING);
        breathingPoses.add(LION);
        breathingPoses.add(CONQUEROR);
        breathingPoses.add(SOUND);
        return breathingPoses;

    }

    /**
     * Helper that populates the warm-up exercises list with pre-defined exercises
     */
    public static List<YogaPose> buildWarmUpOptionsYoga() {
        List<YogaPose> warmUpPoses = new ArrayList<>();

        warmUpPoses.add(CATCOW);
        warmUpPoses.add(BOAT);
        warmUpPoses.add(SEATEDFORWARDBEND);
        warmUpPoses.add(FISHTWIST);
        warmUpPoses.add(PUPPY);
        warmUpPoses.add(BUTTERFLY);
        warmUpPoses.add(LOCUST);
        return warmUpPoses;
    }

    /**
     * Helper that populates the main exercises list with pre-defined exercises
     */
    public static List<YogaPose> buildMainOptionsYoga() {
        List<YogaPose> mainPoses = new ArrayList<>();

        mainPoses.add(PLANK);
        mainPoses.add(DOWNWARD_DOG);
        mainPoses.add(CHAIR);
        mainPoses.add(WARRIOR1);
        mainPoses.add(WARRIORII);
        mainPoses.add(EAGLE);
        mainPoses.add(GATE);
        mainPoses.add(LOW_LUNGE);
        mainPoses.add(HIGH_LUNGE);
        mainPoses.add(TRIANGLE);
        mainPoses.add(GARLAND);
        mainPoses.add(DOLPHIN);
        mainPoses.add(DPLANK);
        mainPoses.add(UPPLANK);
        return mainPoses;


    }

    /**
     * Helper that populates the warm-down exercises list with pre-defined exercises
     */

    public static List<YogaPose> buildWarmDownOptionsYoga() {
        List<YogaPose> warmDownPoses = new ArrayList<>();
        warmDownPoses.add(BRIDGE);
        warmDownPoses.add(CHILD);
        warmDownPoses.add(CORPSE);
        warmDownPoses.add(LOCUST);
        warmDownPoses.add(BIGTOE);
        warmDownPoses.add(STAFF);
        warmDownPoses.add(BABY);
        warmDownPoses.add(ANGLE);

        return warmDownPoses;

    }





}



