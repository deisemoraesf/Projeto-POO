
package com.suicidaesquadrao.estacionamento.model;

public class iss implements Imposto {
    
    @Override
    public double imposto(double total){
        double tot= total*(1.5*100);
        return tot;
    }
    
}
