package com.trabalhofinal.application.usecase;

import org.springframework.stereotype.Component;

import com.trabalhofinal.application.dtos.AssinaturaDTO;
import com.trabalhofinal.domain.service.PagamentoService;

@Component
public class RegistrarPagamentoUC {
    private PagamentoService ps;

    public RegistrarPagamentoUC(PagamentoService ps){
        this.ps = ps;
    }

    public String executa(long codigo, long codigoAssinatura, Double valorPago, String promocao){
        return ps.cadastrarNovo(codigo, codigoAssinatura, valorPago, promocao);
    }
}
