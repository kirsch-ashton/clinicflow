package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class AppointmentProcess {
    Scanner scanner = new Scanner(System.in);
    private Appointment appointment;
    private final String filepath = "appointment.txt";
    private String patientName;
    private boolean isDone = false;

    public void menu(){
        System.out.println("\nAppointment Menu");
        System.out.println("----------------");
        System.out.println("1. Create new appointment");
        System.out.println("2. View appointments");
        System.out.println("3. Search Appointments");
        System.out.println("4. Delete Appointments");
        System.out.println("5. Exit out of Appointment");
    }

    public void process(){
        while(!isDone){
            menu();
            int choice = nav();
            switch(choice){
                case 1:
                    Appointment ap = createAppointmentSlip();
                    addAppointments(ap);
                    break;
                case 2:
                    viewAppointments();
                    break;
                case 3:
                    askPatientName();
                    searchAppointment(patientName);
                    break;
                case 4:
                    askPatientName();
                    deleteAppointment(patientName);
                    break;
                case 5:
                    isDone = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void viewAppointments(){
        try(BufferedReader out = new BufferedReader(new FileReader(filepath))){

            String line;
            while((line = out.readLine()) != null){
                System.out.println(line);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addAppointments(Appointment appointment){
        try(BufferedWriter in = new BufferedWriter(new FileWriter(filepath, true))){
            in.write(appointment.info());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void searchAppointment(String name){
        try(BufferedReader out = new BufferedReader(new FileReader(filepath))){
            StringBuilder block = new StringBuilder();
            boolean matched = false;
            boolean found = false;
            String line;

            while((line = out.readLine()) != null){
                if(line.trim().contains("Appointment Slip")){
                    if(matched){
                        System.out.println(block);
                        found = true;
                    }
                    block.setLength(0);
                    matched = false;
                }
                block.append(line).append("\n");

                if (line.startsWith("Patient:") &&
                        line.substring(8).trim().equalsIgnoreCase(name)) {
                    matched = true;
                }
            }
            if (matched) {
                System.out.print(block);
                found = true;
            }

            if (!found) {
                System.out.println("No appointment found for " + name);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAppointment(String name){
        File original = new File(filepath);
        File temp = new File(filepath + ".tmp");
        boolean deleted = false;
        try(BufferedReader out = new BufferedReader(new FileReader(original));
            BufferedWriter in = new BufferedWriter(new FileWriter(temp))){
            StringBuilder block = new StringBuilder();
            boolean matched = false;
            String line;

            while((line = out.readLine()) != null){
                if(line.trim().contains("Appointment Slip")){
                    if(!block.isEmpty()){
                        if(matched){
                            System.out.println(block);
                            deleted = true;
                        } else {
                            in.write(block.toString());
                        }
                    }
                    block.setLength(0);
                    matched = false;
                }
                block.append(line).append("\n");

                if (line.startsWith("Patient:") &&
                        line.substring(8).trim().equalsIgnoreCase(name)) {
                    matched = true;
                }
            }
            if (!block.isEmpty()) {
                if (matched) {
                    deleted = true;
                } else {
                    in.write(block.toString());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            if (deleted) {
                Files.move(temp.toPath(), original.toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Record deleted");
            } else {
                temp.delete();
                System.out.println("No record found for " + name);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void askPatientName(){
        System.out.print("Find patient name: ");
        patientName = scanner.nextLine();
    }

    public Appointment createAppointmentSlip(){
        System.out.println("\nCreating Appointment Slip ");
        System.out.print("Patient Name: ");
        String patientName = scanner.nextLine();

        System.out.print("Staff Name: ");
        String staffName = scanner.nextLine();

        System.out.print("Time and Date: ");
        String timeData = scanner.nextLine();

        System.out.print("Reason: ");
        String reason = scanner.nextLine();

        return new Appointment(timeData, reason, patientName, staffName);
    }

    public int nav(){
        System.out.print("Enter: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

}
