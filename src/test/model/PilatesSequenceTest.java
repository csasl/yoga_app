package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PilatesSequenceTest {
    PilatesSequence testSequence;

    PilatesPose POSE_1 = new PilatesPose("alternate nostril breathing", "cover one nostril, breath through" +
            "the other", "All", Stage.BREATHING);

    PilatesPose POSE_2 = new PilatesPose("Cat-Cow", "get on your hands and knees, arch your back, then curve" +
            "in", "All", Stage.WARMUP);

    PilatesPose POSE_3 = new PilatesPose("Sun Salutation", "12 steps", "Intermediate", Stage.MAIN);

    PilatesPose POSE_4 = new PilatesPose("Corpse", "lay on your back and relax", "All", Stage.WARMDOWN);


    @BeforeEach
    public void runBefore() {
        testSequence = new PilatesSequence();
    }

    @Test
    public void testConstructor() {
        assertEquals(testSequence.getNumberOfPoses(), 0);
        assertEquals(testSequence.totalTime, 0);
    }

    @Test
    public void addOnePose() {
        assertEquals(testSequence.getNumberOfPoses(), 0);
        testSequence.addPose(POSE_1);
        assertEquals(testSequence.getNumberOfPoses(), 1);

    }

    @Test
    public void addMultiplePoses() {
        assertEquals(testSequence.getNumberOfPoses(), 0);
        testSequence.addPose(POSE_1);
        testSequence.addPose(POSE_2);
        testSequence.addPose(POSE_3);
        testSequence.addPose(POSE_4);
        assertEquals(testSequence.getNumberOfPoses(), 4);

    }

    @Test
    public void removePose() {
        assertEquals(testSequence.getNumberOfPoses(), 0);
        testSequence.addPose(POSE_1);
        testSequence.addPose(POSE_2);
        testSequence.addPose(POSE_3);
        testSequence.addPose(POSE_4);
        assertEquals(testSequence.getNumberOfPoses(), 4);
        testSequence.removePose(POSE_1.getName());
        assertEquals(testSequence.getNumberOfPoses(), 3);
        assertFalse(testSequence.sequenceContainsPose(POSE_1.getName()));

    }

    @Test
    public void testTotalTimeInSeq() {
        testSequence.addPose(POSE_1);
        testSequence.addPose(POSE_2);
        testSequence.addPose(POSE_3);
        testSequence.addPose(POSE_4);
        POSE_1.setTime(2);
        POSE_2.setTime(5);
        POSE_3.setTime(5);
        POSE_4.setTime(3);
        assertEquals(testSequence.totalTimeInSeq(), (2 + 5+ 5 + 3));
    }

@Test
    public void testSequenceContainsPose() {
        testSequence.addPose(POSE_1);
        assertTrue(testSequence.sequenceContainsPose(POSE_1.getName()));
        assertFalse(testSequence.sequenceContainsPose(POSE_4.getName()));
    }

@Test
    public void testListAllPoses() {
        testSequence.addPose(POSE_1);
        testSequence.addPose(POSE_2);
        testSequence.addPose(POSE_3);
        assertEquals(testSequence.listAllPoses(),
                POSE_1.getName()+". " + POSE_2.getName()+ ". " + POSE_3.getName() + ". " );
    }
}
