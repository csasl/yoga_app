package persistence;

//Template code from writer in Teller app: https://github.students.cs.ubc.ca/CPSC210/TellerApp.git

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {
    public static final String SEQUENCE_FILE = "./data/sequence.txt";
    private FileWriter fileWriter;
    private PrintWriter printWriter;


//EFFECTS: Saves sequence to a file
    //Code obtained from: https://www.baeldung.com/java-write-to-file
    public void write(String jsonString, String path) throws IOException {
        fileWriter = new FileWriter(path);
        printWriter = new PrintWriter(fileWriter);
        printWriter.print(jsonString);

    }

//EFFECTS: Closes printwriter
    public void close() {
        printWriter.close();

    }

}
