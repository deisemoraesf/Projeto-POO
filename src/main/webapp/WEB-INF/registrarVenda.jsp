<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Venda</title>
                </head>
                    <body>
                        <h1>Venda</h1>
                        <hr>
                        <div class="d-flex ml-auto">
                            <div class="col-sm-100">
                                <div class="card">
                                <form action="vendaControle?menu=Venda" method="POST">
                                <div class="card-body">  
  
                        <!--DADOS DO CLIENTE-->                            
                                <div class="form-group"><label>Dados Cliente</label></div>                       
                            <div class="form-group d-flex">     
                                <div class="col-sm-6 d-flex">
                                <input type="text" name="cpf" value="${Cliente.getCpf()}" class="form-control" placeholder="CPF" required>                                
                                <input type="submit" name="acao" value="buscarCliente" class="btn btn-outline-info">
                                <br>
                                </div>
                                <div class="col-sm-6">
                                <input type="text" name="id" value="${Cliente.getId()}" placeholder="Id Cliente" class="form-control"> 
                                <input type="text" name="nome" value="${Cliente.getNome()}" placeholder="Nome Cliente" class="form-control">
                                <input type="text" name="veiculo" value="${Cliente.getVeiculo()}" placeholder="Modelo do Veículo" class="form-control">
                                <input type="text" name="placa" value="${Cliente.getPlaca()}" placeholder="Placa" class="form-control">
                                </div>
                            </div>  
    
                        <!--DADOS DO SERVICO-->    
                            <div class="form-group"><label>Dados do Serviço</label></div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-15 d-flex">
                                        <label>Data de Entrada: </label><input type="text" name="entrada" class="form-control" placeholder="dd/mm/aa hh:ss" required>
                                        <label>Data de Saída: </label><input type="text" name="saida" class="form-control" placeholder="dd/mm/aa hh:ss" required>
                                        <div class="form-group">
                                            <div class="col-sm-3"><button type="submit" name="acao" value="inserirServico" class="btn btn-outline-info">Inserir</button>&nbsp;&nbsp;
                                            <a href="menu.jsp" class="btn btn-danger">Sair</a></div>
                                        </div>
                                    
                           
                        <!--BOTÃO PARA INSERIR O ITEM NA VENDA-->   
                                       
                                </div>
                                </div>
                            </div>
                        <div class="col-sm-100">
                        <div class="card">                    
                        <div class="card-body">

                            
                        <!--ITENS DA VENDA--> 
                        <div class="d-flex col-sm-100 mr-auto"><label>Cliente:</label><input type="text" name="razao" value="${Cliente.getNome()}" class="form-control">
                            <div class="d-flex col-sm-100 mr-auto"><label>Nº Venda:</label><input type="text" name="NroVenda" value="${Venda.numero}" class="form-control"></div>
                                </div> 
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Numero</th>
                                    <th>Código</th>
                                    <th>Cliente</th>
                                    <th>Descrição</th>
                                    <th>Quantidade Horas</th>
                                    <th>Subtotal</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="v" items="${Venda}">
                                <tr>
                                    <td>${v.getNumero()}</td>
                                    <td>${v.getId()}</td>
                                    <td>${v.getNome()}</td>
                                    <td>${v.getDescricao}</td>
                                    <td>${v.Calcular()}</td>
                                    <td>${v.processarRecibo()}</td>
                                    <td class="d-flex">
                                        <a href="vendaControle?acao=editar" class="btn btn-warning">Editar</a>
                                        <a href="#" class="btn btn-danger" style="margin-left: 10px;">Remover</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>
                        <div class="card-footer d-flex">
                            <div class="col-sm-6">
                            <a href="controleVenda?acao=salvar" class="btn btn-success">Imprimir</a>    
                            <button type="reset" class="btn btn-danger">Cancelar</a> 
                            </div>
                        </div>
                           
                        </div>
                        </div>           
                    </div>
                      

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
    </body>
</html>
