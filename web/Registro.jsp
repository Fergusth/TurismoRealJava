<%-- 
    Document   : Registro
    Created on : 12-04-2020, 20:03:20
    Author     : oskardashh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        
    <center>
        <div>
            <h3>
                Agregar Usuarios
                
            </h3>
        </div>
        <hr>
        <div>
            
            <form action="Controlador" method="POST">
                
                DNI:
                <input type="text" name="txt_dni">
                Nombre:
                <input type="text" name="txt_nombre">
                Apellidos:
                <input type="text" name="txt_apellidos">
                Correo:
                <input type="text" name="txt_correo">
                Dirección:
                <input type="text" name="txt_direccion">
                Telefono:
                <input type="text" name="txt_telefono">
                Contraseña:
                <input type="text" name="txt_contrasenia">
                Rol:
                <input type="text" name="txt_rol">
                Extranjero:
                <input type="text" name="txt_extranjero">
                Frecuente:
                <input type="text" name="txt_frecuente">
                <input type="submit" name="accion" value="Guardar">
                
                
                
            </form>
                  
            
        </div>
        
    </center>
    </body>
</html>
