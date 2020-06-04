package services;

import domain.Hospital;
import domain.Patient;
import exceptions.ERR;

public class HospitalService {
    public static void addPatient(Hospital hospital, Patient patient)throws ERR {
        hospital.addPatient(patient);
    }

}
