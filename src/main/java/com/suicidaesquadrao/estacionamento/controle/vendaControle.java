package com.suicidaesquadrao.estacionamento.controle;


import com.suicidaesquadrao.estacionamento.dao.VendaDAO;
import com.suicidaesquadrao.estacionamento.model.Cliente;
import com.suicidaesquadrao.estacionamento.model.Venda;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class vendaControle extends HttpServlet {
    
    Venda v = new Venda();
    VendaDAO venda = new VendaDAO();
    Cliente cliente = new Cliente();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     String acao=request.getParameter("acao");
    
     if (acao!=null && acao =="buscarCliente"){
         String cpf=request.getParameter("cpf");
         cliente.setCpf(cpf);
         cliente = venda.buscar(cpf);
         request.setAttribute("id", cliente.getId());
         request.setAttribute("nome", cliente.getNome());
         request.setAttribute("veiculo", cliente.getVeiculo());
         request.setAttribute("placa", cliente.getPlaca());
         
     }else if (acao!=null && acao =="inserirServico"){
         Date entrada = Date.valueOf(request.getParameter("entrada"));
         Date saida = Date.valueOf(request.getParameter("saida"));
         v.processarRecibo(v.calculaHora(entrada, saida));
         
     } else if (acao!=null && acao=="editar"){
         //Integer numero = Integer.parseInt(numero);
           // Cliente cliente = clienteDAO.listarId(idCliente);
            //request.setAttribute("cliente", cliente);
     }
    
    }
        
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
   
}
