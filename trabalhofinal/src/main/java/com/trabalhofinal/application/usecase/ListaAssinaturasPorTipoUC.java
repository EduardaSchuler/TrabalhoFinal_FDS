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


    // nao esta retornando o status de cada objeto junto
    public List<AssinaturaDTO> executa(String tipo){
        return as.listarPorTipo(tipo).stream()
            .map(assinatura-> {
                AssinaturaDTO assiDTO = AssinaturaDTO.fromModel(assinatura);
                assiDTO.setStatus(tipo);
                return assiDTO;
            })
            .toList();
    }
}
