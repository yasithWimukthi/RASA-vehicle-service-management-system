package com.rasa.model;

public class Rent {

    private int RentID;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;
    private String pickUpDate;
    private String dropOffDate;
    private Double rentalPrice;
    private int operatorID;
    private int registrationNo;

    public Rent() {

    }

    public Rent(String firstName, String lastName, String email, String mobile, String address, String pickUpDate, String dropOffDate, Double rentalPrice, int registrationNo, int operatorID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.rentalPrice = rentalPrice;
        this.registrationNo = registrationNo;
        this.operatorID = operatorID;
    }

    public int getRentID() {
        return RentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public int getOperatorID() {
        return operatorID;
    }

    public int getRegistrationNo() {
        return registrationNo;
    }

    public void setRentID(int rentID) {
        RentID = rentID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    public void setRegistrationNo(int registrationNo) {
        this.registrationNo = registrationNo;
    }

}
