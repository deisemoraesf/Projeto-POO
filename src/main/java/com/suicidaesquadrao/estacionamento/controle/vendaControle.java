package com.suicidaesquadrao.estacionamento.controle;


import com.suicidaesquadrao.estacionamento.dao.VendaDAO;
import com.suicidaesquadrao.estacionamento.model.Cliente;
import com.suicidaesquadrao.estacionamento.model.Venda;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
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
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
        
     String acao=request.getParameter("acao");
     String numero=request.getParameter("NroVenda");
     
     try{
     if (acao!=null && acao.equals("buscarCliente")){
         String cpf=request.getParameter("cpf");
         cliente.setCpf(cpf);
         cliente = venda.buscar(cpf);
         request.setAttribute("id", cliente.getId());
         request.setAttribute("nome", cliente.getNome());
         request.setAttribute("veiculo", cliente.getVeiculo());
         request.setAttribute("placa", cliente.getPlaca());
         
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
         }
     RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registrarVenda.jsp");
        dispatcher.forward(request, response);
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
