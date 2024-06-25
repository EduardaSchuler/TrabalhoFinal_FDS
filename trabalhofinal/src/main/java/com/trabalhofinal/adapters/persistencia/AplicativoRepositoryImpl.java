package com.trabalhofinal.adapters.persistencia;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.AplicativoModel;
import com.trabalhofinal.domain.repository.IAplicativoRepository;

@Repository
public class AplicativoRepositoryImpl implements IAplicativoRepository{

    private List<AplicativoModel> apps;

    @Autowired
    public AplicativoRepositoryImpl(){
        apps = new LinkedList<AplicativoModel>();
        apps.add(new AplicativoModel(1500, "Netflix", 39.90));
        apps.add(new AplicativoModel(1600, "Amazon Prime", 14.90));
        apps.add(new AplicativoModel(1700, "Disney Plus", 29.90));
        apps.add(new AplicativoModel(1800, "HBO Max", 49.90));
    }

    @Override
    public List<AplicativoModel> todos() {
        return apps;
    }

    @Override
    public AplicativoModel consultaPorCodigo(long codigo) {
        return apps.stream()
            .filter(app->app.getCodigo() == codigo)
            .findFirst()
            .orElse(null);
    }

    @Override
    public boolean cadastrarNovo(AplicativoModel aplicativo) {
        return apps.add(aplicativo);
    }

    @Override
    public AplicativoModel editarNome(long codigo, String nomeNovo){
        consultaPorCodigo(codigo).setNome(nomeNovo);
        return consultaPorCodigo(codigo);
    }
    
    @Override
    public AplicativoModel atualizaCusto(long codigo, Double novoCusto){
        consultaPorCodigo(codigo).setCustoMensal(novoCusto);
        return consultaPorCodigo(codigo);
    }
}
