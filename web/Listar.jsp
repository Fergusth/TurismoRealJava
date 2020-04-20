<%-- 
    Document   : Listar
    Created on : 09-04-2020, 0:29:51
    Author     : oskardashh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div>
            <h3>Usuarios: </h3>
            <form action="Controlador" method="POST">
                <input type="submit" name="accion" value="Listar">
                
            </form>
        </div>
        <table border="1">
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>NOMBRES</th>
                    <th>APELLIDOS</th>
                    <th>CORREO</th>
                    <th>DIRECCION</th>
                    <th>CONTRASEÑA</th>
                    
                </tr>
            </thead>
            <tbody>
                
                <c:forEach var="dato" items="${datos}">
                <tr>
                    <td>${dato.getDni()}</td>
                    <td>${dato.getNombre()}</td>
                    <td>${dato.getApellidos()}</td>
                    <td>${dato.getCorreo()}</td>
                    <td>${dato.getDireccion()}</td>
                    <td>${dato.getContrasenia()}</td>
                    <td>
                        <form>
                            <input type="submit" value="Editar">
                            <input type="submit" value="Eliminar">
                          
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            
        </table>
    </center>
    </body>
</html>
