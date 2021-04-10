package com.rasa.service;
/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

import com.rasa.model.Customer;
import com.rasa.util.CustomerManagementQuery;
import com.rasa.util.DBConnectionUtil;
import com.rasa.util.QueryConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientService implements IClientService{

    /** REFERENCE FOR CONNECTION **/
    private static Connection conn;

    private PreparedStatement preparedStatement;


    @Override
    public Customer searchByNic(String nic) {
        Customer customer = new Customer();

        try{
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.SEARCH_CLIENT_BY_NIC;
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(QueryConstants.COLUMN_ONE,nic.toUpperCase());

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                customer.setNICno(resultSet.getString("NICnumber"));
                customer.setFirstName(resultSet.getString("firstName"));
                customer.setLastName(resultSet.getString("lastName"));
                customer.setAddress(resultSet.getString("address"));
                customer.setPhoneNo(resultSet.getString("mobile"));
                customer.setEmail(resultSet.getString("email"));
            }

        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }finally {
            DBConnectionUtil.closeConnection(preparedStatement, conn);
        }
        return customer;
    }


    @Override
    public boolean addCustomer(String nic, String fname, String lname, String mobile, String address, String email,String operatorID) {

        try{
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.ADD_CUSTOMER;
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(QueryConstants.COLUMN_ONE,nic.toUpperCase());
            preparedStatement.setString(QueryConstants.COLUMN_TWO,fname);
            preparedStatement.setString(QueryConstants.COLUMN_THREE,lname);
            preparedStatement.setString(QueryConstants.COLUMN_FOUR,email);
            preparedStatement.setString(QueryConstants.COLUMN_FIVE,address);
            preparedStatement.setString(QueryConstants.COLUMN_SIX,mobile);
            preparedStatement.setString(QueryConstants.COLUMN_SEVEN,operatorID);

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
    public boolean updateCustomer(String nic, String fname, String lname, String mobile, String address, String email) {

        try {
            conn = DBConnectionUtil.getConnection();
            String sql = CustomerManagementQuery.UPDATE_CLIENT;
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(QueryConstants.COLUMN_ONE,fname);
            preparedStatement.setString(QueryConstants.COLUMN_TWO,lname);
            preparedStatement.setString(QueryConstants.COLUMN_THREE,email);
            preparedStatement.setString(QueryConstants.COLUMN_FOUR,address);
            preparedStatement.setString(QueryConstants.COLUMN_FIVE,mobile);
            preparedStatement.setString(QueryConstants.COLUMN_SIX,nic.toUpperCase());

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
