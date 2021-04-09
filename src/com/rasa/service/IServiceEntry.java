package com.rasa.service;

import com.rasa.model.Service;

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
    Service searchByRegistrationNumber(String registrationNumber);
}
