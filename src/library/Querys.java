/*
Querys and more
 */
package library;

import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melinna
 */
public class Querys extends DBConnector{
    public static ArrayList<Book> listar(){
        ArrayList<Book> books = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String query = "SELECT ISBN, Titulo, Autor, Cantidad, Tipo, Area, Estado FROM libros";
        
        try {
            pst = getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String ISBN = rs.getString("ISBN");
                String Titulo = rs.getString("Titulo");
                String Autor = rs.getString("Autor");
                int Cantidad = rs.getInt("Cantidad");
                String Tipo = rs.getString("Tipo");
                String Area = rs.getString("Area");
                String Estado = rs.getString("Estado");
                
                Book newBook = new Book(ISBN,Titulo,Autor,Cantidad,Tipo, Area, Estado);
                books.add(newBook);
            }
            return books;
        } catch (SQLException ex) {
            return null;
        }
        
     
    }
}