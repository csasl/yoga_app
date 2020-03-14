package ui;
//https://stackoverflow.com/questions/3002787/simple-popup-java-form-with-at-least-two-fields

import model.YogaSequence;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import persistence.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App {
    public YogaSequence myYogaSequence;
    public static final String SEQUENCE_FILE = "./data/sequence.txt";
    private JTextField nameField = new JTextField("");
    private JTextField timeField = new JTextField("");


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


        } catch (IOException e) {
            initializeNewSequence();
        }
    }

    public void initializeNewSequence() {
        JPanel welcome = new JPanel(new GridLayout(0,1));
        welcome.add(new JLabel("Welcome to HomeYoga, let's get started!"));
        welcome.add(new JLabel("Please name your sequence:"));
        welcome.add(nameField);
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setName();
            }
        });
        welcome.add(new JLabel("How many minutes would you like to work out for:"));
        welcome.add(timeField);
        timeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTime();
            }
        });

        int result = JOptionPane.showConfirmDialog(null,welcome,"Welcome",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
            public void run() {
                    new MainMenu(myYogaSequence);
                }
            });
        }

    }

    public void setName() {
        String name = nameField.getText();
        myYogaSequence.setName(name);

    }

    public void setTime() {
        String input = timeField.getText();
        Integer time = Integer.parseInt(input);
        myYogaSequence.setAllocatedTime(time);
    }



}


