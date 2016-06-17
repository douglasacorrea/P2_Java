<%-- 
    Document   : Header
    Created on : 16/06/2016, 02:06:02
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="header">
        <h3 align="center" class="campos">
                        Olá ${sessionScope.logado.getLogin()}!<br>
                        <a href="../Logout">Sair</a>
        </h3>
   </div>
       <div align="center" id="banner">
              
               <img  src="../images/banner.JPG">
       </div>
    </body>
</html>
