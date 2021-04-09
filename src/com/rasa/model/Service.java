package com.rasa.model;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

public class Service {
    private String NICno;
    private String vehicleRegistrationNo;
    private String entryDate;
    private String accidentDate;
    private String paymentType;

    public Service() {
    }

    public Service(String NICno, String vehicleRegistrationNo, String entryDate, String accidentDate, String paymentType) {
        this.NICno = NICno;
        this.vehicleRegistrationNo = vehicleRegistrationNo;
        this.entryDate = entryDate;
        this.accidentDate = accidentDate;
        this.paymentType = paymentType;
    }

    public Service(String entryDate, String accidentDate, String paymentType) {
        this.entryDate = entryDate;
        this.accidentDate = accidentDate;
        this.paymentType = paymentType;
    }

    public String getNICno() {
        return NICno;
    }

    public void setNICno(String NICno) {
        this.NICno = NICno;
    }

    public String getVehicleRegistrationNo() {
        return vehicleRegistrationNo;
    }

    public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
        this.vehicleRegistrationNo = vehicleRegistrationNo;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(String accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

}


