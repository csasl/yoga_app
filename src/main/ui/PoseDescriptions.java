//Pilates poses and descriptions from: https://www.verywellfit.com/the-first-10-pilates-mat-exercises-and-more-2704611
//Yoga poses and descriptions from: https://www.yogajournal.com/
//PoseDescriptions class contains all the poses the user can select from to add to their sequence

package ui;

import model.PilatesPose;
import model.Stage;
import model.YogaPose;
//PoseDescriptions class contains the information for all poses available for the user to browse

public class PoseDescriptions {
//Yoga Poses:
    protected static final YogaPose ALTERNATE = new YogaPose("Alternate Nostril Breathing",
            "Sit comfortably" + "cover your left nostril with your right ring finger, breathe in "
                    + "through your right nostril, cover "
                    + "your right nostril with your thumb, now uncover your left nostril and breathe out", "All",
            Stage.BREATHING);

    protected static final YogaPose KAPALABHATI = new YogaPose("Kapalabhati", "Inhale deeply through"
            + "your nose, as you exhale, press your belly towards your spine to force the breath out", "All",
            Stage.MAIN);

    protected static final YogaPose COOLING = new YogaPose("Sitali", "Also known as cooling breath. "
            + "Make an O-shape with your mouth and inhale through your mouth as if drinking through a straw,"
            + " breath out " + "through " + "your nose.", "All", Stage.BREATHING);

    protected static final YogaPose LION = new YogaPose("Lion", "Sit cross legged, with your hands "
            + "resting on your knees, take a deep breath in to your nose, open your mouth and stretch your tongue"
            + "towards your chin, exhale through your mouth.", "All", Stage.BREATHING);

    protected static final YogaPose CATCOW = new YogaPose("Cat-Cow", "Start on your hands and knees, "
            + "as you inhale, lift your sit bones and chest towards the sky, allowing your belly to sink, exhale back"
            + "to a neutral spine.", "All", Stage.WARMUP);

    protected static final YogaPose BOAT = new YogaPose("Boat", "Sit on the floor with your knees "
            + "bent, lift your feet off the floor, lean back and slowly straighten your legs if possible",
            "Beginner/ Intermediate", Stage.WARMUP);

    protected static final YogaPose SEATEDFORWARDBEND = new YogaPose("Seated forward bend", "Sit tall"
            + "with your legs streched out in front of you, lean forward with your hips making sure to nor round your"
            + "spine. If possible grab your feet or rest your hands on your shin.", "All", Stage.WARMUP);

    protected static final YogaPose DOWNWARD_DOG = new YogaPose("Downward Dog", "Start on your hands"
            + "and knees, exhale lift your knees off the ground and your sit bones towards the ceiling",
            "All", Stage.MAIN);

    protected static final YogaPose PLANK = new YogaPose("Plank", "Start in downward dog, inhale and "
            + "draw your torsoe forward until your shoulders are above your wrists", "All", Stage.MAIN);

    protected static final YogaPose CHAIR = new YogaPose("Chair", "Start in a standing position,"
            + " raise " + "your arms, bend your knees, try to get your thighs parallel to the floor and take your "
            + "tailbone" + "down to the ground", "Intermediate", Stage.MAIN);

    protected static final YogaPose BRIDGE = new YogaPose("Bridge", "Lay on your back, "
            + "bend your knees" + "and bring your feet as close to your sit-bones as possible, "
            + "lift your hips of the floor until the " + "thighs are parallel to the floor",
            "Intermediate", Stage.WARMDOWN);

    protected static final YogaPose CHILD = new YogaPose("Child's pose",
            "Sit on your knees spread your"
            + "knees hip distance apart and fold forward", "All", Stage.WARMDOWN);

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

    //Pilates poses:

    protected static final PilatesPose IMPRINTING = new PilatesPose("Imprinting",
            "Lay on your back, knees bent, feet flat on the floor, breathe deeply and "
                    + "relax your muscles. Gently sink your spine into the mat as if making an imprint",
            "All", Stage.BREATHING);

    protected static final PilatesPose ARM_REACH = new PilatesPose("Arm reach and pull", "Begin"
            + "in a standing position, reach your arms straight in front of you, inhale and pull your arms back, "
            + "brining your shoulder blades closer together. Repeat.", "All", Stage.WARMUP);

