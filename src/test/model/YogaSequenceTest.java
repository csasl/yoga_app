package model;
import exceptions.DuplicatePoseException;
import exceptions.EmptySequenceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class YogaSequenceTest {
    YogaSequence testSequence;

    YogaPose POSE_1 = new YogaPose("alternate nostril breathing", "cover one nostril, breath through" +
            "the other", "All", Stage.BREATHING);

    YogaPose POSE_2 = new YogaPose("Cat-Cow", "get on your hands and knees, arch your back, then curve" +
            "in", "All", Stage.WARMUP);

    YogaPose POSE_3 = new YogaPose("Sun Salutation", "12 steps", "Intermediate", Stage.MAIN);

    YogaPose POSE_4 = new YogaPose("Corpse", "lay on your back and relax", "All", Stage.WARMDOWN);


    @BeforeEach
    public void runBefore() {
        testSequence = new YogaSequence();
        testSequence.setAllocatedTime(25);
    }

    @Test
    public void testConstructor() {

        assertEquals(testSequence.countPoses(), 0);

    }



    @Test
    public void testSetAllocatedTime() {
        assertEquals(testSequence.getAllocatedTime(), 25);
    }

    @Test
    public void addOnePose() {
        assertEquals(testSequence.countPoses(), 0);
        try {
            testSequence.addPose(POSE_1);
        } catch (DuplicatePoseException e) {
            fail();
        }
        assertEquals(testSequence.countPoses(), 1);
    }

    @Test
    public void addMultiplePosesNoExceptionExpected() {
        assertEquals(testSequence.countPoses(), 0);
        try {
            testSequence.addPose(POSE_1);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_3);
            testSequence.addPose(POSE_4);
        } catch (DuplicatePoseException e) {
            fail();
        }
        assertEquals(4, testSequence.countPoses());
    }

    @Test
    public void addMultiplePosesDuplicateExceptionExpected() {
        assertEquals(testSequence.countPoses(), 0);
        try {
            testSequence.addPose(POSE_1);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_3);
        } catch (DuplicatePoseException e) {
            //expect exception to be thrown
        }
        assertEquals(2, testSequence.countPoses());
    }



    @Test
    public void removePose() {
        assertEquals(testSequence.countPoses(), 0);
        try {
            testSequence.addPose(POSE_1);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_3);
            testSequence.addPose(POSE_4);
        } catch (DuplicatePoseException e) {
            fail();
        }
        assertEquals(testSequence.countPoses(), 4);
        testSequence.removePose(POSE_1.getName());
        assertEquals(testSequence.countPoses(), 3);
        assertFalse(testSequence.sequenceContainsPose(POSE_1.getName()));

    }





    @Test
    public void testTotalTimeInSeqNoException() {
        try {
            testSequence.addPose(POSE_1);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_3);
            testSequence.addPose(POSE_4);
        } catch (DuplicatePoseException e) {
            fail();
        }
        POSE_1.setTime(2);
        POSE_2.setTime(5);
        POSE_3.setTime(5);
        POSE_4.setTime(3);
        try {
            assertEquals(testSequence.totalTimeInSeq(), (2 + 5+ 5 + 3));
        } catch (EmptySequenceException e) {
            fail("Sequence not empty");
        }
    }

    @Test
    public void testTotalTimeInSeqSequenceEmptyException() {
        assertEquals(testSequence.countPoses(), 0);
        try {
            assertEquals(0, testSequence.totalTimeInSeq());
        } catch (EmptySequenceException e) {
            //expected
        }

    }

    @Test
    public void testSequenceContainsPose() {
    try {
        testSequence.addPose(POSE_1);
    } catch (DuplicatePoseException e) {
        fail();
    }
    assertTrue(testSequence.sequenceContainsPose(POSE_1.getName()));
        assertFalse(testSequence.sequenceContainsPose(POSE_4.getName()));
    }

    @Test
    public void testListAllPoses() {
    try {
        testSequence.addPose(POSE_1);
        testSequence.addPose(POSE_2);
        testSequence.addPose(POSE_3);
    } catch (DuplicatePoseException e) {
        fail();
    }

        assertEquals(testSequence.listAllPoses(),
                POSE_1.getName()+". " + POSE_2.getName()+ ". " + POSE_3.getName() + ". " );
    }

    @Test
    public void testUpdateTimeNoException() {
        POSE_1.setTime(5);
        try {
            testSequence.addPose(POSE_1);
        } catch (DuplicatePoseException e) {
            fail();
        }
        assertEquals(20, testSequence.getRemainingTime());
        POSE_2.setTime(3);
        try {
            testSequence.addPose(POSE_2);
        } catch (DuplicatePoseException e) {
            fail();
        }
        assertEquals(17, testSequence.updateRemainingTime());
    }


    @Test
    public void testUpdateTimeException() {
        assertEquals(0, testSequence.countPoses());
        assertEquals(25, testSequence.updateRemainingTime());
    }





}
