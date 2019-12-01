package com.suicidaesquadrao.estacionamento.controle;
import com.suicidaesquadrao.estacionamento.dao.UsuarioDAO;
import com.suicidaesquadrao.estacionamento.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;


public class usuarioControle extends HttpServlet {
    
    private UsuarioDAO UsuarioDAO = new UsuarioDAO();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
              
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao=request.getParameter("acao");
        String id=request.getParameter("id");
        
        try{
            if(acao!=null && acao.equals("excluir")){
            Integer idProduto = Integer.parseInt(id);
            UsuarioDAO.excluir(idProduto);
            request.setAttribute("msg", "Excluído com sucesso!");
            
            }else if(acao!=null && acao.equals("editar")){
            Integer idUsuario = Integer.parseInt(id);
            Usuario usuario = UsuarioDAO.listarId(idUsuario);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/WEB-INF/usuario.jsp").forward(request, response);
            
            }else if(acao!=null && acao.equals("voltarmenu")){
            request.getRequestDispatcher("menu.jsp").forward(request, response);
            
            }else if(acao!=null && acao.equals("voltarlista")){
            request.setAttribute("usuario", UsuarioDAO.listar());    
            request.getRequestDispatcher("/WEB-INF/listaUsuario.jsp").forward(request, response);
            request.setAttribute("usuario", UsuarioDAO.listar());
            
            }else if(acao!=null && acao.equals("cadastrar")){
            request.getRequestDispatcher("/WEB-INF/usuario.jsp").forward(request, response);
           
            }
        request.setAttribute("usuario", UsuarioDAO.listar());
       
        }catch (SQLException ex){
            request.setAttribute("msg", "Erro de Banco de Dados: "+ ex.getMessage());
        
        }catch (validacaoException ex){
            request.setAttribute("msg", "Erro de Dados: "+ ex.getMessage());
        } catch (ClassNotFoundException ex) {        
            Logger.getLogger(usuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/WEB-INF/listaUsuario.jsp").forward(request, response);
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String nome= request.getParameter("nome");
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");
        
        Usuario usuario = new Usuario(0, nome, login, senha);
        
        if (id!=null && !id.equals("")){    
            usuario.setId(Integer.parseInt(id));
        }
        try{
            usuario.valida();
            if(usuario.getId()!=0){
                UsuarioDAO.atualizar(usuario);
                request.setAttribute("msg", "Atualizado com sucesso!");
            }else{
                UsuarioDAO.salvar(usuario);
                request.setAttribute("msg", "Salvo com sucesso!");
                request.setAttribute("usuario", UsuarioDAO.listar());
                request.getRequestDispatcher("/WEB-INF/listaUsuario.jsp").forward(request, response);
            }
            request.setAttribute("usuario", UsuarioDAO.listar());
            
        }catch(validacaoException ex){
            request.setAttribute("msg", "Erro de Validação dos campos" +ex.getMessage());
            request.setAttribute("usuario", usuario);
        }catch (SQLException ex){
            request.setAttribute("msg", "Erro de Banco de Dados" +ex.getMessage());
            request.setAttribute("usuario", usuario);
        }catch (ClassNotFoundException ex){
            request.setAttribute("msg", "Erro de Driver" +ex.getMessage());
            request.setAttribute("usuario", usuario);  
        }
        
        request.getRequestDispatcher("/WEB-INF/listaUsuario.jsp").forward(request, response);
    }
}

