package com.rasa.model;

import java.util.Date;

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

    //getters

    public int getEmpID() {
        return empID;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public int getAdminID() { return adminID; }

    public int getAttID() {
        return attID;
    }



    //setters

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAttendance(String attendance) {
        this.status = status;
    }

    public void setAdminID(int adminID) { this.adminID = adminID; }

    public void setAttID(int attID) {
        this.attID = attID;
    }
}
