package com.rasa.model;

import java.util.Date;

public class paymentList {
    String payId;
    String vehicleRegiNo;
    String customerName;
    Double estimateAmount;
    Double claimAmount;
    Double cash;
    Date paymentDate;

    public paymentList(String payId, String vehicleRegiNo, String customerName, Double estimateAmount, Double claimAmount, Double cash, Date paymentDate) {
        this.payId = payId;
        this.vehicleRegiNo = vehicleRegiNo;
        this.customerName = customerName;
        this.estimateAmount = estimateAmount;
        this.claimAmount = claimAmount;
        this.cash = cash;
        this.paymentDate = paymentDate;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
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

    public Double getEstimateAmount() {
        return estimateAmount;
    }

    public void setEstimateAmount(Double estimateAmount) {
        this.estimateAmount = estimateAmount;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
