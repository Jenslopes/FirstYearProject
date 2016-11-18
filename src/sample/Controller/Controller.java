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

    public void userLogin() {
        BusinessLogic cr = new BusinessLogic();
        int login = cr.fetchUsers(user.getText(), pass.getText());

        switch (login) {
            case -1:
                InfoBox.info("Ikke logget ind");
            case 0:
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                    Stage stage = (Stage) user.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case 1:
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
                    Stage stage = (Stage) user.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        /*
        if(ans == 0) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                Stage stage = (Stage) user.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch(Exception e){

            }
        }

        if(ans == 1){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
                Stage stage = (Stage) user.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch(Exception e){

            }
        }
        if(ans == -1) InfoBox.info("Ikke logget ind");
        */
    }
}
