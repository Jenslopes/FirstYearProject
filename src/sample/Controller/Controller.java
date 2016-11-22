package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Businesslogic.BusinessLogic;
import sample.InfoBox;

/**
 * Created by Julius on 03-11-2016.
 */
public class Controller {
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    BusinessLogic BL = new BusinessLogic();

    public void userLogin() {
        switch (BL.fetchUsers(user.getText(), pass.getText())) {
            case -1:
                InfoBox.info("Ikke logget ind");
                break;
            case 0: BL.setScene((Stage) user.getScene().getWindow(), "../Admin.fxml");
                break;
            case 1: BL.setScene((Stage) user.getScene().getWindow(), "../Contractor.fxml");
                break;
            case 2: BL.setScene((Stage) user.getScene().getWindow(), "../User.fxml");
                break;
        }
    }

    public void cancelLogin(){
        Stage stage = (Stage) user.getScene().getWindow();
        stage.close();
    }
}
