
package com.suicidaesquadrao.estacionamento.controle;

import com.suicidaesquadrao.estacionamento.dao.UsuarioDAO;
import com.suicidaesquadrao.estacionamento.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;


public class usuarioControle extends HttpServlet {
    
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao=request.getParameter("acao");
        String id=request.getParameter("id");
        
        try{
            if(acao!=null && acao.equals("excluir")){
            Integer idProduto = Integer.parseInt(id);
                try {
                    usuarioDAO.excluir(idProduto);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(usuarioControle.class.getName()).log(Level.SEVERE, null, ex);
                }
            request.setAttribute("msg", "Excluído com sucesso!");
            }else if(acao!=null && acao.equals("editar")){
            Integer idUsuario = Integer.parseInt(id);
            Usuario usuario = usuarioDAO.listarId(idUsuario);
            request.setAttribute("cliente", usuario);
            }else if(acao!=null && acao.equals("voltar")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarUsuario.jsp");
            dispatcher.forward(request, response); 
            }
        request.setAttribute("usurio", usuarioDAO.listar());
       
        }catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
        
        }catch (validacaoException ex){
            request.setAttribute("mensagem", "Erro de Dados: "+ ex.getMessage());
        } catch (ClassNotFoundException ex) {        
            Logger.getLogger(usuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarUsuario.jsp");
        dispatcher.forward(request, response);
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome= request.getParameter("nome");
        String usuario=request.getParameter("user");
        String senha=request.getParameter("senha");
        String id = request.getParameter("id");
        
        Usuario usuario1 = new Usuario(0,nome,usuario,senha);
        
        if (id!=null || id!=""){
            usuario1.setId(Integer.parseInt(id));
        }
        try{
            usuario1.valida();
            if(usuario1.getId()!=0){
                usuarioDAO.atualizar(usuario1);
                request.setAttribute("msg", "Atualizado com sucesso!");
            }else{
                usuarioDAO.salvar(usuario1);
                request.setAttribute("msg", "Salvo com sucesso!");
            }
        }catch(SQLException ex){
            System.out.println("Erro banco de dados: "+ex.getMessage()); 
        } catch (validacaoException ex) {
            System.out.println("Erro ao validar Campo: "+ ex.getMessage());;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro Driver: "+ ex.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuario.jsp");
        dispatcher.forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
