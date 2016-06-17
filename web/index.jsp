<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Douglas RentACars</title>
        <link rel="stylesheet" type="text/css" href='${pageContext.request.contextPath}/css/styles.css'/>
    </head>
    <body>
        <div>
            <jsp:include page="/jsp/HeaderIndex.jsp"/>
        </div>
   
    
    <div id="Login">
        <div class="nomediv">
        <label class="nome"> Rent a Car Douglas</label>
    </div>
       <form action='${pageContext.request.contextPath}/AutenticaLogin' method="post" >
                        <h3><label class="campos">Login</label><br><input type="text" name="login" required/><br><br>
                            <label class="campos">Senha</label><br><input  type="password" name="password" required/><br><br>
                            <button class="button-pq" type="submit">Entrar</button>
                        </h3>
        </form>
        <form action='${pageContext.request.contextPath}/jsp/LoginCadastro.jsp' method="post">
            <button class="button-pq" type="submit">Cadastrar</button>
        </form><br>
        
    </div>
    </body>
</html>
