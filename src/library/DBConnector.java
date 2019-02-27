/*
 idkkk
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Melinna
 */
public class DBConnector {
    private String USERNAME = "root";
    private String PASSWORD = "";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE ="inventario";
    
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":"+PORT+"/"+DATABASE;
    
    private static Connection connection;
    
    
    
}
    