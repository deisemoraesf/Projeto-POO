<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <div>
            <form method="POST" action="usuarioControle">
                <label>Id: </label><input type="text" name="id">
                <label>Nome: </label><input type="text" name="nome">
                <label>Usuário: </label><input type="text" name="cpf">
                <label>Senha: </label><input type="text" name="veiculo">
                <button type="submit" value="Salvar"></button>
                <button type="reset" value="Limpar"></button>
                <button type="submit" value="Voltar"><a href=usuarioControle?acao=voltar></button>
            </form>
        </div>
    </body>
</html>
