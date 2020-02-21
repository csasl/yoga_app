package persistence;

import model.YogaSequence;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.PoseDescriptions;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {

    private static final String TEST_FILE = "./data/testSequence.txt";
    private Writer testWriter;
    private Reader testReader;
    private YogaSequence testSequence;

    @BeforeEach
    public void runBefore() {
        testWriter = new Writer();
        testReader = new Reader();
        testSequence = new YogaSequence();
        testSequence.addPose(PoseDescriptions.ALTERNATE);
        testSequence.addPose(PoseDescriptions.COOLING);
        testSequence.addPose(PoseDescriptions.KAPALABHATI);
        testSequence.setAllocatedTime(20);
        testSequence.setName("test");
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
            assertEquals(20, testSequence.getAllocatedTime());
            assertEquals(3, testSequence.countPoses());
            assertEquals("test", testSequence.getName());
            assertTrue(testSequence.sequenceContainsPose("Kapalabhati"));


        } catch (IOException e) {
            fail("Should not be IO exception");
        }
    }

    @Test
    public void testIOException() {
        try {
            testReader.readLines("./path/does/not/exist/testSequence.txt");
        } catch (IOException e) {
            //Expected
        }

    }


}
