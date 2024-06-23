package com.trabalhofinal.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aplicativo {

    @Id
    private long codigo; // Código identificador do aplicativo
    private String nome; // Nome fantasia pelo qual o aplicativo é conhecido
    private Double custoMensal; // Valor da assinatura mensal
    
    public Aplicativo(long codigo, String nome, Double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Double getCustoMensal() {
        return custoMensal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCustoMensal(Double custoMensal) {
        this.custoMensal = custoMensal;
    }

}
