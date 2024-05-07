package com.java.view;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Listar livros");
        System.out.println("3. Emprestar livro");
        System.out.println("4. Devolver livro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public void mensagem(String mensagem){
        System.out.println(mensagem);
    }
}