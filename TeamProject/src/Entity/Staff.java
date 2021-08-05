/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author sajawal
 */
public class Staff {
    String staffid;
    String firstName;
    String surname;
    String jobTitle;
    String password; //comeback

    public Staff(String staffid, String firstName, String surname, String jobTitle) {
        this.staffid = staffid;
        this.firstName = firstName;
        this.surname = surname;
        this.jobTitle = jobTitle;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
   
}
