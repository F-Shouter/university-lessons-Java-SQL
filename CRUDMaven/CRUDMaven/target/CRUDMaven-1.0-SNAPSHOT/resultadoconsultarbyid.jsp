<%-- 
    Document   : resultadoconsultarbyid
    Created on : 26 de ago. de 2024, 11:03:00
    Author     : ptoledo
--%>

<%@page import="com.da.crudmaven.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado Consultar ID</h1>
        <%
        Produto prod = (Produto) request.getAttribute("produto");
        %>
        <h2>
        ID........: <%out.print(prod.getId());%> <BR>
        Descricao.: <%out.print(prod.getDescricao());%> <BR>
        Preco.....: <%out.print(prod.getPreco());%> <BR>
        </h2>
    </body>
</html>
