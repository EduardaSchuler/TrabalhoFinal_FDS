package com.trabalhofinal.domain.model;

import java.util.Date;

public class Assinatura {
    private long codigo; //Código da assinatura
    private Aplicativo aplicativo; //Aplicativo de que trata a assinatura
    private Cliente cliente; //Cliente de que trata a assinatura
    private Date inicioVigencia; //Início da vigência da assinatura
    private Date fimVigencia; //Fim da vigência da assinatura

    public Assinatura(long codigo, Aplicativo aplicativo, Cliente cliente, Date inicioVigencia, Date fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getCodigo() {
        return codigo;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    
}
