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
}
