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

            preparedStatement.setString(QueryConstants.COLUMN_ONE,nic);

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
}
