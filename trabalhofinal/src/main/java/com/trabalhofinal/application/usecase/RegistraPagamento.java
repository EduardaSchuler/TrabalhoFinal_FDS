package com.trabalhofinal.application.usecase;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.Pagamento;
import com.trabalhofinal.domain.service.PagamentoService;

@Service
public class RegistraPagamento {
    @Autowired
    private PagamentoService pagamentoService;

    public Pagamento executa(Long codigoAssinatura, double valorPago, String promocao) throws ParseException {
        return pagamentoService.registrarPagamento(codigoAssinatura, valorPago, promocao);
    }
}
