package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YogaTest {
    YogaPose testPose;

    @BeforeEach
    public void runBefore() {
        testPose = new YogaPose("test pose", "test description",
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

    @Test
    public void testSetName() {
        testPose.setName("test");
        assertEquals("test", testPose.getName());
    }

    @Test
    public void testSetLevel() {
        testPose.setLevel("All");
        assertEquals("All", testPose.getLevel());
    }

    @Test
    public void testSetDescription() {
        testPose.setDescription("test");
        assertEquals("test", testPose.getDescription());
    }

    @Test
    public void testSetStage() {
        testPose.setType(Stage.BREATHING);
        assertTrue(testPose.getType().equals(Stage.BREATHING));
    }
}