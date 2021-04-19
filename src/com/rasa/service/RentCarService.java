package com.rasa.service;
import com.rasa.model.AvailableCars;
import com.rasa.model.Rent;
import com.rasa.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentCarService implements IRentCarService{


    @Override
    public boolean insertRentalDetails(Rent rent) throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();
        String insertQuery = "INSERT INTO `rasa`.`rent` (`firstName`, `lastName`, `email`, `phone`, `address`, `pickUpDate`, `dropOffDate`, `rentalPrice`, `registrationNumber`, `operaterID`) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

        preparedStatement.setString(1, rent.getFirstName());
        preparedStatement.setString(2, rent.getLastName());
        preparedStatement.setString(3, rent.getEmail());
        preparedStatement.setString(4, rent.getMobile());
        preparedStatement.setString(5, rent.getAddress());
        preparedStatement.setString(6, rent.getPickUpDate());
        preparedStatement.setString(7, rent.getDropOffDate());
        preparedStatement.setDouble(8, rent.getRentalPrice());
        preparedStatement.setInt(9, rent.getRegistrationNo());
        preparedStatement.setInt(10, rent.getOperatorID());

        boolean isSuccess = preparedStatement.execute();

        System.out.println(isSuccess);
        return isSuccess;

    }

    @Override
    public ArrayList<Rent> retrieveRentalDetails() throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();

        ArrayList<Rent> list = new ArrayList<>();

        String selectQuery = "SELECT `rent`.`rentID`, `rent`.`firstName`, `rent`.`lastName`, `rent`.`email`, `rent`.`phone`, `rent`.`address`, `rent`.`pickUpDate`, `rent`.`dropOffDate`, `rent`.`rentalPrice`, `rent`.`registrationNumber` FROM `rasa`.`rent`;";
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            Rent rent = new Rent();

            rent.setRentID(rs.getInt(1));
            rent.setFirstName(rs.getString(2));
            rent.setLastName(rs.getString(3));
            rent.setEmail(rs.getString(4));
            rent.setMobile(rs.getString(5));
            rent.setAddress(rs.getString(6));
            rent.setPickUpDate(rs.getString(7));
            rent.setDropOffDate(rs.getString(8));
            rent.setRentalPrice(rs.getDouble(9));
            rent.setRegistrationNo(rs.getInt(10));

            list.add(rent);

        }
        return list;
    }

    @Override
    public ArrayList<AvailableCars> retrieveAvailableCars() throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();

        ArrayList<AvailableCars> list = new ArrayList<>();

        String selectQuery = "SELECT `rentalvehicle`.`RegistrationNumber`, `rentalvehicle`.`brand`, `rentalvehicle`.`model`, `rentalvehicle`.`NoOfsheets`, `rentalvehicle`.`rentalPrice` FROM `rasa`.`rentalvehicle`;";
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            AvailableCars availableCars = new AvailableCars();

            availableCars.setRegistrationNumber(rs.getInt(1));
            availableCars.setBrand(rs.getString(2));
            availableCars.setModel(rs.getString(3));
            availableCars.setNumberOfSeats(rs.getInt(4));
            availableCars.setPricePerDay(rs.getDouble(5));
            //availableCars.setStatus(rs.getString(6));

            list.add(availableCars);

        }

        return list;

    }

    @Override
    public Rent retrieveDataByRentID(int RentID) throws SQLException, ClassNotFoundException {

        Connection con = DBConnectionUtil.getConnection();
        String selectQuery = "SELECT `rent`.`rentID`, `rent`.`firstName`, `rent`.`lastName`, `rent`.`email`, `rent`.`phone`, `rent`.`address`, `rent`.`pickUpDate`, `rent`.`dropOffDate`, `rent`.`rentalPrice`, `rent`.`registrationNumber` FROM `rasa`.`rent` WHERE `rent`.`rentID`=?;";
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);

        preparedStatement.setInt(1, RentID);
        ResultSet rs = preparedStatement.executeQuery();

        Rent rent = new Rent();

        while(rs.next()){

            rent.setRentID(rs.getInt(1));
            rent.setFirstName(rs.getString(2));
            rent.setLastName(rs.getString(3));
            rent.setEmail(rs.getString(4));
            rent.setMobile(rs.getString(5));
            rent.setAddress(rs.getString(6));
            rent.setPickUpDate(rs.getString(7));
            rent.setDropOffDate(rs.getString(8));
            rent.setRentalPrice(rs.getDouble(9));
            rent.setRegistrationNo(rs.getInt(10));

        }

        return rent;

    }

    @Override
    public boolean updateRentDetails(Rent rent) throws SQLException, ClassNotFoundException {
        Connection con = DBConnectionUtil.getConnection();

        String updateQuery = "UPDATE `rasa`.`rent` SET `rentID` = ?, `firstName` = ?, `lastName` = ?, `email` = ?, `phone` = ?, `address` = ?, `pickUpDate` = ?, `dropOffDate` = ?, `rentalPrice` = ?, `registrationNumber` = ? WHERE `rentID` = ?";
        PreparedStatement preparedStatement = con.prepareStatement(updateQuery);

        preparedStatement.setInt(1, rent.getRentID());
        preparedStatement.setString(2, rent.getFirstName());
        preparedStatement.setString(3, rent.getLastName());
        preparedStatement.setString(4, rent.getEmail());
        preparedStatement.setString(5, rent.getMobile());
        preparedStatement.setString(6, rent.getAddress());
        preparedStatement.setString(7, rent.getPickUpDate());
        preparedStatement.setString(8, rent.getDropOffDate());
        preparedStatement.setDouble(9, rent.getRentalPrice());
        preparedStatement.setInt(10, rent.getRegistrationNo());
        preparedStatement.setInt(11, rent.getRentID());

        int result = preparedStatement.executeUpdate();

        if(result == 1){
            return true;
        }
        else{
            return false;
        }

    }


}
