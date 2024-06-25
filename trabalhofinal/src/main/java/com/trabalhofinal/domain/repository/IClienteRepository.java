package com.trabalhofinal.domain.repository;

import java.util.List;

import com.trabalhofinal.domain.model.Cliente;

public interface IClienteRepository {
    List<Cliente> todos();
    Cliente consultaPorCodigo(long codigo);
    boolean cadastrarNovo(Cliente cliente);
    Cliente editarNome(long codigo, String nomeNovo);
    Cliente editarEmail(long codigo, String emailNovo);
}
