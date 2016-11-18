package sample.Businesslogic;

import sample.DAO.Database;

public class BusinessLogic {

    public int fetchUsers(String user, String pass) {
        Database db = new Database();
        return db.userData(user, pass);
    }
}
