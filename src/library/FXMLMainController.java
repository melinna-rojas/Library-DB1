/*
 * Project Name: Library
 * Summary: Designed with JavaFX and MySql, this programme solves the problem of
    disorganized librarians who dont have a well organized database or alerts for
    borrowed books.
 * Code by Rojas, Melinna and Rodriguez L, Carlos
 * All rights reserved
 */
package library;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author Melinna
 */
public class FXMLMainController implements Initializable {

    // Se eliminaron los objetos de la tabla y sus columnas
    @FXML
    private TableView tableInventario;
    @FXML
    private JFXButton btn_Rtc;
    @FXML
    private JFXButton btn_Sgt;

    private ArrayList<Book> books;
    private int index;

//    ObservableList<Book> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TableColumn col_Codigo;
        TableColumn col_Titulo;
        TableColumn col_Autor;
        TableColumn col_Tipo;
        TableColumn col_Area;
        TableColumn col_Estado;
        TableColumn col_Cantidad;

        col_Codigo = new TableColumn("ISBN");
        col_Titulo = new TableColumn("TITULO");
        col_Autor = new TableColumn("AUTOR");
        col_Tipo = new TableColumn("TIPO");
        col_Area = new TableColumn("AREA");
        col_Estado = new TableColumn("ESTADO");
        col_Cantidad = new TableColumn("CANTIDAD");

        col_Codigo.setPrefWidth(110);
        col_Titulo.setPrefWidth(320);
        col_Autor.setPrefWidth(200);
        col_Tipo.setPrefWidth(70);
        col_Area.setPrefWidth(100);
        col_Estado.setPrefWidth(100);
        col_Cantidad.setPrefWidth(70);

        tableInventario.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
            @Override
            public Boolean call(TableView.ResizeFeatures param) {
                return true;
            }

        });

        tableInventario.getColumns().addAll(col_Codigo, col_Titulo, col_Autor, col_Tipo, col_Area, col_Estado, col_Cantidad);
        books = Querys.listar();

        ArrayList<Book> _books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            _books.add(books.get(i));
            index = i;
        }

        ObservableList<Book> oblist = FXCollections.observableArrayList(_books);

        col_Codigo.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
        col_Titulo.setCellValueFactory(new PropertyValueFactory<Book, String>("Titulo"));
        col_Autor.setCellValueFactory(new PropertyValueFactory<Book, String>("Autor"));
        col_Tipo.setCellValueFactory(new PropertyValueFactory<Book, String>("Tipo"));
        col_Area.setCellValueFactory(new PropertyValueFactory<Book, String>("Area"));
        col_Estado.setCellValueFactory(new PropertyValueFactory<Book, String>("Estado"));
        col_Cantidad.setCellValueFactory(new PropertyValueFactory<Book, String>("Cantidad"));
        tableInventario.setItems(oblist);

    }

    @FXML
    private void retroceder(ActionEvent event) {

    }

    @FXML
    private void avanzar(ActionEvent event) {
        ArrayList<Book> b_avanzar = new ArrayList<>();
        if (books.size() - index < 10) {
            
            for (int i = index ; i < books.size(); i++) {
                b_avanzar.add(books.get(i));
            }
        } 
        else {
            for (int i = index + 1; i < index + 10; i++) {
                b_avanzar.add(books.get(i));
            }
        }
        
        ObservableList<Book> oblist = FXCollections.observableArrayList(b_avanzar);
        
        tableInventario.getItems().clear();
        tableInventario.getItems().addAll(oblist);
    }
}
