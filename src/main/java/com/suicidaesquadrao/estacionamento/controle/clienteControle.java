package com.suicidaesquadrao.estacionamento.controle;

import com.suicidaesquadrao.estacionamento.dao.clienteDAO;
import com.suicidaesquadrao.estacionamento.model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;


public class clienteControle extends HttpServlet {
    
    private clienteDAO clienteDAO = new clienteDAO();

    
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
            Integer idCliente = Integer.parseInt(id);
            clienteDAO.excluir(idCliente);
            
            
            }else if(acao!=null && acao.equals("editar")){
            Integer idCliente = Integer.parseInt(id);
            Cliente cliente = clienteDAO.listarId(idCliente);
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("/WEB-INF/cliente.jsp").forward(request, response);
            
            }else if(acao!=null && acao.equals("voltarmenu")){
            request.getRequestDispatcher("/menu.jsp").forward(request, response);
            
            }else if(acao!=null && acao.equals("voltarlista")){
            request.setAttribute("cliente", clienteDAO.listar());    
            request.getRequestDispatcher("/WEB-INF/listaCliente.jsp").forward(request, response);
            request.setAttribute("cliente", clienteDAO.listar());
            
            }else if(acao!=null && acao.equals("cadastrar")){
            request.getRequestDispatcher("/WEB-INF/cliente.jsp").forward(request, response);
           
            }
        request.setAttribute("cliente", clienteDAO.listar());
       
        }catch (SQLException ex){
            request.setAttribute("msg", "Erro de Banco de Dados: "+ ex.getMessage());
        
        }catch (validacaoException ex){
            request.setAttribute("msg", "Erro de Dados: "+ ex.getMessage());
        } catch (ClassNotFoundException ex) {        
            Logger.getLogger(clienteControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/WEB-INF/listaCliente.jsp").forward(request, response);
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String nome= request.getParameter("nome");
        String cpf=request.getParameter("cpf");
        String veiculo=request.getParameter("veiculo");
        String placa=request.getParameter("placa");
        
        
        Cliente cliente = new Cliente(0,nome,cpf,veiculo,placa); 
        
        if (id!=null && !id.equals("")){    
            cliente.setId(Integer.parseInt(id));
        }
        try{
            cliente.valida();
            if(cliente.getId()!=0){
                clienteDAO.atualizar(cliente);
                request.setAttribute("cliente", clienteDAO.listar());
                
            }else{
                clienteDAO.salvar(cliente);
                request.setAttribute("cliente", clienteDAO.listar());
                request.getRequestDispatcher("/WEB-INF/listaCliente.jsp").forward(request, response);
                
            }
        request.setAttribute("cliente", clienteDAO.listar());
            
        }catch(validacaoException ex){
            request.setAttribute("msg", "Erro de Validação dos campos" +ex.getMessage());
            request.setAttribute("cliente", cliente);
        }catch (SQLException ex){
            request.setAttribute("msg", "Erro de Banco de Dados" +ex.getMessage());
            request.setAttribute("cliente", cliente);
        }catch (ClassNotFoundException ex){
            request.setAttribute("msg", "Erro de Driver" +ex.getMessage());
            request.setAttribute("cliente", cliente);  
        }
        
        request.getRequestDispatcher("/WEB-INF/listaCliente.jsp").forward(request, response);
    }
}
