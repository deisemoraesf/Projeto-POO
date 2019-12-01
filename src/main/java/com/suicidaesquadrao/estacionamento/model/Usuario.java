
package com.suicidaesquadrao.estacionamento.model;

public class Usuario <T> extends Pessoa {
    
    private String login;
    private String senha;

    public Usuario( int id, String nome,String login, String senha) {
        super(id, nome);
        this.login = login;
        this.senha = senha;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
}
