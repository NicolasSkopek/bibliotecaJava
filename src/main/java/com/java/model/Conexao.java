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
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nomeDoBanco", "username", "password"); // username, por padrão, é postgres. A senha é aquela que você cadastra assim que baixa o PostgreSQL ou pgAdmin4

            //(EXEMPLO)
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM cadastrar_livro"); // De exemplo, estamos usando o comando SELECT para exibir todas colunas da tabela 'cadastrar_livro'. Os dados que exibimos foram inseridos direto no pgAdmin4 apenas para teste, mas no trabalho final, deverão ser inseridas pelo código Java. EXEMPLO: .createStatement().executeQuery("INSERT INTO nomeDaTabela (coluna1, coluna2) VALUES (value1, value2)"); :)
            while (rsCliente.next()) {

                //(EXEMPLO)
                System.out.println("Nome: " + rsCliente.getString("nome")); // usamos o While para exibir todos. A condição dentro do While faz com que, assim que um elemento da tabela é exibido (no caso, o nome) ele pula para o próximo, até não haver mais elementos a serem exibidos. 
                // IMPORTANTE: Baixe as 4 primeiras extensões quando você pesquisa 'Spring' na aba de extensões do VSCode.
                // Tenha certeza de que a tabela esteja criada no pgAdmin4.
            }
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