package com.trabalhofinal.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.AplicativoModel;
import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.repository.IAplicativoRepository;

@Service
public class AplicativoService {
    @Autowired
    private IAplicativoRepository aplicativoRepository;

    public List<AplicativoModel> listarTodos() {
        return aplicativoRepository.todos();
    }

    public AplicativoModel consultaPorCodigo(long codigo){
        return aplicativoRepository.consultaPorCodigo(codigo);
    }

    public boolean cadastraNovo(AplicativoModel aplicativo) {
        return aplicativoRepository.cadastrarNovo(aplicativo);
    }

    public AplicativoModel editarNome(long codigo, String novoNome){
        return aplicativoRepository.editarNome(codigo, novoNome);
    }

    public AplicativoModel atualizarCusto(long codigo, Double custoMensal) {
        return aplicativoRepository.atualizaCusto(codigo, custoMensal);
    }
}
