package com.rasa.service;

import com.rasa.model.Repair;
import com.rasa.util.CustomerManagementQuery;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.QueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

public class ServiceEntry implements IServiceEntry{

    /** REFERENCE FOR CONNECTION **/
    private static Connection conn;

    private PreparedStatement preparedStatement;

    @Override
    public boolean addServiceEntry(String registrationNumber, String ServiceType, String entryDate, String accidentDate, boolean customerNoObjection, boolean insuranceNoObjection, boolean claimForm) {

        try {
            conn = DBConnectionUtil.getConnection();
            String sql = "";

            if (ServiceType.equals("insurance")){
                sql = CustomerManagementQuery.ADD_CASH_SERVICE;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(QueryConstants.COLUMN_ONE,registrationNumber);
                preparedStatement.setString(QueryConstants.COLUMN_TWO,entryDate);
                preparedStatement.setString(QueryConstants.COLUMN_THREE,accidentDate);
            }else {
                sql = CustomerManagementQuery.ADD_INSURANCE_SERVICE;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(QueryConstants.COLUMN_ONE,registrationNumber);
                preparedStatement.setString(QueryConstants.COLUMN_TWO,entryDate);
                preparedStatement.setString(QueryConstants.COLUMN_THREE,accidentDate);
                preparedStatement.setBoolean(QueryConstants.COLUMN_FOUR,customerNoObjection);
                preparedStatement.setBoolean(QueryConstants.COLUMN_FIVE,insuranceNoObjection);
                preparedStatement.setBoolean(QueryConstants.COLUMN_SIX,claimForm);
            }

            preparedStatement.execute();

        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
            return false;
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }
        return true;
    }

    @Override
    public Repair searchByRegistrationNumber(String registrationNumber) {
        Repair repair = new Repair();

        try {
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.SEARCH_ENTRY_BY_REG_NUM;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(QueryConstants.COLUMN_ONE,registrationNumber.toLowerCase());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                repair.setVehicleRegistrationNo(resultSet.getString("registrationNumber"));
                repair.setEntryDate(resultSet.getString("entryDate"));
                repair.setAccidentDate(resultSet.getString("accidentDate"));
                repair.setCustomerNoObjection(resultSet.getBoolean("customerNoObjection"));
                repair.setLeasingNoObjection(resultSet.getBoolean("insuranceNoObjection"));
                repair.setClaimForm(resultSet.getBoolean("claimForm"));
            }

        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }

        return repair;
    }
}
