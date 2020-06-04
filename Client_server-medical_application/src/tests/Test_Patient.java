package tests;

import domain.AccountH;
import domain.Gender;
import domain.Patient;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_Patient {
    @Test
    public void testPatient() {
        Patient patient = new Patient(Gender.Male, "Pavel", "Gheorghe", 1,"Timisoara", 1234567890, "pavel.gheorghe@gmail.com");
        patient.addAccount(new AccountH(1, "Nutritie necorespunzatoare",1,3,3));

        assertEquals(1, patient.getAccounts().size());
        assertEquals("Mr.  Pavel Gheorghe", patient.getPatientsGreeting());
        assertEquals("Mr. Pavel Gheorghe", patient.toString());
        assertEquals(1, patient.getCnp(), 0);
        assertEquals("Timisoara", patient.getCity());
        assertEquals(1234567890, patient.getTelephoneNumber(), 0);
        assertEquals("pavel.gheorghe@gmail.com", patient.getEmail());
    }
}
