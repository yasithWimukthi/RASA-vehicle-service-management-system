package com.rasa.model;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/


public class InsuranceService extends Service{
    private boolean customerNoObjection;
    private boolean leasingNoObjection;
    private boolean claimForm;

    public InsuranceService() {
    }

    public InsuranceService(
            String NICno,
            String vehicleRegistrationNo,
            String entryDate,
            String accidentDate,
            String paymentType,
            boolean customerNoObjection,
            boolean leasingNoObjection,
            boolean claimForm) {
        super(NICno, vehicleRegistrationNo, entryDate, accidentDate, paymentType);
        this.customerNoObjection = customerNoObjection;
        this.leasingNoObjection = leasingNoObjection;
        this.claimForm = claimForm;
    }

    public InsuranceService(
            String entryDate,
            String accidentDate,
            String paymentType,
            boolean customerNoObjection,
            boolean leasingNoObjection,
            boolean claimForm) {
        super(entryDate, accidentDate, paymentType);
        this.customerNoObjection = customerNoObjection;
        this.leasingNoObjection = leasingNoObjection;
        this.claimForm = claimForm;
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
}
