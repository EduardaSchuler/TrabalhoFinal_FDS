package com.trabalhofinal.application.dtos;

import java.time.LocalDate;

import com.trabalhofinal.domain.model.AplicativoModel;
import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.model.ClienteModel;

public class AssinaturaDTO {
    private long codigo; //Código da assinatura
    private AplicativoModel aplicativo; //Aplicativo de que trata a assinatura
    private ClienteModel cliente; //Cliente de que trata a assinatura
    private LocalDate inicioVigencia; //Início da vigência da assinatura
    private LocalDate fimVigencia; //Fim da vigência da assinatura
    private String status;

    public AssinaturaDTO(AssinaturaModel assinatura) {
        this.codigo = assinatura.getCodigo();
        this.aplicativo = assinatura.getAplicativo();
        this.cliente = assinatura.getCliente();
        this.inicioVigencia = assinatura.getInicioVigencia();
        this.fimVigencia = assinatura.getFimVigencia();
        this.status = assinatura.getStatus().toString();
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

    public String getStatus(){
        return status;
    }

    public static AssinaturaDTO fromModel(AssinaturaModel assinaturaModel){
        return new AssinaturaDTO(assinaturaModel);
    }

}
