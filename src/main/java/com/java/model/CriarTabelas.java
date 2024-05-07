package com.java.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CriarTabelas {
    public static void criarTabelas(Connection conexao) {
        try {
            DatabaseMetaData metaData = conexao.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "cadastrar_livro", null);
            
            if (!resultSet.next()) {
                criarTabelaCadastrarLivro(conexao);  // tabela cadastrar_livro não existe, então podemos criá-la
            } else {
                System.out.println("Tabela cadastrar_livro já existe.");
            }
            
            resultSet = metaData.getTables(null, null, "listar_livros", null);
            
            if (!resultSet.next()) {
                criarTabelaListarLivros(conexao); // tabela listar_livros não existe, então podemos criá-la
            } else {
                System.out.println("Tabela listar_livros já existe.");
            }
            
            resultSet = metaData.getTables(null, null, "emprestar_livro", null);
            
            if (!resultSet.next()) {
                criarTabelaEmprestarLivro(conexao); // tabela emprestar_livro não existe, então podemos criá-la
            } else {
                System.out.println("Tabela emprestar_livro já existe.");
            }
            
            resultSet = metaData.getTables(null, null, "devolver_livro", null);
            
            if (!resultSet.next()) {
                criarTabelaDevolverLivro(conexao);  // tabela devolver_livro não existe, então podemos criá-la
            } else {
                System.out.println("Tabela devolver_livro já existe.");
            }
            
        } catch (SQLException ex) {
            System.out.println("Ocorreu um problema ao verificar ou criar as tabelas: " + ex.getMessage());
        }
    }
    
    private static void criarTabelaCadastrarLivro(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate("CREATE TABLE cadastrar_livro (" +
                "id_cadastrar_livro  INT NOT NULL  PRIMARY KEY," +
                "nome VARCHAR(50) NOT NULL," +
                "autor VARCHAR(50) NOT NULL," +
                "paginas INT NOT NULL" +
                ")");
        System.out.println("Tabela cadastrar_livro criada com sucesso.");
    }
    
    private static void criarTabelaListarLivros(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate("CREATE TABLE listar_livros (" +
                "id_listar_livros INT NOT NULL PRIMARY KEY," +
                "copias INT NOT NULL," +
                "id_livro INT NOT NULL," +
                "FOREIGN KEY (id_livro) REFERENCES cadastrar_livro(id_cadastrar_livro)" +
                ")");
        System.out.println("Tabela listar_livros criada com sucesso.");
    }
    
    private static void criarTabelaEmprestarLivro(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate("CREATE TABLE emprestar_livro (" +
                "id_emprestar_livro INT PRIMARY KEY," +
                "nome VARCHAR(50) NOT NULL," +
                "cliente VARCHAR(50) NOT NULL," +
                "dataAquisicao DATE NOT NULL" +
                ")");
        System.out.println("Tabela emprestar_livro criada com sucesso.");
    }
    
    private static void criarTabelaDevolverLivro(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate("CREATE TABLE devolver_livro (" +
                "id_devolver_livro INT PRIMARY KEY," +
                "dataDevolucao DATE NOT NULL," +
                "id_emprestar_livro INT NOT NULL," +
                "cliente VARCHAR(50) NOT NULL," +
                "FOREIGN KEY (id_emprestar_livro) REFERENCES emprestar_livro(id_emprestar_livro)" +
                ")");
        System.out.println("Tabela devolver_livro criada com sucesso.");
    }
}
