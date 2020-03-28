package ui;

import model.YogaSequence;
import org.codehaus.jackson.map.ObjectMapper;
import persistence.Writer;

import javax.swing.*;
import java.io.IOException;

public class SequenceSaver {
    private Writer writer;
    private static final String SEQUENCE_FILE = "./data/sequence.txt";

    public SequenceSaver() {
        writer = new Writer();

    }

    /**
     * Saves sequence to text file when save button selected
     */
    public void saveSeq(YogaSequence sequence) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(sequence);
            writer.write(jsonString, SEQUENCE_FILE);
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Sorry, could not save");
        }
    }
}
