package com.trabalhofinal.application.dtos;

import com.trabalhofinal.domain.model.ClienteModel;


public class ClienteDTO {

    private long codigo; //Código identificador do cliente
    private String nome; //Nome do cliente
    private String email; //Email do cliente
    
    public ClienteDTO(ClienteModel cliente) {
        this.codigo = cliente.getCodigo();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
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

    public static ClienteDTO fromModel(ClienteModel cliente){
        return new ClienteDTO(cliente);
    }
}

