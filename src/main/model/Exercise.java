package model;
//Yoga class contains information about specific poses including name, description, difficulty level, stage of workout
//and time for pose


public abstract class Exercise {
    protected String name;
    protected String description;
    protected String level;
    protected Stage type;
    private int time;

//EFFECTS: Constructs a new yoga pose with input parameters and time 0

    public Exercise(String name, String description, String level, Stage type) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.type = type;
        time = 0;

    }

//EFFECTS: returns name of Pose
    public String getName() {
        return this.name;
    }

//EFFECTS: returns description of pose
    public String getDescription() {
        return this.description;
    }

//EFFECTS: returns level of difficulty of pose

    public String getLevel() {
        return this.level;
    }

//EFFECTS: returns category of stage of pose
    public Stage getType() {
        return this.type;
    }

//EFFECTS:
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
