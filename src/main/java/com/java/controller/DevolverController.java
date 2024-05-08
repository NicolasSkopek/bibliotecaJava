package com.java.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.config.ConexaoBanco;
import com.java.model.LivroModel;
import com.java.view.MenuView;

public class DevolverController {
    private Scanner scanner;
    private MenuView menuView;

    public DevolverController(MenuView menuView){
        scanner = new Scanner(System.in);
        this.menuView = menuView;
    }
    public void DevolverLivro(){
        menuView.mensagem("===== Devolução de Livro =====\n");
        menuView.mensagem("Digite o id do livro que deseja devolver:");
        int Dlivro = scanner.nextInt();
        try {
            Connection conexao = ConexaoBanco.obterConexao();
            String sql = "SELECT * FROM cadastrar_livro WHERE id_livro = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, Dlivro);
            ResultSet resultado = preparedStatement.executeQuery();
            
            if (resultado.next()) {
                int id = resultado.getInt("id_livro");
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                String editora = resultado.getString("editora");
                String paginas = resultado.getString("paginas");
                String genero = resultado.getString("genero");
    
                menuView.mensagem("\nID: " + id + " | Título: " + titulo + " | Autor: " + autor + " | Editora: " + editora + " | Páginas: " + paginas + " | Genero: " + genero);
    
                menuView.mensagem("\nDeseja devolver este livro?:(S/N)");
                scanner.nextLine();
                String validacao = scanner.nextLine();

                if(validacao.equals("S") || validacao.equals("s")){


                    conexao = ConexaoBanco.obterConexao();
                    sql = "SELECT * FROM cadastrar_livro WHERE id_livro = ?";
                    preparedStatement = conexao.prepareStatement(sql);
                    preparedStatement.setInt(1, id);
                    resultado = preparedStatement.executeQuery();
            
                    if (resultado.next()) {
                        int disponibilidade = resultado.getInt("flag_disponibilidade");
                        if(disponibilidade==1){
                            String retorno = devololucaoBD(conexao,Dlivro);
                            menuView.mensagem(retorno); 
                            LivroModel livroModel = new LivroModel(disponibilidade);
                            livroModel.atualizarDisponibilidade_dsp(conexao,id);
                        }else{
                            menuView.mensagem("O livro ainda não foi emprestado.");
                        }
                    } 
                }else{
                    menuView.mensagem("Operação cancelada!");
                }
            } else {
                menuView.mensagem("Nenhum livro encontrado com o ID fornecido.");
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public String devololucaoBD(Connection conexao, int Dlivro){
        try {
            String sql = "DELETE FROM emprestar_livro WHERE id_livro_fk = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, Dlivro);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Livro devolvido com sucesso!";
            } else {
                return "Falha ao devolver o livro!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao dvolver o livro: " + ex.getMessage();
        }
    }
}

