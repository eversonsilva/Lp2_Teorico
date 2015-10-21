<%-- 
    Document   : index
    Created on : 18/09/2015, 11:38:20
    Author     : 41487532
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Everson Corporation!</h1>
        <br/><br/>
        
        <a href="${pageContext.request.contextPath}/principal?command=Cargo.listar">cargo</a> |
        <a href="${pageContext.request.contextPath}/principal?command=Departamento.listar">departamento</a> |
        <a href="${pageContext.request.contextPath}/principal?command=Funcionario.listar">funcionario</a> |
 
    </body>
</html>
