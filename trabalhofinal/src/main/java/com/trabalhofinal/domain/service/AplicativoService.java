package com.trabalhofinal.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.Aplicativo;
import com.trabalhofinal.domain.model.Assinatura;
import com.trabalhofinal.domain.repository.IAplicativoRepository;

@Service
public class AplicativoService {
    @Autowired
    private IAplicativoRepository aplicativoRepository;

    public List<Aplicativo> listarTodos() {
        return aplicativoRepository.todos();
    }

    public Aplicativo consultaPorCodigo(long codigo){
        return aplicativoRepository.consultaPorCodigo(codigo);
    }

    public boolean cadastraNovo(Aplicativo aplicativo) {
        return aplicativoRepository.cadastrarNovo(aplicativo);
    }

    public Aplicativo editarNome(long codigo, String novoNome){
        return aplicativoRepository.editarNome(codigo, novoNome);
    }

    public Aplicativo atualizarCusto(long codigo, Double custoMensal) {
        return aplicativoRepository.atualizaCusto(codigo, custoMensal);
    }
}
