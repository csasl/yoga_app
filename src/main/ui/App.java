//https://stackoverflow.com/questions/3002787/simple-popup-java-form-with-at-least-two-fields
//Icons made by <a href="https://www.flaticon.com/authors/roundicons" title="Roundicons">Roundicons</a>
// from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>
//Font tutorial: https://www.youtube.com/watch?v=43duJsYmhxQ
//https://mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
//http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870

/**
 *Represents application initialization
 */

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
    private Font appFont;
    private Font segoe;
    private MainMenu mainMenu;


    /**
     * Constructor creates a new app
     */
    public App() { }

    /**
     *Initializes UI formats and sequence
     */

    public void runApp() {
        setFont();
        setButtonUI();
        setPanelUI();
        setPaneUI();
        setListUI();
        setLabelUI();
        setComboBoxUI();
        mainMenu = new MainMenu();
        loadSequence();

    }

    /**
     * Helper to set up font used in app
     */

    public void setFont() {

        try {
            segoe = Font.createFont(Font.TRUETYPE_FONT, new File("./data/segoe.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./data/segoe.ttf")));
        } catch (FontFormatException e) {
            appFont = new Font("Arial", Font.PLAIN, 20);
        } catch (IOException e) {
            appFont = new Font("Arial", Font.PLAIN, 20);
        }
        appFont = segoe;

    }

    /**
     * Helper to set up UI for app's JButtons
     */
    public void setButtonUI() {
        UIManager.put("Button.font", appFont);

    }


    /**
     * Helper to set up UI for app's JPanels
     */
    public void setPanelUI() {
        UIManager.put("Panel.background", Color.darkGray);
        UIManager.put("Panel.foreground", Color.white);
        UIManager.put("Panel.font", appFont);
    }

    /**
     * Helper to set up UI for app's JPanes
     */
    public void setPaneUI() {
        UIManager.put("OptionPane.background", Color.darkGray);
        UIManager.put("OptionPane.okButtonBackground", Color.darkGray);
        UIManager.put("OptionPane.messageForeground", Color.white);
        UIManager.put("OptionPane.messageFont", appFont);
        UIManager.put("OptionPane.questionDialog.border.background", Color.darkGray);

    }


    /**
     * Helper to set up UI for app's JLabels
     */
    public void setLabelUI() {
        UIManager.put("Label.background", Color.darkGray);
        UIManager.put("Label.foreground", Color.white);
        UIManager.put("Label.font", appFont);


    }

    /**
     * Helper to set up UI for app's JLists
     */
    public void setListUI() {
        UIManager.put("List.background", Color.darkGray);
        UIManager.put("List.foreground", Color.white);
        UIManager.put("List.font", appFont);
        UIManager.put("List.cellHeight", 100);
    }

    /**
     * Helper to set up UI for app's JComboBox
     */

    public void setComboBoxUI() {
        UIManager.put("ComboBox.font", appFont);
    }



    /**
     * Displays welcome screen when sequence already saved to file
     */
    public void welcomeBackScreen() {
        JLabel welcomeMsg = new JLabel("Welcome back! Let's keep building");
        JOptionPane.showMessageDialog(null, welcomeMsg, "Home Yoga", JOptionPane.PLAIN_MESSAGE,
                makeIcon());
        runMain();
    }



    /**
     * Loads data saved from sequence file if it exists
     * Code from: https://mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
     */
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



    /**
     * Helper to make icon for welcome screen
     * Code from: http://www.nullpointer.at/2011/08/21/java-code-snippets-howto-resize-an-imageicon/#comment-11870
     */
    public ImageIcon makeIcon() {
        ImageIcon lotus = new ImageIcon("./data/lotus.png");
        Image lotusImage = lotus.getImage();
        Image lotusResize = lotusImage.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon finalLotus = new ImageIcon(lotusResize);
        return finalLotus;
    }

    /**
     * Initializes new sequence and welcome screen when no data was saved
     */
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

    /**
     * Loads the main menu
     */
    public void runMain() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainMenu.initializeMainMenu(myYogaSequence);
            }
        });

    }

}


