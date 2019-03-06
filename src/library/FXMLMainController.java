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
public class FXMLMainController implements Initializable{

    // Se eliminaron los objetos de la tabla y sus columnas
    @FXML
    private TableView tableInventario;

    
//    ObservableList<Book> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
            
        TableColumn col_Codigo;

        TableColumn col_Titulo;

        TableColumn col_Autor;

        TableColumn col_Tipo;

        TableColumn col_Estado;
        
        
        col_Codigo = new TableColumn("ISBN");
        col_Titulo = new TableColumn("TITULO");
        col_Autor = new TableColumn("AUTOR");
        col_Tipo =  new TableColumn("TIPO");
        col_Estado = new TableColumn("ESTADO");
        
        col_Codigo.setPrefWidth(70);
        col_Titulo.setPrefWidth(407);
        col_Autor.setPrefWidth(202);
        col_Tipo.setPrefWidth(100);
        col_Estado.setPrefWidth(100);
        
        
        tableInventario.getColumns().addAll(col_Codigo,col_Titulo,col_Autor,col_Tipo,col_Estado);
        
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("0001", "Hola mundo", "Carlos", "dasad","asdasd", "asda",3));
        books.add(new Book("0002", "Hola mundo1", "Carñaslos","dasad","asdasd", "asda", 6));
        books.add(new Book("0003", "Hola mundo2", "Carlxdos","dasad","asdasd", "asda", 7));
        books.add(new Book("0004", "Hola mundo3", "qwqw","dasad","asdasd", "asda", 8));

        
        ObservableList<Book> oblist = FXCollections.observableArrayList(books);
        
        col_Codigo.setCellValueFactory(new PropertyValueFactory<Book,String>("ISBN"));
        col_Titulo.setCellValueFactory(new PropertyValueFactory<Book,String>("Titulo"));
        col_Autor.setCellValueFactory(new PropertyValueFactory<Book,String>("Autor"));
        col_Tipo.setCellValueFactory(new PropertyValueFactory<Book,String>("Tipo"));
        col_Estado.setCellValueFactory(new PropertyValueFactory<Book,String>("Estado"));
        
        
        tableInventario.setItems(oblist);
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
//        col_Codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
//        col_Titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
//        col_Autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
//        col_Tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
//        col_Estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
//        tableInventario.getColumns().addAll(col_Codigo,col_Titulo,col_Autor,col_Tipo,col_Estado);
//        
//        ArrayList<Book> books = Querys.listar();
//        
//        for (Book book : books) {
//            tableInventario.getItems().add(book);
//        }
    
//        tableInventario.setItems(oblist);



   }
}    
