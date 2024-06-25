package com.trabalhofinal.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.model.PagamentoModel;
import com.trabalhofinal.domain.repository.IPagamentoRepository;

@Service
public class PagamentoService {
    @Autowired
    private IPagamentoRepository pagamentoRepository;

    public List<PagamentoModel> listarTodos() {
        return pagamentoRepository.todos();
    }

    public PagamentoModel consultaPorCodigo(long codigo){
        return pagamentoRepository.consultaPorCodigo(codigo);
    }

    public boolean cadastrarNovo(PagamentoModel pagamento){
        return pagamentoRepository.cadastrarNovo(pagamento);
    }

    public PagamentoModel atualizaPagamentoAssinatura(long codigo, AssinaturaModel novaAssinatura){
        return pagamentoRepository.atualizaPagamentoAssinatura(codigo, novaAssinatura);
    }

    public PagamentoModel atualizaValorPago(long codigo, Double novoValorPago){
        return pagamentoRepository.atualizaValorPago(codigo, novoValorPago);
    }

    public PagamentoModel atualizaDataPagamento(long codigo, LocalDate novaDataPagamento){
        return pagamentoRepository.atualizaDataPagamento(codigo, novaDataPagamento);
    }

    public PagamentoModel editarPromocao(long codigo, String novaPromocao){
        return pagamentoRepository.editarPromocao(codigo, novaPromocao);
    }
}