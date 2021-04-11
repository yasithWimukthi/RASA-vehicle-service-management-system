package com.rasa.model;

public class addpayment {

    String ser_id;
    Double totalEstimate;
    Double estimateForRemoveAndRefiting;
    Double estimateForPainting;
    String vehicleRegiNo;

    public addpayment(String ser_id, Double totalEstimate, Double estimateForRemoveAndRefiting, Double estimateForPainting, String vehicleRegiNo) {
        this.ser_id = ser_id;
        this.totalEstimate = totalEstimate;
        this.estimateForRemoveAndRefiting = estimateForRemoveAndRefiting;
        this.estimateForPainting = estimateForPainting;
        this.vehicleRegiNo = vehicleRegiNo;
    }

    public String getSer_id() {
        return ser_id;
    }

    public void setSer_id(String ser_id) {
        this.ser_id = ser_id;
    }

    public Double getTotalEstimate() {
        return totalEstimate;
    }

    public void setTotalEstimate(Double totalEstimate) {
        this.totalEstimate = totalEstimate;
    }

    public Double getEstimateForRemoveAndRefiting() {
        return estimateForRemoveAndRefiting;
    }

    public void setEstimateForRemoveAndRefiting(Double estimateForRemoveAndRefiting) {
        this.estimateForRemoveAndRefiting = estimateForRemoveAndRefiting;
    }

    public Double getEstimateForPainting() {
        return estimateForPainting;
    }

    public void setEstimateForPainting(Double estimateForPainting) {
        this.estimateForPainting = estimateForPainting;
    }

    public String getVehicleRegiNo() {
        return vehicleRegiNo;
    }

    public void setVehicleRegiNo(String vehicleRegiNo) {
        this.vehicleRegiNo = vehicleRegiNo;
    }
}
