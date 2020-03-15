//https://stackoverflow.com/questions/3002787/simple-popup-java-form-with-at-least-two-fields
//https://stackoverflow.com/questions/38062716/implementing-an-actionlistener-to-a-jtextfield
//Icons made by <a href="https://www.flaticon.com/authors/roundicons" title="Roundicons">Roundicons</a>
// from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>



package ui;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import persistence.Reader;

import model.YogaSequence;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App {
    private YogaSequence myYogaSequence;
    private static final String SEQUENCE_FILE = "./data/sequence.txt";
    private JComboBox timeBox;




    public App() { }

    public void runApp() {
        loadSequence();
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MainMenu(myYogaSequence);
//
//            }
//        });
    }


    public void loadSequence() {
        Reader reader = new Reader();

        try {
            String jsonString = reader.readLines(SEQUENCE_FILE);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            myYogaSequence =  mapper.readValue(jsonString,YogaSequence.class);
            runMain();


        } catch (IOException e) {
            initializeNewSequence();
        }
    }


    public void initializeNewSequence() {
        myYogaSequence = new YogaSequence();
        ImageIcon lotus = new ImageIcon("lotus.png");

        Object[] times = {20, 45, 60};
        Integer i = (Integer) JOptionPane.showInputDialog(null,
                "Please select the number of minutes you want to work out for:", "Welcome"
                        + "to HomeYoga!", JOptionPane.PLAIN_MESSAGE, lotus, times, 20);
        switch (i) {
            case 20:
                myYogaSequence.setAllocatedTime(20);
                break;
            case 45:
                myYogaSequence.setAllocatedTime(45);
                break;
            case 60:
                myYogaSequence.setAllocatedTime(60);
        }
        UIManager.put("OptionPane.background", Color.black);
        UIManager.getLookAndFeelDefaults().put("Panel.background", Color.black);


        runMain();
    }


    public void runMain() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenu(myYogaSequence);
            }
        });

    }




}


