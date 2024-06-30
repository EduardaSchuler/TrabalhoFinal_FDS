package com.trabalhofinal.adapters.Persistency;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.PagamentoModel;
import com.trabalhofinal.domain.repository.IPagamentoRepository;

@Repository
public class PagamentoRepositoryImpl implements IPagamentoRepository{
    
    private List<PagamentoModel> pagamentos;

    @Autowired
    public PagamentoRepositoryImpl(){
        pagamentos = new LinkedList<PagamentoModel>();

        //coloquei null aqui porque nao sabia o que botar (by: lari)
        pagamentos.add(new PagamentoModel(001, null, 54.90, null));
        pagamentos.add(new PagamentoModel(001, null, 54.90, null));
        pagamentos.add(new PagamentoModel(001, null, 54.90, null));
        pagamentos.add(new PagamentoModel(001, null, 54.90, null));
    }
    
    @Override
    public List<PagamentoModel> todos(){
        return pagamentos;
    }

    @Override
    public PagamentoModel consultaPorCodigo(long codigo){
        return pagamentos.stream()
            .filter(app->app.getCodigo() == codigo)
            .findFirst()
            .orElse(null);
    }

    @Override
    public boolean cadastrarNovo(PagamentoModel pagamento){
        return pagamentos.add(pagamento);
    }

    @Override
    public PagamentoModel editarPromocao(long codigo, String novaPromocao){
        consultaPorCodigo(codigo).setPromocao(novaPromocao);
        return consultaPorCodigo(codigo);
    }
}
