package com.suicidaesquadrao.estacionamento.dao;


import static com.suicidaesquadrao.estacionamento.dao.ConexaoBD.getConnection;
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



public class UsuarioDAO implements CRUD<Usuario>{

    @Override
    public void excluir(Integer idUsuario) {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement("DELETE FROM USUARIO WHERE ID=?");
            ps.setInt(1, idUsuario);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public Usuario listarId(Integer idUsuario) throws SQLException, validacaoException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps;
        
            ps = conexao.prepareStatement("SELECT ID,NOME,USER,SENHA WHERE ID=?");
            ps.setInt(1, idUsuario);
             ResultSet rs = ps.executeQuery();
            if(rs.next()){
            return new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));   
            }
            throw new validacaoException("Não achou cliente com código" +idUsuario);
            
    }
    
    
    @Override
    public List<Usuario> listar() throws SQLException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("SELECT ID,NOME,USER,SENHA FROM USUARIO");
        ResultSet rs = ps.executeQuery();
        List<Usuario> usuario = new ArrayList();
        while(rs.next()){
            usuario.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)));
       
        }
    return usuario;   
    }
    
   
    @Override
    public void salvar(Usuario usuario) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO CLIENTE (NOME,USER,SENHA) VALUES(?,?,?)");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getUser());
        ps.setString(3, usuario.getSenha());
        
        ps.execute(); 
    }

    @Override
    public void atualizar(Usuario usuario) throws validacaoException, SQLException, ClassNotFoundException {
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement ps = conexao.prepareStatement("UPDATE USUARIO SET NOME=?,USER=?,SENHA=? WHERE ID=?");
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getUser());
        ps.setString(3, usuario.getSenha());
        ps.setInt(5, usuario.getId());
        ps.execute();
    }
    public boolean autenticacao( String usuario, String senha) throws ClassNotFoundException, SQLException{
        Connection conexao = ConexaoBD.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            
            String consulta= "select * from usuario where usuario=? and senha=?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, senha);
            rs = pst.executeQuery();
                     
            if(rs.absolute(1)){
                System.out.println("ENTORU NO ABSOLUTE FLAVIÃOOOOOO");
                return true;
            } 
                      
        } catch (Exception e)  {            
            System.err.println("ERRO JAVA " + e);
        } 
                
        finally {
            try {
                if(getConnection() != null) getConnection().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close(); 
            } catch (Exception e ){
                  System.err.println("Error 2 " + e);
            }
        }
        
       return false;
    }
    
}
