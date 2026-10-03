import model.*;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    public boolean isDone = false;
    String filePath = "record.txt";

    public void process(int choice){
        MedicalRecordProcess mrp = new MedicalRecordProcess();
        switch(choice){
            case 1:
                MedicalRecord record = askInput();
                mrp.addRecord(record, filePath);
                break;
            case 2:
                mrp.viewRecord(filePath);
                break;
            case 3:
                isDone = true;
                break;
            case 4:
                isDone = true;
                break;
            case 5:
                isDone = true;
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
        System.out.println("Enter: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public MedicalRecord askInput(){
        System.out.println("Patient Name: ");
        String patientName = scanner.nextLine();

        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.println("Last Check Up: ");
        String lastCheckUp = scanner.nextLine();

        return new MedicalRecord(patientName, age, diagnosis, lastCheckUp);
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
