<%-- 
    Document   : Index
    Created on : 08-04-2020, 22:16:40
    Author     : oskardashh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="Validad" method="POST">
                        <div class="form-group text-center">
                            <h3>Login</h3>
                            <img src="Imagenes/logo.png" alt="70" width="170"/>
                            <label>¡Bienvenido a Turismo Real!</label>
                        </div>
                        <div class="form-group">
                            <label>DNI: </label>
                            <input type="text" name="txt_dni" class="form-group">
                        </div>
                        <div class="form-group">
                            <label>Contraseña:</label>
                            <input type="password" name="txt_contrasenia" class="form-group">              
                        </div>
                        <input type="submit" name="accion" value="Iniciar Sesión" class="btn btn-primary btn-b">     
                    </form>
                </div>
            </div>
        </div>
        
        
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
   
        
        
        
    </body>
      
</html>
