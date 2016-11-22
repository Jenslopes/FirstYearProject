package sample.Businesslogic;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import sample.DAO.Database;

public class BusinessLogic {
    Database db = new Database();

    public int fetchUsers(String user, String pass) {
        return db.userData(user, hashpw(pass));
    }

    public String hashpw(String pass){
        int hash = 7;
        for (int i = 0; i < pass.length(); i++) {
            hash = hash*31 + pass.charAt(i);
        }
        return new String(hash + "");
        //http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
    }
    public void setScene(Stage oStage, String path){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            oStage.setScene(new Scene(root));
            oStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
