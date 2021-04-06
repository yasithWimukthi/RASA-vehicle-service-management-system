package com.rasa.model;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

public class Customer {
    private String customerID;
    private String NICno;
    private String fullName;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;
    private String email;

    public Customer() {
    }

    public Customer(String customerID, String NICno, String fullName, String firstName, String lastName, String address, String phoneNo, String email) {
        this.customerID = customerID;
        this.NICno = NICno;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public Customer(String NICno, String fullName, String firstName, String lastName, String address, String phoneNo, String email) {
        this.NICno = NICno;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getNICno() {
        return NICno;
    }

    public void setNICno(String NICno) {
        this.NICno = NICno;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "NICno='" + NICno + '\'' +
                ", name='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}