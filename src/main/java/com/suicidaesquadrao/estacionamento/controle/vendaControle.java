package com.suicidaesquadrao.estacionamento.controle;


import com.suicidaesquadrao.estacionamento.dao.VendaDAO;
import com.suicidaesquadrao.estacionamento.model.Cliente;
import com.suicidaesquadrao.estacionamento.model.Venda;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.validacaoException;



public class vendaControle extends HttpServlet {
    
    Venda v = new Venda();
    VendaDAO venda = new VendaDAO();
    Cliente cliente = new Cliente();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        
        
    String menu=request.getParameter("menu");
    String acao=request.getParameter("acao");
    String selecao=request.getParameter("selecao");
    
    Date entrada = Date.valueOf(request.getParameter("entrada"));
    Date saida = Date.valueOf(request.getParameter("saida"));
    
    if(menu.equals("Home")){
        
    }
    if(menu.equals("Clientes")){
           
    }   
    if(menu.equals("Filial")){
        
    }
    if(menu.equals("Produtos")){
        
    }
    if(menu.equals("Usuarios")){
        
    }
    if(menu.equals("NovaVenda")){
        
        switch (acao){
            case "BuscarCliente":
                //Buscar cliente no BD através do Cpf
                String cpf = request.getParameter("cpj");
                cliente.setCpf(cpf);
        {
            try {
                cliente = venda.buscar(cpf);
            } catch (Exception ex) {
                Logger.getLogger(vendaControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                request.setAttribute("cliente", cliente);
                request.setAttribute("numVenda", v.getNumero());
                request.setAttribute("totalPagar", v.getPreco());
                break;
            case "BuscarProduto": 
                //Buscar produto no BD através do ID
                try {
                
                v.processarRecibo(v.calculaHora(entrada, saida));
                
                break;   
                } catch (Exception e) {
                }
            case "InserirProduto":
                //Lista os produtos na tela de venda
                request.setAttribute("venda", cliente);
                int numero=v.getNumero();
                int cli = cliente.getId();
                String cli_nome= cliente.getNome(); //contador
                String descricao=v.getDescricao();
                double ent = v.calculaHora(entrada, saida);
                double sai =v.getPreco();
                
                //Venda ven = new Venda (numero,entrada,saida,sai); 
                                
            case "Finalizar":
                request.getRequestDispatcher("/WEB-INF/vendaEfetuada.jsp").forward(request, response);
                break;
                
            case "Cancelar":
                request.getRequestDispatcher("/WEB-INF/menu.jsp").forward(request, response);
                
            }
        request.getRequestDispatcher("/WEB-INF/registrarVenda.jsp").forward(request, response);
        }
    
      
    }
    
    /*@Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
        
     String acao=request.getParameter("acao");
     String numero=request.getParameter("NroVenda");
     
     try{
     if (acao!=null && acao.equals("buscarCliente")){
         String cpf=request.getParameter("cpf");
         cliente = venda.buscar(cpf);
         request.setAttribute("cliente", cliente);
         
     }else if (acao!=null && acao.equals("inserirServico")){
         Date entrada = Date.valueOf(request.getParameter("entrada"));
         Date saida = Date.valueOf(request.getParameter("saida"));
         v.processarRecibo(v.calculaHora(entrada, saida));
         
     } else if (acao!=null && acao.equals("editar")){
         Integer num = Integer.parseInt(numero);
         venda.listarId(num);
         request.setAttribute("cliente", v);
         
     } else if (acao!=null && acao.equals("excluir")){
         Integer num = Integer.parseInt(numero);
         venda.excluir(num);
         request.setAttribute("cliente", v);
     }
     } catch (SQLException | validacaoException | ClassNotFoundException ex) {
             request.setAttribute("mensagem", ex.getMessage());
         } catch (Exception ex) {
            Logger.getLogger(vendaControle.class.getName()).log(Level.SEVERE, null, ex);
        }
     RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registrarVenda.jsp");
        dispatcher.forward(request, response);
    }
        
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acao=request.getParameter("acao");
        String numero=request.getParameter("NroVenda");
     
        try{
            if (acao!=null && acao.equals("buscarCliente")){
            String cpf=request.getParameter("cpf");
            cliente = venda.buscar(cpf);
            request.setAttribute("cliente", cliente);
                          
            }else if (acao!=null && acao.equals("editar")){
            Integer num = Integer.parseInt(numero);
            venda.listarId(num);
            request.setAttribute("cliente", v);
         
            }else if (acao!=null && acao.equals("excluir")){
            Integer num = Integer.parseInt(numero);
            venda.excluir(num);
            request.setAttribute("cliente", v);
            }
            request.setAttribute("filiais", venda.listar());
            
        } catch (SQLException | validacaoException | ClassNotFoundException ex) {
             request.setAttribute("mensagem", ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(vendaControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registrarVenda.jsp");
        dispatcher.forward(request, response);
    }
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acao=request.getParameter("acao");
        String numero=request.getParameter("NroVenda");
        
        Date entrada = Date.valueOf(request.getParameter("entrada"));
        Date saida = Date.valueOf(request.getParameter("saida"));
        
         try{
            if (acao!=null && acao.equals("inserirServico")){
                 v.calculaHora(entrada, saida);
             }
         
         } catch (Exception ex) {
            Logger.getLogger(vendaControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registrarVenda.jsp");
        dispatcher.forward(request, response);
    }*/
        
        
        
        
        
        
    }

    
   

