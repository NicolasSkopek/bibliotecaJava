package com.java.model;

public class LivroModel{

    private String titulo;
    private String autor;
    private String editora;
    private String numPaginas;
    private String genero;
    
    public LivroModel(String titulo, String autor,String editora, String numPaginas,String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.numPaginas = numPaginas;
        this.genero = genero;
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
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public String getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
