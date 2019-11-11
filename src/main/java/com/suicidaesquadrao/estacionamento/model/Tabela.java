
package com.suicidaesquadrao.estacionamento.model;

public class Tabela {
    
    private double precoHora;
    private double precoDiario;
    private double precoMensal;

    private Imposto imposto;
    
    public Tabela() {
    }
    
    public Tabela(double precoHora, double precoDiario, double precoMensal) {
        this.precoHora = precoHora;
        this.precoDiario = precoDiario;
        this.precoMensal = precoMensal;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(double precoDiario) {
        this.precoDiario = precoDiario;
    }

    public double getPrecoMensal() {
        return precoMensal;
    }

    public void setPrecoMensal(double precoMensal) {
        this.precoMensal = precoMensal;
    }
    
   public void processarRecibo (Estacionar venda){
        long inicial = venda.getEntrada().getTime();
        long fim = venda.getSaida().getTime();
        double horas = (double)(fim - inicial)/1000/60/60;
        
        double pagamento;
        if (horas > 12.0){
            pagamento = precoDiario;
        }else {
            pagamento = Math.ceil(horas)*precoHora;
        }
       double taxaImposto = imposto.imposto(pagamento);
        
        venda.setRecibo(new Recibo (taxaImposto, pagamento));
    }
    
    
    
}
