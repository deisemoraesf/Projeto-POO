
package com.suicidaesquadrao.estacionamento.model;

public class Tabela <T>{
  
   private double precoHora;
   private double precoDiario;
   private double precoMensal; 

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
   
   
    
}
