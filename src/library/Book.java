/*
i just saw the tutorial, i just want to have the project done :cccc
 */
package library;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Melinna
 */
public class Book {
//    String ISBN, Titulo,Autor, Tipo, Area, Estado;
//    int Cantidad;
//    Se cambiarion los atributos a objetos del tipo SimpleStringProperty para que puedan ser agregados a un ObservableArrayList  
        SimpleStringProperty ISBN;
        SimpleStringProperty Titulo;
        SimpleStringProperty Autor;
        SimpleStringProperty Tipo;
        SimpleStringProperty Area;
        SimpleStringProperty Estado;
        SimpleStringProperty Cantidad;

    // Al ser SimpleStringProperty se utiliza el setValue() para definir un nuevo valor
    public Book(String ISBN, String Titulo, String Autor, String Tipo, String Area, String Estado, int Cantidad) {
        this.ISBN = new SimpleStringProperty(ISBN);
        this.Titulo = new SimpleStringProperty(Titulo);
        this.Autor = new SimpleStringProperty(Autor);
        this.Tipo = new SimpleStringProperty(Tipo);
        this.Area = new SimpleStringProperty(Area);
        this.Estado = new SimpleStringProperty(Estado);
        this.Cantidad = new SimpleStringProperty(String.valueOf(Cantidad));
    }
    // Los getters y setters se cambiaron sutilmente con los metodos get() y setValue()
    public String getISBN() {
        return ISBN.get();
    }

    public void setISBN(String ISBN) {
        this.ISBN.setValue(ISBN);
    }

    public String getTitulo() {
        return Titulo.get();
    }

    public void setTitulo(String Titulo) {
        this.Titulo.setValue(Titulo);
    }

    public String getAutor() {
        return Autor.get();
    }

    public void setAutor(String Autor) {
        this.Autor.setValue(Autor);
    }

    public String getTipo() {
        return Tipo.get();
    }

    public void setTipo(String Tipo) {
        this.Tipo.setValue(Tipo);
    }

    public String getArea() {
        return Area.get();
    }

    public void setArea(String Area) {
        this.Area.setValue(Area);
    }
    
   public String getCantidad(){
       return Cantidad.get();
   }
   
   public void setCantidad(int Cantidad){
       this.Cantidad.setValue(String.valueOf(Cantidad));
   }
   
   public String getEstado(){
       return Estado.get();
   }
   
   public void setEstado(String Estado){
       this.Estado.setValue(Estado);
   }
}
