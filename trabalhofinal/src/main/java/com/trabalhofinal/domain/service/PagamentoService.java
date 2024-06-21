package com.trabalhofinal.domain.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.domain.model.Assinatura;
import com.trabalhofinal.domain.model.Pagamento;
import com.trabalhofinal.domain.repository.IAssinaturaRepository;
import com.trabalhofinal.domain.repository.IPagamentoRepository;

@Service
public class PagamentoService {
    @Autowired
    private IPagamentoRepository pagamentoRepository;

    @Autowired
    private IAssinaturaRepository assinaturaRepository;

/*     public Pagamento registrarPagamento(Long codigoAssinatura, double valorPago, String promocao) {
        Assinatura assinatura = assinaturaRepository.findById(codigoAssinatura).orElseThrow(() -> new RuntimeException("Assinatura não encontrada"));

        String dataPagamento = LocalDate.now().toString();
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        Pagamento pagamento = new Pagamento();
        pagamento.setAssinatura(assinatura);
        pagamento.setValorPago(valorPago);
        pagamento.setDataPagamento(sdf.parse(dataPagamento));
        pagamento.setPromocao(promocao);

        // lógica de extensão de vigência da assinatura
        if (valorPago == assinatura.getAplicativo().getCustoMensal()) {
            LocalDate novaDataFimVigencia = assinatura.getFimVigencia().isAfter(LocalDate.now())
                    ? assinatura.getFimVigencia().plusDays(30)
                    : LocalDate.now().plusDays(30);
            assinatura.setFimVigencia(novaDataFimVigencia);
            assinaturaRepository.save(assinatura);
        }

        return pagamentoRepository.save(pagamento);
    } */

    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }
}