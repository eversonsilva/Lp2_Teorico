<%-- 
    Document   : BemVindo
    Created on : 21/10/2015, 15:21:34
    Author     : Everson
--%>

<%@page import="br.mackenzie.fci.ec.lp2.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem Vindo</title>
    </head>
    <body>
        <h1>Bem Vindo <%
 Usuario usuario = (Usuario) session.getAttribute("usuario");
 out.println(usuario.getUsername());
%></h1>
        
    
    </body>
</html>
