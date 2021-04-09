package com.rasa.service;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

import com.rasa.model.Vehicle;
import com.rasa.util.CustomerManagementQuery;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.QueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleService implements IVehicleService{

    /** REFERENCE FOR CONNECTION **/
    private static Connection conn;

    private PreparedStatement preparedStatement;

    @Override
    public Vehicle searchByRegistrationNumber(String registrationNum) {

        Vehicle vehicle = new Vehicle();

        try {
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.SEARCH_VEHICLE_BY_REGISTRATION_NUMBER;
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(QueryConstants.COLUMN_ONE,registrationNum);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                vehicle.setRegistrationNo(resultSet.getString("registrationNumber"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setYear(resultSet.getInt("manufacturedYear"));

            }

        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }

        return vehicle;
    }

    @Override
    public boolean addVehicle(String registrationNumber, int manufacturedYear, String brand, String model, String color, String NICnumber) {

        try {
            conn = DBConnectionUtil.getConnection();

            //add vehicle details
            String sql = CustomerManagementQuery.ADD_VEHICLE;
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(QueryConstants.COLUMN_ONE,registrationNumber.toLowerCase());
            preparedStatement.setInt(QueryConstants.COLUMN_TWO,manufacturedYear);
            preparedStatement.setString(QueryConstants.COLUMN_THREE,brand);
            preparedStatement.setString(QueryConstants.COLUMN_FOUR,model);
            preparedStatement.setString(QueryConstants.COLUMN_FIVE,color);
            preparedStatement.execute();

            // add owner details
            sql = CustomerManagementQuery.ADD_OWNER;
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(QueryConstants.COLUMN_ONE,NICnumber);
            preparedStatement.setString(QueryConstants.COLUMN_TWO,registrationNumber);
            preparedStatement.execute();

        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
            return false;

        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }
        return true;
    }
}
