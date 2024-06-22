package com.trabalhofinal.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.Aplicativo;
import com.trabalhofinal.domain.service.AplicativoService;

@Service
public class atualizaCustoAplicativo {
    @Autowired
    private AplicativoService aplicativoService;

    public Aplicativo executa(Long id, double custoMensal) {
        return aplicativoService.atualizarCusto(id, custoMensal);
    }
}
