package com.trabalhofinal.application.usecase;

import org.springframework.stereotype.Component;

import com.trabalhofinal.application.dtos.AssinaturaDTO;
import com.trabalhofinal.domain.service.AssinaturaService;

@Component
public class CriaAssinatura {
    private AssinaturaService as;

    public CriaAssinatura(AssinaturaService as){
        this.as = as;
    }

    public AssinaturaDTO executa(long codigo, long codigoCliente, long codigoAplicativo){
        return new AssinaturaDTO(as.criarAssinatura(codigo, codigoCliente, codigoAplicativo));
    }

}
