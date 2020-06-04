package utils;

import domain.Patient;

public interface PatientRegistrationListener {
    void onPatientAdded (Patient patient);
}
