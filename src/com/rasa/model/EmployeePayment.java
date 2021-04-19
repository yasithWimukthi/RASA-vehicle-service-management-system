package com.rasa.model;

import java.sql.Date;

public class EmployeePayment {

    private int paymentID;
    private int empID;
    private int adminID;
    private Date date;
    private double bonus;
    private double deduct;
    private double amount;


    public EmployeePayment(int empID, int adminID, Date date, double bonus, double deduct, double amount) {
        this.empID = empID;
        this.adminID = adminID;
        this.date = date;
        this.bonus = bonus;
        this.deduct = deduct;
        this.amount = amount;
    }

    public EmployeePayment() {

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

    public double getBonus() {
        return bonus;
    }

    public double getDeduct() {
        return deduct;
    }

    public double getAmount() {
        return amount;
    }


    public int getPaymentID() {
        return paymentID;
    }




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

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setDeduct(double deduct) {
        this.deduct = deduct;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
}