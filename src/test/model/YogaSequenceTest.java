package model;
import exceptions.DuplicatePoseException;
import exceptions.EmptySequenceException;
import exceptions.OutOfTimeException;
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
        POSE_1.setTime(5);
        POSE_2.setTime(5);
        POSE_3.setTime(5);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testSequence.countPoses());

    }



    @Test
    public void testSetAllocatedTime() {
        assertEquals(25, testSequence.getAllocatedTime());
    }

    @Test
    public void addOnePose() {
        assertEquals(0, testSequence.countPoses());
        try {
            testSequence.addPose(POSE_1);
        } catch (Exception e) {
            fail();
        }
        assertEquals(1, testSequence.countPoses());
    }

    @Test
    public void addMultiplePosesNoExceptionExpected() {
        assertEquals(0, testSequence.countPoses());
        try {
            testSequence.addPose(POSE_1);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_3);
            testSequence.addPose(POSE_4);
        } catch (Exception e) {
            fail();
        }
        assertEquals(4, testSequence.countPoses());
    }

    @Test
    public void addMultiplePosesDuplicateExceptionExpected() {
        assertEquals(0, testSequence.countPoses());
        try {
            testSequence.addPose(POSE_1);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_3);
        } catch (DuplicatePoseException e) {
            //expect exception to be thrown
        } catch (OutOfTimeException e) {
            fail();
        }
        assertEquals(2, testSequence.countPoses());
    }

    @Test
    public void addPoseOutOfTimeException() {
        POSE_4.setTime(20);
        try{
            testSequence.addPose(POSE_1);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_3);
            testSequence.addPose(POSE_4);
        } catch (OutOfTimeException e) {
            //expected
        } catch (DuplicatePoseException e) {
            fail();
        }
    }


    @Test
    public void removePoseNoExceptionExpected() {
        assertEquals(0, testSequence.countPoses());
        try {
            testSequence.addPose(POSE_1);
            testSequence.addPose(POSE_2);
            testSequence.addPose(POSE_3);
            testSequence.addPose(POSE_4);
        } catch (Exception e) {
            fail();
        }
        assertEquals(4, testSequence.countPoses());
        try {
            testSequence.removePose(POSE_1.getName());
        } catch (EmptySequenceException e) {
            fail();
        }
        assertEquals(3,testSequence.countPoses());
        assertFalse(testSequence.sequenceContainsPose(POSE_1.getName()));

    }

    @Test
    public void testRemoveEmptySequenceException() {
        assertEquals(0, testSequence.countPoses());
        try {
            testSequence.removePose(POSE_1.getName());
        } catch (EmptySequenceException e) {
            //expected
        }
    }


    @Test
    public void testTotalTimeInSeqNoException() {
        try {
            try {
                testSequence.addPose(POSE_1);
                testSequence.addPose(POSE_2);
                testSequence.addPose(POSE_3);
                testSequence.addPose(POSE_4);
            } catch (OutOfTimeException e) {
                fail();
            }

        } catch (DuplicatePoseException e) {
            fail();
        }
        POSE_1.setTime(2);
        POSE_2.setTime(5);
        POSE_3.setTime(5);
        POSE_4.setTime(3);
        try {
            assertEquals(15, testSequence.totalTimeInSeq());
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
    } catch (Exception e) {
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
    } catch (Exception e) {
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
        } catch (Exception e) {
            fail();
        }
        assertEquals(20, testSequence.getRemainingTime());
        POSE_2.setTime(3);
        try {
            testSequence.addPose(POSE_2);
        } catch (Exception e) {
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
