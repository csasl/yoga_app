package model;
//Exercise class contains information about specific poses including name, description, difficulty level,
// stage of workout and time pose will be practiced for


public abstract class Exercise {
    protected String name;
    protected String description;
    protected String level;
    protected Stage type;
    protected int time;

//EFFECTS: Constructs a new exercise with input parameters and time 0

    public Exercise(String name, String description, String level, Stage type) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.type = type;
        time = 0;

    }

//EFFECTS: returns name of exercise
    public String getName() {
        return this.name;
    }

//EFFECTS: returns description of exercise
    public String getDescription() {
        return this.description;
    }

//EFFECTS: returns level of difficulty of exercise

    public String getLevel() {
        return this.level;
    }

//EFFECTS: returns category of stage of exercise
    public Stage getType() {
        return this.type;
    }

//EFFECTS: returns the time that exercise will be practiced for
    public int getTime() {
        return time;
    }

//MODIFIES: this
//EFFECTS: given a time in minutes, sets the time exercise will be practised for
    public void setTime(int time) {
        this.time = time;
    }
}
