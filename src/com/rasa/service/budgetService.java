package com.rasa.service;

import com.rasa.model.Budget;
import com.rasa.util.DBConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class budgetService {

    static Connection connection;


    public double CalRepairAmount(String year,String month) {
        double repairAmount = 0;
        double totalAmount = 0;
        try {
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT cash FROM rasa.payment WHERE EXTRACT(year FROM paymentDate) =? AND EXTRACT(month FROM paymentDate) = ?; ");

            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                repairAmount = resultSet.getDouble(1);
                totalAmount = totalAmount + repairAmount;

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return totalAmount;
    }


    public double calRentals(String year,String month){
        double rentalAmount = 0;
        double totalRentalAmount= 0;

        try{
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT rentalPrice FROM rasa.rent WHERE EXTRACT(year FROM dropOffDate) =? AND EXTRACT(month FROM dropOffDate) = ?; ");


            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                rentalAmount = resultSet.getDouble(1);
                totalRentalAmount = totalRentalAmount +  rentalAmount;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return totalRentalAmount;

    }

    public double calEmpPayments(String year,String month){
        double empPayments = 0;
        double totalEmpPayments= 0;
        try{
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT amount FROM employeepayment  WHERE  EXTRACT(year FROM date) =? AND EXTRACT(month FROM date) = ?;");

            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                empPayments = resultSet.getDouble(1);
                totalEmpPayments = totalEmpPayments +  empPayments;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return totalEmpPayments;
    }



    public double calInventoryExpenses(String year,String month){
            double inventoryExpenses = 0;
            double totalInventoryExpenses= 0;
        try{
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT (price * quntity) FROM rasa.item WHERE EXTRACT(year FROM date) =? AND EXTRACT(month FROM date) = ?;");

            preparedStatement.setString(1, year);
            preparedStatement.setString(2, month);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                inventoryExpenses = resultSet.getDouble(1);
                totalInventoryExpenses = totalInventoryExpenses + inventoryExpenses;

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  totalInventoryExpenses;


    }


        public Budget AllMethods(String year, String month){
            System.out.println(year+month);
            Double CalRepairAmount = CalRepairAmount(year,month);
            Double calRentals = calRentals(year,month);
            Double calInventoryExpenses = calInventoryExpenses(year,month);
            Double calEmpPayments = calEmpPayments(year,month);


            Double totIncome = CalRepairAmount + calRentals;
            Double totExpenses = calInventoryExpenses + calEmpPayments;
            Double profit = totIncome - totExpenses;
            Budget bd = new Budget(totIncome,CalRepairAmount,calRentals,totExpenses,calInventoryExpenses,calEmpPayments,profit);

            return bd;

      }
}
