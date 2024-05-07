package com.java.controller;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;


import com.java.config.ConexaoBanco;
import com.java.model.LivroModel;
import com.java.view.MenuView;

public class CadastroController {
    private Scanner scanner;
    private MenuView menuView;

    public CadastroController(MenuView menuView){
        scanner = new Scanner(System.in);
        this.menuView = menuView;
    }

    public void CadastrarLivro(){
        menuView.mensagem("===== Cadastrando Novo Livro =====");
        menuView.mensagem("Digite o título do livro:");
        String titulo = scanner.nextLine();
        menuView.mensagem("Digite o nome do autor:");
        String autor = scanner.nextLine();
        menuView.mensagem("Digite o nome da editora:");
        String editora = scanner.nextLine();
        menuView.mensagem("Digite o número de páginas:");
        String numPaginas = scanner.nextLine();
        menuView.mensagem("Digite o gênero:");
        String genero = scanner.nextLine();

        LivroModel novoLivro = new LivroModel(titulo, autor, editora, numPaginas, genero);
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            String retorno = cadastroBD(novoLivro, conexao);
            menuView.mensagem(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    } 
    
    public String cadastroBD(LivroModel livroModel, Connection conexao) {
        try {
            String sql = "INSERT INTO cadastrar_livro (titulo, autor, editora, paginas, genero) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, livroModel.getTitulo());
            preparedStatement.setString(2, livroModel.getAutor());
            preparedStatement.setString(3, livroModel.getEditora());
            preparedStatement.setString(4, livroModel.getNumPaginas());
            preparedStatement.setString(5, livroModel.getGenero());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Livro cadastrado com sucesso!";
            } else {
                return "Falha ao cadastrar o livro!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar o livro: " + ex.getMessage();
        }
    }
    
}
