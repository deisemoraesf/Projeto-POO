<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Cliente</title>
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
            <form method="POST" action="usuarioControle">
                <label>Id: </label><input type="text" name="id">
                <label>Nome: </label><input type="text" name="nome">
                <label>Usuário: </label><input type="text" name="cpf">
                <label>Senha: </label><input type="text" name="veiculo">
                <button type="submit" class="btn btn-success" onclick="return Alerta()">Salvar</button>&nbsp
                <button type="reset" value="Limpar" class="btn btn-primary">Limpar</button>
                <a href="usuarioControle?acao=voltar" class="btn btn-primary">Voltar</a>
            </form>
        </div>
    </body>
</html>
