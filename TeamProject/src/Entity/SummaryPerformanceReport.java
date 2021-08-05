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
public class SummaryPerformanceReport {
    private String nameOfReport;
    private Date datePeriod;
    private Time dayShift;
    private Date date;
    private Time copyRoom;
    private Time development;
    private Time finishing;
    private Time packing;
    private Time total;

    public SummaryPerformanceReport(String nameOfReport, Date datePeriod, Time dayShift, Date date, Time copyRoom, Time development, Time finishing, Time packing, Time total) {
        this.nameOfReport = nameOfReport;
        this.datePeriod = datePeriod;
        this.dayShift = dayShift;
        this.date = date;
        this.copyRoom = copyRoom;
        this.development = development;
        this.finishing = finishing;
        this.packing = packing;
        this.total = total;
    }

    public String getNameOfReport() {
        return nameOfReport;
    }

    public void setNameOfReport(String nameOfReport) {
        this.nameOfReport = nameOfReport;
    }

    public Date getDatePeriod() {
        return datePeriod;
    }

    public void setDatePeriod(Date datePeriod) {
        this.datePeriod = datePeriod;
    }

    public Time getDayShift() {
        return dayShift;
    }

    public void setDayShift(Time dayShift) {
        this.dayShift = dayShift;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getCopyRoom() {
        return copyRoom;
    }

    public void setCopyRoom(Time copyRoom) {
        this.copyRoom = copyRoom;
    }

    public Time getDevelopment() {
        return development;
    }

    public void setDevelopment(Time development) {
        this.development = development;
    }

    public Time getFinishing() {
        return finishing;
    }

    public void setFinishing(Time finishing) {
        this.finishing = finishing;
    }

    public Time getPacking() {
        return packing;
    }

    public void setPacking(Time packing) {
        this.packing = packing;
    }

    public Time getTotal() {
        return total;
    }

    public void setTotal(Time total) {
        this.total = total;
    }
      
}
