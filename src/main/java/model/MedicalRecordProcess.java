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
}
