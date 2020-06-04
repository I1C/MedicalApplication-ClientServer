package services;

import domain.Email;
import domain.Hospital;
import domain.Patient;

public class EmailService {
    private static Email email;
    private static Hospital hospital;

    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            Thread.currentThread().setName("EmailService Thread");
            hospital = new Hospital();
            for (Patient patient: hospital.getPatientsOnAdded())
            email = new Email(patient);
                email.sendEmail();
        }
    });

    public EmailService(){
        thread.start();
    }

    public void close(){
        System.out.println(Thread.currentThread().getName() + " interrupting the EmailService Thread...");
        thread.interrupt();
    }

}
