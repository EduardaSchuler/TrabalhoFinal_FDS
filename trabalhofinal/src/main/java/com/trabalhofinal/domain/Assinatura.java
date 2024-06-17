package com.trabalhofinal.domain;

import java.util.Date;

public class Assinatura {
    private long codigo; //Código da assinatura
    private Aplicativo aplicativo; //Aplicativo de que trata a assinatura
    private Cliente cliente; //Cliente de que trata a assinatura
    private Date inicioVigencia; //Início da vigência da assinatura
    private Date fimVigencia; //Fim da vigência da assinatura
}
