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

    /**
     * addVehicle
     * save vehicle details into the vehicle table
     * @param registrationNumber
     * @param manufacturedYear
     * @param brand
     * @param model
     * @param color
     * @param NICnumber
     * @return return true if added successfully otherwise false
     */
    boolean addVehicle(
            String registrationNumber,
            int manufacturedYear,
            String brand,
            String model,
            String color,
            String NICnumber
    );

    /**
     * updateVehicle
     * update existing vehicle details
     * @param registrationNumber
     * @param manufacturedYear
     * @param brand
     * @param model
     * @param color
     * @param NICnumber
     * @return return true if update successfully otherwise false
     */
    boolean updateVehicle(
            String registrationNumber,
            int manufacturedYear,
            String brand,
            String model,
            String color,
            String NICnumber
    );
}
