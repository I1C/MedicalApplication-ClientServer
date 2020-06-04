package domain;

import exceptions.NA;

public class AccountH {
    private int ID;
    private String diagnostic;
    private int bulletinOfAnalysis;
    private int emergencyCode;
    protected int numberOfHospitalizations;

    public AccountH (int ID, String diagnostic, int bulletinOfAnalysis, int emergencyCode, int numberOfHospitalizations){
        this.ID=ID;
        this.diagnostic=diagnostic;
        this.bulletinOfAnalysis=bulletinOfAnalysis;
        this.emergencyCode=emergencyCode;
        this.numberOfHospitalizations=numberOfHospitalizations;
    }

    public void NumberOfHospitalization(final int nr) throws NA {
        if (nr<0) {
            throw new NA("\n" +
                    "In the last three months, the patient was not admitted to the hospital."
                    + "\n");
        }
        this.numberOfHospitalizations=nr;
    }

    public int getNumberOfHospitalizations() {
        return numberOfHospitalizations;
    }


    public int getID() { return this.ID; }


    public String getDiagnostic(){ return this.diagnostic; }


    public int getBulletinOfAnalysis(){
        return this.bulletinOfAnalysis;
    }


    public int getEmergencyCode(){
        return this.emergencyCode;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n"+"ID: "+getID() + "\n");
        sb.append("Diagnostic: "+getDiagnostic() + "\n");
        sb.append("Bulletin of Analysis: "+getBulletinOfAnalysis() + "\n");
        sb.append("Emergency Code: "+getEmergencyCode() + "\n");
        sb.append("Number of Hospitalization in last three months: "+getNumberOfHospitalizations() + "\n");
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
        AccountH other = (AccountH) obj;
        if(ID !=0 && ID != other.ID)
            return false;
        if(bulletinOfAnalysis != other.bulletinOfAnalysis)
            return false;
        return true;
    }

    @Override
    public int hashCode() {

        final int prime = 33;
        int result = 1;
        result = prime * result + ID;
        result = prime * result + ((diagnostic == null) ? 0 : diagnostic.hashCode());
        result = prime * result + bulletinOfAnalysis;
        result = prime * result + emergencyCode;
        result = prime * result + numberOfHospitalizations;
        return result;
    }
}


