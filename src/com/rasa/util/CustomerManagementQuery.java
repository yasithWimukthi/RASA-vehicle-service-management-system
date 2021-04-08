package com.rasa.util;

public class CustomerManagementQuery {
    public static final String SEARCH_CLIENT_BY_NIC = "SELECT * FROM client WHERE NICnumber = ?";
    public static final String ADD_CUSTOMER = "INSERT INTO client (NICnumber,firstName,lastName,email,address,mobile,OperatorID) VALUES (?,?,?,?,?,?,?) ";
    public static final String SEARCH_VEHICLE_BY_REGISTRATION_NUMBER = "SELECT * FROM vehicle WHERE registrationNumber = ? " ;
}
