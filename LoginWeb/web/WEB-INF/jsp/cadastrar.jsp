<%-- 
    Document   : cadastrar
    Created on : 21/10/2015, 15:20:48
    Author     : Everson
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <h1>Cadastrar</h1>
        <br/><br/>
        
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            
            <input type="hidden" name ="command" value="Usuario.sejaBemVindo" >
            <label for="name">Username:</label> <input type="text" name="name" size="30" required /><br/>
            <label for="name">Senha:</label> <input type="password" name="password" size="30" required/>
            <br>
            <input type="submit" value="Enviar">
            
        </form>
            
            
    </body>
</html>
