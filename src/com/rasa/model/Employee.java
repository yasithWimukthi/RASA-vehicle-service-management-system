package com.rasa.model;

public class Employee {
    private String employeeID;
    private String fname;
    private String lname;
    private String gender;
    private String DOB;
    private String NIC;
    private String basicSalary;
    private String mobile;
    private String email;
    private String address;
    private String joinDate;

    public Employee(String fname, String lname, String gender, String DOB, String NIC, String basicSalary,String mobile,String email,String address,String joinDate) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.DOB = DOB;
        this.NIC = NIC;
        this.basicSalary = basicSalary;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.joinDate = joinDate;
    }

    public Employee() {

    }

    public Employee(String employeeID, String fname) {
        this.employeeID=employeeID;
        this.fname = fname;
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

    public String getDOB() {
        return  DOB;
    }

    public void setDOB(String DOB) {
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

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
}
