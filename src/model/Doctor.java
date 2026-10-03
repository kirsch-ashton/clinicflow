package model;

public class Doctor{
    private String name;
    private String specialization;

    public Doctor(){}
    public Doctor(String name){
        this.name = name;
    }
    public Doctor(String name, String specialization){
        this.name = name;
        this.specialization = specialization;
    }

    public void setDoctorName(String name) {
        this.name = name;
    }
    public String getDoctorName(){
        return this.name;
    }

    public void setSpecialization(String x){
        this.specialization = x;
    }
    public String getSpecialization(){
        return this.specialization;
    }
}
