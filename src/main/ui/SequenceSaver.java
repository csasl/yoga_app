package ui;

import model.YogaSequence;
import org.codehaus.jackson.map.ObjectMapper;
import persistence.Writer;

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
    public void saveSeq() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(App.getInstance().getSequence());
            writer.write(jsonString, SEQUENCE_FILE);
            writer.close();
            DialogCreator.createWarning("Saved sequence!");
        } catch (IOException e) {
            DialogCreator.createWarning("Sorry, could not save");
        }
    }
}
