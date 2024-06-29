package com.trabalhofinal.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalhofinal.application.dtos.AssinaturaDTO;
import com.trabalhofinal.domain.service.AssinaturaService;

@Component
public class ListaAssinaturasPorClienteUC {
    
    private AssinaturaService as;

    public ListaAssinaturasPorClienteUC(AssinaturaService as){
        this.as = as;
    }

    public List<AssinaturaDTO> executa(long codigoCliente){
        return as.listarPorCliente(codigoCliente).stream()
                .map(assinatura->AssinaturaDTO.fromModel(assinatura))
                .toList();
    }
}
