
package com.suicidaesquadrao.estacionamento.model;

import java.util.Date;

public class Venda <T> extends Cliente{
    
    private int numero;
    private Date dataEmissao;
    private Date entrada;
    private Date saida;
    private String descricao;
    private Imposto imposto;
    private double preco;

    public Venda() {
        super();
    }
    public Venda(int numero, int id_cliente, String nome_cliente, String descricao,double preco) {
        this.numero = numero;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    public double calculaHora (Date entrada, Date saida){
       double  horas;
       long inicial = entrada.getTime();
       long fim = saida.getTime();
       return horas = (double)(fim - inicial)/1000/60/60; 
    }

    
    public void processarRecibo (double horas){
        
        Tabela preco = new Tabela();
        double pagamento;
        if (horas > 12.0){
            pagamento = preco.getPrecoDiario();
            descricao = "Cobrança por preço diário";
        }else {
            pagamento = Math.ceil(horas)*preco.getPrecoHora();
            descricao = "Cobrança por hora";
        }
        double taxaImposto = imposto.imposto(pagamento);
        
    }
    
}
