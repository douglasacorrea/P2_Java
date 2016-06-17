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
            <jsp:include page="Header.jsp"/>
        </div>
    <div>
            <jsp:include page="Menu.jsp"/>
    </div>
            <form action='${pageContext.request.contextPath}/ReservaNova' method="post" >
                <div>
                    <br>
                        <center>
                            <div class="strap">
                                <label class="campos">Preencha o nome do Motorista</label><br>
                                <input  type="text" name="nomeMotorista" required/>
                                
                            </div>
                            <br><br>
                            <div class="strap">
                                <label class="campos">Escolha a Data de Retirada</label><br>
                                <input type="date" name="startDate"  min="2016-06-01" required/>
                            </div>
                            <br><br>
                            <div class="strap">
                                <label class="campos">Escolha a Data de Devolução</label><br>
                                <input type="date" name="endDate"  min="2016-06-01" required/>
                            </div>
                            <br><br>
                            <div class="strap-car">
                            <label class="campos-car">Escolha o Carro</label>
                            </div>
                            <br><br>
                            <div class="strap"><br><br>
                                <select class="campos" name="carro"> 
                                       <option value="Palio">Palio</option>
                                       <option value="Fox">Fox</option>
                                       <option value="Peugeot">Peugeot</option>

                                </select><br><br>
                            </div>
                                <button  class="button" type="submit">Reservar</button>
                       
            </form>
           
	
    </body>
</html>