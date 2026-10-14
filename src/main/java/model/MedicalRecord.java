package model;
public class MedicalRecord{
    private String diagnosis;
    private String lastCheckup;
    private String weight;
    private String height;
    private String bloodType;
    private String bloodPressure;
    private String admissionReason;
    private String heartRate;
    private Patient patient;
    private Staff staff;

    public MedicalRecord(){}

    public MedicalRecord(String diagnosis, String lastCheckup, String weight, String height, Patient patient, Staff staff){
        this.diagnosis = diagnosis;
        this.lastCheckup = lastCheckup;
        this.weight = weight;
        this.height = height;
        this.patient = patient;
        this.staff = staff;
    }

    public MedicalRecord(String diagnosis, String lastCheckup, String weight, String height, Patient patient, String bloodType, String bloodPressure, String heartRate, String admissionReason){
        this.diagnosis = diagnosis;
        this.lastCheckup = lastCheckup;
        this.weight = weight;
        this.height = height;
        this.bloodType = bloodType;
        this.bloodPressure = bloodPressure;
        this.admissionReason = admissionReason;
        this.heartRate = heartRate;
        this.patient = patient;
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

    public String getAdmissionReason() {
        return admissionReason;
    }
    public String getBloodPressure() {
        return bloodPressure;
    }
    public String getHeight() {
        return height;
    }
    public String getWeight() {
        return weight;
    }
    public String getHeartRate() {
        return heartRate;
    }
    public String getBloodType() {
        return bloodType;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
}
