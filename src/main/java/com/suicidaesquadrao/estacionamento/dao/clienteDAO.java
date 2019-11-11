package com.suicidaesquadrao.estacionamento.dao;


import com.suicidaesquadrao.estacionamento.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.validacaoException;



public class clienteDAO implements crud<Cliente>{

    @Override
    public void excluir(Integer idCliente) {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE ID=?");
            ps.setInt(1, idCliente);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(clienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public Cliente listarId(Integer idCliente) throws SQLException, validacaoException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        
            ps = conexao.prepareStatement("SELECT ID,NOME,CPF,VEICULO,PLACA FROM CLIENTE WHERE ID=?");
            ps.setInt(1, idCliente);
             ResultSet rs = ps.executeQuery();
            if(rs.next()){
            return new Cliente(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));   
            }
            throw new validacaoException("Não achou cliente com código" +idCliente);
            
    }
    
    
    @Override
    public List<Cliente> listar() throws SQLException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT ID,NOME,CPF,VEICULO, PLACA FROM CLIENTE");
        ResultSet rs = ps.executeQuery();
        List<Cliente> cliente = new ArrayList();
        while(rs.next()){
            cliente.add(new Cliente(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
       
        }
    return cliente;   
    }
    
   
    @Override
    public void salvar(Cliente cliente) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO CLIENTE (NOME,CPF,VEICULO,PLACA) VALUES(?,?,?,?)");
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getVeiculo());
        ps.setString(4, cliente.getPlaca());
                
        ps.execute(); 
    }

    @Override
    public void atualizar(Cliente cliente) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE CLIENTE SET NOME=?,CPF=?,VEICULO=?,PLACA=? WHERE ID=?");
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getVeiculo());
        ps.setString(4, cliente.getPlaca());
        ps.setInt(5, cliente.getId());
        ps.execute();
    }

    
}
