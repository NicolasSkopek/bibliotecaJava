package com.java.controller;
import java.util.Scanner;

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
        /*Lógica seria baseada em pedir o id do livro e as informações do usuario
        pedir data atual e a data para entrega
        adicionar linha ao BD */
    }
}
