package com.trabalhofinal.adapters.persistencia;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.Aplicativo;
import com.trabalhofinal.domain.repository.IAplicativoRepository;

@Repository
public class AplicativoRepositoryImpl implements IAplicativoRepository{

    private List<Aplicativo> apps;

    @Autowired
    public AplicativoRepositoryImpl(){
        apps = new LinkedList<Aplicativo>();
        apps.add(new Aplicativo(1500, "Netflix", 39.90));
        apps.add(new Aplicativo(1600, "Amazon Prime", 14.90));
        apps.add(new Aplicativo(1700, "Disney Plus", 29.90));
        apps.add(new Aplicativo(1800, "HBO Max", 49.90));
    }

    @Override
    public List<Aplicativo> todos() {
        return apps;
    }

    @Override
    public Aplicativo consultaPorCodigo(long codigo) {
        return apps.stream()
            .filter(app->app.getCodigo() == codigo)
            .findFirst()
            .orElse(null);
    }

    @Override
    public boolean cadastrarNovo(Aplicativo aplicativo) {
        return apps.add(aplicativo);
    }

    @Override
    public Aplicativo editarNome(long codigo, String nomeNovo){
        consultaPorCodigo(codigo).setNome(nomeNovo);
        return consultaPorCodigo(codigo);
    }
    
    @Override
    public Aplicativo atualizaCusto(long codigo, Double novoCusto){
        consultaPorCodigo(codigo).setCustoMensal(novoCusto);
        return consultaPorCodigo(codigo);
    }
}
