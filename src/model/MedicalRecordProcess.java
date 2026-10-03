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
            StringBuilder block = new StringBuilder();
            boolean matched = false;
            boolean found = false;
            String line;

            while((line = out.readLine()) != null){
                if(line.trim().contains("RECORD")){
                    if(matched){
                        System.out.println(block);
                        found = true;
                    }
                    block.setLength(0);
                    matched = false;
                }
                block.append(line).append("\n");

                if (line.startsWith("Name:") &&
                        line.substring(5).trim().equalsIgnoreCase(name)) {
                    matched = true;
                }
            }
            if (matched) {
                System.out.print(block);
                found = true;
            }

            if (!found) {
                System.out.println("No record found for " + name);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
