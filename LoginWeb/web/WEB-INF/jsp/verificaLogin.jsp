<%-- 
    Document   : verificaLogin
    Created on : 21/10/2015, 18:53:05
    Author     : Everson
--%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verifica Login</title>
    </head>
    <body>
        
        <c:if var="name"
            
            if(empty($nome) || strstr($nome, ' ')==FALSE)
{echo "Favor digitar seu nome corretamente.<br>";$erro=1;}

if(strlen($email)<8 || strstr($email, '@')==FALSE)
{echo "Favor digitar seu email corretamente.<br>";$erro=1;}

if(empty($msg))
{echo "Favor entre com algum comentrio.<br>";$erro=1;}

if($erro==0)
{echo "Todos os dados foram digitados corretamente!";
include "insere.inc";
}


    </body>
</html>
