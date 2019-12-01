
package com.suicidaesquadrao.estacionamento.model;

import util.validacaoException;

public class Tabela <T>{
  
   private double precoHora;
   private double precoDiario;
   private double precoMensal;
   private int id;

    public Tabela() {
    }

    public Tabela(int id, double precoHora, double precoDiario, double precoMensal) {
        this.precoHora = precoHora;
        this.precoDiario = precoDiario;
        this.precoMensal = precoMensal;
        this.id = id;
    }
    
    
    public void valida () throws validacaoException{
        if(precoHora<=0){
            throw new validacaoException("O campo é obrigatório");
        }else if(precoDiario<=0){
            throw new validacaoException("O campo é obrigatório");
        }else if(precoMensal<=0){
            throw new validacaoException("O campo é obrigatório");
        }
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


     
    

   
    
}
