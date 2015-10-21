<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionario - Inserir</title>
    </head>
    <body>
        <h3>Funcionarios: inserir</h3>
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name ="command" value="Funcionario.inserir">
            <label for="name">Nome:</label> <input type="text" name="name" size="30">
            <br>
            <select name="cargos" >
                <option value="">--selecione--</option>
                <c:forEach var="cargo" items="${cargos}">
                    <option value="${cargo.codigo}">
                        <c:out value="${cargo.nome}" />
                    </option>
                </c:forEach>
            </select>
            <select name="departamentos" >
                <option value="">--selecione--</option>
                <c:forEach var="departamento" items="${departamentos}">
                    <option value="${departamento.codigo}">
                        <c:out value="${departamento.nome}" />
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="Enviar">
            <input type="button" onClick="location.href='${pageContext.request.contextPath}/principal?command=Funcionario.listar'" value="Cancelar">
        </form>
    </body>
</html>

