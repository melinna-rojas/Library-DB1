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
    public static Connection getConnection(){
        Connection connection = DriverManager.getConnection("google.com");
        return connection;
    }
    
}
    