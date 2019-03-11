/*
Querys and more
 */
package library;

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
public class Querys extends DBConnector {

    public static ArrayList<Book> listar() {
        ArrayList<Book> books = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String query = "SELECT ISBN, Titulo, Autor, Cantidad, Tipo, Area, Estado FROM libros";

        try {
            DBConnector conector = new DBConnector();
            pst = conector.getConexion().prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String ISBN = rs.getString("ISBN");
                String Titulo = rs.getString("Titulo");
                String Autor = rs.getString("Autor");
                int Cantidad = rs.getInt("Cantidad");
                String Tipo = rs.getString("Tipo");
                String Area = rs.getString("Area");
                String Estado = rs.getString("Estado");

                Book newBook = new Book(ISBN, Titulo, Autor, Tipo, Area, Estado, Cantidad);
                books.add(newBook);
            }

            return books;
        } catch (SQLException ex) {

            return null;
        }

    }

    public static ArrayList<String> mostrar_Tipo() {
        ArrayList<String> tipos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String query = "SELECT DISTINCT Tipo FROM libros";

        try {
            DBConnector conector = new DBConnector();
            pst = conector.getConexion().prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                tipos.add(rs.getString("Tipo"));
            }
            return tipos;
        } catch (SQLException ex) {
            return null;
        }

    }

    public static ArrayList<String> mostrar_Area() {
        ArrayList<String> area = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String query = "SELECT DISTINCT Area FROM libros";

        try {
            DBConnector conector = new DBConnector();
            pst = conector.getConexion().prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                area.add(rs.getString("Area"));
            }
            return area;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static ArrayList<String> mostrar_Estado() {
        ArrayList<String> estado = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String query = "SELECT DISTINCT Estado FROM libros";

        try {
            DBConnector conector = new DBConnector();
            pst = conector.getConexion().prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                estado.add(rs.getString("Estado"));
            }
            return estado;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static ArrayList<Book> search_Books(String n_Titulo, String n_Autor, String n_Tipo, String n_Area, String n_Estado) {
        ArrayList<Book> book_S = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String query = "SELECT Titulo,Autor,Tipo,Area,Estado FROM libros WHERE Titulo LIKE '%{"+n_Titulo+"}%' OR Autor LIKE '%{" + n_Autor + "}%' OR Tipo LIKE '%{" + n_Tipo + "}% OR Area LIKE '%{" + n_Area + "}%' OR Estado LIKE '%{" + n_Estado + "}%'";

        try {
            DBConnector conector = new DBConnector();
            pst = conector.getConexion().prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                
                String ISBN = rs.getString("ISBN");
                String Titulo = rs.getString("Titulo");
                String Autor = rs.getString("Autor");
                int Cantidad = rs.getInt("Cantidad");
                String Tipo = rs.getString("Tipo");
                String Area = rs.getString("Area");
                String Estado = rs.getString("Estado");

                Book s_Book = new Book(ISBN, Titulo, Autor, Tipo, Area, Estado, Cantidad);
                book_S.add(s_Book);
            }
            return book_S;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static boolean validar_login(String user, String password) {
        boolean result = false;

        String query = "SELECT * FROM usuarios WHERE user='" + user + "' AND password='" + password + "'";

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            DBConnector conector = new DBConnector();
            pst = conector.getConexion().prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                result = true;
            }
            return result;
        } catch (SQLException ex) {
            return false;
        }
    }
}
