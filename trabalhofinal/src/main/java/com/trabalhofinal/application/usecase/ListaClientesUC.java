package com.trabalhofinal.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalhofinal.application.dtos.ClienteDTO;
import com.trabalhofinal.domain.service.ClienteService;

@Component
public class ListaClientesUC {
    private ClienteService cs;

    public ListaClientesUC(ClienteService cs){
        this.cs = cs;
    }

    public List<ClienteDTO> executa(){
        return cs.listarTodos().stream()
        .map(c->ClienteDTO.fromModel(c))
        .toList();
    }
}
