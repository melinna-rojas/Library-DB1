/*
i just saw the tutorial, i just want to have the project done :cccc
 */
package library;

/**
 *
 * @author Melinna
 */
public class Book {
    String codigo,titulo,autor,tipo,estado;

    public Book(String codigo, String titulo, String autor, String tipo, String estado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
