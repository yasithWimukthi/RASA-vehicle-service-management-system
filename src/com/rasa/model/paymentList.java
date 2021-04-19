package com.rasa.model;


import java.sql.Date;

public class paymentList {

    int payId;
    String vehicleRegiNo;
    String customerName;
    double estimateAmount;
    double cash;
    Date paymentDate;

    public paymentList(int payId,String vehicleRegiNo,String customerName,double estimateAmount,double cash,Date paymentDate) {
        this.payId = payId;
        this.vehicleRegiNo = vehicleRegiNo;
        this.customerName = customerName;
        this.estimateAmount = estimateAmount;

        this.cash = cash;
        this.paymentDate = paymentDate;
    }

    public paymentList(String vehicleRegiNo,String customerName,double estimateAmount,double cash,Date paymentDate) {


        this.vehicleRegiNo = vehicleRegiNo;
        this.customerName = customerName;
        this.estimateAmount = estimateAmount;

        this.cash = cash;
        this.paymentDate = paymentDate;
    }



    public  int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getVehicleRegiNo() {
        return vehicleRegiNo;
    }

    public void setVehicleRegiNo(String vehicleRegiNo) {
        this.vehicleRegiNo = vehicleRegiNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getEstimateAmount() {
        return estimateAmount;
    }

    public void setEstimateAmount(double estimateAmount) {
        this.estimateAmount = estimateAmount;
    }



    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
