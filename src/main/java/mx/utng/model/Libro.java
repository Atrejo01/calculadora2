package mx.utng.model;

public class Libro {
    private int id;
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int anio;
    private int existencias;
    private int disponibles;
    
    public Libro() {
    }

    

    public Libro(int id, String isbn, String titulo, String autor, String editorial, int anio, int existencias,
            int disponibles) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.existencias = existencias;
        this.disponibles = disponibles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", anio=" + anio
                + ", existencias=" + existencias + ", disponibles=" + disponibles + "]";
    }



    public String getEditorial() {
        return editorial;
    }



    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
