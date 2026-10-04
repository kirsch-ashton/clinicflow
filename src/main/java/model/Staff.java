package model;

public class Staff {
    private String name;
    //private String specialization;

    public Staff(){}
    public Staff(String name){
        this.name = name;
    }

    public void setStaffName(String name) {
        this.name = name;
    }
    public String getStaffName(){
        return this.name;
    }

    /*
    public void setSpecialization(String x){
        this.specialization = x;
    }
    public String getSpecialization(){
        return this.specialization;
    }*/
}
