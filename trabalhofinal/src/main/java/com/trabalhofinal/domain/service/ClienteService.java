package com.trabalhofinal.domain.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.ClienteModel;
import com.trabalhofinal.domain.repository.IClienteRepository;

@Service
public class ClienteService {
    private IClienteRepository clienteRepository;

    @Autowired
    public ClienteService(IClienteRepository clientes){
        this.clienteRepository = clientes;
    }

    public List<ClienteModel> listarTodos() {
        return clienteRepository.todos();
    }

    public ClienteModel consultaPorCodigo(long codigo){
        return clienteRepository.consultaPorCodigo(codigo);
    }

    public boolean cadastrarNovo(ClienteModel cliente) {
        return clienteRepository.cadastrarNovo(cliente);
    }

    public ClienteModel editarNome(long codigo, String nomeNovo){
        return clienteRepository.editarNome(codigo, nomeNovo);
    }

    public ClienteModel editarEmail(long codigo, String emailNovo){
        return clienteRepository.editarEmail(codigo, emailNovo);
    }
}
