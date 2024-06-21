package com.trabalhofinal.domain.model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo; //Identificador único do pagamento
    private Assinatura assinatura; // Assinatura paga
    private double valorPago; // Valor pago
    private Date dataPagamento; // Data em que o pagamento foi efetivado
    private String promocao; // Código correspondente a promoção usada no pagamento. Pode ser um “none” no caso de não ser usado código nenhum.

    public Pagamento() {
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

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }
}
