
package com.suicidaesquadrao.estacionamento.model;

public class Tabela <T>{
  
   private int id_tabela; 
   private double precoHora;
   private double precoDiario;
   private double precoMensal; 

    public Tabela() {
    }

    public Tabela(double precoHora) {
        this.precoHora = precoHora;
    }
    
    

    public Tabela(int id_tabela, double precoHora, double precoDiario, double precoMensal) {
        this.id_tabela = id_tabela;
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

    public int getId_tabela() {
        return id_tabela;
    }

    public void setId_tabela(int id_tabela) {
        this.id_tabela = id_tabela;
    }
   
    
    
}
