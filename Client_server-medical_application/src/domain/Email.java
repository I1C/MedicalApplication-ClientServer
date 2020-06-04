package domain;

public class Email {
    private Patient patient;
    private boolean isSent = false;

    public Email(Patient patient){
        this.patient = patient;
    }

    public Patient getPatient(){return patient;}


    public synchronized void sendEmail(){

        System.out.println("\u001B[32m"+"\n" +"Waiting for emails to be sent to the patients from Hospital Service!"+"\n"+"\u001B[32m");
        try{
            Thread.sleep(1000);
            isSent = true;
            notify();
        }catch (InterruptedException e){
            System.out.println("ERROR sending email: " + e.getMessage());
        }
    }

    public synchronized void waitForEmail(){
//        System.out.println("\u001B[34m"+"The registration notification was sent to the email address of "+patient.getPatientsGreeting() + "\u001B[34m"+"\n");
        while(!isSent){
            try{
                wait(2000);
            }catch (InterruptedException e){
                System.out.println("ERROR waiting for Email:" + e.getMessage());
            }
            isSent = true;
        }
    }
}

