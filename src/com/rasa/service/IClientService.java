package com.rasa.service;
/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

import com.rasa.model.Customer;

public interface IClientService {

    /**
     * searchByNic
     * search customer for given NIC number
     * @param nic
     * @return Customer
     */
    Customer searchByNic(String nic);

    /**
     * addCustomer
     * Save customer details into the client table
     *
     * @param nic
     * @param fname
     * @param lname
     * @param mobile
     * @param address
     * @param email
     * @return True if operation is success otherwise false
     */
    boolean addCustomer(
            String nic,
            String fname,
            String lname,
            String mobile,
            String address,
            String email,
            String operatorID
    );

    /**
     * updateCustomer
     * update existing customer details
     * @param nic
     * @param fname
     * @param lname
     * @param mobile
     * @param address
     * @param email
     * @return return true if operation is success otherwise false
     */
    boolean updateCustomer(
            String nic,
            String fname,
            String lname,
            String mobile,
            String address,
            String email
    );
}
