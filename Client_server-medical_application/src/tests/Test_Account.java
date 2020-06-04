package tests;

import static org.junit.Assert.assertEquals;

import domain.AccountH;
import org.junit.Test;


public class Test_Account {

    @Test
    public void testSavingAccount() {
        AccountH savingAccount = new AccountH(1, "Nutritie necorespunzatoare",1,3,3);

        assertEquals(1, savingAccount.getID());
        assertEquals("Nutritie necorespunzatoare", savingAccount.getDiagnostic());
        assertEquals(1, savingAccount.getBulletinOfAnalysis(), 0);
        assertEquals(3, savingAccount.getEmergencyCode(), 0);
        assertEquals(3, savingAccount.getNumberOfHospitalizations(), 0);
    }

}
