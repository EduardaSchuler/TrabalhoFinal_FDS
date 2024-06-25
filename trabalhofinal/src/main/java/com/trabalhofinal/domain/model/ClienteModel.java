package com.trabalhofinal.domain.model;

import javax.persistence.*;

public class ClienteModel {

    private long codigo; //Código identificador do cliente
    private String nome; //Nome do cliente
    private String email; //Email do cliente
    
    public ClienteModel(long codigo, String nome, String email) {
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

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
