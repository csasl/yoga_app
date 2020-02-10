package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PilatesPoseTest {
    PilatesPose testPose;

    @BeforeEach
    public void runBefore() {
        testPose = new PilatesPose("test pose", "test description",
                                            "intermediate", Stage.MAIN);
    }

    @Test
    public void testConstructor() {
        assertEquals(testPose.getName(), "test pose");
        assertEquals(testPose.getDescription(), "test description");
        assertEquals(testPose.getLevel(), "intermediate");
        assertEquals(testPose.getType(), Stage.MAIN);
        assertEquals(testPose.getTime(), 0);
    }

    @Test
    public void testSetTime() {
        assertEquals(testPose.getTime(), 0);
        testPose.setTime(10);
        assertEquals(testPose.getTime(), 10);
    }
}