package com.java.model;

public class EmprestimoModel extends EntidadeInterface{

    private int idLivro;
    private String titulo;
    private String nomeCliente;
    private String contatoCliente;
  
    public EmprestimoModel(int idLivro, String titulo, String nomeCliente, String contatoCliente) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.nomeCliente = nomeCliente;
        this.contatoCliente = contatoCliente;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getContatoCliente() {
        return contatoCliente;
    }

    public void setContatoCliente(String contatoCliente) {
        this.contatoCliente = contatoCliente;
    }

   
}
