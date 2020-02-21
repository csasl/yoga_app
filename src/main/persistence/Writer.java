package persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {
    public static final String SEQUENCE_FILE = "./data/sequence.txt";
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    public void write(String jsonString, String path) throws IOException {
        fileWriter = new FileWriter(path);
        printWriter = new PrintWriter(fileWriter);
        printWriter.print(jsonString);

    }

    public void close() {
        printWriter.close();

    }

}
