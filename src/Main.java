import model.*;
import patientrepository.PatientRepository;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    public boolean isDone = false;
    String filePath = "record.txt";
    String patientName;
    private Patient patient;
    private Staff staff;

    public void process(int choice){
        MedicalRecordProcess mrp = new MedicalRecordProcess();
        PatientRepository pr = new PatientRepository();
        AppointmentProcess ap = new AppointmentProcess();

        switch(choice){
            case 1:
                Patient patient = patientInfo();
                Staff staff = staffInfo();
                MedicalRecord record = medicalInfo(patient, staff);
                mrp.addRecord(record, filePath);
                break;
            case 2:
                pr.viewRecord(filePath);
                break;
            case 3:
                searchUser();
                pr.searchRecord(filePath, patientName);
                break;
            case 4:
                pr.deleteRecord(filePath, patientName);
                break;
            case 5:
                ap.process();
                break;
            case 6:
                isDone = true;
                break;
            default:
                break;
        }
    }

    public void menu(){
        System.out.println("CLINIC SYSTEM");
        System.out.println("1. Add Record");
        System.out.println("2. View Record");
        System.out.println("3. Search Record");
        System.out.println("4. Delete Record");
        System.out.println("5. Appointment");
        System.out.println("6. Exit");
    }

    public int nav(){
        System.out.print("Enter: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public MedicalRecord medicalInfo(Patient patient, Staff staff){
        System.out.print("Weight: ");
        String weight = scanner.nextLine();

        System.out.print("Height: ");
        String height = scanner.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Last Check Up: ");
        String lastCheckUp = scanner.nextLine();

        return new MedicalRecord(diagnosis, lastCheckUp, height, weight, patient, staff);
    }

    public Patient patientInfo(){
        System.out.print("Patient Name: ");
        String patientName = scanner.nextLine();

        System.out.print("Contact Number");
        String contactNum = scanner.nextLine();

        System.out.print("Age: ");
        String age = scanner.nextLine();

        return new Patient(patientName, contactNum, age);
    }

    public Staff staffInfo(){
        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();
        return new Staff(name);
    }

    public void searchUser(){
        System.out.print("Enter user:");
        patientName = scanner.nextLine();
    }

    public static void main(String[] args){
        Main main = new Main();

        while(!main.isDone){
            main.menu();
            int choice = main.nav();
            main.process(choice);
        }

    }
}
