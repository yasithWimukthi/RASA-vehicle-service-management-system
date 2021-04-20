package com.rasa.model;


import java.sql.Date;

public class paymentList {

    int payId;
    String registrationNumber;
    String customerName;
    double estimateAmount;
    double cash;
    Date paymentDate;
    int serivceID;

    public paymentList(int payId,String registrationNumber,double estimateAmount,double cash,Date paymentDate,int serivceID) {
        this.payId = payId;
        this.registrationNumber = registrationNumber;

        this.estimateAmount = estimateAmount;

        this.cash = cash;
        this.paymentDate = paymentDate;
        this.serivceID = serivceID;
    }

    public paymentList(String registrationNumber,double estimateAmount,double cash,Date paymentDate,int serivceID) {


        this.registrationNumber = registrationNumber;

        this.estimateAmount = estimateAmount;

        this.cash = cash;
        this.paymentDate = paymentDate;
        this.serivceID = serivceID;
    }
    public paymentList(int payId,String registrationNumber,double estimateAmount,double cash,Date paymentDate) {
      this.payId = payId;

        this.registrationNumber = registrationNumber;

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

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber =registrationNumber;
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

    public int getSerivceID() {
        return serivceID;
    }

    public void setSerivceID(int serivceID) {
        this.serivceID = serivceID;
    }
}
