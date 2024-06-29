package com.trabalhofinal.application.usecase;

import org.springframework.stereotype.Component;

import com.trabalhofinal.domain.service.AssinaturaService;

@Component
public class AssinaturaValidaUC {
    private AssinaturaService as;

    public AssinaturaValidaUC(AssinaturaService as){
        this.as = as;
    }

    public boolean executa(long codigoAssinatura){
        return as.assinaturaValida(codigoAssinatura);
    }
}
