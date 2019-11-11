
package com.suicidaesquadrao.estacionamento.model;

import java.util.Date;

public class Recibo {
    
    private int numero;
    private Date dataEmissao;
    
    private Double imposto;
    private Double total;

    public Recibo(Double imposto, Double total) {
        this.imposto = imposto;
        this.total = total;
    }

    public Double getImposto() {
        return imposto;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public int getNumero() {
    return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
    
}
