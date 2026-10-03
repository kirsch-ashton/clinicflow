package model;

public class Appointment {
    private String patientName;
    private String doctorName;
    private String appointedTimeDate;
    private String diagnosis;

    public Appointment(String patientName, String doctorName, String appointedTimeDate, String diagnosis){
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointedTimeDate = appointedTimeDate;
        this.diagnosis = diagnosis;
    }

    public void displayInfo(){
        System.out.println("Appointment Slip");
        System.out.println("----------------");
        System.out.println("Patient Name: " + this.patientName);
        System.out.println("Diagnosis: " + this.diagnosis);
        System.out.println("Appointed Time and Date: " + this.appointedTimeDate);
        System.out.println("To be checked by Doctor, " + this.doctorName);
    }

}
