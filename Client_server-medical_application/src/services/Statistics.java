package services;

import domain.Hospital;
import domain.HospitalReports;
import domain.Patient;

public class Statistics {
    private static HospitalReports hospitalReports = new HospitalReports();

    public static void go(String[] args, Hospital hospital){
        if(args.length == 0 ){
            return;
        }

        for(String arg: args) {
            switch(arg.toLowerCase()){
                case "statistics": case "statistic":
                    statistics(hospital);
                    break;
                case "patients": case "patient":
                    patients(hospital);
                    break;
                case "accounts": case "account":
                    accounts(hospital);
                    break;
            }

        }
    }

    private static void statistics(Hospital hospital){

        System.out.println("\033[0;32m"+"\n"+"START STATISTICS"+"\033[0;32m");
        System.out.println("\033[0;37m"+"\n" +"The total number of patients in the hospital database is: "+hospitalReports.getNumberOfPatients(hospital)+"\033[0;37m");
        System.out.println("\n"+"The total number of accounts in the hospital database is: "+hospitalReports.getNumberOfAccounts(hospital));
        System.out.println("\n" +"Patients from the hospital database sorted alphabetically: ");
        System.out.println(hospitalReports.getPatientsSorted(hospital));
        System.out.println("\n"+"Patients from the hospital database sorted by cities:");
        System.out.println(hospitalReports.getPatientsByCity(hospital));
        System.out.println("\n"+"Accounts from the hospital database sorted by ID:");
        System.out.println(hospitalReports.getAccountsSortedByID(hospital));
        System.out.println("\n"+"Accounts from the hospital database sorted by number of hospitalization:");
        System.out.println(hospitalReports.getAccountSortedByNumberOfHospitalization(hospital));
        System.out.println("\n"+"Accounts from the hospital database sorted by emergency code:");
        System.out.println(hospitalReports.getAccountSortedByEmergencyCode(hospital));
        System.out.println("\033[0;32m"+"\n"+"END OF STATISTICS"+"\n"+"\033[0;32m");

    }

    private static void patients(Hospital hospital){

        System.out.println("\033[0;32m"+"START STATISTICS"+"\033[0;32m");
        System.out.println("\033[0;37m"+"\n" +"The total number of patients in the hospital database is: "+hospitalReports.getNumberOfPatients(hospital)+"\033[0;37m");
        System.out.println("\n"+"The total number of accounts in the hospital database is: "+hospitalReports.getNumberOfAccounts(hospital));
        System.out.println("\n" +"Patients from the hospital database sorted alphabetically: ");
        System.out.println(hospitalReports.getPatientsSorted(hospital));
        System.out.println("\n"+"Patients from the hospital database sorted by cities:");
        System.out.println(hospitalReports.getPatientsByCity(hospital));
        System.out.println("\n"+"Accounts from the hospital database sorted by ID:");
        System.out.println(hospitalReports.getAccountsSortedByID(hospital));
        System.out.println("\n"+"Accounts from the hospital database sorted by number of hospitalization:");
        System.out.println(hospitalReports.getAccountSortedByNumberOfHospitalization(hospital));
        System.out.println("\n"+"Accounts from the hospital database sorted by emergency code:");
        System.out.println(hospitalReports.getAccountSortedByEmergencyCode(hospital));
        System.out.println("\033[0;32m"+"\n"+"END OF STATISTICS"+"\n"+"\033[0;32m");

    }

    private static void accounts(Hospital hospital){

        System.out.println("\033[0;32m"+"START STATISTICS"+"\033[0;32m");
        System.out.println("\033[0;37m"+"\n" +"The total number of patients in the hospital database is: "+hospitalReports.getNumberOfPatients(hospital)+"\033[0;37m");
        System.out.println("\n"+"The total number of accounts in the hospital database is: "+hospitalReports.getNumberOfAccounts(hospital));
        System.out.println("\n" +"Patients from the hospital database sorted alphabetically: ");
        System.out.println(hospitalReports.getPatientsSorted(hospital));
        System.out.println("\n"+"Patients from the hospital database sorted by cities:");
        System.out.println(hospitalReports.getPatientsByCity(hospital));
        System.out.println("\n"+"Accounts from the hospital database sorted by ID:");
        System.out.println(hospitalReports.getAccountsSortedByID(hospital));
        System.out.println("\n"+"Accounts from the hospital database sorted by number of hospitalization:");
        System.out.println(hospitalReports.getAccountSortedByNumberOfHospitalization(hospital));
        System.out.println("\n"+"Accounts from the hospital database sorted by emergency code:");
        System.out.println(hospitalReports.getAccountSortedByEmergencyCode(hospital));
        System.out.println("\033[0;32m"+"\n"+"END OF STATISTICS"+"\n"+"\033[0;32m");

    }

    public String getStatistic(Hospital hospital){
        StringBuilder sb = new StringBuilder();
        sb.append("\033[0;32m"+"\n"+"START STATISTICS"+"\033[0;32m");
        sb.append("\033[0;37m"+"\n" +"The total number of patients in the hospital database is: "+hospitalReports.getNumberOfPatients(hospital)+"\033[0;37m");
        sb.append("\n");
        sb.append("\n"+"The total number of accounts in the hospital database is: "+hospitalReports.getNumberOfAccounts(hospital));
        sb.append("\n");
        sb.append("\n" +"Patients from the hospital database sorted alphabetically: ");
        sb.append(hospitalReports.getPatientsSorted(hospital));
        sb.append("\n");
        sb.append("\n"+"Patients from the hospital database sorted by cities:");
        sb.append(hospitalReports.getPatientsByCity(hospital));
        sb.append("\n");
        sb.append("\n"+"Accounts from the hospital database sorted by ID:");
        sb.append(hospitalReports.getAccountsSortedByID(hospital));
        sb.append("\n");
        sb.append("\n"+"Accounts from the hospital database sorted by number of hospitalization:");
        sb.append(hospitalReports.getAccountSortedByNumberOfHospitalization(hospital));
        sb.append("\n");
        sb.append("\n"+"Accounts from the hospital database sorted by emergency code:");
        sb.append(hospitalReports.getAccountSortedByEmergencyCode(hospital));
        sb.append("\033[0;32m"+"\n"+"END OF STATISTICS"+"\n"+"\033[0;32m");
        return sb.toString();
    }

}
