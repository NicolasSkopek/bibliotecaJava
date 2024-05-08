package com.java.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;


import com.java.config.ConexaoBanco;
import com.java.model.EmprestimoModel;
import com.java.model.LivroModel;
import com.java.view.MenuView;

public class EmprestimoController {
    private Scanner scanner;
    private MenuView menuView;

    public EmprestimoController(MenuView menuView){
        scanner = new Scanner(System.in);
        this.menuView = menuView;
    }

    public void EmprestimoLivro(){
        menuView.mensagem("===== Emprestando Novo Livro =====\n");
        menuView.mensagem("Digite o ID do livro a ser emprestado: ");
        int idLivro = scanner.nextInt();
        menuView.mensagem("Digite o título do livro: ");
        scanner.nextLine();
        String titulo = scanner.nextLine();
        menuView.mensagem("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        menuView.mensagem("Digite o número de telefone do cliente: ");
        String telefone = scanner.nextLine();

        try {
            Connection conexao = ConexaoBanco.obterConexao();
            String sql = "SELECT * FROM cadastrar_livro WHERE id_livro = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, idLivro);
            ResultSet resultado = preparedStatement.executeQuery();
            
            if (resultado.next()) {
                int disponibilidade = resultado.getInt("flag_disponibilidade");
                if(disponibilidade!=1){
                    EmprestimoModel novoEmprestimo = new EmprestimoModel(idLivro, titulo, nomeCliente, telefone);
                        String retorno = emprestimoBD(novoEmprestimo, conexao);
                        menuView.mensagem(retorno);
                    LivroModel livroModel = new LivroModel(disponibilidade);
                    livroModel.atualizarDisponibilidade_indsp(conexao,idLivro);
                }else{
                    menuView.mensagem("O livro não está disponível para empréstimo.");
                }
            } else {
                menuView.mensagem("Nenhum livro encontrado com o ID fornecido.");
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    } 
    
    public String emprestimoBD(EmprestimoModel novoEmprestimo, Connection conexao) {
        try {
            String sql = "INSERT INTO emprestar_livro (id_livro_fk, titulo_livro, cliente, contato) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, novoEmprestimo.getIdLivro());
            preparedStatement.setString(2, novoEmprestimo.getTitulo());
            preparedStatement.setString(3, novoEmprestimo.getNomeCliente());
            preparedStatement.setString(4, novoEmprestimo.getContatoCliente());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Livro emprestado com sucesseso";
            } else {
                return "Falha ao emprestar o livro!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao emprestar o livro: " + ex.getMessage();
        }
    }
    
}
