/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author sajawal
 */
public class Task {
    private int taskID;
    private String description;
    private String location;
    private String shelfSlot;
    private float priceOfTask;
    private int duration;
    private boolean isTaskCompleted;
    private Time startTime;
    private Date completedBy;

    public Task(int taskID, String description, String location, String shelfSlot, float priceOfTask, int duration, boolean isTaskCompleted, Time startTime, Date completedBy) {
        this.taskID = taskID;
        this.description = description;
        this.location = location;
        this.shelfSlot = shelfSlot;
        this.priceOfTask = priceOfTask;
        this.duration = duration;
        this.isTaskCompleted = isTaskCompleted;
        this.startTime = startTime;
        this.completedBy = completedBy;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShelfSlot() {
        return shelfSlot;
    }

    public void setShelfSlot(String shelfSlot) {
        this.shelfSlot = shelfSlot;
    }

    public float getPriceOfTask() {
        return priceOfTask;
    }

    public void setPriceOfTask(float priceOfTask) {
        this.priceOfTask = priceOfTask;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isIsTaskCompleted() {
        return isTaskCompleted;
    }

    public void setIsTaskCompleted(boolean isTaskCompleted) {
        this.isTaskCompleted = isTaskCompleted;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(Date completedBy) {
        this.completedBy = completedBy;
    }
    
}
