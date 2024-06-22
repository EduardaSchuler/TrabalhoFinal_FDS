package com.trabalhofinal.adapters.persistencia;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.trabalhofinal.domain.model.Assinatura;
import com.trabalhofinal.domain.model.Pagamento;
import com.trabalhofinal.domain.repository.IPagamentoRepository;

@Repository
public class PagamentoRepositoryImpl implements IPagamentoRepository{
    
    private List<Pagamento> pagamentos;

    public PagamentoRepositoryImpl(){
        pagamentos = new LinkedList<Pagamento>();

        //coloquei null aqui porque nao sabia o que botar (by: lari)
        pagamentos.add(new Pagamento(001, null, 54.90, null, "10% de desconto"));
        pagamentos.add(new Pagamento(001, null, 54.90, null, "10% de desconto"));
        pagamentos.add(new Pagamento(001, null, 54.90, null, "10% de desconto"));
        pagamentos.add(new Pagamento(001, null, 54.90, null, "10% de desconto"));
    }
    
    @Override
    public List<Pagamento> todos(){
        return pagamentos;
    }

    @Override
    public Pagamento consultaPorCodigo(long codigo){
        return pagamentos.stream()
            .filter(app->app.getCodigo() == codigo)
            .findFirst()
            .orElse(null);
    }

    @Override
    public boolean cadastrarNovo(Pagamento pagamento){
        return pagamentos.add(pagamento);
    }

    @Override
    public Pagamento atualizaPagamentoAssinatura(long codigo, Assinatura novaAssinatura){
        consultaPorCodigo(codigo).setAssinatura(novaAssinatura);
        return consultaPorCodigo(codigo);
    }

    @Override
    public Pagamento atualizaValorPago(long codigo, double novoValorPago){
        consultaPorCodigo(codigo).setValorPago(novoValorPago);
        return consultaPorCodigo(codigo);
    }

    @Override
    public Pagamento atualizaDataPagamento(long codigo, Date novaDataPagamento){
        consultaPorCodigo(codigo).setDataPagamento(novaDataPagamento);
        return consultaPorCodigo(codigo);
    }

    @Override
    public Pagamento editarPromocao(long codigo, String novaPromocao){
        consultaPorCodigo(codigo).setPromocao(novaPromocao);
        return consultaPorCodigo(codigo);
    }
}
