package com.trabalhofinal.domain.repository;

import java.util.List;

import com.trabalhofinal.domain.model.Aplicativo;

public interface IAplicativoRepository {
    List<Aplicativo> todos();
    Aplicativo consultaPorCodigo(long codigo);
    boolean cadastrarNovo(Aplicativo aplicativo);
    Aplicativo editarNome(long codigo, String nomeNovo);
    Aplicativo atualizaCusto(long codigo, Double custoNovo);
}
