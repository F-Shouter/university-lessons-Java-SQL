<%-- 
    Document   : formularioeditar
    Created on : 2 de set. de 2024, 10:04:27
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
            <form action = "ManterProduto" method="GET">
                ID........: <%out.print(prod.getId());%> <input type="hidden" name="txtid" value="<%out.print(prod.getId());%>">  <BR>
                Descricao.: <input type="text" name="txtdescricao" value="<%out.print(prod.getDescricao());%>">  <BR>
                Preco.....: <input type="number" name="txtpreco" value="<%out.print(prod.getPreco());%>"> <BR>
                <input type="submit" name="op" value="ATUALIZAR">
            </form>
        </h2>
    </body>
</html>
