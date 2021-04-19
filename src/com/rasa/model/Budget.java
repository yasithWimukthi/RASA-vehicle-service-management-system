package model;

import java.util.Date;

public class Budget {

    String year;
    String month;
    double totIncome;

    double repairAmount;
    double rentalAmount;
    double inventoryExpenses;
    double empPayments;
    double totExpenses;
    double profit;



    public Budget(double repairAmount) {
        this.repairAmount = repairAmount;
    }

    public Budget(String year, String month, double totIncome, double repairAmount, double rentalAmount,double totExpenses, double inventoryExpenses, double empPayments, double profit) {
        this.year = year;
        this.month = month;
        this.totIncome = totIncome;

        this.repairAmount = repairAmount;
        this.rentalAmount = rentalAmount;
        this.totExpenses = totExpenses;
        this.inventoryExpenses = inventoryExpenses;
        this.empPayments = empPayments;

        this.profit = profit;
    }

    public Budget(double totIncome,double repairAmount, double rentalAmount,double totExpenses,  double inventoryExpenses, double empPayments, double profit) {
        this.totIncome = totIncome;

        this.repairAmount = repairAmount;
        this.rentalAmount = rentalAmount;
        this.totExpenses = totExpenses;
        this.inventoryExpenses = inventoryExpenses;
        this.empPayments = empPayments;
        this.profit = profit;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getTotIncome() {
        return totIncome;
    }

    public void setTotIncome(double totIncome) {
        this.totIncome = totIncome;
    }

    public double getTotExpenses() {
        return totExpenses;
    }

    public void setTotExpenses(double totExpenses) {
        this.totExpenses = totExpenses;
    }

    public double getRepairAmount() {
        return repairAmount;
    }

    public void setRepairAmount(double repairAmount) {
        this.repairAmount = repairAmount;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public double getInventoryExpenses() {
        return inventoryExpenses;
    }

    public void setInventoryExpenses(double inventoryExpenses) {
        this.inventoryExpenses = inventoryExpenses;
    }

    public double getEmpPayments() {
        return empPayments;
    }

    public void setEmpPayments(double empPayments) {
        this.empPayments = empPayments;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
