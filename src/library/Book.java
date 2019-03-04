/*
i just saw the tutorial, i just want to have the project done :cccc
 */
package library;

/**
 *
 * @author Melinna
 */
public class Book {
    String ISBN, Titulo,Autor, Tipo, Area, Estado;
   int Cantidad;

    public Book(String ISBN, String Titulo, String Autor, String Tipo, String Area, String Estado, int Cantidad) {
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Tipo = Tipo;
        this.Area = Area;
        this.Estado = Estado;
        this.Cantidad = Cantidad;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
    
   
}
