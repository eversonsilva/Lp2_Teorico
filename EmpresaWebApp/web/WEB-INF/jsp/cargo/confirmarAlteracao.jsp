<%-- 
    Document   : inserir
    Created on : 29/09/2015, 11:03:17
    Author     : 41487532
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargo - Confirmar Alteracao</title>
    </head>
    <body>
        <h3>Cargos - Confirmar alteração</h3>
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name ="command" value="Cargo.confirmar-alteracao">
            <label for="codigo">Codigo:</label> 
            <input type="text" name="codigo" size="30" readonly="true" value="${cargo.codigo}">
            <label for="nome">Nome:</label> 
            <input type="text" name="nome" size="30" value="${cargo.nome}">
            <br>
            <input type="submit" value="Enviar">
            <input type="button" onClick="location.href='${pageContext.request.contextPath}/principal?command=Cargo.listar'" value="Cancelar">
        </form>
    </body>
</html>