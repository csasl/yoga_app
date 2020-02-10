package model;
//Pilates sequence is a subclass of the exercise class

import java.util.ArrayList;
import java.util.List;

public class PilatesSequence extends ExerciseSequence {
    List<PilatesPose> pilatesSequence;

    public PilatesSequence() {
        pilatesSequence = new ArrayList<>();
    }
}
