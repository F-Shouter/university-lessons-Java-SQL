<%-- 
    Document   : indexjsp
    Created on : 10/05/2022, 17:21:08
    Author     : proft
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>COMBATE SQL Injection</h1>
        <form action="Controller_Autenticacao" method="post">
            <BR>
            Login......: <input type="text" name="txtlogin"><BR>
            Senha......: <input type="text" name="txtsenha"><BR>
            <BR>
            <input type="submit" name="operacao" value="Login"> 
        </form>
    </body>
</html>