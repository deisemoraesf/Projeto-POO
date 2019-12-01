<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Cliente</title>
    </head>
    <body>
        <h1>Clientes</h1>
        <hr>
        <a href="clienteControle?acao=cadastrar" class="btn btn-success">Cadastrar</a>
        <a href="clienteControle?acao=voltarmenu" class="btn btn-primary">Sair</a>
        <br/>
        <br/>
        <table class="table table-hover">
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Veiculo</th>
            <th>Placa</th>
            <th>Ação</th>
                  
            </tr>
            <c:forEach var="c" items="${Cliente}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.nome}</td>
                    <td>${c.cpf}</td>
                    <td>${c.veiculo}</td>
                    <td>${c.placa}</td>
                    <td class="d-flex">
                    <a href=clienteControle?acao=editar&id=${c.id} class="btn btn-info">Editar</a>&nbsp;&nbsp;
                    <a href=clienteControle?acao=excluir&id=${c.id} class="btn btn-danger">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
