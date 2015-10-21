<%-- 
    Document   : lista
    Created on : 22/09/2015, 10:59:17
    Author     : 41487532
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamento - Listar</title>
    </head>
    <body>
        <h3>Departamento</h3>
        <a href="${pageContext.request.contextPath}/principal?command=Departamento.formulario">inserir</a>
        <a href="${pageContext.request.contextPath}/principal?command=Departamento.alterar">alterar</a>
        <a href="${pageContext.request.contextPath}/principal?command=Departamento.remover">remover</a>
        <br/><br/>
        <c:forEach var="departamento" items="${departamentos}">
            <c:out value="${departamento.codigo}"/>&nbsp;&#45;&nbsp;
            <c:out value="${departamento.nome}"/>
            <br>
        </c:forEach>
    </body>
</html>