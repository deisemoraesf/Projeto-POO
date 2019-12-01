
package com.suicidaesquadrao.estacionamento.model;

import util.validacaoException;

public class Cliente <T> extends Pessoa{
  
    private String cpf;
    private String veiculo;
    private String placa;

    public Cliente() {
    }
    

    public Cliente(String cpf,String veiculo, String placa, String nome, int id) {
        super(id, nome);
        this.cpf = cpf;
        this.veiculo = veiculo;
        this.placa = placa;
    }
    
    public void valida () throws validacaoException{
        if(cpf==null|| cpf.equals("")){
            throw new validacaoException("O campo é obrigatório");
        }else if(veiculo==null|| veiculo.equals("")){
            throw new validacaoException("O campo é obrigatório");
        }else if(placa==null|| placa.equals("")){
            throw new validacaoException("O campo é obrigatório");
        }
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
}
