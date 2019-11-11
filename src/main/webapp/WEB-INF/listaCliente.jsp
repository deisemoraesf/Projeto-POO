
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body>
        <h1>Clientes</h1>
        <hr>
        
        <div name="menu">
            <div>Id</div>
            <div>Nome</div>
            <div>CPF</div>
            <div>Veículo</div>
            <div>Placa</div>
        </div>
        <c:forEach var="c" items="${Cliente}">
            <div name="lista">
                <div>${c.id}</div>
                <div>${c.nome}</div>
                <div>${c.cpf}</div>
                <div>${c.veiculo}</div>
                <div>${c.placa}</div>
                <div><a href=clienteControle?acao=editar&id=${c.id}>Editar</a></div>
                <div><a href=clienteControle?acao=excluir&id=${c.id}>Excluir</a></div>
            </div>
        </c:forEach>
    </body>
</html>
