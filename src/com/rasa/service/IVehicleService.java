package com.rasa.service;

import com.rasa.model.Vehicle;

/**
 * RASA VEHICLE SERVICE MANAGEMENT SYSTEM
 *
 * @author Yasith Wimukthi
 * IT19966922
 **/

public interface IVehicleService {
    /**
     * searchByRegistrationNumber
     * search vehicle for given registration number
     * @param registrationNum
     * @return Vehicle object
     */
    Vehicle searchByRegistrationNumber(String registrationNum);
}
