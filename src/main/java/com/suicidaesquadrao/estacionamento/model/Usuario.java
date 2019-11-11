
package com.suicidaesquadrao.estacionamento.model;

public class Usuario <T> extends Pessoa {
    
    private String user;
    private String senha;

    public Usuario( int id, String nome,String user, String senha) {
        super(id, nome);
        this.user = user;
        this.senha = senha;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
}
