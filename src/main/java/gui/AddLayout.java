package gui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class AddLayout {
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

        BorderPane mainLayout = new BorderPane();
        mainLayout.setLeft(grid);
        return mainLayout;
    }
}
