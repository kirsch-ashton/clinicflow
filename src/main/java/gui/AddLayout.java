package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.MedicalRecord;

import java.awt.*;

public class AddLayout {
    MedicalRecord medicalRecord;
    public static class recordTable{
        private String patientName;
        private String patientId;

        public recordTable(String name, String patientId){
            this.patientName = name;
            this.patientId = patientId;
        }

        public String getPatientName() {
            return patientName;
        }

        public String getPatientId() {
            return patientId;
        }
    }
    ObservableList<recordTable> data = FXCollections.observableArrayList();

    public void addButtonLayout(){
        Stage stage = new Stage();
        BorderPane root = new BorderPane();
        root.setCenter(mainLayout());
        Scene secondlayout = new Scene(root);
        secondlayout.getStylesheets().add(getClass().getResource("/addlayoutstyle.css").toExternalForm());
        stage.setScene(secondlayout);
        stage.sizeToScene();
        stage.show();
    }
    public void viewButtonLayout(){
        Stage stage = new Stage();
        BorderPane root = new BorderPane();
        root.setCenter(viewLayout());
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    private BorderPane mainLayout() {
        TextField name = new TextField();
        TextField age = new TextField();
        TextField contactNumber = new TextField();
        TextField height = new TextField();
        TextField weight = new TextField();

        TextField bloodType = new TextField();
        TextField bloodPressure = new TextField();
        TextField heartRate = new TextField();

        TextArea admissionReason = new TextArea();
        admissionReason.setPrefRowCount(3);
        admissionReason.setWrapText(true);

        Button submitButton = new Button("Submit");

        GridPane grid = new GridPane(10, 10);
        grid.setPadding(new javafx.geometry.Insets(15));
        grid.add(new Label("Name:"), 0, 0);
        grid.add(name, 1, 0);
        grid.add(new Label("Age:"), 2, 0);
        grid.add(age, 3, 0);

        grid.add(new Label("Contact Number:"), 0, 1);
        grid.add(contactNumber, 1, 1);
        grid.add(new Label("Height (cm):"), 0, 3);
        grid.add(height, 1, 3);

        grid.add(new Label("Weight (kg):"), 0, 2);
        grid.add(weight, 1, 2);
        grid.add(new Label("Blood Type:"), 2, 2);
        grid.add(bloodType, 3, 2);

        grid.add(new Label("Blood Pressure:"), 2, 1);
        grid.add(bloodPressure, 3, 1);
        grid.add(new Label("Heart Rate (bpm):"), 2, 3);
        grid.add(heartRate, 3, 3);

        grid.add(new Label("Reason for Admission / Diagnosis:"), 0, 4);
        grid.add(admissionReason, 0, 5, 4, 1);

        grid.add(submitButton,0, 6, 4, 1);

        grid.getStyleClass().add("add-layout-style");
        grid.setAlignment(Pos.CENTER);

        BorderPane mainLayout = new BorderPane();
        mainLayout.setLeft(grid);
        return mainLayout;
    }

    private BorderPane viewLayout(){
        TableView<recordTable> table = new TableView<>();

        TableColumn<recordTable, String> patientColumn = new TableColumn<>("Patient Name");
        patientColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));

        TableColumn<recordTable, String> patientIdColumn = new TableColumn<>("Patient ID");
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));

        table.getColumns().add(patientColumn);
        table.getColumns().add(patientIdColumn);
        table.setItems(data);

        BorderPane viewLayout = new BorderPane();
        viewLayout.setCenter(table);
        return viewLayout;
    }

    private BorderPane recordLayout(){
        TextField name = new TextField();
        TextField age = new TextField();
        TextField contactNumber = new TextField();
        TextField height = new TextField();
        TextField weight = new TextField();

        TextField bloodType = new TextField();
        TextField bloodPressure = new TextField();
        TextField heartRate = new TextField();

        TextArea admissionReason = new TextArea();

        GridPane grid = new GridPane();

        BorderPane root = new BorderPane();
        root.setCenter(grid);
        return root;
    }
}
