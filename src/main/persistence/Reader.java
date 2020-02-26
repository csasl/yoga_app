package persistence;

//Template for code from reader class in Teller App : https://github.students.cs.ubc.ca/CPSC210/TellerApp.git

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {


//EFFECTS: Reads all bytes in saved file and returns content of file
    //Code obtained from: https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
    public String readLines(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return content;

    }
}
