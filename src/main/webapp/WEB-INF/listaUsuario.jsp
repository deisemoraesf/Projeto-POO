<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Usuario</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <hr>
        <form method="POST" action="usuarioControle">    
        <table class="table table-hover">
            <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Login</th>
            <th>Senha</th>
            <th>Ação</th>
            <th>Ação</th>
           </tr>
           
            <c:forEach var="u" items="${Usuario}" >
                <tr>
                    <td>${u.id}</td>
                    <td>${u.nome}</td>
                    <td>${u.user}</td>
                    <td>${u.senha}</td>
                    
                    <td><a href=usuarioControle?acao=editar&id=${u.id}>Editar</a></td>
                    <td><a href=usuarioControle?acao=excluir&id=${u.id}>Excluir</a></td>
                </tr>
              
            </c:forEach>
        </table>         
        </form>
                <a href="usuarioControle?acao=salvar" class="btn btn-success" style="margin-left: 10px">Cadastrar</a>        
                <a href="menu.jsp" class="btn btn-danger" style="margin-left:10px">Voltar</a>  
        <br>
                </body>
</html>
