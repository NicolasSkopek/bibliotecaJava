package com.java.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import com.java.config.ConexaoBanco;
import com.java.view.MenuView;

public class ListarController {
    private MenuView menuView;

    public ListarController(MenuView menuView){
        this.menuView = menuView;
    }
    public void ListarLivros(){
        menuView.mensagem("===== Livros Cadastrados =====");

        try {
            Connection conexao = ConexaoBanco.obterConexao();

            Statement declaracao = conexao.createStatement();

            String sql = "SELECT * FROM cadastrar_livro";
            ResultSet resultado = declaracao.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id_livro");
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                String editora = resultado.getString("editora");
                String paginas = resultado.getString("paginas");
                String genero = resultado.getString("genero");

                menuView.mensagem("\nID: " + id + " | Título: " + titulo + " | Autor: " + autor + " | Editora: " + editora + " | Páginas: " + paginas + " | Genero: " + genero);
            }

            resultado.close();
            declaracao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}