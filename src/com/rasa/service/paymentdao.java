package com.rasa.service;


import com.rasa.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rasa.model.paymentList;

public class paymentdao {


    public paymentdao() {

    }
    static Connection connection;
    // method for insert payments
    public static void addPayment(paymentList paymentlist) throws SQLException {

        try{
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO rasa.payment "+" (vehicleRegiNo,customerName,estimateAmount,cash,paymentDate)VALUES "+" (?,?,?,?,?)");
            preparedStatement.setString(1,paymentlist.getVehicleRegiNo());
            preparedStatement.setString(2,paymentlist.getCustomerName());
            preparedStatement.setDouble(3,paymentlist.getEstimateAmount());

            preparedStatement.setDouble(4,paymentlist.getCash());
            preparedStatement.setDate(5, paymentlist.getPaymentDate());

            System.out.println(preparedStatement);
            preparedStatement.executeLargeUpdate();

        }catch(SQLException | ClassNotFoundException e){

            printSQLException((SQLException) e);

        }


    }

    public paymentList selectPayment(int payId){
        paymentList paymentlist=null;

        try{
            connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT payId,vehicleRegiNo,customerName,estimateAmount,claimAmount,cash,paymentDate FROM rasa.payment WHERE payId = ?");
            preparedStatement.setInt(1,payId);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                String vehicleRegiNo = rs.getString("vehicleRegiNo");
                String customerName = rs.getString("customerName");
                double estimateAmount = rs.getDouble("estimateAmount");

                double cash = rs.getDouble("cash");
                Date paymentDate= rs.getDate("paymentDate");

                paymentlist = new paymentList(payId,vehicleRegiNo,customerName,estimateAmount,cash,paymentDate);
            }
            System.out.println(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return paymentlist;

    }

    public static List<paymentList> selectAllPayment(){

        List<paymentList> pays = new ArrayList<>();

        try{
            connection = DBConnectionUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM rasa.payment");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int payId = rs.getInt("payId");
                String vehicleRegiNo = rs.getString("vehicleRegiNo");
                String customerName = rs.getString("customerName");
                double estimateAmount = rs.getDouble("estimateAmount");

                double cash = rs.getDouble("cash");
                Date paymentDate = rs.getDate("paymentDate");

                pays.add(new paymentList(payId,vehicleRegiNo,customerName,estimateAmount,cash,paymentDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return pays;
    }


    //method for delete payment
    public  boolean deletePayment(int payId)throws SQLException{
        paymentList paymentlist=null;
        boolean rowDeleted = false;
        try {

            connection = DBConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM rasa.payment WHERE payId = ?");
            System.out.println(statement);

            statement.setInt(1,payId);
            //use to update the query
            rowDeleted = statement.executeUpdate() > 0;//return number of rows deleted
        }catch (SQLException | ClassNotFoundException e) {
            printSQLException((SQLException) e);
        }
        return rowDeleted;


    }



    public static boolean updatePayment(paymentList paymentlist) throws SQLException {
        boolean rowUpdated = false;
        try {


            connection = DBConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE payment set vehicleRegiNo = ?,customerName = ?,estimateAmount = ?,cash = ? ,paymentDate = ? where payId = ?");

            statement.setString(1, paymentlist.getVehicleRegiNo());
            statement.setString(2,paymentlist.getCustomerName());
            statement.setDouble(3, paymentlist.getEstimateAmount());

            statement.setDouble(4,paymentlist.getCash());
            statement.setDate(5,paymentlist.getPaymentDate());

            statement.setInt(6, paymentlist.getPayId());
            System.out.println(statement);

            rowUpdated = statement.executeUpdate() > 0;//return number of rows updated
        }catch (SQLException | ClassNotFoundException e) {
            printSQLException((SQLException) e);
        }
        return rowUpdated;
    }



    private static void printSQLException(SQLException ex) {
        for(Throwable e:ex)
            if (e instanceof SQLException) {

                e.printStackTrace(System.err);
                System.err.println("SQLState:" + ((SQLException) e).getSQLState());
                System.err.println("Error Code:" + ((SQLException) e).getErrorCode());
                System.err.println("Message:" + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }

            }
    }



}







