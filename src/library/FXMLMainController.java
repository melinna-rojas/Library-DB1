/*
 * Project Name: Library
 * Summary: Designed with JavaFX and MySql, this programme solves the problem of
    disorganized librarians who dont have a well organized database or alerts for
    borrowed books.
 * Code by Rojas, Melinna and Rodriguez L, Carlos
 * All rights reserved
 */
package library;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Melinna
 */
public class FXMLMainController {

    @FXML
    private TableView<Book> tableInventario;
    @FXML
    private TableColumn<Book, Book> col_Codigo;
    @FXML
    private TableColumn<Book, Book> col_Titulo;
    @FXML
    private TableColumn<Book, Book> col_Autor;
    @FXML
    private TableColumn<Book, Book> col_Tipo;
    @FXML
    private TableColumn<Book, Book> col_Estado;
    
    ObservableList<Book> oblist = FXCollections.observableArrayList();
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
//        try {
//            Connection con = DBConnector.getConnection();
//            ResultSet rs = con.createStatement().executeQuery("select * from data");
//            while(rs.next()){
//                oblist.add(new Book(rs.getString("id"),rs.getString("titulo"),
//                        rs.getString("autor"),rs.getString("tipo"),rs.getString("estado")));
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        col_Codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        col_Titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        col_Autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        col_Tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        col_Estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tableInventario.getColumns().addAll(col_Codigo,col_Titulo,col_Autor,col_Tipo,col_Estado);
        
        ArrayList<Book> books = Querys.listar();
        
        for (Book book : books) {
            tableInventario.getItems().add(book);
        }
    
//        tableInventario.setItems(oblist);
   }
}    
