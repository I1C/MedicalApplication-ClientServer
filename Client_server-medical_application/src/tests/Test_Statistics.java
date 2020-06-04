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

public class Test_Statistics {

    Statistics statistics = new Statistics();

    @Test
    public void testHospital() throws ERR {

        Hospital hospital = new Hospital();

        Patient patient1 = new Patient(Gender.Male, "Pavel", "Gheorghe", 1,"Timisoara", 1234567890, "pavel.gheorghe@gmail.com");
        patient1.addAccount(new AccountH(1, "Nutritie necorespunzatoare",1,3,3));

        Patient patient2 = new Patient(Gender.Female, "Andreea", "Gheorghe", 1,"Bucuresti", 1234567899, "andreea.gheorghe@gmail.com");
        patient2.addAccount(new AccountH(2, "Durere lombara", 2, 1, 0));

        HospitalService.addPatient(hospital, patient1);
        HospitalService.addPatient(hospital, patient2);

        assertEquals(4, hospital.getPatientsOnAdded().size());

        List<Patient> patientList = new ArrayList<>(hospital.getPatientsOnAdded());
        assertEquals("Mr.  Ioan Gheorghe", patientList.get(0).getPatientsGreeting());
        assertEquals("Mr. Ioan Gheorghe", patientList.get(0).toString());
        assertEquals("Ms.  Ioana Gheorghe", patientList.get(1).getPatientsGreeting());
        assertEquals("Ms. Ioana Gheorghe", patientList.get(1).toString());
        assertEquals("Mr.  Pavel Gheorghe", patientList.get(2).getPatientsGreeting());
        assertEquals("Mr. Pavel Gheorghe", patientList.get(2).toString());
        assertEquals("Ms.  Andreea Gheorghe", patientList.get(3).getPatientsGreeting());
        assertEquals("Ms. Andreea Gheorghe", patientList.get(3).toString());

//        statistics.getStatistic(hospital);
        assertEquals("\u001B[0;32m\n" +
                "START STATISTICS\u001B[0;32m\u001B[0;37m\n" +
                "The total number of patients in the hospital database is: 4\u001B[0;37m\n" +
                "\n" +
                "The total number of accounts in the hospital database is: 4\n" +
                "\n" +
                "Patients from the hospital database sorted alphabetically: [Ms. Andreea Gheorghe, Mr. Pavel Gheorghe, Ms. Ioana Gheorghe, Mr. Ioan Gheorghe]\n" +
                "\n" +
                "Patients from the hospital database sorted by cities:{Bucuresti=[Ms. Ioana Gheorghe, Ms. Andreea Gheorghe], Timisoara=[Mr. Ioan Gheorghe, Mr. Pavel Gheorghe]}\n" +
                "\n" +
                "Accounts from the hospital database sorted by ID:[\n" +
                "ID: 1\n" +
                "Diagnostic: Nutritie necorespunzatoare\n" +
                "Bulletin of Analysis: 1\n" +
                "Emergency Code: 3\n" +
                "Number of Hospitalization in last three months: 3\n" +
                ", \n" +
                "ID: 2\n" +
                "Diagnostic: Durere lombara\n" +
                "Bulletin of Analysis: 2\n" +
                "Emergency Code: 1\n" +
                "Number of Hospitalization in last three months: 0\n" +
                "]\n" +
                "\n" +
                "Accounts from the hospital database sorted by number of hospitalization:[\n" +
                "ID: 1\n" +
                "Diagnostic: Nutritie necorespunzatoare\n" +
                "Bulletin of Analysis: 1\n" +
                "Emergency Code: 3\n" +
                "Number of Hospitalization in last three months: 3\n" +
                ", \n" +
                "ID: 2\n" +
                "Diagnostic: Durere lombara\n" +
                "Bulletin of Analysis: 2\n" +
                "Emergency Code: 1\n" +
                "Number of Hospitalization in last three months: 0\n" +
                "]\n" +
                "\n" +
                "Accounts from the hospital database sorted by emergency code:[\n" +
                "ID: 2\n" +
                "Diagnostic: Durere lombara\n" +
                "Bulletin of Analysis: 2\n" +
                "Emergency Code: 1\n" +
                "Number of Hospitalization in last three months: 0\n" +
                ", \n" +
                "ID: 1\n" +
                "Diagnostic: Nutritie necorespunzatoare\n" +
                "Bulletin of Analysis: 1\n" +
                "Emergency Code: 3\n" +
                "Number of Hospitalization in last three months: 3\n" +
                "]\u001B[0;32m\n" +
                "END OF STATISTICS\n" +
                "\u001B[0;32m", statistics.getStatistic(hospital));
    }
}
