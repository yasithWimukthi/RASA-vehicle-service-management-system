package com.rasa.model;

public class addpayment {
    int serviceID;
    private double removeRefting;
    private double replacing;
    private double painting;
    private double totEstimateAmount;

    public addpayment(int serviceID, double removeRefting, double replacing, double painting, double totEstimateAmount) {
        this.serviceID = serviceID;
        this.removeRefting = removeRefting;
        this.replacing = replacing;
        this.painting = painting;
        this.totEstimateAmount = totEstimateAmount;
    }

    public addpayment(double removeRefting){
        this.removeRefting = removeRefting;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public double getRemoveRefting() {
        return removeRefting;
    }

    public void setRemoveRefting(double removeRefting) {
        this.removeRefting = removeRefting;
    }

    public double getReplacing() {
        return replacing;
    }

    public void setReplacing(double replacing) {
        this.replacing = replacing;
    }

    public double getPainting() {
        return painting;
    }

    public void setPainting(double painting) {
        this.painting = painting;
    }

    public double getTotEstimateAmount() {
        return totEstimateAmount;
    }

    public void setTotEstimateAmount(double totEstimateAmount) {
        this.totEstimateAmount = totEstimateAmount;
    }
}
