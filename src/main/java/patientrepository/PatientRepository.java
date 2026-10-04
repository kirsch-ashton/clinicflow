package patientrepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class PatientRepository {

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

    public void deleteRecord(String filePath, String name){
        File original = new File(filePath);
        File temp = new File(filePath + ".tmp");
        boolean deleted = false;
        try(BufferedReader out = new BufferedReader(new FileReader(original));
            BufferedWriter in = new BufferedWriter(new FileWriter(temp))){
            StringBuilder block = new StringBuilder();
            boolean matched = false;
            String line;

            while((line = out.readLine()) != null){
                if(line.trim().contains("RECORD")){
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

                if (line.startsWith("Name:") &&
                        line.substring(5).trim().equalsIgnoreCase(name)) {
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
}
