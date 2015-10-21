<%-- 
    Document   : listar-alterar
    Created on : 06/10/2015, 11:01:14
    Author     : 41487532
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionario - Atualizar</title>
    </head>
    <body>
        <h3>Alterar - Funcionario</h3>
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name="command" value="Funcionario.alterarPorId"
            <label for="funcionarios">Funcionario:&nbsp;</label>
            
            <select name="funcionarios" onchange="this.form.submit()">               
                <option value="">--selecione--</option>              
                <c:forEach var="funcionario" items="${funcionarios}">
                    <option value="${funcionario.codigo}">
                        <c:out value="${funcionario.nome}" />
                    </option>
                </c:forEach>
            </select>
   
            <input type="button" onClick="location.href='${pageContext.request.contextPath}/principal?command=Funcionario.listar'" value="Cancelar">
        </form>
        
    </body>
</html>