package com.trabalhofinal.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pagamento {

    @Id
    private long codigo; //Identificador único do pagamento
    private Assinatura assinatura; // Assinatura paga
    private Double valorPago; // Valor pago
    private Date dataPagamento; // Data em que o pagamento foi efetivado
    private String promocao; // Código correspondente a promoção usada no pagamento. Pode ser um “none” no caso de não ser usado código nenhum.

    public Pagamento(long codigo, Assinatura assinatura,  Double valorPago, Date dataPagamento, String promocao) {
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

    public Double getValorPago() {
        return valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }
}
