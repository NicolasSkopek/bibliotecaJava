package com.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroModel implements DisponibilidadeInterface{

    private String titulo;
    private String autor;
    private String editora;
    private String numPaginas;
    private String genero;
    private int disponivel;
    
    public LivroModel(String titulo, String autor,String editora, String numPaginas,String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.numPaginas = numPaginas;
        this.genero = genero;
    }
    
    public LivroModel(int disponivel){
        this.disponivel = disponivel;
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
    @Override
    public int verificadisponibilidade() {
        return disponivel;
    }
        public void atualizarDisponibilidade_indsp(Connection conexao, int idLivro) throws SQLException {
        String sql = "UPDATE cadastrar_livro SET flag_disponibilidade = ? WHERE id_livro = ?";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, idLivro);
            preparedStatement.executeUpdate();
        }
    }
    public void atualizarDisponibilidade_dsp(Connection conexao, int id) throws SQLException {
        String sql = "UPDATE cadastrar_livro SET flag_disponibilidade = ? WHERE id_livro = ?";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }
}
