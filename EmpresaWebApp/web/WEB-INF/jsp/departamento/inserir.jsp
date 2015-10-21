<%-- 
    Document   : inserir
    Created on : 29/09/2015, 11:03:17
    Author     : 41487532
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamento - Inserir</title>
    </head>
    <body>
        <h3>Departamento: inserir</h3>
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name ="command" value="Departamento.inserir">
            <label for="name">Nome:</label> <input type="text" name="name" size="30">
            <br>
            <input type="submit" value="Enviar">
            <input type="button" onClick="location.href='${pageContext.request.contextPath}/principal?command=Departamento.listar'" value="Cancelar">
        </form>
    </body>
</html>
