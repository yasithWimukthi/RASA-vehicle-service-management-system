package com.rasa.service;

import com.rasa.model.AvailableCars;
import com.rasa.model.Rent;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRentCarService {

    public boolean insertRentalDetails(Rent rent) throws SQLException, ClassNotFoundException;

    public ArrayList<Rent> retrieveRentalDetails() throws SQLException, ClassNotFoundException;

    public ArrayList<AvailableCars> retrieveAvailableCars() throws SQLException, ClassNotFoundException;

    public Rent retrieveDataByRentID(int RentID) throws SQLException, ClassNotFoundException;

    public boolean updateRentDetails(Rent rent) throws SQLException, ClassNotFoundException;

    public boolean deleteRentalDetails(int rentID) throws SQLException, ClassNotFoundException;

}
