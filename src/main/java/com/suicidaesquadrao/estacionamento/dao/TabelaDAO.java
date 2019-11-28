package com.suicidaesquadrao.estacionamento.dao;


import com.suicidaesquadrao.estacionamento.model.Tabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.validacaoException;



public class TabelaDAO {

 
    public List<Tabela> listar() throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT PRECOHORA,PRECODIARIO,PRECOMENSAL FROM TABELA");
        ResultSet rs = ps.executeQuery();
        List<Tabela> tabela = new ArrayList();
        while(rs.next()){
            tabela.add(new Tabela(rs.getDouble(1), rs.getDouble(2),rs.getDouble(3)));
       
        }
    return tabela;   
    }
    
   
    
    public void salvar(Tabela preco) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO TABELA (PRECOHORA,PRECODIARIO,PRECOMENSAL) VALUES(?,?,?)");
        ps.setDouble(1, preco.getPrecoHora());
        ps.setDouble(2, preco.getPrecoDiario());
        ps.setDouble(3, preco.getPrecoMensal());
        
        ps.execute(); 
    }

   
    public void atualizar(Tabela preco) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE TABELA SET PRECOHORA=?,PRECODIARIO=?,PRECOMENSAL=?");
        ps.setDouble(1, preco.getPrecoHora());
        ps.setDouble(2, preco.getPrecoDiario());
        ps.setDouble(3, preco.getPrecoMensal());
        
        ps.execute();
    }
    
}
