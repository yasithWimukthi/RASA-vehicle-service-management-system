package com.rasa.service;

import com.itextpdf.text.DocumentException;
import com.rasa.model.AvailableCars;
import com.rasa.model.Customer;
import com.rasa.model.Rent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
//import com.itextpdf.text.DocumentException;

public interface IRentCarService {

    public boolean insertRentalDetails(Rent rent) throws SQLException, ClassNotFoundException;

    public ArrayList<Rent> retrieveRentalDetails() throws SQLException, ClassNotFoundException;

    public ArrayList<AvailableCars> retrieveAvailableCars() throws SQLException, ClassNotFoundException;

    public Rent retrieveDataByRentID(int RentID) throws SQLException, ClassNotFoundException;

    public boolean updateRentDetails(Rent rent) throws SQLException, ClassNotFoundException;

    public boolean deleteRentalDetails(int rentID) throws SQLException, ClassNotFoundException;

    public ArrayList<AvailableCars> searchByBrand(String brand) throws SQLException, ClassNotFoundException;

    public boolean createRentalDetailsPdf(ArrayList<Rent> rent, int year, int month) throws IOException, DocumentException, SQLException, ClassNotFoundException;

    public ArrayList<Rent> retrieveRentalDetailsByYearAndMonth(int year, int month) throws SQLException, ClassNotFoundException;

    public String month(int month);

}
