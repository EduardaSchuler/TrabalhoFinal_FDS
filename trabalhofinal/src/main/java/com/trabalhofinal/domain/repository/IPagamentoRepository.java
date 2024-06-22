package com.trabalhofinal.domain.repository;

import java.util.Date;
import java.util.List;

import com.trabalhofinal.domain.model.Assinatura;
import com.trabalhofinal.domain.model.Pagamento;

public interface IPagamentoRepository {
    List<Pagamento> todos();
    Pagamento consultaPorCodigo(long codigo);
    boolean cadastrarNovo(Pagamento pagamento);
    Pagamento atualizaPagamentoAssinatura(long codigo, Assinatura novaAssinatura);
    Pagamento atualizaValorPago(long codigo, double novoValorPago);
    Pagamento atualizaDataPagamento(long codigo, Date novaDataPagamento);
    Pagamento editarPromocao(long codigo, String novaPromocao);
    
}
