package sample.DAO;

import java.sql.*;

/**
 * Created by Julius on 03-11-2016.
 */
public class Database {
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "testdata";
    String usern = "root";
    String passw = "nolimit";

    public int userData(String user, String pass) {
        try {
            Connection connection = DriverManager.getConnection(url + dbName, usern, passw);
            Statement statement = connection.createStatement();
            ResultSet re = statement.executeQuery("SELECT * FROM users");
            while (re.next()) {
                if(re.getString("user").equals(user) && re.getString("pass").equals(pass)){
                    return re.getInt("level");
                }
            }
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
