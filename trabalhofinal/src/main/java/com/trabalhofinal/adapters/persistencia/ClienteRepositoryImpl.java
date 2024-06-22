package com.trabalhofinal.adapters.persistencia;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.Cliente;
import com.trabalhofinal.domain.repository.IClienteRepository;

@Repository
public class ClienteRepositoryImpl implements IClienteRepository{

    List<Cliente> clientes;
    
     public ClienteRepositoryImpl(){
        clientes = new LinkedList<Cliente>();
        clientes.add(new Cliente(2401, "Joana Palmeiras", "joanapalm@gmail.com"));
        clientes.add(new Cliente(2402, "Vitor Ulisses Machado", "vitorulisses@outlook.com"));
        clientes.add(new Cliente(2403, "Daniela Borges", "danieborges@hotmail.com"));
        clientes.add(new Cliente(2404, "Roberto Nascimento Ferreira", "robertonasc@yahoo.com"));
    }

    @Override
    public List<Cliente> todos(){
        return clientes;
    }

    @Override
    public Cliente consultaPorCodigo(long codigo){
        return clientes.stream()
            .filter(app->app.getCodigo() == codigo)
            .findFirst()
            .orElse(null);
    }

    @Override
    public boolean cadastrarNovo(Cliente cliente){
        return clientes.add(cliente);
    }

    @Override
    public Cliente editarNome(long codigo, String nomeNovo){
        consultaPorCodigo(codigo).setNome(nomeNovo);
        return consultaPorCodigo(codigo);
    }
    
    @Override
    public Cliente editarEmail(long codigo, String emailNovo){
        consultaPorCodigo(codigo).setEmail(emailNovo);
        return consultaPorCodigo(codigo);
    }
}
