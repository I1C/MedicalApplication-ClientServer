package main;

import domain.Hospital;
import services.EmailService;
import services.HospitalServerBackground;
import domain.Patient;
import services.Statistics;
import java.net.*;
import java.io.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server{

    private final static Logger logInfo = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Hospital hospital;
    private static HospitalServerBackground hospitalServerBackground;
    private static EmailService emailService;
    private static Statistics statistics;
    Set<Patient> patientsOnHospitalDatabase = new LinkedHashSet<>();

    //initialize socket and input stream

    private Socket           socket   = null;
    private ServerSocket     server   = null;
    private DataInputStream  in       = null;
    private DataOutputStream out      = null;


    public Server(int port) {

        // starts server and waits for a connection

        try {
            server = new ServerSocket(port);
            logInfo.log(Level.INFO,"Server started");
//            System.out.println("\033[0;31m"+"\n"+"Server started"+"\n"+"\033[0;31m");

            logInfo.log(Level.INFO,"Waiting for a medical application ...");
//            System.out.println("\u001B[32m"+"Waiting for a medical application ..."+"\u001B[32m");

            socket = server.accept();
            logInfo.log(Level.INFO,"Connected to the medical application");
//            System.out.println("\033[0;31m"+"\n"+"Connected to the medical application"+"\n"+"\033[0;31m");

            // takes input from the client socket

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());

            String line = "";

            // reads message from medical application until "Over" is sent

            while (!line.equals("Over"))
                try {
                    line = in.readUTF();

                    for (Patient patient : hospital.getPatientsOnAdded()) {
                        while (!patientsOnHospitalDatabase.contains(patient)) {
                            patientsOnHospitalDatabase.add(patient);
                        }
                        for(Patient patient1:patientsOnHospitalDatabase){

                            if(line.equals(patient1.getName())){
                                line=hospital.Final(patient1);
                            }
                        }
                        if(line.equals("Statistics")){
                            line=statistics.getStatistic(hospital);
                        }
                        if(line.equals("All patients")){
                            line=hospital.getAllPatients();
                        }
                        if(line.equals("All patients by name")){
                            line=hospital.getPatientsByName();
                        }
                    }

                    out.writeUTF(line);

                } catch (IOException i) {
                    System.out.println(i);
                }

            logInfo.log(Level.INFO,"Closing connection");

            // close connection
            socket.close();
            in.close();

        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public Set<Patient> getPatientsOnHospitalDatabase (){
        return Collections.unmodifiableSet(patientsOnHospitalDatabase);
    }

    public static void main(String args[]) throws InterruptedException {
        hospital = new Hospital();
        hospitalServerBackground = new HospitalServerBackground();
        hospitalServerBackground.modifyDataBaseOfHospital();
        emailService = new EmailService();
        statistics = new Statistics();
        Thread.sleep(5000);
//        Statistics.go(args, hospital);
        Server server = new Server(5000);
    }
}