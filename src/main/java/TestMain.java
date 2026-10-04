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
import javax.swing.*;

public class TestMain extends Application {

    @Override
    public void start(Stage stage) {
        VBox sidePanel = createSidePanel();
        VBox mainPanel = createMainPanel();
        Image image = new Image(getClass().getResourceAsStream("/images/icon.PNG"));
        stage.getIcons().add(image);

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

    private VBox createSidePanel() {
        Label title = new Label("Clinic Management System");

        Button dashBoard = new Button("Dashboard");
        dashBoard.setMaxSize(150, 200);
        dashBoard.setPrefSize(150, 30);
        dashBoard.setStyle("-fx-background-color: beige");

        Button addButton = new Button("Add Patient");
        addButton.setMaxSize(150, 200);
        addButton.setPrefSize(150, 30);
        addButton.setStyle("-fx-background-color: beige");
        //addButton.setOnAction(e -> addPatient());

        Button viewButton = new Button("View Patients");
        viewButton.setMaxSize(150, 200);
        viewButton.setPrefSize(150, 30);
        viewButton.setStyle("-fx-background-color: beige");
        //viewButton.setOnAction(e -> viewPatients());

        return new VBox(20, title, dashBoard, addButton, viewButton);
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