package domain;

import exceptions.ERR;
import utils.FullDetailsOfPatient;
import utils.PatientRegistrationListener;
import java.text.DateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Hospital {

    private final static Set<Patient> patients = new LinkedHashSet<>();
    private final List<PatientRegistrationListener> listeners = new ArrayList<>();
    private final List<FullDetailsOfPatient> details = new ArrayList<>();
    private static Email email;

    private int printedPatients = 0;
    private int debuggedPatients = 0;
//    private int emailedPatients = 0;

    public int getPrintedPatients() {
        return printedPatients;
    }

    public int getDebuggedPatients() {
        return debuggedPatients;
    }
//    public int getEmailedPatients() { return emailedPatients; }


    private void notify(Patient patient) {
        for (PatientRegistrationListener listener : listeners) {
            listener.onPatientAdded(patient);
        }
    }

    public void addPatient(final Patient patient) throws ERR {
        if (patients.contains(patient)) {
            throw new ERR("The patient already exist into the Hospital database!");
        }
        patients.add(patient);
        notify(patient);
        notifyFullDetails(patient);
    }

    class EmailNotificationListener implements PatientRegistrationListener {
        @Override
        public void onPatientAdded(Patient patient) {
            System.out.println("\u001B[32m" + "The registration notification was sent to the email address: " + patient.getEmail() + "!" + "\u001B[32m" + "\n");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    email = new Email(patient);
                    Thread.currentThread().setName(patient.getName() + "'s thread");
                    email.waitForEmail();
                    System.out.println("\033[0;92m" + patient.getPatientsGreeting() + " received the email successfully." + "\033[0;92m");
                }
            }).start();
        }
    }

    class DebugListener implements PatientRegistrationListener {

        @Override
        public void onPatientAdded(Patient patient) {
            System.out.println("\u001B[32m" + "The patient: " + patient.getPatientsGreeting() + " added on the Hospital database in: " + DateFormat.getDateInstance(DateFormat.FULL).format(new Date()) + "\u001B[32m");
            debuggedPatients++;
        }
    }

    private void notifyFullDetails(Patient patient) {
        for (FullDetailsOfPatient detail : details) {
            detail.fullDetails(patient);
        }
    }

    class DebugPatientsFullDetails implements FullDetailsOfPatient {
        @Override
        public void fullDetails(Patient patient) {
            System.out.println("\u001B[37m" + "The patient " + patient.getPatientsGreeting() + " with account details: " + patient.details() + "\n" + "Have: " + "\n" + patient.fullDetails() + "\n" + "\u001B[37m");
            printedPatients++;
        }
    }


    public Set<Patient> getPatientsOnAdded() {
        return Collections.unmodifiableSet(patients);
    }


    public String Final(Patient patient) {
        String s = ("\n" + "The patient " + patient.getPatientsGreeting() + " with account details: " + patient.details() + "\n" + "Have: " + "\n" + patient.fullDetails() + "\n");
        return s;
    }

    public String getAllPatients() {
        StringBuilder sb = new StringBuilder();
        patients.forEach(patient -> sb.append("\n"+"The patient " + patient.getPatientsGreeting() + " with account details: " + patient.details() + "\n" + "Have: " + "\n" + patient.fullDetails() + "\n"));
        return sb.toString();

    }

    public String getPatientsByName(){
        StringBuilder sb = new StringBuilder();
        Stream<Patient> allPatients = patients.stream();
        allPatients.forEach(patient -> sb.append("\n"+patient+"\n"));
        return sb.toString();
    }

    public Hospital() {
        listeners.add(new DebugListener());
        details.add(new DebugPatientsFullDetails());
        listeners.add(new EmailNotificationListener());

    }

}