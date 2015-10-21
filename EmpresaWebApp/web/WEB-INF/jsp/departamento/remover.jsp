<%-- 
    Document   : remover
    Created on : 16/10/2015, 18:29:35
    Author     : Everson
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamento - Deletar</title>
    </head>
    <body>
        <h3>Deletar - Departamento</h3>
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name="command" value="Departamento.removerPorId"
            <label for="departamentos">Departamentos:&nbsp;</label>
            <select name="departamentos" onchange="this.form.submit()">
                <option value="">--selecione--</option>
                <c:forEach var="departamento" items="${departamentos}">
                    <option value="${departamento.codigo}">
                        <c:out value="${departamento.nome}" />
                    </option>
                </c:forEach>
            </select>
            <input type="button" onClick="location.href='${pageContext.request.contextPath}/principal?command=Departamento.listar'" value="Cancelar">
        </form>
        
    </body>
</html>