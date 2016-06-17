<%-- 
    Document   : LoginCadastro
    Created on : 08/06/2016, 01:25:48
    Author     : Douglas
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Douglas RentACars</title>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.contextPath}/css/styles.css'/>
    </head>
    <body>
    <div id="banner">
        <center><img src="../images/banner.JPG"></center>
    </div>
    <div id="Login">
        <label class="nome">Cadastre seu Login e Senha</label>
            <form action='${pageContext.request.contextPath}/UsuarioNovo' method="post" >
                <label class="campos">Preencha o Login</label><br>
                <input class="campos" type="text" name="login" required/><br><br>
                <label class="campos">Preencha a Senha</label><br>
                <input class="campos" type="password" name="password" required/><br><br>
                <button class="button-pq" type="submit">Enviar</button>
            </form>
            </p>
            <form action='${pageContext.request.contextPath}/index.jsp' method="post">
                <button class="button-pq" type="submit">Cancelar</button>
            </form>
    </div>
</body>
</html>
