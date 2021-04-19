package com.rasa.model;

public class AvailableCars {

    private int registrationNumber;
    private String brand;
    private String model;
    private int numberOfSeats;
    private double pricePerDay;
    private String status;

    public AvailableCars() {

    }

    public AvailableCars(int registrationNumber, String brand, String model, int numberOfSeats, double pricePerDay) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.pricePerDay = pricePerDay;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getStatus() {
        return status;
    }
}
