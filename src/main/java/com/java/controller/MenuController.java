package com.java.controller;

import com.java.view.MenuView;

public class MenuController {
    private MenuView menuView;
    private CadastroController cadastroController;

    public MenuController(MenuView menuView, CadastroController cadastroController) {
        this.menuView = menuView;
        this.cadastroController = cadastroController;
        }

        public void iniciar() {
            int opcao;
            do {
                opcao = menuView.exibirMenu();
                switch (opcao) {
                    case 1:
                        cadastroController.CadastrarLivro();
                        break;
                    case 2:
                        // Lógica para lidar com a opção 2
                        break;
                    case 3:
                        //Lógica para lidar com a opção 3
                        break;
                    case 4:
                        //Lógica para lidar com a opção 4
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 5);
        }
}
