import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javax.swing.*;

public class TestMain extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Clinic Management System");
        Image image = new Image(getClass().getResourceAsStream("/images/icon.PNG"));
        stage.getIcons().add(image);
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Clinic Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}