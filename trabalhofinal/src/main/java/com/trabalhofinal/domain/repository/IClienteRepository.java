package com.trabalhofinal.domain.repository;

import java.util.List;

import com.trabalhofinal.domain.model.ClienteModel;

public interface IClienteRepository {
    List<ClienteModel> todos();
    ClienteModel consultaPorCodigo(long codigo);
    boolean cadastrarNovo(ClienteModel cliente);
    ClienteModel editarNome(long codigo, String nomeNovo);
    ClienteModel editarEmail(long codigo, String emailNovo);
}
