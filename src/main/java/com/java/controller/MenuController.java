package com.java.controller;

import com.java.view.MenuView;

public class MenuController {
    private MenuView menuView;
    private CadastroController cadastroController;
    private ListarController listarController;
    private EmprestimoController emprestimoController;
    private DevolverController devolverController;

    public MenuController(MenuView menuView, CadastroController cadastroController,ListarController listarController,EmprestimoController emprestimoController, DevolverController devolverController){
        this.menuView = menuView;
        this.cadastroController = cadastroController;
        this.listarController = listarController;
        this.emprestimoController = emprestimoController;
        this.devolverController = devolverController;
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
                        listarController.ListarLivros();
                        break;
                    case 3:
                        emprestimoController.EmprestimoLivro();
                        break;
                    case 4:
                        devolverController.DevolverLivro();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
        }
}
