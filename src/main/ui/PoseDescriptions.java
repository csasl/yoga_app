//Pilates poses and descriptions from: https://www.verywellfit.com/the-first-10-pilates-mat-exercises-and-more-2704611
//Yoga poses and descriptions from: https://www.yogajournal.com/
//PoseDescriptions class contains all the poses the user can select from to add to their sequence


package ui;

import model.Stage;
import model.YogaPose;

import model.Stage;
//PoseDescriptions class contains the information for all poses  available for the user to browse

public class PoseDescriptions {
//Yoga Poses:
    public static final YogaPose ALTERNATE = new YogaPose("Alternate Nostril Breathing",
            "\n 1.Sit comfortably in a cross legged position"
                    + "\n 2. Cover your left nostril with your right ring finger and breathe in "
                    + "through your right nostril"
                    + "\n 3.Cover your right nostril with your thumb, "
                    + "\n 4.now uncover your left nostril and breathe out", "All",
            Stage.BREATHING);

    public static final YogaPose KAPALABHATI = new YogaPose("Kapalabhati", "\n 1.Inhale deeply through"
            + "your nose \n 2. As you exhale, press your belly towards your spine to force the breath out", "All",
            Stage.MAIN);

    public static final YogaPose COOLING = new YogaPose("Sitali",
            "\n 1.Make an O-shape with your mouth and inhale through your mouth as if drinking through a straw,"
            + " \n 2.breath out through your nose.", "All", Stage.BREATHING);

    protected static final YogaPose LION = new YogaPose("Lion", "\n 1.Sit cross legged, with your hands "
            + "resting on your knees \n 2.Take a deep breath in to your nose, open your mouth and stretch your tongue"
            + "towards your chin \n 3. Exhale through your mouth.", "All", Stage.BREATHING);



    protected static final YogaPose CATCOW = new YogaPose("Cat-Cow", " \n 1.Start on your hands and knees, "
            + "\n 2. As you inhale, lift your sit bones and chest towards the sky "
            + "\n 3. Allow your belly to sink  exhale backto a neutral spine.",
            "All", Stage.WARMUP);

    protected static final YogaPose BOAT = new YogaPose("Boat", " \n 1.Sit on the floor with your knees "
            + "bent \n 2. Lift your feet off the floor, lean back and slowly straighten your legs if possible",
            "Beginner/ Intermediate", Stage.WARMUP);

    protected static final YogaPose SEATEDFORWARDBEND = new YogaPose("Seated forward bend",
            "\n 1.Sit tall with your legs streched out in front of you "
                    + "\n 2. Lean forward with your hips making sure to nor round your spine. "
                    + "\n 3.If possible grab your feet or rest your hands on your shin.", "All", Stage.WARMUP);

    protected static final YogaPose DOWNWARD_DOG = new YogaPose("Downward Dog",
            "\n 1.Start on your hands and knees, "
                    + "\n 2.Exhale lift your knees off the ground and your sit bones towards the ceiling",
            "All", Stage.MAIN);

    protected static final YogaPose PLANK = new YogaPose("Plank", "\n 1.Start in downward dog"
            + "\n 2.Inhale and draw your torsoe forward until your shoulders are above your wrists",
            "All", Stage.MAIN);

    protected static final YogaPose CHAIR = new YogaPose("Chair", "\n 1.Start in a standing position"
            + " \n 2.Raise your arms, bend your knees, try to get your thighs parallel to the floor and take your "
            + "tailbone" + "down to the ground", "Intermediate", Stage.MAIN);

    protected static final YogaPose BRIDGE = new YogaPose("Bridge", "\n 1.Lay on your back, "
            + "bend your knees" + "\n 2. Bring your feet as close to your sit-bones as possible"
            + "\n 3.Lift your hips of the floor until the " + "thighs are parallel to the floor",
            "Intermediate", Stage.WARMDOWN);

