<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PT" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modelo GRID BookleWeb</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />
    
</head>
<body class="background-login">
    <div class="container-fluid">
        
        <!-- CABEÇALHO -->
        <header class="row">
            <c:import url="/resources/template/publico/menu.jsp"></c:import> 
        </header>

        <!-- CONTEÚDO -->
        <div class="row">
            <div role="main">
                <div class="col-md-4 col-md-offset-4">
		          <form id="formlogin" action="<c:url value='j_spring_security_check' />" method="POST">
			         <fieldset>
				        <center>
				        <br><br>
				        <hr class="colorgraph">
				        <img src="resources/img/logo.png" alt="..." class="img-circle">
				        </center>
				        <hr class="colorgraph">
                         
                        <div class="form-group">
                            <input type="text" name="j_username" class="form-control" placeholder="Usuario"
                            value="${param.usuario}">
                        </div>
                        <div class="form-group">
                            <input type="password" name="j_password" class="form-control" placeholder="Senha">
                        </div>

                        <c:if test="${not empty param.error}">
                          <div class="alert alert-danger">
                          <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                          <span class="sr-only">Error:</span>
                          ${param.error}
                        </div>
                        </c:if>
  				       
                        
                            <div>
                                <button id="entrar" class="btn btn-lg btn-primary btn-block" type="submit" >Entrar</button>
                            </div>
                        
                        
                        <span class="button-checkbox">
                            <a href="resetarsenha.jsp" class="btn">Esqueceu sua senha?</a>
                            <a href="criarnovaconta.jsp" class="btn">Criar novo login</a>
                        </span>
			         </fieldset>
			         <br>
		          </form>
                </div>
            </div>
        </div>
        <!-- RODAPÉ 
        <footer class="row">
         
        </footer>-->
    
    <!--FIM DIV CONTAINER-->
    </div>

    <!-- Javascript do bootstrap -->
    <script src="resources/js/jquery-1.11.2.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</body>
    
</html>
