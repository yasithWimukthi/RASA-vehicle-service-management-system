package com.rasa.model;

public class Item {
    private String ItemCode;
    private String itemName;
    private double price;
    private int quantity;
    private String date;
    private String supplyName;
    private int supplerID;

    public int getSupplerID() {
        return supplerID;
    }

    public void setSupplerID(int supplerID) {
        this.supplerID = supplerID;
    }

    public Item(String itemName, double price, int quantity, String date, int supplerID) {

        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
        this.supplerID = supplerID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }



    public Item() {
    }

    public Item(String itemCode, String itemName, double price, int quntity, String supplyName,String date) {
        ItemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quntity;
        this.supplyName = supplyName;
        this.date = date;

    }

    public Item(String itemName, double price, int quntity, String supplyName,String date) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quntity;
        this.supplyName = supplyName;
        this.date = date;

    }

    public String getItemCode() {
        return ItemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getsupplyName() {
        return supplyName;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSupplerName(String supplyName) {
        this.supplyName = supplyName;
    }
}
