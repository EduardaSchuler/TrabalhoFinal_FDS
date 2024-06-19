package com.trabalhofinal.domain.model;

public class Cliente {
    private long codigo; //Código identificador do cliente
    private String nome; //Nome do cliente
    private String email; //Email do cliente
    
    public Cliente(long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
