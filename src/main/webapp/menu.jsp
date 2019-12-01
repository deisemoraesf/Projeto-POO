<%

    HttpSession objsession = request.getSession(true);
    String usuario = (String)objsession.getAttribute("usuario");
    
    if(usuario.equals("")){       
        response.sendRedirect("login.jsp");
    }
    

%>

<!DOCTYPE html>
<html>
    <head>
        <title>Cadastros</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        
            <script type="text/javascript">
            function Voltar(){
                location.href = 'login.jsp';
            }
            </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
     <nav class="navbar navbar-expand-lg navbar-light bg-light ">


  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
  
      <li class="nav-item">
         <strong> 
             <a class="nav-link" class="btn btn-outline-light" href="clienteControle" target="frame">Clientes</a>
         </strong>
      </li>
      
       <li class="nav-item">
         <strong> 
        <a class="nav-link" href="usuarioControle" target="frame">Usuario</a>
        </strong>
      </li>
      
       <li class="nav-item">
           <strong>
        <a class="nav-link" href="tabelaControle" target="frame">Tabela</a>
        </strong>
      </li>
      
       <li class="nav-item">
           <strong>
        <a class="nav-link" href="vendaControle" target="frame">Vendas</a>
           </strong>
      </li>
      
    </ul>
      
      
      
        <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <% out.println(usuario); %> 
         </button>
         <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="#" onClick="Voltar()">Sair</a>
          </div>
        </div>
  </div>
</nav>
        <div class="m-4" style="height: 850px;">
            <iframe name="frame" style="height: 100%; width: 100%"></iframe>             
        </div>  
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
        
        
    </body>
</html>