package com.java.main;

import com.java.controller.*;
import com.java.model.*;
import com.java.view.*;

public class Main {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        CadastroController cadastroController = new CadastroController(menuView);
        MenuController menuController = new MenuController(menuView, cadastroController);
        menuController.iniciar();
    }
}
