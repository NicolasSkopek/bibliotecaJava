package com.java.controller;
import java.util.Scanner;

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

    }
}
