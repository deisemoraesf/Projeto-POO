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
        PreparedStatement ps = conexao.prepareStatement("SELECT id_tabela,precohora,precodiario,precomensal FROM tabela");
        ResultSet rs = ps.executeQuery();
        List<Tabela> tabela = new ArrayList();
        while(rs.next()){
            tabela.add(new Tabela(rs.getInt(1),rs.getDouble(2), rs.getDouble(3),rs.getDouble(4)));
        }
        return tabela;
    }
                      
        
    public void salvar(Tabela preco) throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO tabela (precohora,precodiario,precomensal) VALUES(?,?,?)");
        ps.setDouble(1, preco.getPrecoHora());
        ps.setDouble(2, preco.getPrecoDiario());
        ps.setDouble(3, preco.getPrecoMensal());
        
        ps.execute(); 
    }

   
    public void atualizar(Tabela preco) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE tabela SET precohora=?,precodiario=?,precomensal=? where id_tabela=?");
        ps.setDouble(1, preco.getPrecoHora());
        ps.setDouble(2, preco.getPrecoDiario());
        ps.setDouble(3, preco.getPrecoMensal());
        ps.setInt(4, preco.getId());
        
        ps.execute();
    }
    
    
        public Tabela listarId(Integer idTabela) throws SQLException, validacaoException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        
            ps = conexao.prepareStatement("SELECT id_tabela,precohora,precodiario,precomensal FROM tabela WHERE id_tabela=?");
            ps.setInt(1, idTabela);
             ResultSet rs = ps.executeQuery();
            if(rs.next()){
            return new Tabela(rs.getInt(1),rs.getDouble(2), rs.getDouble(3),rs.getDouble(4));  
            }
            throw new validacaoException("Não achou a tabela com código" +idTabela);
            
    }
    
}
