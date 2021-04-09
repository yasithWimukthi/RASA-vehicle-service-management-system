package com.rasa.service;

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
}
