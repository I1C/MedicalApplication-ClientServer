package domain;

public enum Gender {
    Male ("Mr. "), Female ("Ms. ");
    private String greeting;
    private Gender(String greeting){
        this.greeting = greeting;
    }
    public String getGreeting(){
        return greeting;
    }
}
