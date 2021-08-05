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
public class JobInvoice {
    private String labContactInfo;
    private int invoiceID;
    private String accountHoldersName;
    private String customerID;
    private String address;
    private String phoneNumber;
    private String jobID;
    private String specialInstructions;
    private float price;
    private int taskID;
    private float subTotal;
    private int discountAgreed;
    private float total;
    private String labBankInformation;

    public JobInvoice(String labContactInfo, int invoiceID, String accountHoldersName, String customerID, String address, String phoneNumber, String jobID, String specialInstructions, float price, int taskID, float subTotal, int discountAgreed, float total, String labBankInformation) {
        this.labContactInfo = labContactInfo;
        this.invoiceID = invoiceID;
        this.accountHoldersName = accountHoldersName;
        this.customerID = customerID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.jobID = jobID;
        this.specialInstructions = specialInstructions;
        this.price = price;
        this.taskID = taskID;
        this.subTotal = subTotal;
        this.discountAgreed = discountAgreed;
        this.total = total;
        this.labBankInformation = labBankInformation;
    }

    public String getLabContactInfo() {
        return labContactInfo;
    }

    public void setLabContactInfo(String labContactInfo) {
        this.labContactInfo = labContactInfo;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getAccountHoldersName() {
        return accountHoldersName;
    }

    public void setAccountHoldersName(String accountHoldersName) {
        this.accountHoldersName = accountHoldersName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public int getDiscountAgreed() {
        return discountAgreed;
    }

    public void setDiscountAgreed(int discountAgreed) {
        this.discountAgreed = discountAgreed;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getLabBankInformation() {
        return labBankInformation;
    }

    public void setLabBankInformation(String labBankInformation) {
        this.labBankInformation = labBankInformation;
    }
    
    
}
