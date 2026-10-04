package model;

public class Appointment {
    private String patientName;
    private String staffName;
    private String appointedTimeDate;
    private String reason;

    public Appointment(String appointedTimeDate, String reason, String patientName, String staff){
        this.appointedTimeDate = appointedTimeDate;
        this.reason = reason;
        this.patientName = patientName;
        this.staffName = staff;
    }

    public String getAppointedTimeDate() {
        return this.appointedTimeDate;
    }

    public String getReason(){
        return this.reason;
    }

    public String getPatientName(){
        return this.patientName;
    }

    public String getStaffName(){
        return this.staffName;
    }

    public void setAppointedTimeDate(String appointedTimeDate) {
        this.appointedTimeDate = appointedTimeDate;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String info(){
        return "Appointment Slip\n" +
                "Patient: " + patientName + "\n" +
                "Reason: " + reason + "\n" +
                "Appointed Time: " + appointedTimeDate + "\n" +
                "Staff : " + staffName;
    }
}
