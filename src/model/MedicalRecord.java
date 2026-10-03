package model;

public class MedicalRecord extends Doctor{
    private String patientName;
    private int patientAge;
    private String diagnosis;
    private String lastCheckup;
    //private int age;

    public MedicalRecord(){}

    public MedicalRecord(String diagnosis, String lastCheckup){
        this.diagnosis = diagnosis;
        this.lastCheckup = lastCheckup;
    }

    public MedicalRecord(String name, int age, String diagnosis, String lastCheckup){
        this.patientName = name;
        this.patientAge = age;
        this.diagnosis = diagnosis;
        this.lastCheckup = lastCheckup;
    }

    public void displayInfo(){
        System.out.println("MEDICAL RECORD OF " + this.patientName);
        //System.out.println("Contact Number: " + this.patientCNumber);
        System.out.println("Age: " + this.age);
        System.out.println("Last Check up: " + this.lastCheckup);
        System.out.println("Diagnosis: " + this.diagnosis);
    }

    public String convertToFile(){
        System.out.println("DEBUG");
        System.out.println(getPatientName());
        System.out.println(getContactNumber());
        System.out.println(getAge());
        System.out.println(this.diagnosis);
        System.out.println("DEBUG");

        return "RECORD \n" +
                "Name: " + this.patientName + "\n" +
                //"Contact Number: " + getContactNumber() + "\n" +
                "Age: " + this.patientAge + "\n" +
                "Diagnosis: " + this.diagnosis + "\n" +
                //"Current Doctor: " + getDoctorName() + "\n" +
                "Last Check up: " + this.lastCheckup + "\n";
    }
}
