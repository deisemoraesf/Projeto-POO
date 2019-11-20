
package com.suicidaesquadrao.estacionamento.model;

import java.util.Date;

public class Venda <T> {
    
    private int numero;
    private Date dataEmissao;
    private Date entrada;
    private Date saida;
    private Imposto imposto;
    private double preco;

    public Venda() {
    }

    public Venda(int numero, Date dataEmissao, Date entrada, Date saida,double preco) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.entrada = entrada;
        this.saida = saida;
        this.preco = preco;
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

    
    
    public Imposto getImposto() {
        return imposto;
    }
    
    public Imposto getImposto(int i) {
        return imposto;
    }

    public void setImposto(Imposto imposto) {
        this.imposto = imposto;
    }

    public double getPreco() {
        return preco;
    }
    
    public double getPreco(int i) {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    

    

    public void processarRecibo (Date entrada, Date saida){
        long inicial = entrada.getTime();
        long fim = saida.getTime();
        double horas = (double)(fim - inicial)/1000/60/60;
        Tabela preco = new Tabela();
        double pagamento;
        if (horas > 12.0){
            pagamento = preco.getPrecoDiario();
        }else {
            pagamento = Math.ceil(horas)*preco.getPrecoHora();
        }
        double taxaImposto = imposto.imposto(pagamento);
        
    }
    
}
