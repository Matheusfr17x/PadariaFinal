package padariafinal.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectionManager {

    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://localhost:3306/padaria_db";
                connection = DriverManager.getConnection(url, "root", "");
            } else if (connection.isClosed()) {
                connection = null;
                return connection;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public static void closeConnection(){
        if(connection !=null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
