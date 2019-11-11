
package com.suicidaesquadrao.estacionamento.model;

import java.util.Date;

public class Estacionar {
    
    private Date entrada;
    private Date saida;
    
    private Cliente cliente;
    private Recibo recibo;

    public Estacionar(Date entrada, Date saida, Cliente cliente) {
        this.entrada = entrada;
        this.saida = saida;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }
    
    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

}