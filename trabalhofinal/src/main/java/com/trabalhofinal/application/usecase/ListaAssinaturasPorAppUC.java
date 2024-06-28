package com.trabalhofinal.application.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trabalhofinal.application.dtos.AssinaturaDTO;
import com.trabalhofinal.domain.service.AssinaturaService;

@Component
public class ListaAssinaturasPorAppUC {
    private AssinaturaService as;

    public ListaAssinaturasPorAppUC(AssinaturaService as){
        this.as = as;
    }

    public List<AssinaturaDTO> executa(long codigoApp){
        return as.listarPorAplicativo(codigoApp).stream()
                .map(assinatura->AssinaturaDTO.fromModel(assinatura))
                .toList();
    }
}
