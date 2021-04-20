package com.tosloth.toslothserver;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Goals")
public class Goal {


    @Id
    private String id;

    private String owner;
    private String name;
    private String description;
    private Interval interval;
    private Boolean done;
    private String creationTime;
    private String endTime;
    private String deadlineTime;
    private ArrayList<Goal> subGoalsArrayList = new ArrayList<>();

    public Goal() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public ArrayList<Goal> getSubGoalsArrayList() {
        return subGoalsArrayList;
    }

    public void setSubGoalsArrayList(ArrayList<Goal> subGoalsArrayList) {
        this.subGoalsArrayList = subGoalsArrayList;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", interval=" + interval +
                ", done=" + done +
                ", creationTime='" + creationTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", deadlineTime='" + deadlineTime + '\'' +
                '}';
    }
}

