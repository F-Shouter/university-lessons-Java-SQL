<%-- 
    Document   : sucessoautenticacao
    Created on : 10/05/2022, 17:34:38
    Author     : proft
--%>

<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Página de Sucesso na Autenticação</h1>
        <BR>
        <% String m = (String) request.getAttribute("mensagem");%>
        <%=m%>
        <br><br><br>
        <% Usuario usu = (Usuario) request.getAttribute("usu");%><br><br>
        
        
        Usuário Logado<br>
        Nome..........: <%=usu.getNome()%><br>
        Login.........: <%=usu.getLogin()%><br>
        Senha.........: <%=usu.getSenha()%><br>
        Nível Acesso..: <%=usu.getNivelacesso()%><br>

    </body>
</html>
