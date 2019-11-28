
package com.suicidaesquadrao.estacionamento.controle;

import com.suicidaesquadrao.estacionamento.dao.TabelaDAO;
import com.suicidaesquadrao.estacionamento.model.Tabela;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class tabelaControle extends HttpServlet {
    
    private TabelaDAO tabelaDAO = new TabelaDAO();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Double hora= Double.parseDouble(request.getParameter("hora"));
        Double diario= Double.parseDouble(request.getParameter("diario"));
        Double mensal= Double.parseDouble(request.getParameter("mensal"));
        
        String acao=request.getParameter("acao");
        
        Tabela preco = new Tabela(hora,diario,mensal);
        
        try{
            if(acao!=null && acao.equals("salvar")){
                tabelaDAO.salvar(preco);
                request.setAttribute("msg", "Salvo com sucesso!");
            }
            else if(acao!=null && acao.equals("editar")){
                tabelaDAO.atualizar(preco);
                request.setAttribute("msg", "Atualizado com sucesso!");
            }
            else if(acao!=null && acao.equals("voltar")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");
            dispatcher.forward(request, response);
            }
            request.setAttribute("tabela",tabelaDAO.listar());
            
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
    

}
