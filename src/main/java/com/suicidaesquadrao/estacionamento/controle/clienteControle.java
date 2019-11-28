
package com.suicidaesquadrao.estacionamento.controle;

import com.suicidaesquadrao.estacionamento.dao.ClienteDao;
import com.suicidaesquadrao.estacionamento.model.Cliente;
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


public class clienteControle extends HttpServlet {
    
    private ClienteDao clienteDAO = new ClienteDao();

    
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
            clienteDAO.excluir(idProduto);
            request.setAttribute("msg", "Excluído com sucesso!");
            }else if(acao!=null && acao.equals("editar")){
            Integer idCliente = Integer.parseInt(id);
            Cliente cliente = clienteDAO.listarId(idCliente);
            request.setAttribute("cliente", cliente);
            }else if(acao!=null && acao.equals("voltar")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarClientes.jsp");
            dispatcher.forward(request, response); 
            }
        request.setAttribute("produtos", clienteDAO.listar());
       
        }catch (SQLException ex){
            request.setAttribute("mensagem", "Erro de Banco de Dados: "+ ex.getMessage());
        
        }catch (validacaoException ex){
            request.setAttribute("mensagem", "Erro de Dados: "+ ex.getMessage());
        } catch (ClassNotFoundException ex) {        
            Logger.getLogger(clienteControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listarClientes.jsp");
        dispatcher.forward(request, response);
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome= request.getParameter("nome");
        String cpf=request.getParameter("cpf");
        String veiculo=request.getParameter("veiculo");
        String placa=request.getParameter("placa");
        String id = request.getParameter("id");
        
        Cliente cliente = new Cliente (0,nome,cpf,veiculo,placa); 
        
        if (id!=null || id!=""){
            cliente.setId(Integer.parseInt(id));
        }
        try{
            cliente.valida();
            if(cliente.getId()!=0){
                clienteDAO.atualizar(cliente);
                request.setAttribute("msg", "Atualizado com sucesso!");
            }else{
                clienteDAO.salvar(cliente);
                request.setAttribute("msg", "Salvo com sucesso!");
            }
        }catch(SQLException ex){
            System.out.println("Erro banco de dados: "+ex.getMessage()); 
        } catch (validacaoException ex) {
            System.out.println("Erro ao validar Campo: "+ ex.getMessage());;
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro Driver: "+ ex.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cliente.jsp");
        dispatcher.forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
