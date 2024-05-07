package com.java.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TabelasModel {
    public static void criarTabelas(Connection conexao) {
        try {
            DatabaseMetaData metaData = conexao.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "cadastrar_livro", null);
            
            if (!resultSet.next()) {
                criarTabelaCadastrarLivro(conexao);  // tabela cadastrar_livro não existe, então podemos criá-la
            } else {
                System.out.println("Tabela cadastrar_livro já existe.");
            }
            
            resultSet = metaData.getTables(null, null, "empréstimo_livro", null);
            
            if (!resultSet.next()) {
                criarTabelaEmprestimorLivro(conexao); // tabela emprestar_livro não existe, então podemos criá-la
            } else {
                System.out.println("Tabela emprestar_livro já existe.");
            }
            
        } catch (SQLException ex) {
            System.out.println("Ocorreu um problema ao verificar ou criar as tabelas: " + ex.getMessage());
        }
    }
    
    private static void criarTabelaCadastrarLivro(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate(
                "CREATE TABLE cadastrar_livro (" +
                "id_livro  SERIAL NOT NULL  PRIMARY KEY," +
                "titulo VARCHAR(50) NOT NULL," +
                "autor VARCHAR(50) NOT NULL," +
                "editora VARCHAR(50) NOT NULL," +
                "paginas VARCHAR(4) NOT NULL," +
                "genero VARCHAR(50) NOT NULL," +
                "flag_disponibilidade INTEGER" +
                ")");
        System.out.println("Tabela cadastrar_livro criada com sucesso.");
    }
    
    private static void criarTabelaEmprestimorLivro(Connection conexao) throws SQLException {
        conexao.createStatement().executeUpdate(
                "CREATE TABLE emprestar_livro (" +
                "id_emprestimo SERIAL PRIMARY KEY," +
                "id_livro_fk INT NOT NULL," +
                "titulo_livro VARCHAR(50) NOT NULL," +
                "cliente VARCHAR(50) NOT NULL," +
                "contato VARCHAR(13) NOT NULL," +
                "FOREIGN KEY (id_livro_fk) REFERENCES cadastrar_livro(id_livro)"+
                ")");
        System.out.println("Tabela emprestimo_livro criada com sucesso.");
    }

}
