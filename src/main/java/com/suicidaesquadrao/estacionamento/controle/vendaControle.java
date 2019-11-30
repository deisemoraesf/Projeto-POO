package com.suicidaesquadrao.estacionamento.controle;


import com.suicidaesquadrao.estacionamento.dao.VendaDAO;
import com.suicidaesquadrao.estacionamento.model.Cliente;
import com.suicidaesquadrao.estacionamento.model.Venda;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            throws ServletException, IOException, SQLException, validacaoException, ClassNotFoundException {
        
     String acao=request.getParameter("acao");
     String numero=request.getParameter("NroVenda");
    
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
    
    }
        
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | validacaoException | ClassNotFoundException ex) {
            Logger.getLogger(vendaControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | validacaoException | ClassNotFoundException ex) {
            Logger.getLogger(vendaControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
   
}
