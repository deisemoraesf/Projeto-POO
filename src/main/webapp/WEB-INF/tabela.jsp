
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Tabela de Preços</title>
    </head>
    <body>
        <h1>Tabela Preços</h1>
        <hr>
        <form method="POST" action="tabelaControle">
            <label>Preço por Hora: </label><input type="text" name="hora" class="form-control" placeholder="Preço por hora" required>
            <label>Preço por Diário: </label><input type="text" name="diario" class="form-control" placeholder="Preço por dia" required>
            <label>Preço por Mensal: </label><input type="text" name="mensal" class="form-control" placeholder="Preço mensal" required>
            <br>
                        
        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Preço Hora</th>
                                    <th>Preço Diário</th>
                                    <th>Preço Mensal</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="t" items="${Tabela}">
                                <tr>
                                    <td>${t.getPrecoHora()}</td>
                                    <td>${t.getPrecoDiario()}</td>
                                    <td>${t.getPrecoMensal()}</td>
                                    
                                    <td class="d-flex">
                                        <a href="tabelaControle?acao=editar" class="btn btn-warning">Editar</a><br>
                                        
                                    </td>
                                </tr>
                                </c:forEach>
            <a href="tabelaControle?acao=salvar" class="btn btn-success" style="margin-left: 10px;">Salvar</a>
            <a href="tabelaControle?acao=voltar" class="btn btn-danger" style="margin-left: 10px;">Voltar</a>

        </form>                        
                            </tbody>
                        </table>
    </body>
</html>
