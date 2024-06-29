package com.trabalhofinal.application.dtos;

import com.trabalhofinal.domain.model.AplicativoModel;

public class AplicativoDTO {

    private long codigo; // Código identificador do aplicativo
    private String nome; // Nome fantasia pelo qual o aplicativo é conhecido
    private Double custoMensal; // Valor da assinatura mensal
    
    public AplicativoDTO(AplicativoModel app) {
        this.codigo = app.getCodigo();
        this.nome = app.getNome();
        this.custoMensal = app.getCustoMensal();
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

    public static AplicativoDTO fromModel(AplicativoModel aplicativoModel){
        return new AplicativoDTO(aplicativoModel);
    }

}
