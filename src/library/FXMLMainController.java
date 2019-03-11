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
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
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
    @FXML
    private JFXComboBox<String> cb_Area;
    @FXML
    private JFXComboBox<String> cb_Tipo;
    @FXML
    private JFXComboBox<String> cb_Estado;
    @FXML
    private JFXTextField txt_Titulo;
    @FXML
    private JFXTextField txt_Autor;
    @FXML
    private Label btn_Inicio;
    @FXML
    private Label btn_Prestamos;
    @FXML
    private Label btn_Alumnos;
    @FXML
    private Label btn_Inventario;
    @FXML
    private JFXTabPane tab_main;
    @FXML
    private Label pop_Id;
    @FXML
    private ImageView btn_Search;

    private JFXPopup popUp = new JFXPopup();

    private ArrayList<Book> books;
    private int index;
    private int pag = 1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initPopUp();

        //Llenando los combo box
        ArrayList<String> tipos = Querys.mostrar_Tipo();
        tipos.forEach((tipo) -> {
            cb_Tipo.getItems().add(tipo);
        });
        cb_Tipo.setValue("");

        ArrayList<String> estados = Querys.mostrar_Estado();

        estados.forEach((estado) -> {
            cb_Estado.getItems().add(estado);
        });
         cb_Estado.setValue("");

        ArrayList<String> areas = Querys.mostrar_Area();

        areas.forEach((area) -> {
            cb_Area.getItems().add(area);
        });
         cb_Area.setValue("");

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

        col_Codigo.setPrefWidth(130);
        col_Titulo.setPrefWidth(400);
        col_Autor.setPrefWidth(300);
        col_Tipo.setPrefWidth(90);
        col_Area.setPrefWidth(150);
        col_Estado.setPrefWidth(100);
        col_Cantidad.setPrefWidth(80);

        btn_Rtc.setDisable(true);

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

        col_Codigo.setCellValueFactory(new PropertyValueFactory("ISBN"));
        col_Titulo.setCellValueFactory(new PropertyValueFactory("Titulo"));
        col_Autor.setCellValueFactory(new PropertyValueFactory("Autor"));
        col_Tipo.setCellValueFactory(new PropertyValueFactory("Tipo"));
        col_Area.setCellValueFactory(new PropertyValueFactory("Area"));
        col_Estado.setCellValueFactory(new PropertyValueFactory("Estado"));
        col_Cantidad.setCellValueFactory(new PropertyValueFactory("Cantidad"));
        tableInventario.setItems(oblist);
    }

    @FXML
    private void retroceder(ActionEvent event) {
        ArrayList<Book> b_retroceder = new ArrayList<>(); // Se crea el arraylist para los datos a mostrar

        btn_Sgt.setDisable(false); // Se habilita el boton sgte
        pag--;
        if (pag > 0) {

            int inicio = 10 * (pag - 1);

            for (int i = inicio; i < inicio + 10; i++) {
                b_retroceder.add(books.get(i));
                index = i;
            }

            ObservableList<Book> oblist = FXCollections.observableArrayList(b_retroceder);

            tableInventario.getItems().clear();
            tableInventario.getItems().addAll(oblist);

            if (pag == 1) {
                btn_Rtc.setDisable(true);
            } else {
                btn_Rtc.setDisable(false);
            }
        }
    }

    @FXML
    private void avanzar(ActionEvent event) {
        ArrayList<Book> b_avanzar = new ArrayList<>();

        pag++; // aumenta el numero de pagina

        btn_Rtc.setDisable(false); // Se habilita el boton retroceder

        if ((books.size() - (index + 1)) < 10) {
            btn_Sgt.setDisable(true);

            for (int i = index + 1; i < books.size(); i++) {
                b_avanzar.add(books.get(i));
                index = i;
            }
        } else {
            btn_Sgt.setDisable(false);
            int i;
            for (i = index + 1; i <= index + 10; i++) {
                b_avanzar.add(books.get(i));
            }
            index = i;

        }
        ObservableList<Book> oblist = FXCollections.observableArrayList(b_avanzar);
        tableInventario.getItems().clear();
        tableInventario.getItems().addAll(oblist);
    }

    @FXML
    private void changeTab(MouseEvent event) {
        String label_Name = ((Label) event.getSource()).getText();
        switch (label_Name) {
            case "inicio":
                tab_main.getSelectionModel().select(0);
                break;
            case "prestamos":
                tab_main.getSelectionModel().select(1);
                break;
            case "alumnos":
                tab_main.getSelectionModel().select(2);
                break;
            case "inventario":
                tab_main.getSelectionModel().select(3);
                break;
        }
    }

    @FXML
    private void popUp_Click(MouseEvent event) {
        popUp.show(pop_Id, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT);
    }

    private void initPopUp() {
        JFXButton logout = new JFXButton("Cerrar Sesion");
        JFXButton close = new JFXButton("Salir");
        logout.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {

        });

        close.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
            System.exit(0);
        });

        logout.setPadding(new Insets(10));
        logout.setPrefWidth(189);
        close.setPrefWidth(189);
        close.setPadding(new Insets(10));
        VBox vbox = new VBox(logout, close);
        popUp.setPopupContent(vbox);
    }

    @FXML
    private void search_Queries(MouseEvent event) {
        String Titulo = txt_Titulo.getText();
        String Autor = txt_Autor.getText();
        String Tipo = cb_Tipo.getValue();
        String Area = cb_Area.getValue();
        String Estado = cb_Estado.getValue();
        
        ArrayList<Book> n_books = new ArrayList<>();
        
        n_books = Querys.search_Books(Titulo, Autor, Tipo, Area, Estado);
        System.out.println(n_books.size());
        ObservableList<Book> oblist = FXCollections.observableArrayList(n_books);
        tableInventario.getItems().clear();
        tableInventario.setItems(oblist);
    }
}
