<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <hr>
        <div class="container" method="POST" action="usuarioControle">
        <div name="menu">
            <div>Id</div>
            <div>Nome</div>
            <div>Usuario</div>
            <div>Senha</div>
            
        </div>
        <c:forEach var="u" items="${Usuario}">
            <div name="lista">
                <div>${u.id}</div>
                <div>${u.nome}</div>
                <div>${u.user}</div>
                <div>${u.senha}</div>
                <div><a href=usuarioControle?acao=editar&id=${u.id}>Editar</a></div>
                <div><a href=usuarioControle?acao=excluir&id=${u.id}>Excluir</a></div>
            </div>
        </c:forEach>
        </div>
    </body>
</html>
