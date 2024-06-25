package com.trabalhofinal.adapters.persistencia;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.ClienteModel;
import com.trabalhofinal.domain.repository.IClienteRepository;

@Repository
public class ClienteRepositoryImpl implements IClienteRepository{

    List<ClienteModel> clientes;
    
    @Autowired
    public ClienteRepositoryImpl(){
        clientes = new LinkedList<ClienteModel>();
        clientes.add(new ClienteModel(2401, "Joana Palmeiras", "joanapalm@gmail.com"));
        clientes.add(new ClienteModel(2402, "Vitor Ulisses Machado", "vitorulisses@outlook.com"));
        clientes.add(new ClienteModel(2403, "Daniela Borges", "danieborges@hotmail.com"));
        clientes.add(new ClienteModel(2404, "Roberto Nascimento Ferreira", "robertonasc@yahoo.com"));
    }

    @Override
    public List<ClienteModel> todos(){
        return clientes;
    }

    @Override
    public ClienteModel consultaPorCodigo(long codigo){
        return clientes.stream()
            .filter(app->app.getCodigo() == codigo)
            .findFirst()
            .orElse(null);
    }

    @Override
    public boolean cadastrarNovo(ClienteModel cliente){
        return clientes.add(cliente);
    }

    @Override
    public ClienteModel editarNome(long codigo, String nomeNovo){
        consultaPorCodigo(codigo).setNome(nomeNovo);
        return consultaPorCodigo(codigo);
    }
    
    @Override
    public ClienteModel editarEmail(long codigo, String emailNovo){
        consultaPorCodigo(codigo).setEmail(emailNovo);
        return consultaPorCodigo(codigo);
    }
}
