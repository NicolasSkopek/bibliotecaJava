package com.java.controller;
import java.util.Scanner;

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
        /*Lógica seria baseada em pedir as informações do livro e dia do emprestimo
        perguntar a data atual, e informar se foi entregue em dia ou atrasado
        remover a linha do BD*/
    }
}
