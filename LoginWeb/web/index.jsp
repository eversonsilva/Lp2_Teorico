<%-- 
    Document   : index
    Created on : 21/10/2015, 13:39:05
    Author     : Everson
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Login</title>
    </head>
    <body>
        <h2>Login</h2>

        <br/><br/>
                
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            
            <input type="hidden" name ="command" value="Usuario.verifica">
            <label for="name">Username:</label> <input type="text" name="name" size="30" required/><br/>
            <label for="name">Senha:</label> <input type="password" name="password" size="30" required/>
            <br>
            <input type="submit" value="Enviar">
            <a href="${pageContext.request.contextPath}/principal?command=Usuario.formulario">Cadastrar</a>
        </form>
    </body>
</html>
