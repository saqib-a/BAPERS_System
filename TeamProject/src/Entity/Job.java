/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author sajawal
 */
public class Job {
    private String specialInstructions;
    private boolean isJobCompleted;
    private String jobID;
    private boolean isJobUrgent;
    private boolean isJobSuperUrgent;
    private Date deadline;
    private float priceOfJob;
    private int jobNumber;
    private String newJobAlert;
    private String deadlineAlert;

    public Job(String specialInstructions, boolean isJobCompleted, String jobID, boolean isJobUrgent, boolean isJobSuperUrgent, Date deadline, float priceOfJob, int jobNumber, String newJobAlert, String deadlineAlert) {
        this.specialInstructions = specialInstructions;
        this.isJobCompleted = isJobCompleted;
        this.jobID = jobID;
        this.isJobUrgent = isJobUrgent;
        this.isJobSuperUrgent = isJobSuperUrgent;
        this.deadline = deadline;
        this.priceOfJob = priceOfJob;
        this.jobNumber = jobNumber;
        this.newJobAlert = newJobAlert;
        this.deadlineAlert = deadlineAlert;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public boolean isIsJobCompleted() {
        return isJobCompleted;
    }

    public void setIsJobCompleted(boolean isJobCompleted) {
        this.isJobCompleted = isJobCompleted;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public boolean isIsJobUrgent() {
        return isJobUrgent;
    }

    public void setIsJobUrgent(boolean isJobUrgent) {
        this.isJobUrgent = isJobUrgent;
    }

    public boolean isIsJobSuperUrgent() {
        return isJobSuperUrgent;
    }

    public void setIsJobSuperUrgent(boolean isJobSuperUrgent) {
        this.isJobSuperUrgent = isJobSuperUrgent;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public float getPriceOfJob() {
        return priceOfJob;
    }

    public void setPriceOfJob(float priceOfJob) {
        this.priceOfJob = priceOfJob;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getNewJobAlert() {
        return newJobAlert;
    }

    public void setNewJobAlert(String newJobAlert) {
        this.newJobAlert = newJobAlert;
    }

    public String getDeadlineAlert() {
        return deadlineAlert;
    }

    public void setDeadlineAlert(String deadlineAlert) {
        this.deadlineAlert = deadlineAlert;
    }
    
      
}
