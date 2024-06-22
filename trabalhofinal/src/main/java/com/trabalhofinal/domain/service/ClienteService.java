package com.trabalhofinal.domain.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.Cliente;
import com.trabalhofinal.domain.repository.IClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private IClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.todos();
    }

    public Cliente consultaPorCodigo(long codigo){
        return clienteRepository.consultaPorCodigo(codigo);
    }

    public boolean cadastrarNovo(Cliente cliente) {
        return clienteRepository.cadastrarNovo(cliente);
    }

    public Cliente editarNome(long codigo, String nomeNovo){
        return clienteRepository.editarNome(codigo, nomeNovo);
    }

    public Cliente editarEmail(long codigo, String emailNovo){
        return clienteRepository.editarEmail(codigo, emailNovo);
    }
   
}
