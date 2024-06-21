package com.trabalhofinal.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.Aplicativo;
import com.trabalhofinal.domain.repository.IAplicativoRepository;

@Service
public class AplicativoService {
    @Autowired
    private IAplicativoRepository aplicativoRepository;

    public List<Aplicativo> listarTodos() {
        return aplicativoRepository.findAll();
    }

    public Aplicativo salvar(Aplicativo aplicativo) {
        return aplicativoRepository.save(aplicativo);
    }

    public Aplicativo atualizarCusto(Long id, double custoMensal) {
        Aplicativo aplicativo = aplicativoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aplicativo não encontrado"));
        aplicativo.setCustoMensal(custoMensal);
        return aplicativoRepository.save(aplicativo);
    }
}
