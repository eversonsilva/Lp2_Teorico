<%-- 
    Document   : listar
    Created on : 22/09/2015, 10:59:09
    Author     : 41487532
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargo - Listar</title>
    </head>
    <body>
        <h3>Cargos</h3>
        <a href="${pageContext.request.contextPath}/principal?command=Cargo.formulario">inserir</a>
        <a href="${pageContext.request.contextPath}/principal?command=Cargo.alterar">alterar</a>
        <a href="${pageContext.request.contextPath}/principal?command=Cargo.remover">remover</a>
        <br/><br/>
        <c:forEach var="cargo" items="${cargos}">
            <c:out value="${cargo.codigo}"/>&nbsp;&#45;&nbsp;
            <c:out value="${cargo.nome}"/>
            <br>
        </c:forEach>
    </body>
</html>
