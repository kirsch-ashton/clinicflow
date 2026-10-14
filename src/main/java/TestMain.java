import gui.AddLayout;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import model.MedicalRecord;

import javax.swing.*;

public class TestMain extends Application {
    private AddLayout al = new AddLayout();
    private MedicalRecord mr;
    private MedicalRecord mrp;
    private BackgroundMain bm;
    static int choice;

    @Override
    public void start(Stage stage) {
        BorderPane sidePanel = createSidePanel();
        VBox mainPanel = createMainPanel();
        Image image = new Image(getClass().getResourceAsStream("/images/icon.PNG"));
        stage.getIcons().add(image);

        sidePanel.getStyleClass().add("side-panel");

        BorderPane root = new BorderPane();
        root.setLeft(sidePanel);
        root.setCenter(mainPanel);
        sidePanel.setStyle("-fx-background-color: teal;");
        mainPanel.setStyle("-fx-background-color: seashell;");
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("Clinic Management System");
        stage.setScene(scene);
        stage.show();
    }

    private BorderPane createSidePanel() {
        Label title = new Label("Clinic Management System");
        title.setMaxHeight(35);
        title.setPrefHeight(35);
        VBox buttonBox = getButtonBox();
        BorderPane sidePanel = new BorderPane();

        sidePanel.setCenter(buttonBox);
        sidePanel.setTop(title);
        buttonBox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(title, Pos.BOTTOM_CENTER);

        return sidePanel;
    }

    private VBox getButtonBox() {
        Button dashBoard = new Button("Dashboard");
        Button addButton = new Button("Add Patient");
        Button viewButton = new Button("View Patients");

        dashBoard.setOnAction(event -> {
            bm.process(choice);
        });

        addButton.setOnAction(event -> {
            al.addButtonLayout();
        });

        viewButton.setOnAction(event -> {
            al.viewButtonLayout();
        });

        return new VBox(20,dashBoard,addButton,viewButton);
    }



    private VBox createMainPanel(){
        Label totalRecords = new Label("Total Records");
        Label byGender = new Label("Total Records by Male and Female");
        Label thisMonth = new Label("Records this Month");

        HBox bottomRow = new HBox(20, byGender, thisMonth);
        bottomRow.setAlignment(Pos.CENTER);

        return new VBox(20, totalRecords, bottomRow);
    }

    public static void main(String[] args) {
        launch();
    }
}