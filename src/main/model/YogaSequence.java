package model;

/**
 * Represents a yoga sequence that user can set an allocated time for and add yoga poses to
 */

import exceptions.DuplicatePoseException;
import exceptions.OutOfTimeException;

import java.util.ArrayList;
import java.util.List;

public  class YogaSequence {

    private List<YogaPose> exerciseSequence;
    private Integer allocatedTime;
    private Integer remainingTime;


    //EFFECTS: Constructs and empty list of exercises
    public YogaSequence() {
        exerciseSequence = new ArrayList<>();
    }


    //MODIFIES: this
    //EFFECTS: Sets allocated time to given time in mins
    public void setAllocatedTime(Integer time) {
        this.allocatedTime = time;
    }

    //MODIFIES: this
    //EFFECTS: Given a pose, adds it to the sequence. If pose is already in sequence, throws duplicate pose exception
    //          If adding the pose will result in remaining time less than 0, throws out of time exception
    public void addPose(YogaPose pos) throws DuplicatePoseException, OutOfTimeException {
        if (sequenceContainsPose(pos.getName())) {
            throw new DuplicatePoseException();
        } else if (updateRemainingTime() - pos.getTime() < 0) {
            throw new OutOfTimeException();
        } else {
            exerciseSequence.add(pos);
            updateRemainingTime();

        }
    }

    //MODIFIES: this
    //EFFECTS: Returns remaining time in sequence after each pose is added
    public int updateRemainingTime()  {
        remainingTime = allocatedTime - totalTimeInSeq();
        return remainingTime;
    }


    //MODIFIES: this
    //EFFECTS: Given a pose, removes the pose from the list if it is in the list, otherwise does not modify the list
    public void removePose(String pose)  {
        if (exerciseSequence.size() > 0) {
            for (int i = 0; i < exerciseSequence.size(); i++) {
                if (exerciseSequence.get(i).getName().equals(pose)) {
                    exerciseSequence.remove(i);
                    i--;
                }
            }
        }
    }


    //EFFECTS: returns the total time the sequence will take
    public Integer totalTimeInSeq()  {
        int totalTime = 0;
        for (YogaPose nextPos : exerciseSequence) {
            totalTime = totalTime + nextPos.getTime();
        }
        return totalTime;
    }



    //EFFECTS: Returns the total number of poses in the sequence
    public int countPoses() {
        int numberOfPoses = exerciseSequence.size();
        return numberOfPoses;
    }


    //EFFECTS: returns true if sequence contains given pose name
    public Boolean sequenceContainsPose(String pose)  {
        boolean contains = false;

        for (YogaPose nextPose : exerciseSequence) {
            if (nextPose.getName().equals(pose)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    //EFFECTS: Returns all poses in the sequence in the format Pose 1. Pose 2. Pose 3....
    public String listAllPoses() {
        String listOfPoses = "";
        for (YogaPose nextPose: exerciseSequence) {
            listOfPoses = listOfPoses  + nextPose.getName() + ". ";
        }
        return listOfPoses;
    }


    //EFFECTS: Returns allocated time
    public Integer getAllocatedTime() {
        return allocatedTime;
    }

    //EFFECTS: returns sequence
    public List<YogaPose> getExerciseSequence() {
        return exerciseSequence;
    }

    //MODIFIES: This
    //EFFECTS: sets remaining time

    public void setRemainingTime(Integer time) {
        this.remainingTime = time;
    }

    //EFFECTS: gets remaining time
    public Integer getRemainingTime() {
        return  remainingTime;
    }


}











