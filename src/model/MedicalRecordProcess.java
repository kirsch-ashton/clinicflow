package model;

import java.io.*;

public class MedicalRecordProcess{
    public void addRecord(MedicalRecord record, String filePath){
        System.out.println("CALLED FUNCTION ADD RECORD");
        try(BufferedWriter in = new BufferedWriter(new FileWriter(filePath, true))){

            in.write(record.convertToFile());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void viewRecord(String filePath){
        try(BufferedReader out = new BufferedReader(new FileReader(filePath))){

            String line;
            while((line = out.readLine()) != null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void searchRecord(String filePath, String name){
        try(BufferedReader out = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = out.readLine()) != null){
                if(line.contains(name)){
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
