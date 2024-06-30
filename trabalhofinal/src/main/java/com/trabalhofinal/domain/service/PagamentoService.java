package com.trabalhofinal.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.model.PagamentoModel;
import com.trabalhofinal.domain.repository.IAssinaturaRepository;
import com.trabalhofinal.domain.repository.IPagamentoRepository;

@Service
public class PagamentoService {
    @Autowired
    private IAssinaturaRepository assinaturaRepository;
    @Autowired
    private IPagamentoRepository pagamentoRepository;

    public List<PagamentoModel> listarTodos() {
        return pagamentoRepository.todos();
    }

    public PagamentoModel consultaPorCodigo(long codigo){
        return pagamentoRepository.consultaPorCodigo(codigo);
    }

    public String cadastrarNovo(PagamentoModel pagamento){
        if(pagamento.getValorPago() < pagamento.getAssinatura().getAplicativo().getCustoMensal()){
            return ("Valor estornado: " + pagamento.getValorPago() + "\n" + "Data de vencimento da Assinatura: " + pagamento.getAssinatura().getFimVigencia());
        }

        if(pagamento.getAssinatura().getFimVigencia().isBefore(LocalDate.now())){
            pagamento.getAssinatura().setFimVigencia(LocalDate.now());
        }
        
        pagamento.getAssinatura().setFimVigencia(pagamento.getAssinatura().getFimVigencia().plusDays(30));
        return ("Valor estornado: " + (pagamento.getValorPago() - pagamento.getAssinatura().getAplicativo().getCustoMensal()) + "\n" + "Data de vencimento da Assinatura: " + pagamento.getAssinatura().getFimVigencia());
    }

    public PagamentoModel editarPromocao(long codigo, String novaPromocao){
        return pagamentoRepository.editarPromocao(codigo, novaPromocao);
    }
}