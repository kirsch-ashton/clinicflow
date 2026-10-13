package gui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        Scene secondlayout = new Scene(root, 500, 700);
        stage.setScene(secondlayout);
        stage.show();
    }

    private BorderPane mainLayout(){
        TextField name = new TextField("Name: ");
        TextField age = new TextField("Age: ");
        TextField contactNumber = new TextField("Contact Number: ");
        TextField height = new TextField("Height: ");
        TextField weight = new TextField("Weight: ");
        GridPane grid = new GridPane(10, 10);
        grid.add(new Label("Name: "), 0,0);
        grid.add(name, 1, 0);

        grid.add(new Label("Age: "), 0, 1);
        grid.add(age, 1, 1);

        grid.add(new Label("Height: "), 2,0);
        grid.add(height,2,1);

        grid.add(new Label("Weight"), 3,0);
        grid.add(weight, 3,1);

        BorderPane mainLayout = new BorderPane();
        mainLayout.setLeft(grid);
        return mainLayout;
    }
}
