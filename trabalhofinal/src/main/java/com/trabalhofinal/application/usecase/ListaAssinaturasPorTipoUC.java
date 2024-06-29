package com.trabalhofinal.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalhofinal.application.dtos.AssinaturaDTO;
import com.trabalhofinal.domain.service.AssinaturaService;

@Component
public class ListaAssinaturasPorTipoUC {
    private AssinaturaService as;

    public ListaAssinaturasPorTipoUC(AssinaturaService as){
        this.as = as;
    }

    public List<AssinaturaDTO> executa(String tipo){
        return as.listarPorTipo(tipo).stream()
        .map(assinatura->AssinaturaDTO.fromModel(assinatura))
        .toList();
    }
}
