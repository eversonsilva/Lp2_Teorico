<%-- 
    Document   : index
    Created on : 21/10/2015, 13:39:05
    Author     : Everson
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Login</title>
    </head>
    <body>
        <h2>Login</h2>

        <br/><br/>

        <form method="POST" id="formLogin" action="${pageContext.request.contextPath}/principal">

            <input type="hidden" name="command" value="Usuario.sejaBemVindo">
            <label for="name">Username:</label> <input type="text" id="username" name="username" size="30" required/><br/>
            <label for="name">Senha:</label> <input type="password" id="password" name="senha" size="30" required/>
            <br>
            <input type="button" onclick="verifica()" value="Enviar" required>
            <a href="${pageContext.request.contextPath}/principal?command=Usuario.formulario">Cadastrar</a>
        </form>
        <script>
            function verifica() {
            switch (true){
                            case (document.getElementById("username").value == ""):
                                document.getElementById("username").focus();
                                alert("Digite o Usuário");
                                break;
                            case (document.getElementById("password").value == ""):
                                document.getElementById("password").focus();
                                alert("Digite a Senha");
                                break;
                            default:
                                document.getElementById("formLogin").submit();
                                break;
                    }
                    }
        </script>
    </body>
</html>
