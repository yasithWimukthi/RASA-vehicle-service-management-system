package com.rasa.model;

/**
 * RASA VIHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

public class Vehicle {
    private String NICno;
    private String registrationNo;
    private int year;
    private String model;
    private String brand;
    private String color;

    public Vehicle(
            String NICno,
            String registrationNo,
            int year,
            String model,
            String brand,
            String color
    ) {
        this.NICno = NICno;
        this.registrationNo = registrationNo;
        this.year = year;
        this.model = model;
        this.brand = brand;
        this.color = color;
    }

    public Vehicle(String registrationNo, int year, String model, String brand, String color) {
        this.registrationNo = registrationNo;
        this.year = year;
        this.model = model;
        this.brand = brand;
        this.color = color;
    }

    public String getNICno() {
        return NICno;
    }

    public void setNICno(String NICno) {
        this.NICno = NICno;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "Customer NIC Number='" + NICno + '\'' +
                ",Vehicle Registration Number='" + registrationNo + '\'' +
                ", Year=" + year +
                ", Model='" + model + '\'' +
                ", Brand='" + brand + '\'' +
                ", Color='" + color + '\'' +
                '}';
    }
}
