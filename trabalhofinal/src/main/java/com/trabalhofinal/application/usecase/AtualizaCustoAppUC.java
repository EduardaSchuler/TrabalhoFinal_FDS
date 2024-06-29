package com.trabalhofinal.application.usecase;

import org.springframework.stereotype.Component;

import com.trabalhofinal.application.dtos.AplicativoDTO;
import com.trabalhofinal.domain.service.AplicativoService;

@Component
public class AtualizaCustoAppUC {
    private AplicativoService as;

    public AtualizaCustoAppUC (AplicativoService as){
        this.as = as;
    }

    public AplicativoDTO executa(long idApp, Double novoCusto){
        return new AplicativoDTO(as.atualizarCusto(idApp, novoCusto));
    }
}
