package com.rasa.model;

import java.util.Date;

public class Budget {

     Date month;
     Double profit;
     Double repairAmount;
     Double rentalAmount;
     Double inventoryExpenses;
     Double empPayments;

    public Budget(Double repairAmount, Double rentalAmount, Double inventoryExpenses, Double empPayments) {
        this.repairAmount = repairAmount;
        this.rentalAmount = rentalAmount;
        this.inventoryExpenses = inventoryExpenses;
        this.empPayments = empPayments;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getRepairAmount() {
        return repairAmount;
    }

    public void setRepairAmount(Double repairAmount) {
        this.repairAmount = repairAmount;
    }

    public Double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(Double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public Double getInventoryExpenses() {
        return inventoryExpenses;
    }

    public void setInventoryExpenses(Double inventoryExpenses) {
        this.inventoryExpenses = inventoryExpenses;
    }

    public Double getEmpPayments() {
        return empPayments;
    }

    public void setEmpPayments(Double empPayments) {
        this.empPayments = empPayments;
    }
}
