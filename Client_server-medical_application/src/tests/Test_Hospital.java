package tests;

import domain.AccountH;
import domain.Gender;
import domain.Hospital;
import domain.Patient;
import exceptions.ERR;
import services.HospitalService;
import org.junit.Test;
import services.Statistics;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test_Hospital {


    @Test
    public void testHospital() throws ERR {

        Hospital hospital = new Hospital();

        Patient patient = new Patient(Gender.Male, "Ioan", "Gheorghe", 1,"Timisoara", 1234567890, "pavel.gheorghe@gmail.com");
        patient.addAccount(new AccountH(1, "Nutritie necorespunzatoare",1,3,3));

        Patient patient2 = new Patient(Gender.Female, "Ioana", "Gheorghe", 1,"Bucuresti", 1234567899, "andreea.gheorghe@gmail.com");
        patient2.addAccount(new AccountH(2, "Durere lombara", 2, 1, 0));

        HospitalService.addPatient(hospital, patient);
        HospitalService.addPatient(hospital, patient2);

        assertEquals(2, hospital.getPatientsOnAdded().size());

        List<Patient> patientList = new ArrayList<>(hospital.getPatientsOnAdded());
        assertEquals("Mr.  Ioan Gheorghe", patientList.get(0).getPatientsGreeting());
        assertEquals("Mr. Ioan Gheorghe", patientList.get(0).toString());
        assertEquals("Ms.  Ioana Gheorghe", patientList.get(1).getPatientsGreeting());
        assertEquals("Ms. Ioana Gheorghe", patientList.get(1).toString());


    }
}
