package com.trabalhofinal.domain;

import java.util.Date;

public class Pagamento {
    private long codigo; //Identificador único do pagamento
    private Assinatura assinatura; // Assinatura paga
    private double valorPago; // Valor pago
    private Date dataPagamento; // Data em que o pagamento foi efetivado
    private String promocao; // Código correspondente a promoção usada no pagamento. Pode ser um “none” no caso de não ser usado código nenhum.

}
