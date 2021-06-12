package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private ElevatorSystem system = new ElevatorSystem();
    @FXML
    private Button requestButton;
    @FXML
    private TextField input;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void chooseFloor() {
        int floor = 1;
        if (input.getText().isBlank() || input.getText().isEmpty()) {
            system.request(floor);
        }
        try {
            floor = Integer.parseInt(input.getText());
        } catch (NumberFormatException e) {}
        // request inputted value
        system.request(floor);
    }
}
