package com.trabalhofinal.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.Assinatura;
import com.trabalhofinal.domain.model.Pagamento;
import com.trabalhofinal.domain.repository.IPagamentoRepository;

@Service
public class PagamentoService {
    @Autowired
    private IPagamentoRepository pagamentoRepository;

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.todos();
    }

    public Pagamento consultaPorCodigo(long codigo){
        return pagamentoRepository.consultaPorCodigo(codigo);
    }

    public boolean cadastrarNovo(Pagamento pagamento){
        return pagamentoRepository.cadastrarNovo(pagamento);
    }

    public Pagamento atualizaPagamentoAssinatura(long codigo, Assinatura novaAssinatura){
        return pagamentoRepository.atualizaPagamentoAssinatura(codigo, novaAssinatura);
    }

    public Pagamento atualizaValorPago(long codigo, Double novoValorPago){
        return pagamentoRepository.atualizaValorPago(codigo, novoValorPago);
    }

    public Pagamento atualizaDataPagamento(long codigo, LocalDate novaDataPagamento){
        return pagamentoRepository.atualizaDataPagamento(codigo, novaDataPagamento);
    }

    public Pagamento editarPromocao(long codigo, String novaPromocao){
        return pagamentoRepository.editarPromocao(codigo, novaPromocao);
    }
}