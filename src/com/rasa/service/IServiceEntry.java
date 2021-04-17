package com.rasa.service;

import com.rasa.model.Repair;

import java.util.ArrayList;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

public interface IServiceEntry {

    /**
     * addServiceEntry
     * add service details into the service table
     * @param registrationNumber
     * @param ServiceType
     * @param entryDate
     * @param accidentDate
     * @param customerNoObjection
     * @param insuranceNoObjection
     * @param claimForm
     * @return return true if insert successfully, otherwise false
     */
    boolean addServiceEntry(
            String registrationNumber,
            String nic,
            String ServiceType,
            String entryDate,
            String accidentDate,
            boolean  customerNoObjection,
            boolean insuranceNoObjection,
            boolean claimForm
    );

    /**
     * searchByRegistrationNumber
     * search service entries by registration number
     * @param registrationNumber
     * @return Service object for given registration number
     */
    ArrayList<Repair> searchByRegistrationNumber(String registrationNumber);

    /**
     * searchByRegistrationNic
     * search service entries by NIC number
     * @param nicNumber
     * @return Service object for given nic number
     */
    ArrayList<Repair> searchByRegistrationNic(String nicNumber);

    /**
     * getRepairByServiceID
     * get repair details of given service id
     * @param serviceID
     * @return
     */
    Repair getRepairByServiceID(int serviceID);
}
