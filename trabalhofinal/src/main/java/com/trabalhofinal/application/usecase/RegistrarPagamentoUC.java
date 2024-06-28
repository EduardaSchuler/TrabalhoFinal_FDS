package com.trabalhofinal.application.usecase;

import org.springframework.stereotype.Component;

import com.trabalhofinal.domain.service.PagamentoService;

@Component
public class RegistrarPagamentoUC {
    private PagamentoService ps;

    public RegistrarPagamentoUC(PagamentoService ps){
        this.ps = ps;
    }
}
