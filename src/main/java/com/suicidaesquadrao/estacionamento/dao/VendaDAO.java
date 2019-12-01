package com.suicidaesquadrao.estacionamento.dao;


import com.suicidaesquadrao.estacionamento.model.Cliente;
import com.suicidaesquadrao.estacionamento.model.Usuario;
import com.suicidaesquadrao.estacionamento.model.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.validacaoException;



public class VendaDAO implements crud<Venda>{

    @Override
    public void excluir(Integer numero) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement("DELETE FROM venda WHERE numero=?");
            ps.setInt(1, numero);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public Usuario listarId(Integer numero) throws SQLException, validacaoException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        
            ps = conexao.prepareStatement("SELECT numero,dataEmissao,entrada, saida,preco,id_cliente_venda"
                    + "WHERE numero=?");
            ps.setInt(1, numero);
             ResultSet rs = ps.executeQuery();
            if(rs.next()){
            return new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));   
            }
            throw new validacaoException("Não achou cliente com código" +numero);
            
    }
    
    
    @Override
    public List<Venda> listar() throws SQLException, ClassNotFoundException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT numero,dataEmissao,ENTRADA,SAIDA,PRECO FROM VENDA");
        ResultSet rs = ps.executeQuery();
        List<Venda> venda = new ArrayList();
        while(rs.next()){
            venda.add(new Venda(rs.getInt(1), rs.getDate(2),rs.getDate(3),rs.getDate(4),rs.getDouble(5)));
       
        }
    return venda;   
    }
    
   
    @Override
    public void salvar(Venda venda) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO VENDA (DATAEMISSAO,ENTRADA,SAIDA,PRECO) VALUES(?,?,?,?)");
        ps.setDate(1, (Date) venda.getDataEmissao());
        ps.setDate(2, (Date) venda.getEntrada());
        ps.setDate(3, (Date) venda.getSaida());
        ps.setDouble(4, venda.getPreco());
        ps.execute(); 
    }

    @Override
    public void atualizar(Venda venda) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE VENDA SET SAIDA=?, PRECO=? WHERE NUMERO=?");
        ps.setDate(1, (Date) venda.getSaida());
        ps.setDouble(2, venda.getPreco());
        
        ps.setInt(3, venda.getNumero());
        ps.execute();
    }

    public Cliente buscar(String cpf) throws SQLException, ClassNotFoundException, Exception{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        
            ps = conexao.prepareStatement("SELECT id_cliente,nome_cliente,cpf, veiculo,placa from cliente"
                    + "WHERE cpf=?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            return new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));   
            }
            throw new Exception("Não achou cliente com código");
            }
}
