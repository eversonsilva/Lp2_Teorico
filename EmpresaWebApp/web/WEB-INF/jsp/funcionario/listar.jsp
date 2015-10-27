<%-- 
    Document   : listar
    Created on : 22/09/2015, 10:59:30
    Author     : 41487532
--%>


<%@page language="java" contentType="text/html; charset -ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionarios</title>
    </head>
    <body>
        <h3>Funcionarios</h3>
        <a href="${pageContext.request.contextPath}/principal?command=Funcionario.formulario">Inserir</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Funcionario.alterar">Alterar</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Funcionario.remover">Remover</a> | 
        
        
       <br/><br/><br/>
       
       <table style="width:100%">
            <tr>
              <td>ID</td>
              <td>NOME</td> 
              <td>CARGO</td>
              <td>DEPARTAMENTO</td>
            </tr>
            <tr>
                <c:forEach items="${funcionarios}" var="funcionario" varStatus="i">
                   <c:if test="${(i.index + 1) % 4 == 0}"> 
                        <td>${funcionario}</td>
                        </tr>
                        <tr>
                    </c:if>
                    <c:if test="${(i.index + 1) % 4 != 0}"> 
                        <td>${funcionario}</td>
                    </c:if>
                </c:forEach>
        </table>
       
    </body>
</html>
