package com.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    public static void main(String[] args) throws SQLException {

        Connection conexao = null;

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "postgres", "983632"); // username, por padrão, é postgres. A senha é aquela que você cadastra assim que baixa o PostgreSQL ou pgAdmin4

            //criação do banco de dados
            conexao.createStatement().executeUpdate("CREATE TABLE cadastrar_livro (" +
             "id_cadastrar_livro  INT NOT NULL  PRIMARY KEY," +
             "nome VARCHAR(50) NOT NULL," +
             "autor VARCHAR(50) NOT NULL," +
             "paginas INT NOT NULL" +
            ")");
            conexao.createStatement().executeUpdate("CREATE TABLE listar_livros (" +
            "id_listar_livros INT NOT NULL PRIMARY KEY," +
            "copias INT NOT NULL," +
            "id_livro INT NOT NULL," +
            "FOREIGN KEY (id_livro) REFERENCES cadastrar_livro(id_cadastrar_livro)" +
            ")");
            conexao.createStatement().executeUpdate("CREATE TABLE emprestar_livro (" +
                "id_emprestar_livro INT PRIMARY KEY," +
                "nome VARCHAR(50) NOT NULL," +
                "cliente VARCHAR(50) NOT NULL," +
                "dataAquisicao DATE NOT NULL" +
            ")");
            conexao.createStatement().executeUpdate("CREATE TABLE devolver_livro (" +
                "id_devolver_livro INT PRIMARY KEY," +
                "dataDevolucao DATE NOT NULL," +
                "id_emprestar_livro INT NOT NULL," +
                "cliente VARCHAR(50) NOT NULL," +
                "FOREIGN KEY (id_emprestar_livro) REFERENCES emprestar_livro(id_emprestar_livro)" +
            ")");


        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um problema ao acessar o banco: " + ex.getMessage());           
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }
}