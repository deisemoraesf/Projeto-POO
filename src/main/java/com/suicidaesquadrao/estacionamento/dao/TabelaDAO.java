package com.suicidaesquadrao.estacionamento.dao;


import com.suicidaesquadrao.estacionamento.model.Tabela;
import com.suicidaesquadrao.estacionamento.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.validacaoException;



public class TabelaDAO implements crud<Tabela> {
    
    @Override
    public void excluir(Integer idTabela) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement("DELETE FROM tabela WHERE id_tabela=?");
            ps.setInt(1, idTabela);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

 
    @Override
    public List<Tabela> listar() throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT * FROM TABELA");
        ResultSet rs = ps.executeQuery();
        List<Tabela> tabela = new ArrayList();
        while(rs.next()){
            tabela.add(new Tabela(rs.getInt(1),rs.getDouble(1), rs.getDouble(2),rs.getDouble(3)));
       
        }
    return tabela;   
    }
    
        
    @Override
    public void salvar(Tabela preco) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT into tabela (precoHora,precoDiario,precoMensal) VALUES(?,?,?)");
        ps.setDouble(1, preco.getPrecoHora());
        ps.setDouble(2, preco.getPrecoDiario());
        ps.setDouble(3, preco.getPrecoMensal());
        
        ps.execute(); 
    }

   
    @Override
    public void atualizar(Tabela preco) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE TABELA SET PRECOHORA=?,PRECODIARIO=?,PRECOMENSAL=? where id_tabela=?");
        ps.setDouble(1, preco.getPrecoHora());
        ps.setDouble(2, preco.getPrecoDiario());
        ps.setDouble(3, preco.getPrecoMensal());
        ps.setInt(4, preco.getId_tabela());
        ps.execute();
    }
    
    @Override
    public Tabela listarId(Integer idTabela) throws SQLException, validacaoException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        
            ps = conexao.prepareStatement("SELECT id_tabela,precoHora,precoDiario,precoMensal FROM tabela WHERE id_tabela=?");
            ps.setInt(1, idTabela);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            return new Tabela(rs.getInt(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4));   
            }
            throw new validacaoException("Não achou o usuário com código" +idTabela);
            
    }
}
