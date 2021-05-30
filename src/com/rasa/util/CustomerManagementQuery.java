package com.rasa.util;

public class CustomerManagementQuery {
    public static final String SEARCH_CLIENT_BY_NIC = "SELECT * FROM client WHERE NICnumber = ?";
    public static final String ADD_CUSTOMER = "INSERT INTO client (NICnumber,firstName,lastName,email,address,mobile,OperatorID) VALUES (?,?,?,?,?,?,?) ";
    public static final String SEARCH_VEHICLE_BY_REGISTRATION_NUMBER = "SELECT * FROM vehicle WHERE registrationNumber = ? " ;
    public static final String ADD_VEHICLE = "INSERT INTO vehicle (registrationNumber,manufacturedYear,brand,model,color) VALUES (?,?,?,?,?) " ;
    public static final String ADD_OWNER = "INSERT INTO veicleOwner (NICnumber,registrationNumber) VALUES (?,?) " ;
    public static final String ADD_CASH_SERVICE = "INSERT INTO service (registrationNumber,entryDate,accidentDate,type,NICnumber,progress) VALUES (?,?,?,?,?,?)" ;
    public static final String ADD_INSURANCE_SERVICE = "INSERT INTO service (registrationNumber,entryDate,accidentDate,customerNoObjection,insuranceNoObjection,claimForm,type,NICnumber,progress) VALUES(?,?,?,?,?,?,?,?,?)" ;
    public static final String SEARCH_ENTRY_BY_REG_NUM = "SELECT * FROM service where registrationNumber = ? " ;
    public static final String UPDATE_CLIENT = "UPDATE client SET firstName = ?, lastName = ?, email = ?, address = ?, mobile = ? WHERE NICnumber = ? " ;
    public static final String UPDATE_VEHICLE = "UPDATE vehicle SET manufacturedYear = ?, brand = ?, model = ?, color = ? WHERE registrationNumber = ?" ;
    public static final String SEARCH_ENTRY_BY_NIC_NUM = "SELECT * FROM service,veicleOwner WHERE service.registrationNumber = veicleOwner.registrationNumber AND veicleOwner.NICnumber = ? " ;
    public static final String ADD_INSURANCE_SERVICE_ENTRY = "INSERT INTO service (registrationNumber,entryDate,accidentDate,customerNoObjection,insuranceNoObjection,claimForm) VALUES (?,?,?,?,?,?)" ;
    public static final String ADD_NORMAL_SERVICE_ENTRY = "INSERT INTO service (registrationNumber,entryDate,accidentDate) VALUES (?,?,?)" ;
    public static final String GET_SERVICE_BY_SERVICE_ID = "SELECT * FROM service WHERE serivceID = ? " ;
    public static final String DELETE_SERVICE_ENTRY = "DELETE FROM service WHERE serivceID = ? " ;
    public static final String UPDATE_CASH_SERVICE_ENTRY = "UPDATE service SET entryDate=?, accidentDate=? WHERE serivceID=? " ;
    public static final String UPDATE_INSURANCE_SERVICE_ENTRY = "UPDATE service SET entryDate=?, accidentDate=?, customerNoObjection=?, insuranceNoObjection=?, claimForm=? WHERE serivceID=? " ;
}
