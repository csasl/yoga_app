package model;
//YogaSequence is a subclass of ExerciseSequence

import java.util.ArrayList;
import java.util.List;

public class YogaSequence extends ExerciseSequence {
    List<YogaPose> yogaSequence;

//EFFECTS: Constructs and empty list of yoga poses
    public YogaSequence() {
        yogaSequence = new ArrayList<>();
    }

}








