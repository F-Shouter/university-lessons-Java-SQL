<%-- 
    Document   : resultadoconsultartodos
    Created on : 27 de ago. de 2024, 08:42:36
    Author     : ptoledo
--%>

<%@page import="java.util.List"%>
<%@page import="com.da.crudmaven.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Todos</title>
    </head>
    <body>
    <center>    
        <h1>Consultar Todos</h1>
        <%
            List<Produto> lprod = (List<Produto>) request.getAttribute("lprod");
        %>

        <table border="1">
            <th>ID</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th>Editar</th>
            <th>Remover</th>
                <%for (Produto prod : lprod) {%>
            <tr>
                <td><%out.print(prod.getId());%></td>
                <td><%out.print(prod.getDescricao());%></td>
                <td><%out.print(prod.getPreco());%></td>
                
                
                <td><a href="ManterProduto?op=EDITAR&txtid=<%out.print(prod.getId());%>"><img src="imagens/edit01.png" width="30" height="30"></a></td>
           
                
                <td><a href="ManterProduto?op=DELETAR&txtid=<%out.print(prod.getId());%>"><img src="imagens/trash01.jpg" width="30" height="30"></a></td>
                
            </tr>
            <%}%>
        </table>
    </center>
</body>
</html>
