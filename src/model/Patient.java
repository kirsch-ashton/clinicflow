package model;

public class Patient {
    protected String patientName;
    protected String contactNumber;
    protected int age;
    protected String patientID;

    public Patient(){}

    public Patient(String patientName, String contactNumber, String patientID, int age){
        this.patientName = patientName;
        this.contactNumber = contactNumber;
        this.age = age;
        this.patientID = patientID;
    }

    public int getAge() { return age; }
    public void setAge(int x){ this.age = x; }

    public String getPatientName(){ return this.patientName; }
    public void setPatientName(String x){ this.patientName = x; }

    public String getContactNumber(){ return this.contactNumber; }
    public void setContactNumber(String x){ this.contactNumber = x; }

    public String getPatientId(){ return this.patientID; }
    public void setPatientId(String x){ this.patientID = x; }
}
