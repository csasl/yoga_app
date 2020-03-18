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
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class App {
    private YogaSequence myYogaSequence;
    private static final String SEQUENCE_FILE = "./data/sequence.txt";
    private JComboBox timeBox;
    private Font montserrat;
    private Font montserratLarge;



    public App() { }

    public void runApp() {
        setFont();
        setButtonUI();
        setPanelUI();
        setPaneUI();
        setListUI();
        setLabelUI();
        setSliderUI();
        loadSequence();
    }

    //EFFECTS: Loads font to be used to app

    public void setFont() {
        File font = new File("Montserrat.otf");
        try {
            montserrat = Font.createFont(Font.TRUETYPE_FONT, font);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        montserratLarge = new Font("Montserrat", Font.PLAIN, 18);
    }

    //EFFECTS: Sets UI components for all buttons in app
    public void setButtonUI() {
        UIManager.put("Button.background", Color.darkGray);
        UIManager.put("Button.foreground", Color.white);
        UIManager.put("Button.font", montserratLarge);

    }

    //EFFECTS: Sets UI components for panel components of app
    public void setPanelUI() {
        UIManager.put("Panel.background", Color.darkGray);
        UIManager.put("Panel.foreground", Color.white);
        UIManager.put("Panel.font", montserratLarge);


    }

    //EFFECTS: Sets UI components for option panes in app
    public void setPaneUI() {
        UIManager.put("OptionPane.background", Color.darkGray);
        UIManager.put("OptionPane.okButtonBackground", Color.darkGray);
        UIManager.put("OptionPane.messageForeground", Color.white);
        UIManager.put("OptionPane.messageFont", montserratLarge);
        UIManager.put("OptionPane.questionDialog.border.background", Color.darkGray);

    }

    //EFFECTS: Sets UI components for Slider
    public void setSliderUI() {
        UIManager.put("Slider.tickColor", Color.black);
        UIManager.put("Slider.foreground", Color.black);
        UIManager.put("Slider.background", Color.lightGray);

    }

    //EFFECTS: Sets UI components for labels
    public void setLabelUI() {
        UIManager.put("Label.background", Color.darkGray);
        UIManager.put("Label.foreground", Color.white);
        UIManager.put("Label.font", montserratLarge);


    }

    //EFFECTS: Sets UI components for JLists in app
    public void setListUI() {
        UIManager.put("List.background", Color.darkGray);
        UIManager.put("List.foreground", Color.white);
        UIManager.put("List.font", montserratLarge);
        UIManager.put("List.cellHeight", 100);
    }

    //EFFECTS: Displays welcome screen when sequence already saved to file
    public void welcomeBackScreen() {
        JLabel welcomeMsg = new JLabel("Welcome back! Let's keep building");
        JOptionPane.showMessageDialog(null, welcomeMsg, "Home Yoga", JOptionPane.PLAIN_MESSAGE,
                makeIcon());
        runMain();
    }



    //EFFECTS: Reads sequence data from text file and loads values to sequence. If not found, throws IO exception
    public void loadSequence() {
        Reader reader = new Reader();
        try {
            String jsonString = reader.readLines(SEQUENCE_FILE);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            myYogaSequence =  mapper.readValue(jsonString,YogaSequence.class);
            welcomeBackScreen();

        } catch (IOException e) {
            initializeNewSequence();
        }
    }



    //EFFECTS: Resizes icons for welcome frames
    public ImageIcon makeIcon() {
        ImageIcon lotus = new ImageIcon("lotus.png");
        Image lotusImage = lotus.getImage();
        Image lotusResize = lotusImage.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon finalLotus = new ImageIcon(lotusResize);
        return finalLotus;
    }

//EFFECTS: Displays menu for user to initialize a new sequence
    public void initializeNewSequence() {
        myYogaSequence = new YogaSequence();
        Object[] times = {20, 45, 60};
        JOptionPane timePane = new JOptionPane();
        Integer i = (Integer) timePane.showInputDialog(null,
                "Please select the number of minutes you want to work out for:", "Welcome"
                        + " to HomeYoga!", JOptionPane.PLAIN_MESSAGE, makeIcon(), times, 20);
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


