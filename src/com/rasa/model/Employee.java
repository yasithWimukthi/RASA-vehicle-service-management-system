package com.rasa.model;

public class Employee {
    private int employeeID;
    private String fname;
    private String lname;
    private String gender;
    private String DOB;
    private String NIC;
    private Double basicSalary;
    private String mobile;
    private String email;
    private String address;
    private String joinDate;

    public Employee(String fname, String lname, String gender, String DOB, String NIC, double basicSalary,String mobile,String email,String address,String joinDate) {
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

    public Employee(int employeeID, String fname) {
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

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
}
