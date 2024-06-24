package com.trabalhofinal.application.usecase;

import java.util.List;

import com.trabalhofinal.domain.model.Cliente;
import com.trabalhofinal.domain.service.ClienteService;

public class ListaClientesUC {
    private ClienteService cs;

    public List<Cliente> executa(){
        return cs.listarTodos();
    }
}
