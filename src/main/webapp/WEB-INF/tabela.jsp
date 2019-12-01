<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Tabela de Preço</title>
    </head>
    <body>
        <h1>Tabela de Preço</h1>
        <hr>
        <form method="POST" action="tabelaControle">
            <input type="hidden" name="id" value="${tabelas.id}"/>
            <label style="margin-left: 10px; font-weight: bold;">ID:</label><input type="text" disabled name="id" value="${tabelas.id}" class="form-control" style="margin-left: 10px; width:60px;"/><br/>
            <label style="margin-left: 10px; font-weight: bold;">Preço Hora:</label><input type="text" name="precoHora" value="${tabelas.precoHora}" class="form-control"style="margin-left: 10px; width:400px;"/><br/>
            <label style="margin-left: 10px; font-weight: bold;">Preço Diária:</label><input type="text" name="precoDiario"value="${tabelas.precoDiario}" class="form-control" style="margin-left: 10px; width:400px;"/><br/>
            <label style="margin-left: 10px; font-weight: bold;">Preço Mensal:</label><input type="text" name="precoMesal" value="${tabelas.precoMensal}" class="form-control" style="margin-left: 10px; width:400px;"/><br/>
            
            <input type="submit" value="salvar">
            <a href="tabelaControle?acao=salvar" class="btn btn-success" style="margin-left: 10px;">Salvar</a>
        </form>
        <br>
        <table class="table table-hover">
            <tr>
            <th>ID</th>
            <th>Preço Hora</th>
            <th>Preço Diária</th>
            <th>Preço Mensal</th>
            <th>Ações</th>
            </tr>
            <c:forEach var="t" items="${tabela}">
                <tr>
                    <td>${t.id}</td>
                    <td>${t.precoHora}</td>
                    <td>${t.precoDiario}</td>
                    <td>${t.precoMensal}</td>
                    <td><a href=tabelaControle?acao=editar&id=${t.id}>Editar</a>
                </tr>
            </c:forEach>
                
        </table>
        <br>
        
    </body>
</html>