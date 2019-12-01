package com.suicidaesquadrao.estacionamento.controle;

import com.suicidaesquadrao.estacionamento.dao.TabelaDAO;
import com.suicidaesquadrao.estacionamento.model.Tabela;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;


public class tabelaControle extends HttpServlet {
    
    private TabelaDAO TabelaDAO = new TabelaDAO();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
              
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao=request.getParameter("acao");
        String id=request.getParameter("id");
        
        try{
            if(acao!=null && acao.equals("editar")){
            Integer idTabela = Integer.parseInt(id);
            Tabela tabelas = TabelaDAO.listarId(idTabela);
            request.setAttribute("tabelas", tabelas);
            request.setAttribute("tabela", TabelaDAO.listar());

            }
            /*}else if(acao!=null && acao.equals("salvar")){
            request.setAttribute("tabela", TabelaDAO.listar());
            request.getRequestDispatcher("/WEB-INF/tabela.jsp").forward(request, response);
            }*/
            
      
            request.setAttribute("tabela", TabelaDAO.listar());

        }catch (SQLException ex){
            request.setAttribute("msg", "Erro de Banco de Dados: "+ ex.getMessage());
        
        }catch (validacaoException ex){
            request.setAttribute("msg", "Erro de Dados: "+ ex.getMessage());
        } catch (ClassNotFoundException ex) {        
            Logger.getLogger(tabelaControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/WEB-INF/tabela.jsp").forward(request, response);
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        double precoHora= Double.parseDouble(request.getParameter("precoHora"));
        double precoDiario= Double.parseDouble(request.getParameter("precoDiario"));
        double precoMensal= Double.parseDouble(request.getParameter("precoMensal"));
        
        
        Tabela tabela = new Tabela(0, precoHora, precoDiario, precoMensal);
        
        if (id!=null && !id.equals("")){    
            tabela.setId(Integer.parseInt(id));
        }
        try{
            tabela.valida();
            if(tabela.getId()!=0){
                TabelaDAO.atualizar(tabela);
                request.setAttribute("msg", "Atualizado com sucesso!");
            }else{
                TabelaDAO.salvar(tabela);
                request.setAttribute("msg", "Salvo com sucesso!");
                //request.setAttribute("tabela", TabelaDAO.listar());
                request.getRequestDispatcher("/WEB-INF/tabela.jsp").forward(request, response);
            }
            request.setAttribute("tabela", TabelaDAO.listar());
            
        }catch(validacaoException ex){
            request.setAttribute("msg", "Erro de Validação dos campos" +ex.getMessage());
            request.setAttribute("tabela", tabela);
        }catch (SQLException ex){
            request.setAttribute("msg", "Erro de Banco de Dados" +ex.getMessage());
            request.setAttribute("tabela", tabela);
        }catch (ClassNotFoundException ex){
            request.setAttribute("msg", "Erro de Driver" +ex.getMessage());
            request.setAttribute("tabela", tabela);  
        }
        
        request.getRequestDispatcher("/WEB-INF/tabela.jsp").forward(request, response);
    }
}

