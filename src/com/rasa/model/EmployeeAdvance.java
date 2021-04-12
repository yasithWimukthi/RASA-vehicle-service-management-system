package com.rasa.model;

import java.sql.Date;

public class EmployeeAdvance {

    private int advanceID;
    private int empID;
    private int adminID;
    private Date date;
    private double amount;

    public EmployeeAdvance(int empID, int adminID, Date date, double amount) {
        this.empID = empID;
        this.adminID = adminID;
        this.date = date;
        this.amount = amount;
    }

    public EmployeeAdvance() {

    }

    //getters

    public int getEmpID() {
        return empID;
    }

    public int getAdminID() {
        return adminID;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public int getAdvanceID() { return advanceID; }




    //setters

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) { this.amount = amount; }

    public void setAdvanceID(int advanceID) { this.advanceID = advanceID; }
}
