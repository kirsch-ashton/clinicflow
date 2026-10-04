package model;
public class MedicalRecord{
    private String diagnosis;
    private String lastCheckup;
    private String weight;
    private String height;

    private Patient patient;
    private Staff staff;

    public MedicalRecord(String diagnosis, String lastCheckup){
        this.diagnosis = diagnosis;
        this.lastCheckup = lastCheckup;
    }

    public MedicalRecord(String diagnosis, String lastCheckup, String weight, String height, Patient patient, Staff staff){
        this.diagnosis = diagnosis;
        this.lastCheckup = lastCheckup;
        this.weight = weight;
        this.height = height;
        this.patient = patient;
        this.staff = staff;
    }

    public void displayInfo(){
        //System.out.println("MEDICAL RECORD OF " + this.patientName);
        //System.out.println("Contact Number: " + this.patientCNumber);
        //System.out.println("Age: " + this.age);
        System.out.println("Last Check up: " + this.lastCheckup);
        System.out.println("Diagnosis: " + this.diagnosis);
    }

    public String convertToFile(){

        return "RECORD \n" +
                "Name: " + patient.getPatientName() + "\n" +
                "Contact Number: " + patient.getContactNumber() + "\n" +
                "Age: " + patient.getAge() + "\n" +
                "Height: " + this.height + "\n" +
                "Weight: " + this.weight + "\n" +
                "Diagnosis: " + this.diagnosis + "\n" +
                "Current Doctor: " + staff.getStaffName() + "\n" +
                "Last Check up: " + this.lastCheckup + "\n" +
                " ";
    }
}
