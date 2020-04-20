<%-- 
    Document   : Principal
    Created on : 07-04-2020, 22:34:41
    Author     : oskardashh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
 
        <title>Inicio</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a style="color: white" class="navbar-toggler"><span class="navbar-toggler-icon"></span> Home</a>

            <div class="dropdown">
                <a style="color:white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Sesión</a>
                <div class="dropdown-menu text-center">
                    <a><img src="Imagenes/usuario.png" height="80" width="80"></a><br>
                    <a>User</a>
                    <a>example@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <a href="Login.jsp" class="dropdown-item">Salir</a>

                </div>
            </div>
        </nav>
        <div class="container mt-4">
            <h1>Bienvenido al Sistema...<strong>Usuario ${dni}</strong></h1>
        </div>
       
        
        
        
        
        
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
