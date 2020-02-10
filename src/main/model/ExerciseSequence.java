package model;

import java.util.ArrayList;
import java.util.List;

public abstract class ExerciseSequence {
    List<Exercise> exerciseSequence;

//EFFECTS: Constructs and empty list of yoga poses
    public ExerciseSequence() {
        exerciseSequence = new ArrayList<>();
    }

//MODIFIES: this
//EFFECTS: Given a pose, adds it to the list of poses

    public void addPose(Exercise pos) {
        exerciseSequence.add(pos);
    }
//REQUIRES: Non-empty list of poses
//MODIFIES: this
//EFFECTS: Given a pose, removes the pose from the list if it is in the list, otherwise does not modify the list

    public void removePose(String pose) {
        for (int i = 0; i < exerciseSequence.size(); i++) {
            if (exerciseSequence.get(i).getName().equals(pose)) {
                exerciseSequence.remove(i);
                i--;
            }
        }
    }
//REQUIRES: Non-empty list of poses
//EFFECTS: returns the total time the sequence will take

    public Integer totalTimeInSeq() {
        Integer totalTime = 0;
        for (Exercise nextPos: exerciseSequence) {
            totalTime = totalTime + nextPos.getTime();
        }
        return totalTime;
    }


//REQUIRES: Non-empty list of poses
//EFFECTS: Returns the total number of poses in the sequence

    public int getNumberOfPoses() {
        return exerciseSequence.size();
    }

    public Boolean sequenceContainsPose(String pose) {
        boolean contains = false;

        for (Exercise nextPose : exerciseSequence) {
            if (nextPose.getName().equals(pose)) {
                contains = true;
            }
        }
        return contains;
    }


    public String listAllPoses() {
        String listOfPoses = "";
        for (Exercise nextPose: exerciseSequence) {
            listOfPoses = listOfPoses  + nextPose.getName() + ". ";
        }
        return listOfPoses;
    }
}








