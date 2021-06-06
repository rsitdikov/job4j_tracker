package ru.job4j.oop.profession;

public class Work {
    private String description;
    private String goal;
    private boolean isDone;

    public Work(String description, String goal) {
        this.description = description;
        this.goal = goal;
        isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getGoal() {
        return goal;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
