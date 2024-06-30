package com.trabalhofinal.domain.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.model.PagamentoModel;

public interface IPagamentoRepository {
    List<PagamentoModel> todos();
    PagamentoModel consultaPorCodigo(long codigo);
    boolean cadastrarNovo(PagamentoModel pagamento);
    PagamentoModel editarPromocao(long codigo, String novaPromocao);
    
}
