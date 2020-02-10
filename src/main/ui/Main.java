package ui;

import model.YogaPose;
import model.YogaSequence;
import model.YogaStage;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        YogaApp app = new YogaApp();
        System.out.println("Welcome to Yoga Flow, let's get started!");
        app.manageUserInput();
    }

}
