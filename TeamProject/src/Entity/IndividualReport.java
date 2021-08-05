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
public class IndividualReport {
    //donest have anything app
    private String customerId;
    private String jobID;
    private Date datePeroid;
    private String nameOfReport;

    public IndividualReport(String customerId, String jobID, Date datePeroid, String nameOfReport) {
        this.customerId = customerId;
        this.jobID = jobID;
        this.datePeroid = datePeroid;
        this.nameOfReport = nameOfReport;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public Date getDatePeroid() {
        return datePeroid;
    }

    public void setDatePeroid(Date datePeroid) {
        this.datePeroid = datePeroid;
    }

    public String getNameOfReport() {
        return nameOfReport;
    }

    public void setNameOfReport(String nameOfReport) {
        this.nameOfReport = nameOfReport;
    }
    
}
