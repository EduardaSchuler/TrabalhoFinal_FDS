package com.trabalhofinal.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalhofinal.application.dtos.AplicativoDTO;
import com.trabalhofinal.application.dtos.ClienteDTO;
import com.trabalhofinal.domain.service.AplicativoService;

@Component
public class ListaAplicativoUC {
    private AplicativoService as;

    public ListaAplicativoUC(AplicativoService as){
        this.as = as;
    }

    public List<AplicativoDTO> executa(){
        return as.listarTodos().stream()
        .map(app->AplicativoDTO.fromModel(app)).
        toList();
    }
}
