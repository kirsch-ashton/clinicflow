package model;

public class Patient {
    private String patientName;
    private String contactNumber;
    private String age;
    //protected String patientID;

    public Patient(){}

    public Patient(String patientName, String contactNumber, String age){
        this.patientName = patientName;
        this.contactNumber = contactNumber;
        this.age = age;
        //this.patientID = patientID;
    }

    public String getAge() { return age; }
    public void setAge(String x){ this.age = x; }

    public String getPatientName(){ return this.patientName; }
    public void setPatientName(String x){ this.patientName = x; }

    public String getContactNumber(){ return this.contactNumber; }
    public void setContactNumber(String x){ this.contactNumber = x; }

    //public String getPatientId(){ return this.patientID; }
    //public void setPatientId(String x){ this.patientID = x; }
}
