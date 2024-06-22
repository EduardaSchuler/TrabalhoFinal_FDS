package com.trabalhofinal.application.usecase;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.Assinatura;
import com.trabalhofinal.domain.service.AssinaturaService;

@Service
public class CriaAssinatura {
    @Autowired
    private AssinaturaService assinaturaService;

    public Assinatura executa(Long codigoCliente, Long codigoAplicativo) throws ParseException{
        return assinaturaService.criarAssinatura(codigoCliente, codigoAplicativo);
    }
}
