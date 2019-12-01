
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script type="text/javascript">
             function Alerta(){
                 alert("Sucesso!");
             }
        </script>
        
        <title>Cliente</title>
        
        <style>
            body{
                text-align: center;
                align-items: center;
            }
        </style>
    
    </head>
    <body>
        <h1>Cadastro Cliente</h1>
        <hr>
        <br>
       
        <div>
            <form method="POST" action="clienteControle">
                
                <input type="hidden" name="id" value="${cliente.id}"/>
                <label>Id:</label>&nbsp;<input type="text" disabled name="id" value="${cliente.id}"/><br><br>
                <label>Nome:</label>&nbsp;<input type="text" name="nome" value="${cliente.nome}"/><br><br>
                <label>CPF:</label>&nbsp;<input type="text" name="cpf" value="${cliente.cpf}"/><br><br>
                <label>Veículo:</label>&nbsp;<input type="text" name="veiculo" value="${cliente.veiculo}"/><br><br>
                <label>Placa:</label>&nbsp;<input type="text" name="placa" value="${cliente.placa}"/><br><br>
                
                <button type="submit" class="btn btn-success" onclick="return Alerta()">Salvar</button>&nbsp
                <button type="reset" value="Limpar" class="btn btn-primary">Limpar</button>
                <a href="clienteControle?acao=voltarlista" class="btn btn-primary">Voltar</a>
            </form>
            
        </div>
        
    </body>
</html>



