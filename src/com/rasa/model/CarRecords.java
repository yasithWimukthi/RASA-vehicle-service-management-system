package com.rasa.model;

public class CarRecords {

    private int regNumber;
    private String fname;
    private String lname;
    private String id;
    private String address;
    private int phone;
    private String email;
    private String bookNumber;
    private String model;
    private int seatAmount;
    private float distance;
    private String carType;

    public CarRecords(int regNumber, String fname, String lname,String id, String address,  int phone, String email, String bookNumber, String model, int seatAmount, float distance, String carType) {

        this.regNumber = regNumber;
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.bookNumber = bookNumber;
        this.model = model;
        this.seatAmount = seatAmount;
        this.distance = distance;
        this.carType = carType;
    }

    public CarRecords(String fname, String lname, String id, String address, int phone, String email, String bookNumber, String model, int seatAmount, float distance, String carType) {
        this.fname = fname;
        this.lname = lname;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.bookNumber = bookNumber;
        this.model = model;
        this.seatAmount = seatAmount;
        this.distance = distance;
        this.carType = carType;
    }

    //getters

    public int getRegNumber(){  return regNumber; }

    public String getFname() { return fname; }

    public String getLname() {
        return lname;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() { return email; }

    public String getBookNumber() {
        return bookNumber;
    }

    public String getModel() {
        return model;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public float getDistance() {
        return distance;
    }

    public String getCarType() {
        return carType;
    }

    //setters

    public void setRegNumber(int regNumber){ regNumber = regNumber ;}

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) { this.email = email; }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }


    public String getID() {
        return id;
    }
}





