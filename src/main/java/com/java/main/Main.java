package com.java.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.java.config.ConexaoBanco;
import com.java.controller.*;
import com.java.model.*;
import com.java.view.*;

public class Main {
    public static void main(String[] args) {
        Connection conexao = null;
        try {
        conexao = ConexaoBanco.obterConexao(); // conexão com o banco
        if (conexao != null) {
            System.out.println("Conexão bem-sucedida!");
            TabelasModel.criarTabelas(conexao); // cria as tabelas
        } else {
            System.out.println("Falha ao conectar ao banco de dados.");
        }
    } catch (SQLException ex) {
        System.out.println("Ocorreu um problema: " + ex.getMessage());
    } finally {
        ConexaoBanco.fecharConexao(); // fecha conexão
    }   
        MenuView menuView = new MenuView();
        CadastroController cadastroController = new CadastroController(menuView);
        MenuController menuController = new MenuController(menuView, cadastroController);
        menuController.iniciar();
        }
    }   

