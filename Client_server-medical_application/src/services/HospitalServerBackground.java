package services;

import domain.*;
import exceptions.ERR;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HospitalServerBackground {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    Hospital hospital = new Hospital();

    public void modifyDataBaseOfHospital() {

        Patient ComanMaria = new Patient(Gender.Female, "Maria-Laura", "Coman", 1,"Bucuresti", 770985302, "maria.coman@gmail.com");
        AccountH account1 = new AccountH(1, "Viroza", 1, 3, 0);
        Patient ComanIoan = new Patient(Gender.Male, "Ioan", "Coman", 2,"Bucuresti", 773889233, "");
        AccountH account2 = new AccountH(2, "Ruptura de menisc", 2, 1, 1);
        AccountH account22 = new AccountH(2, "Hernie de disc", 22, 1, 2);
        Patient ComanIlie = new Patient(Gender.Male, "Ilie", "Coman", 3,"Cluj", 771421001, "ilie.coman@gmail.com");
        AccountH account3 = new AccountH(3, "Entorsa", 3, 2, 1);
        Patient ComanMadalinaOfelia = new Patient(Gender.Female, "Madalina-Ofelia", "Coman", 4,"Pitesti", 773889279, "ofelia.coman@gmail.com");
        AccountH account4 = new AccountH(4, "Steatoza", 4, 2, 3);
        Patient ComanAurel = new Patient(Gender.Male, "Aurel", "Coman", 5,"Pitesti", 773889228, "aurel.coman@gmail.com");
        AccountH account5 = new AccountH(5, "Hernie de disc", 5, 1, 1);

        ComanMaria.addAccount(account1);
        ComanIoan.addAccount(account2);
        ComanIoan.addAccount(account22);
        ComanIlie.addAccount(account3);
        ComanMadalinaOfelia.addAccount(account4);
        ComanAurel.addAccount(account5);
        ComanIoan.setImplicitEmail();

        try {
            HospitalService.addPatient(hospital, ComanMaria);
        } catch (ERR e){
            LOGGER.log(Level.SEVERE, "Cannot add an already existing patient: %s%n", ComanMaria.getName());
        }

        try {
            HospitalService.addPatient(hospital, ComanIoan );
        } catch (ERR e) {
            LOGGER.log(Level.SEVERE, "Cannot add an already existing patient: %s%n", ComanIoan.getName());
        }

        try {
            HospitalService.addPatient(hospital, ComanIlie);
        } catch (ERR e) {
            LOGGER.log(Level.SEVERE, "Cannot add an already existing patient: %s%n", ComanIlie.getName());
        }

        try {
            HospitalService.addPatient(hospital, ComanMadalinaOfelia);
        } catch (ERR e) {
            LOGGER.log(Level.SEVERE, "Cannot add an already existing patient: %s%n", ComanMadalinaOfelia.getName());
        }

        try {
            HospitalService.addPatient(hospital, ComanAurel);
        } catch (ERR e) {
            LOGGER.log(Level.SEVERE, "Cannot add an already existing patient: %s%n", ComanAurel.getName());
        }
    }

}
