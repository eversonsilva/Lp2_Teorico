<%-- 
    Document   : index
    Created on : 15/09/2015, 11:46:07
    Author     : 41487532
--%>

<%@page import="br.mackenzie.fci.ec.lp2.main.model.Cargo"%>
<%@page import="br.mackenzie.fci.ec.lp2.main.dao.CargoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
            for(Cargo cargo : new CargoDAO().listar())
                out.println(cargo.getCodigo() + "-" + cargo.getNome()+"<br>");
        %>
        
    </body>
</html>
