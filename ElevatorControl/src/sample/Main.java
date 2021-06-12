package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    // build scene, add icon, and show scene
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Elevator Control");
        primaryStage.setScene(new Scene(root, 500, 350));
        primaryStage.show();
        primaryStage.getIcons().add(new Image("/sample/elevatorpic.jpg"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
