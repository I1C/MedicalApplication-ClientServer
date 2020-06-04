package exceptions;

public class HospitalException extends Exception {
    private static final long serialVersionUID = 123456789L;

    public HospitalException (String message){
        super (message);
    }
}
