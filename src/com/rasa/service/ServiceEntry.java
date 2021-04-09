package com.rasa.service;

import com.rasa.model.InsuranceService;
import com.rasa.model.Service;
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

            if (ServiceType == "insurance"){
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
    public Service searchByRegistrationNumber(String registrationNumber) {
        Service service;

        try {
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.SEARCH_ENTRY_BY_REG_NUM;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(QueryConstants.COLUMN_ONE,registrationNumber.toLowerCase());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                service = new InsuranceService(

                );
            }

        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }

        return null;
    }
}
