//https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
//https://www.baeldung.com/jackson-object-mapper-tutorial


package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Represents the main menu that users interact with
 */

public class MainMenu extends JFrame {
    private JButton save = new JButton("Save sequence");
    private JButton manage = new JButton("Manage sequence");
    private JButton view = new JButton("View sequence");
    private JToolBar toolBar;
    private SequenceManager manageMenu;
    private SequenceViewer viewSeq;
    private SequenceSaver saver;
    private StageViewer poses;


    /**
     * Constructs main menu
     */
    public MainMenu() {
        super("Home Yoga");
        saver = new SequenceSaver();
        manageMenu = new SequenceManager();
        viewSeq = new SequenceViewer();
    }

    /**
     * Initializes components of main menu
     *
     */

    public void initializeMainMenu() {
        setLayout(new BorderLayout());
        toolBar = new JToolBar();
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        poses = new StageViewer();
        addComponents();
        addListeners();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);
    }

    /**
     * Helper to add components to frame
     */

    public void addComponents() {
        add(toolBar, BorderLayout.NORTH);
        toolBar.add(save);
        toolBar.add(manage);
        toolBar.add(view);
        add(poses);
    }

    /**
     * Helper to set up action listeners for buttons on main menu
     */
    public void addListeners() {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saver.saveSeq();

            }
        });

        manage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageMenu.showGUI();
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSeq.displaySequence();
            }
        });
    }


}













