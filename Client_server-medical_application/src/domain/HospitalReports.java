package domain;

import java.util.*;

public class HospitalReports{

    // Returns the number of hospital patients.
    public int getNumberOfPatients(Hospital hospital){
        return hospital.getPatientsOnAdded().size();
    }

    // Returns the total number of accounts for all hospital patients.
    public int getNumberOfAccounts(Hospital hospital){
        int numberOfAccounts = 0;
        for (Patient patient : hospital.getPatientsOnAdded()){
            numberOfAccounts += patient.getAccounts().size();
        }
        return numberOfAccounts;
    }

    // Displays the set of clients in alphabetical order.
    public SortedSet<Patient> getPatientsSorted(Hospital hospital){
        return new TreeSet<Patient>(hospital.getPatientsOnAdded());
    }


    // Returns the set of all accounts. The list is ordered by current account ID.
    public SortedSet<AccountH> getAccountsSortedByID(Hospital hospital){
        SortedSet<AccountH> setOfAllAccounts = new TreeSet<>(Comparator.comparing(AccountH :: getID));
        for(Patient patient : hospital.getPatientsOnAdded()){
            setOfAllAccounts.addAll(patient.getAccounts());
        }
        return setOfAllAccounts;
    }

    // Returns the set of all accounts. The list is ordered by current account NumberOfHospitalization.
    public SortedSet getAccountSortedByNumberOfHospitalization(Hospital hospital){
        SortedSet<AccountH> setOfAllAccounts = new TreeSet <>(Comparator.comparing(AccountH :: getNumberOfHospitalizations)).descendingSet();
        for(Patient patient : hospital.getPatientsOnAdded()){
            setOfAllAccounts.addAll(patient.getAccounts());
        }
        return setOfAllAccounts;
    }

    // Returns the set of all accounts. The list is ordered by current account EmergencyCode.
    public SortedSet getAccountSortedByEmergencyCode(Hospital hospital){
        SortedSet<AccountH> setOfAllAccounts = new TreeSet<>(Comparator.comparing(AccountH :: getEmergencyCode));
        for(Patient patient : hospital.getPatientsOnAdded()){
            setOfAllAccounts.addAll(patient.getAccounts());
        }
        return  setOfAllAccounts;
    }

    // Print the resulting table, and order by city name alphabetically.
    public Map<String, List<Patient>> getPatientsByCity(Hospital hospital){
        Map<String, List<Patient>> patientsByCity = new TreeMap<>();
        for(Patient patient : hospital.getPatientsOnAdded()){
            String city = patient.getCity();
            if(patientsByCity.containsKey(city)){
                patientsByCity.get(city).add(patient);
            }
            else{
                patientsByCity.put(city, new ArrayList<>(Collections.singletonList(patient)));
            }
        }
        return patientsByCity;
    }

}
