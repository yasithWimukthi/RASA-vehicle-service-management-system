package com.rasa.model;

import java.sql.Date;

public class EmployeeAttendance {

    private int attID;
    private int empID;
    private int adminID;
    private Date date;
    private String status;


    public EmployeeAttendance(int empID, int adminID, Date date, String status) {
        this.empID = empID;
        this.adminID = adminID;
        this.date = date;
        this.status = status;
    }

    public EmployeeAttendance(){}

    //getters
    public int getAttID() {
        return attID;
    }

    public int getEmpID() {
        return empID;
    }

    public int getAdminID() {
        return adminID;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

//setters

    public void setAttID(int attID) {
        this.attID = attID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }






}