package com.trabalhofinal.adapters.persistencia;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.model.PagamentoModel;
import com.trabalhofinal.domain.repository.IPagamentoRepository;

@Repository
public class PagamentoRepositoryImpl implements IPagamentoRepository{
    
    private List<PagamentoModel> pagamentos;

    @Autowired
    public PagamentoRepositoryImpl(){
        pagamentos = new LinkedList<PagamentoModel>();

        //coloquei null aqui porque nao sabia o que botar (by: lari)
        pagamentos.add(new PagamentoModel(001, null, 54.90, null, "10% de desconto"));
        pagamentos.add(new PagamentoModel(001, null, 54.90, null, "10% de desconto"));
        pagamentos.add(new PagamentoModel(001, null, 54.90, null, "10% de desconto"));
        pagamentos.add(new PagamentoModel(001, null, 54.90, null, "10% de desconto"));
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
    public PagamentoModel atualizaPagamentoAssinatura(long codigo, AssinaturaModel novaAssinatura){
        consultaPorCodigo(codigo).setAssinatura(novaAssinatura);
        return consultaPorCodigo(codigo);
    }

    @Override
    public PagamentoModel atualizaValorPago(long codigo, double novoValorPago){
        consultaPorCodigo(codigo).setValorPago(novoValorPago);
        return consultaPorCodigo(codigo);
    }

    @Override
    public PagamentoModel atualizaDataPagamento(long codigo, LocalDate novaDataPagamento){
        consultaPorCodigo(codigo).setDataPagamento(novaDataPagamento);
        return consultaPorCodigo(codigo);
    }

    @Override
    public PagamentoModel editarPromocao(long codigo, String novaPromocao){
        consultaPorCodigo(codigo).setPromocao(novaPromocao);
        return consultaPorCodigo(codigo);
    }
}