    protected static final PilatesPose PELVIC_CURL = new PilatesPose("Pelvic curl", "Lay on your back"
            + "engage your ab muscles and pull your abs towards your spine, inhale and lift your hips off the ground."
            + "Exhale and release your hips back to the ground.", "All", Stage.WARMUP);

    protected static final PilatesPose SWAN = new PilatesPose("Swan", "Lay on your belly, bring"
            + "your hands under your shoulders, inhale and lift your torsoe off the ground, stay for a few seconds, "
            + "exhale to come back down.", "All", Stage.WARMUP);

    protected static final PilatesPose ROLL_OVER = new PilatesPose("Roll over", "Begin lying down on "
            + "your back, extend your legs 90 degrees off the ground. Slightly lift your legs as you tilt your pelvis "
            + "back. Reach your legs over and above your head. Exhale and bring your legs back down to 90 degrees.",
            "Intermediate", Stage.MAIN);

    protected static final PilatesPose CIRCLES = new PilatesPose("One leg circles",
            "Lie on your back," + "bring one knee into your chest and extend it towards the ceiling. "
                    + "Point your toes, begin to make clockwise" + "circles with the lifted leg. "
                    + "Switch to counterclockwise after 8-10 circles.", "All", Stage.MAIN);

    protected static final PilatesPose SINGLE_lEG = new PilatesPose("Single leg stretch",
            "Start on your back, bend your knees so your shins are parallel to the floor"
                    + "curl up your head and shoulders and extend your left leg 45 degrees. Grasp your right"
                    + "knee with your hands, inhale and switch legs. ", "All",
            Stage.MAIN);

    protected static final PilatesPose DOUBLE_LEG = new PilatesPose("Double leg stretch", "Start on"
            + "your back with your knees bent, shins parallel to the floor. Curl up your head and shoulders, exhale and"
            + "reach your arms behind you while extending your legs straight out, then bring your knees back in towards"
            + "your chest, grasping it with your hands.", "Intermediate", Stage.MAIN);

    protected static final PilatesPose ROCKER = new PilatesPose("Rocker", "Start sitting, bend your"
            + "knees spread your legs hip width distance apart. Grab your shins or ankles with your hands. Lengthen"
            + "your legs one at a time towards the ceiling in a V-shape. Inhale and rock bacwards on your shoulder, "
            + "exhale and roll back up, repeat. ", "All", Stage.MAIN);

    protected static final PilatesPose CRISS_CROSS = new PilatesPose("Criss cross", "Start on your "
            + "back with your knees bent, shins parallel to the floor. Extend your right leg straight and bring your"
            + "right elbow to your left knee, repeat on the other side.", "All", Stage.MAIN);

    protected static final PilatesPose SAW = new PilatesPose("Saw", "Sit tall with your legs"
            + "extended. Raise your arms out to the side at shoulder level. Inhale and twist to the right, reaching"
            + "your left hand towards the outside of the right foot. Repeat on the other side.", "All",
            Stage.MAIN);

    protected static final PilatesPose ARM_LEG_REACH = new PilatesPose("Kneeling reach", "Start on"
            + "your hands and knees. Keep a neutral spine throughout this exercise. Inhale and reach your right arm "
            + "and left leg out. Exhale back to your hands and knees, repeat on the other side.",
            "All", Stage.MAIN);

    protected static final PilatesPose SEATED_TWIST = new PilatesPose("Seated Twist", "Seat "
            + "cross-legged, inhale and twist your torsoe to the right, grab your right knee with your left hand to "
            + "deepen, exhale come back to centre and repeat on the other side.", "All", Stage.WARMDOWN);

    protected static final PilatesPose SPINE_STRETCH = new PilatesPose("Spine stretch", "Sit tall"
            + "with your legs streched in front of you. Extend the arms out infront of you to shoulder height, exhale "
            + "as" + "you come forward bringing your fingers towards your toes. Hold for a few breaths and release.",
            "All", Stage.WARMDOWN);

    protected static final PilatesPose BRIDGE_PILATES = new PilatesPose("Bridge", "Lay on your back,"
            + " bend your knees and bring your feet as close to your sit-bones as possible, lift your hips of "
            + "the floor until the thighs are parallel to the floor", "All", Stage.WARMDOWN);

    protected static final PilatesPose CORPSE_PILATES = new PilatesPose("Corpse", "Lay down"
            + "on your back, arms resting on your side, relax your muscles and breathe normally.", "All",
            Stage.WARMDOWN);


}
