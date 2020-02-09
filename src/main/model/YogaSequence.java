package model;

import java.util.ArrayList;
import java.util.List;

public class YogaSequence {
    List<YogaPose> yogaSequence;

//EFFECTS: Constructs and empty list of yoga poses
    public YogaSequence() {
        yogaSequence = new ArrayList<>();
    }

//MODIFIES: this
//EFFECTS: Given a pose, adds it to the list of poses

    public void addPose(YogaPose pos) {
        yogaSequence.add(pos);
    }
//REQUIRES: Non-empty list of poses
//MODIFIES: this
//EFFECTS: Given a pose, removes the pose from the list if it is in the list, otherwise does not modify the list

    public void removePose(YogaPose pos) {
        yogaSequence.remove(pos);
    }
//REQUIRES: Non-empty list of poses
//EFFECTS: returns the total time the sequence will take

    public Integer totalTimeInSeq() {
        Integer totalTime = 0;
        for (YogaPose nextPos: yogaSequence) {
            totalTime = totalTime + nextPos.getTime();
        }
        return totalTime;
    }

//REQUIRES: Non-empty list of poses
//EFFECTS: Given a stage of workout, returns all sequences in that stage

    public YogaSequence getByStage(YogaStage stage) {
        YogaSequence byType = new YogaSequence();
        for (YogaPose nextPos: yogaSequence) {
            if (nextPos.getType() == stage) {
                byType.addPose(nextPos);
                return byType;
            }
        }
        return null;
    }

//REQUIRES: Non-empty list of poses
//EFFECTS: Returns the total number of poses in the sequence

    public int getNumberOfPoses() {
        return yogaSequence.size();
    }

    public Boolean sequenceContainsPose(YogaPose pos) {
        return yogaSequence.contains(pos);
    }
}








