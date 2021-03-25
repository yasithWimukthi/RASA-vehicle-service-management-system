package com.rasa.model;

import java.util.Date;

public class Employee {
    private int employeeID;
    private String fname;
    private String lname;
    private String gender;
    private Date DOB;
    private String address;
    private String email;
    private String mobile;
    private double basicSalary;
    private Date joinDate;

    public Employee(String fname, String lname, String gender, Date dob, String address, String email, String mobile, double basicSalary, Date joinDate) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.DOB = dob;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.basicSalary = basicSalary;
        this.joinDate = joinDate;
    }

    public Employee(String fname, String lname, String gender, double basicSalary, Date dob, String address, String email, String mobile, Date joinDate) {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public java.sql.Date getDOB() {
        return (java.sql.Date) DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public java.sql.Date getJoinDate() {
        return (java.sql.Date) joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
