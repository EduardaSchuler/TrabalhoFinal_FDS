package com.trabalhofinal.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aplicativo {

    @Id
    private long codigo; // Código identificador do aplicativo
    private String nome; // Nome fantasia pelo qual o aplicativo é conhecido
    private double custoMensal; // Valor da assinatura mensal
    
    public Aplicativo(long codigo, String nome, double custoMensal) {
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

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }

}
