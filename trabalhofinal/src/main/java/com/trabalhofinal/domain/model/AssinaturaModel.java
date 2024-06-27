package com.trabalhofinal.domain.model;

import java.time.LocalDate;

public class AssinaturaModel {

    enum Status{    ATIVA, CANCELADA    }

    private long codigo; //Código da assinatura
    private AplicativoModel aplicativo; //Aplicativo de que trata a assinatura
    private ClienteModel cliente; //Cliente de que trata a assinatura
    private LocalDate inicioVigencia; //Início da vigência da assinatura
    private LocalDate fimVigencia; //Fim da vigência da assinatura
    private Status status;


    public AssinaturaModel(long codigo, AplicativoModel aplicativo, ClienteModel cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.status = fimVigencia.isAfter(LocalDate.now()) ? Status.ATIVA : Status.CANCELADA;
    }

    public long getCodigo() {
        return codigo;
    }

    public AplicativoModel getAplicativo() {
        return aplicativo;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public Status getStatus(){
        return status;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setAplicativo(AplicativoModel aplicativo) {
        this.aplicativo = aplicativo;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

}
