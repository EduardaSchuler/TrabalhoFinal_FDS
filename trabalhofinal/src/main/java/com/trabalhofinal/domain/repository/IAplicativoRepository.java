package com.trabalhofinal.domain.repository;

import java.util.List;

import com.trabalhofinal.domain.model.AplicativoModel;

public interface IAplicativoRepository {
    List<AplicativoModel> todos();
    AplicativoModel consultaPorCodigo(long codigo);
    boolean cadastrarNovo(AplicativoModel aplicativo);
    AplicativoModel editarNome(long codigo, String nomeNovo);
    AplicativoModel atualizaCusto(long codigo, Double custoNovo);
}
