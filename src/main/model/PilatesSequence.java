package model;
//Pilates sequence is a subclass of the exercise class

import java.util.ArrayList;
import java.util.List;

public class PilatesSequence extends ExerciseSequence {
    List<PilatesPose> pilatesSequence;
    Integer totalTime;
    Integer numberOfPoses;

    public PilatesSequence() {
        pilatesSequence = new ArrayList<>();
        totalTime = 0;
        numberOfPoses = 0;
    }
}
