package com.trabalhofinal.domain.model;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.cglib.core.Local;

@Entity
public class AssinaturaModel {

    @Id
    private long codigo; //Código da assinatura
    private AplicativoModel aplicativo; //Aplicativo de que trata a assinatura
    private ClienteModel cliente; //Cliente de que trata a assinatura
    private LocalDate inicioVigencia; //Início da vigência da assinatura
    private LocalDate fimVigencia; //Fim da vigência da assinatura


    public AssinaturaModel(long codigo, AplicativoModel aplicativo, ClienteModel cliente, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
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
