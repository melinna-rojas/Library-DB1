/*
 Gets the connection with "Biblioteca" Data Base
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melinna
 */
public class DBConnector {

    private String USERNAME = "root";
    private String PASSWORD = "";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "library";

    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?user="+USERNAME+"&password="+PASSWORD;


 

    public Connection getConexion(){
        
        try {
            Class.forName(CLASSNAME);
            Connection connection = DriverManager.getConnection(URL);
             return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ERROR" + ex);
        }
            return null;
       
    }
    
//    public static void main(String[] args) {
//        DBConnector con = new DBConnector();
//        System.out.println(con.getConexion());
//    }
}
