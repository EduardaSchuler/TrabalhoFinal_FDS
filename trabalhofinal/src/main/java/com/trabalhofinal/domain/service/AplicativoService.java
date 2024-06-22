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
        return aplicativoRepository.todos();
    }

    public boolean salvar(Aplicativo aplicativo) {
        return aplicativoRepository.cadastrarNovo(aplicativo);
    }

    public Aplicativo editarNome(long codigo, String novoNome){
        return aplicativoRepository.editarNome(codigo, novoNome);
    }

    public Aplicativo atualizarCusto(long codigo, double custoMensal) {
        return aplicativoRepository.atualizaCusto(codigo, custoMensal);
    }
}
