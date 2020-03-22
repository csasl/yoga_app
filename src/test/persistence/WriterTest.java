package persistence;

import model.Stage;
import model.YogaPose;
import model.YogaSequence;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class WriterTest {

    private static final String TEST_FILE = "./data/testSequence.txt";
    private Writer testWriter;
    private YogaSequence testSequence;
    private Reader testReader;
    private YogaPose testPose;

    @BeforeEach
    public void runBefore() {
        testWriter = new Writer();
        testReader = new Reader();
        testSequence = new YogaSequence();
        testSequence.setAllocatedTime(20);
        testPose= new YogaPose("test", "test", "All", Stage.BREATHING);
        testPose.setTime(5);
        testSequence.addPose(testPose);

    }

    @Test
    public void testWrite() {
        ObjectMapper mapper = new ObjectMapper();
        //save test sequence to test file
        try {
            String jsonTestString = mapper.writeValueAsString(testSequence);
            testWriter.write(jsonTestString, TEST_FILE);
            testWriter.close();

        } catch (IOException e) {
            fail("Should not be IO exception");
        }
        ObjectMapper mapper2 = new ObjectMapper();

        try {
            String readjson = testReader.readLines(TEST_FILE);
            testSequence = mapper2.readValue(readjson, YogaSequence.class);
            assertEquals(20, testSequence.getAllocatedTime() );
            assertEquals(1, testSequence.countPoses());
            assertEquals(15, testSequence.getRemainingTime());
            assertTrue(testSequence.sequenceContainsPose("test"));


        } catch (IOException e) {
            fail("Should not be IO exception");
        }


    }
}
