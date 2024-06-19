package com.trabalhofinal.domain.model;

import java.util.Date;

public class Pagamento {
    private long codigo; //Identificador único do pagamento
    private Assinatura assinatura; // Assinatura paga
    private double valorPago; // Valor pago
    private Date dataPagamento; // Data em que o pagamento foi efetivado
    private String promocao; // Código correspondente a promoção usada no pagamento. Pode ser um “none” no caso de não ser usado código nenhum.

    public Pagamento(long codigo, Assinatura assinatura, double valorPago, Date dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    
}