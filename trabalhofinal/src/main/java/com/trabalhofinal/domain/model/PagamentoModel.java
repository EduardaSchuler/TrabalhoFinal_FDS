package com.trabalhofinal.domain.model;

import java.time.LocalDate;

public class PagamentoModel {

    private long codigo; //Identificador único do pagamento
    private AssinaturaModel assinatura; // Assinatura paga
    private Double valorPago; // Valor pago
    private LocalDate dataPagamento; // Data em que o pagamento foi efetivado
    private String promocao; // Código correspondente a promoção usada no pagamento. Pode ser um “none” no caso de não ser usado código nenhum.

    public PagamentoModel(long codigo, AssinaturaModel assinatura,  Double valorPago, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = LocalDate.now();
        this.promocao = promocao;
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

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setAssinatura(AssinaturaModel assinatura) {
        this.assinatura = assinatura;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }
}
