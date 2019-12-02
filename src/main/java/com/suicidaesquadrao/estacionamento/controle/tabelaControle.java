
package com.suicidaesquadrao.estacionamento.controle;

import com.suicidaesquadrao.estacionamento.dao.TabelaDAO;
import com.suicidaesquadrao.estacionamento.model.Cliente;
import com.suicidaesquadrao.estacionamento.model.Tabela;
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


public class tabelaControle extends HttpServlet {
    
    private TabelaDAO tabelaDAO = new TabelaDAO();

    /*
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
              
        String acao=request.getParameter("acao");
        
        try{
            if (acao==null || acao==""){
                
            }
            if(acao!=null && acao.equals("salvar")){
                
                Tabela preco = criTabela(request);
                tabelaDAO.salvar(preco);
                request.setAttribute("tabela",tabelaDAO.listar());
            }
            else if(acao!=null && acao.equals("editar")){
                Tabela preco = criTabela(request);
                tabelaDAO.atualizar(preco);
                request.setAttribute("tabela",tabelaDAO.listar());
            }
            else if(acao!=null && acao.equals("voltar")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");
            dispatcher.forward(request, response);
            }
            request.setAttribute("tabela",tabelaDAO.listar());
            
        }catch(IOException | ClassNotFoundException | SQLException | ServletException | validacaoException e){
            System.out.println("Erro: "+e);
        }
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tabela.jsp");
        dispatcher.forward(request, response);
    }
    
    private Tabela criTabela(HttpServletRequest request) {
            double hora=Double.parseDouble(request.getParameter("hora"));
            double diario= Double.parseDouble(request.getParameter("diario"));
            double mensal= Double.parseDouble(request.getParameter("mensal"));
            
            Tabela preco = new Tabela(hora,diario,mensal);
            
            return preco;    
    }

    */
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            
            String acao=request.getParameter("acao");
            String id=request.getParameter("id");
            
            try{
            if(acao!=null && acao.equals("excluir")){
            Integer idTabela = Integer.parseInt(id);
            tabelaDAO.excluir(idTabela);
            
            }else if(acao!=null && acao.equals("voltar")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");
            dispatcher.forward(request, response);
            }
            request.setAttribute("tabela",tabelaDAO.listar());
            
        }catch(IOException | ClassNotFoundException | SQLException | ServletException e){
            System.out.println("Erro: "+e);
        }
               
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tabela.jsp");
        dispatcher.forward(request, response);
            
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            
            String id=request.getParameter("id");
            double hora=Double.parseDouble(request.getParameter("hora"));
            double diario= Double.parseDouble(request.getParameter("diario"));
            double mensal= Double.parseDouble(request.getParameter("mensal"));
            
            Tabela preco = new Tabela(0,hora,diario,mensal);
            
            if (id!=null && !id.equals("")){    
            preco.setId_tabela(Integer.parseInt(id));
            }
        try {
            if(preco.getId_tabela()!=0){
            Integer idTabela = Integer.parseInt(id);
            tabelaDAO.atualizar(preco);
            request.setAttribute("tabela", preco);
            
            }else{
                tabelaDAO.salvar(preco);
                 request.setAttribute("tabela", tabelaDAO.listar());
                
                }
                request.setAttribute("tabela", tabelaDAO.listar());
            
        } catch (validacaoException | SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem: ", ex.getMessage());
        }
                     
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tabela.jsp");
            dispatcher.forward(request, response);
    }

    
    

}
