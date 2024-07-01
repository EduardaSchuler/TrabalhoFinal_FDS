package com.trabalhofinal.application.dtos;

import java.time.LocalDate;

import com.trabalhofinal.domain.model.AssinaturaModel;
import com.trabalhofinal.domain.model.ClienteModel;
import com.trabalhofinal.domain.model.PagamentoModel;

public class PagamentoDTO {

    private long codigo; //Identificador único do pagamento
    private AssinaturaModel assinatura; // Assinatura paga
    private Double valorPago; // Valor pago
    private LocalDate dataPagamento; // Data em que o pagamento foi efetivado
    private String promocao; // Código correspondente a promoção usada no pagamento. Pode ser um “none” no caso de não ser usado código nenhum.

    public PagamentoDTO(PagamentoModel pagamento) {
        this.codigo = pagamento.getCodigo();
        this.assinatura = pagamento.getAssinatura();
        this.valorPago = pagamento.getValorPago();
        this.dataPagamento = pagamento.getDataPagamento();
        this.promocao = pagamento.getPromocao();
    }

    public long getCodigo() {
        return codigo;
    }

    public AssinaturaModel getAssinatura() {
        return assinatura;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }
    
    public static PagamentoDTO fromModel(PagamentoModel pagamento){
        return new PagamentoDTO(pagamento);
    }
}