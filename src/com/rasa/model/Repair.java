package com.rasa.model;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

public class Repair {
    private String NICno;
    private String vehicleRegistrationNo;
    private String entryDate;
    private String accidentDate;
    private String paymentType;
    private boolean customerNoObjection;
    private boolean leasingNoObjection;
    private boolean claimForm;
    private String progress;
    private int repairId;

    public Repair() {
    }

    public Repair(String NICno, String vehicleRegistrationNo, String entryDate, String accidentDate, String paymentType, boolean customerNoObjection, boolean leasingNoObjection, boolean claimForm) {
        this.NICno = NICno;
        this.vehicleRegistrationNo = vehicleRegistrationNo;
        this.entryDate = entryDate;
        this.accidentDate = accidentDate;
        this.paymentType = paymentType;
        this.customerNoObjection = customerNoObjection;
        this.leasingNoObjection = leasingNoObjection;
        this.claimForm = claimForm;
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

    public boolean isCustomerNoObjection() {
        return customerNoObjection;
    }

    public void setCustomerNoObjection(boolean customerNoObjection) {
        this.customerNoObjection = customerNoObjection;
    }

    public boolean isLeasingNoObjection() {
        return leasingNoObjection;
    }

    public void setLeasingNoObjection(boolean leasingNoObjection) {
        this.leasingNoObjection = leasingNoObjection;
    }

    public boolean isClaimForm() {
        return claimForm;
    }

    public void setClaimForm(boolean claimForm) {
        this.claimForm = claimForm;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }
}
