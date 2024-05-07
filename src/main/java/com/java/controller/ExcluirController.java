package com.java.controller;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;


import com.java.config.ConexaoBanco;
import com.java.model.LivroModel;
import com.java.view.MenuView;

public class ExcluirController {
    private Scanner scanner;
    private MenuView menuView;

    public ExcluirController(MenuView menuView){
        scanner = new Scanner(System.in);
        this.menuView = menuView;
    }
    public void ExcluirLivro(){
        menuView.mensagem("==== Excluindo Livro ====");
        menuView.mensagem("Digite o Id do livro que deseja Remover da lista:");
        int remov = scanner.nextInt();
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            String retorno = removeBD(conexao,remov);
            menuView.mensagem(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String removeBD(Connection conexao, int remov){
        try {
            String sql = "DELETE FROM cadastrar_livro WHERE id_livro = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, remov);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Livro removido com sucesso!";
            } else {
                return "Falha ao remover o livro!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao remover o livro: " + ex.getMessage();
        }
    }
}
