package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
            case 0:
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../Admin.fxml"));
                    Stage stage = (Stage) user.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../Contractor.fxml"));
                    Stage stage = (Stage) user.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../User.fxml"));
                    Stage stage = (Stage) user.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void cancelLogin(){
        Stage stage = (Stage) user.getScene().getWindow();
        stage.close();
    }
}
