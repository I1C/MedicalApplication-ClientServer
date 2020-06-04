package domain;

import java.util.*;

public class Patient implements Comparable{
    private Gender gender;
    private String name;
    private String lastName;
    private int cnp;
    private String city;
    private int telephoneNumber;
    private String email;
    private Set<AccountH> accounts = new LinkedHashSet<>();

    public Patient(Gender gender, String name, String lastName, int cnp, String city, int telephoneNumber, String email){

        this.gender=gender;
        this.name=name;
        this.lastName=lastName;
        this.cnp=cnp;
        this.city=city;
        this.telephoneNumber=telephoneNumber;
        this.email=email;

    }

    public Patient(){}

    public String setImplicitEmail (){
        Random r = new Random();
        return this.email= name.toLowerCase()+lastName.toLowerCase()+r.nextInt(99)+"@gmail.com";
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String setCity(String city){
        return this.city=city;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() { return name; }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

//    public Email getEmails() {
//        return emails = getEmail();
//    }

    public int getCnp() { return cnp; }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        if(gender.Female.equals(getGender())) {
            builder.append("Ms. ");
        }else{
            builder.append("Mr. ");
        }
        builder.append(name);
        builder.append(" ");
        builder.append(lastName);
        return builder.toString();
    }

    public String details(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n"+"\n"+"CNP: "+cnp + "\n");
        sb.append("City: "+city + "\n");
        sb.append("Phone: 0"+telephoneNumber + "\n");
        sb.append("Email: "+email + "\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null)
            return  false;
        if(getClass() != obj.getClass())
            return false;
        Patient other = (Patient) obj;
        if(gender != other.gender)
            return false;
        if(name != other.name)
            return false;
        if(lastName != other.lastName)
            return false;
        if(city != other.city)
            return false;
        if(telephoneNumber != other.telephoneNumber)
            return false;
        if(email != other.email)
            return false;
        return true;
    }

    @Override
    public int hashCode () {
        final int prime = 33;
        int result = 1;
        result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + telephoneNumber;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    public String fullDetails(){
        return accounts.toString();
    }

    public void addAccount(final AccountH account){

        if(accounts.contains(account)){
            System.out.println("Account "+account.getID()+" already exists in the database!");
        }
        accounts.add(account);
    }

    public String getPatientsGreeting () {
        if (gender != null) {
            return gender.getGreeting() + " " + name + " " + lastName;
        } else {
            return name + lastName;
        }
    }

    public Set<AccountH> getAccounts() {
        return Collections.unmodifiableSet(accounts);
    }

    @Override
    public int compareTo(Object o) {
        if(this.equals(o) && ((Patient) o).getAccounts().equals(this.getAccounts())){
            return this.getName().compareTo(((Patient) o).getName());
        }
        return -1;
    }
}

