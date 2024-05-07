package com.java.controller;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;

import com.java.config.ConexaoBanco;
import com.java.model.LivroModel;
import com.java.view.MenuView;

public class ListarController {
    private Scanner scanner;
    private MenuView menuView;

    public ListarController(MenuView menuView){
        scanner = new Scanner(System.in);
        this.menuView = menuView;
    }
    public void ListarLivros(){
        menuView.mensagem("===== Livros Cadastrados =====");

        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = ConexaoBanco.obterConexao();

            // Cria uma declaração para executar a consulta SQL
            Statement declaracao = conexao.createStatement();

            // Executa a consulta SQL para recuperar os dados dos livros
            String sql = "SELECT * FROM cadastrar_livro";
            ResultSet resultado = declaracao.executeQuery(sql);

            // Exibe os dados dos livros
            while (resultado.next()) {
                int id = resultado.getInt("id_livro");
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                String editora = resultado.getString("editora");
                String paginas = resultado.getString("paginas");
                String genero = resultado.getString("genero");

                menuView.mensagem("\nID: " + id + " | Título: " + titulo + " | Autor: " + autor + " | Editora: " + editora + " | Páginas: " + paginas + " | Genero: " + genero);
            }

            // Fecha os recursos
            resultado.close();
            declaracao.close();
            conexao.close();
        } catch (SQLException e) {
            // Trata os erros de SQL
            e.printStackTrace();
        }
    }
}