//Main class initiates running the YogaLates App
//Used code from: //Used code from: https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
// UI package as a template for this class

package ui;

import model.YogaSequence;
import persistence.Reader;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        App yogaApp = new App();
        yogaApp.runApp();
    }

}
