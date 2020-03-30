package persistence;

import exceptions.DuplicatePoseException;
import model.Stage;
import model.YogaPose;
import model.YogaSequence;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {

    private static final String TEST_FILE = "./data/testSequence.txt";
    private Writer testWriter;
    private Reader testReader;
    private YogaSequence testSequence;
    private YogaPose test1;

    @BeforeEach
    public void runBefore() {

        test1 = new YogaPose("test", "test description", "All", Stage.BREATHING);
        test1.setTime(5);
        testWriter = new Writer();
        testReader = new Reader();
        testSequence = new YogaSequence();
        testSequence.setAllocatedTime(20);
        try {
            testSequence.addPose(test1);
        } catch (Exception e) {
            fail();
        }

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
            assertEquals(1, testSequence.countPoses());
            assertEquals(15, testSequence.getRemainingTime());

            assertTrue(testSequence.sequenceContainsPose("test"));


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
