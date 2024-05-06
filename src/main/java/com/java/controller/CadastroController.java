package com.java.controller;
import java.util.Scanner;

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
        String retorno = cadastroBD(novoLivro);
        menuView.mensagem(retorno);
    } 
    public String cadastroBD(LivroModel livroModel){
        //chama a função para enviar os dados para o BD
        return "Livro cadastrado com sucesso!";
    }
}
