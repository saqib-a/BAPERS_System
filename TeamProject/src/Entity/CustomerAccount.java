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
public class CustomerAccount {

    String accountNo;
    String accountName;
    String title;
    String firstName;
    String surname;
    String address;
    String postcode;
    String city;
    String phoneNo;
    String valuedCustomer;

    public CustomerAccount(String accountNo, String accountName, String title, String firstName, String surname, String address, String postcode, String city, String phoneNo, String valuedCustomer) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.phoneNo = phoneNo;
        this.valuedCustomer = valuedCustomer;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getValuedCustomer() {
        return valuedCustomer;
    }

    public void setValuedCustomer(String valuedCustomer) {
        this.valuedCustomer = valuedCustomer;
    }
    
}
