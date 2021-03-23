package com.rasa.model;

/**
 * RASA VIHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

public class Customer {
    private String customerID;
    private String NICno;
    private String name;
    private String address;
    private String phoneNo;
    private String email;

    public Customer(String customerID, String NICno, String name, String address, String phoneNo, String email) {
        this.customerID = customerID;
        this.NICno = NICno;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public Customer(String NICno, String name, String address, String phoneNo, String email) {
        this.NICno = NICno;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}