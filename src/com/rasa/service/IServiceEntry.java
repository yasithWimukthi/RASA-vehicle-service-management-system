package com.rasa.service;

import com.itextpdf.text.DocumentException;
import com.rasa.model.Customer;
import com.rasa.model.Repair;
import com.rasa.model.Vehicle;

import java.io.IOException;
import java.sql.SQLException;
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
     * @return Service object for given registration number
     */
    Repair getRepairByServiceID(int serviceID);

    /**
     * deleteServiceEntry
     * delete service entry of given service ID
     * @param serviceID
     * @return return true if delete successfully, otherwise false
     */
    Boolean deleteServiceEntry(int serviceID);

    /**
     * update service entry of given service id
     * @param serviceID
     * @return return true if delete successfully, otherwise false
     */
    Boolean updateServiceEntry(
            int serviceID,
            String ServiceType,
            String entryDate,
            String accidentDate,
            boolean  customerNoObjection,
            boolean insuranceNoObjection,
            boolean claimForm
    ) ;

    /**
     * generate detailed report about service
     * @param customer
     * @param vehicle
     * @param repair
     * @return
     */
    boolean generateServiceReport(Customer customer, Vehicle vehicle,Repair repair)  throws IOException, DocumentException, SQLException, ClassNotFoundException;
}
