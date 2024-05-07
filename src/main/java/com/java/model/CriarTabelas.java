package com.java.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {
    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = ConexaoBanco.obterConexao();
            Statement statement = conexao.createStatement();

            statement.executeUpdate("CREATE TABLE cadastrar_livro (" +
                    "id_cadastrar_livro  INT NOT NULL  PRIMARY KEY," +
                    "nome VARCHAR(50) NOT NULL," +
                    "autor VARCHAR(50) NOT NULL," +
                    "paginas INT NOT NULL" +
                    ")");
            statement.executeUpdate("CREATE TABLE listar_livros (" +
                    "id_listar_livros INT NOT NULL PRIMARY KEY," +
                    "copias INT NOT NULL," +
                    "id_livro INT NOT NULL," +
                    "FOREIGN KEY (id_livro) REFERENCES cadastrar_livro(id_cadastrar_livro)" +
                    ")");
            statement.executeUpdate("CREATE TABLE emprestar_livro (" +
                    "id_emprestar_livro INT PRIMARY KEY," +
                    "nome VARCHAR(50) NOT NULL," +
                    "cliente VARCHAR(50) NOT NULL," +
                    "dataAquisicao DATE NOT NULL" +
                    ")");
            statement.executeUpdate("CREATE TABLE devolver_livro (" +
                    "id_devolver_livro INT PRIMARY KEY," +
                    "dataDevolucao DATE NOT NULL," +
                    "id_emprestar_livro INT NOT NULL," +
                    "cliente VARCHAR(50) NOT NULL," +
                    "FOREIGN KEY (id_emprestar_livro) REFERENCES emprestar_livro(id_emprestar_livro)" +
                    ")");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um problema ao criar as tabelas: " + ex.getMessage());
        } finally {
            ConexaoBanco.fecharConexao();
        }
    }
}
