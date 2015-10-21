<%-- 
    Document   : confirmarRemocao
    Created on : 16/10/2015, 18:31:35
    Author     : Everson
--%>


<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamento - Confirmar Remocao</title>
    </head>
    <body>
        <h3>Departamentos - Confirmar remocao</h3>
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name ="command" value="Departamento.confirmar-remocao">
            <label for="codigo">Codigo:</label> 
            <input type="text" name="codigo" size="30" readonly="true" value="${departamento.codigo}">
            <label for="nome">Nome:</label> 
            <input type="text" name="nome" size="30" readonly="true" value="${departamento.nome}">
            <br>
            <input type="submit" value="Enviar">
            <input type="button" onClick="location.href='${pageContext.request.contextPath}/principal?command=Departamento.listar'" value="Cancelar">
        </form>
    </body>
</html>