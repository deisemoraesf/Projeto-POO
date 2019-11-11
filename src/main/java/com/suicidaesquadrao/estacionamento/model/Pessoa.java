
package com.suicidaesquadrao.estacionamento.model;

import util.validacaoException;

public class Pessoa <T> {
    
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public void valida () throws validacaoException{
        if(nome==null||nome.equals("")){
            throw new validacaoException("O campo é obrigatório");
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
