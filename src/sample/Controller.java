package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Controller {
    public AnchorPane loginScreen;
    public Button okLogin;

    public void clickbutton(ActionEvent actionEvent) {
        System.out.println("you are now logged in");
    }
}