    protected static final YogaPose CHILD = new YogaPose("Child's pose",
            "\n 1.Sit on your knees spread your"
            + "knees hip distance apart and fold forward "
                    + "\n 2.Touch your forehead to the ground",
            "All", Stage.WARMDOWN);

    protected static final YogaPose CORPSE = new YogaPose("Shavasana",
            "Lay on your back, close your eyes"
            + "relax your muscles and breath normally. Stay here for as long as needed", "All",
            Stage.WARMDOWN);

    protected static final YogaPose WARRIOR1 = new YogaPose("Warrior 1",
            "Start in a standing position,"
            + "step your feet around 4 feet apart, turn your right foot 90 degrees and your left 45 degrees, "
            + "rotate your" + "torsoe to the right and bend your right knee. "
            + "Repeat on the other side.", "Intermediate", Stage.MAIN);

    protected static final YogaPose FISHTWIST = new YogaPose("Half Lord of the Fish Twist",
            "Start in a "
            + "seated position with your legs streched in front of you. Bend your knees, bring your left foot under"
            + "your right hip. Step the right foot over the left leg so that your knee points up. Twist towards the "
            + "left and set your left upper arm on the outside of the right knee. Repeat on"
            + "the other side.", "All", Stage.WARMUP);

    protected static final YogaPose PUPPY = new YogaPose("Puppy",
            "Start on your hands and knees, walk"
            + "your hands a few inches higher, curl your toes then lift your knees of the ground, drop your forehead "
            + "towards the ground", "All", Stage.WARMUP);

    protected static final YogaPose BUTTERFLY = new YogaPose("Butterfly",
            "Sit with your legs extended"
            + "out infront of you, bring your heels as close to your pelvis as possible. Use your thumb and first 2"
            + "fingers to hold your big toes", "Intermediate", Stage.WARMUP);

    protected static final YogaPose EAGLE = new YogaPose("Eagle", "Start in standing, bend "
            + "your knees "
            + "slightly, lift up your left foot and cross your left thigh over the right. Hook your left foot on "
            + "the right calf. Spread your arms straight in front of you, sweep your right arm abve the left, bend"
            + "your elbows and left your elbows stretching your fingers to the ceiling.", "Intermdiate",
            Stage.MAIN);

    protected static final YogaPose GATE = new YogaPose("Gate", "Kneel on the floor, "
            + "extend your right"
            + "leg to the right side of the room, bring your arms up towards the ceiling, as you exhale bend toward "
            + "the right, rest your right hand on your right leg, bring your left arm up to the ceiling.", "All",
            Stage.MAIN);

    protected static final YogaPose LOW_LUNGE = new YogaPose("Low lunge", "From Downward Dog, step"
            + "your right foot betwwen your hands, rest your left knee on the floor. "
            + "Raise your arms towards the ceiling. Repeat on the other side.", "All", Stage.MAIN);

    protected static final YogaPose HIGH_LUNGE = new YogaPose("High lunge", "From Downward Dog, step"
            + "your right foot betwwen your hands, rest your left knee on the floor. "
            + "Raise your arms towards the ceiling, now raise your left knee of the ground. "
            + "Repeat on the other side", "All", Stage.MAIN);

    protected static final YogaPose TRIANGLE = new YogaPose("Triagnle", "Start in standing, step your"
            + "feet about 4 feet apart. Turn your right foot 90 degrees to face the front and turn your left foot"
            + "slightly to the right. Raise your arms to the side, bend your torsoe towards the right side.  Rest"
            + "your right arm on your right foot, shin or thigh and lift your left arm up to the ceiling. "
            + "Repeat on the other side", "Intermediate", Stage.MAIN);

    protected static final YogaPose GARLAND = new YogaPose("Garland", "Squat with your feet as close "
            + "together as possible, spread your knees wider than your torsoe, press your elbows towards the knee "
            + "and bring your palms together.", "Intermediate", Stage.MAIN);

}



