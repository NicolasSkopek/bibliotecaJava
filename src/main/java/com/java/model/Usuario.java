package com.java.model;

public class Usuario extends Entidade{
    String nome;
    String telefone;

    public Usuario(String nome,String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public Usuario(int id,String nome,String telefone){
        super.setId(id);
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
