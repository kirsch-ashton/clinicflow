package model;

public class MedicalRecord extends Doctor{
    private String patientName;
    private int patientAge;
    private String diagnosis;
    private String lastCheckup;
    private String staffName;
    private String contactNum;

    public MedicalRecord(String diagnosis, String lastCheckup){
        this.diagnosis = diagnosis;
        this.lastCheckup = lastCheckup;
    }

    public MedicalRecord(String name, int age, String diagnosis, String lastCheckup, String staffName, String contactNum){
        this.patientName = name;
        this.patientAge = age;
        this.diagnosis = diagnosis;
        this.lastCheckup = lastCheckup;
        this.staffName = staffName;
        this.contactNumber = contactNum;
    }

    public void displayInfo(){
        System.out.println("MEDICAL RECORD OF " + this.patientName);
        //System.out.println("Contact Number: " + this.patientCNumber);
        System.out.println("Age: " + this.age);
        System.out.println("Last Check up: " + this.lastCheckup);
        System.out.println("Diagnosis: " + this.diagnosis);
    }

    public String convertToFile(){

        return "RECORD \n" +
                "Name: " + this.patientName + "\n" +
                "Contact Number: " + this.contactNumber + "\n" +
                "Age: " + this.patientAge + "\n" +
                "Diagnosis: " + this.diagnosis + "\n" +
                "Current Doctor: " + this.staffName + "\n" +
                "Last Check up: " + this.lastCheckup + "\n";
    }
}
