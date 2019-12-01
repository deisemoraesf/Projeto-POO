<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script type="text/javascript">
             function Alerta(){
                 alert("Cadastrado com Sucesso!");
             }
        </script>
        <title>Usuario</title>
        <style>
            body{
                text-align: center;
                align-items: center;
            }
        </style>
    </head>
    <body>
        <h1>Cadastro Usuario</h1>
        <hr>
        <br>
        <div>
            <form method="POST" action="usuarioControle">
                <input type="hidden" name="id" value="${usuarios.id}"/>
                <label>Id:</label>&nbsp;<input type="text" disabled name="id" value="${usuarios.id}"/><br><br>
                <label>Nome:</label>&nbsp;<input type="text" name="nome" value="${usuarios.nome}"required/><br><br>
                <label>Usuario:</label>&nbsp;<input type="text" name="login" value="${usuarios.login}"required/><br><br>
                <label>Senha:</label>&nbsp;<input type="password" name="senha" value="${usuarios.senha}"required/><br><br>
                
                <button type="submit" class="btn btn-success" onclick="return Alerta()">Salvar</button>&nbsp
                <button type="reset" value="Limpar" class="btn btn-primary">Limpar</button>
                <a href="usuarioControle?acao=voltarlista" class="btn btn-primary">Voltar</a>
            </form>
        </div>
    </body>
</html>







