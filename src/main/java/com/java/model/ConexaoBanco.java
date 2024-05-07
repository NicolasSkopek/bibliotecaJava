package com.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static Connection conexao = null;

    public static Connection obterConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "postgres", "admin");
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver do banco de dados não localizado.");
            } catch (SQLException ex) {
                System.out.println("Ocorreu um problema ao acessar o banco: " + ex.getMessage());
                throw ex;
            }
        }
        return conexao;
    }

    public static void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão com o banco: " + ex.getMessage());
        }
    }
}
