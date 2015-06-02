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
    <title>Login BookleWeb</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />

<!-- Fontes do Google -->
<link href='http://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
    
<!-- Estilos do Alertfy -->
<link rel="stylesheet" href="<c:url value="/resources/jquery/alertifyjs/alertify.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/jquery/alertifyjs/css/themes/default.min.css"/>" /> 
<script src="<c:url value="/resources/jquery/alertifyjs/alertify.min.js" />"></script>
    
<!-- Jquery Validator Form -->
    <script src="resources/js/jquery-1.11.2.min.js"></script>   
<script src="<c:url value="/resources/jquery/validator/jquery.validate.js" />"></script>
<script src="<c:url value="/resources/jquery/validator/views/login.js" />"></script>
    
</head>
<body class="background-login">
    <div class="container-fluid">
        
        <!-- MENSAGENS ALERTIFY-->
        <c:if test="${not empty param.error}">
            <script>
                alertify.error("${param.error}");
            </script>
        </c:if>
        
        <c:if test="${not empty erro}">
            <script>
                alertify.error("${erro}");
            </script>
        </c:if>
        
        <c:if test="${not empty sucesso}">
            <script>
                alertify.success("${sucesso}");
            </script>
        </c:if>
             
        <!-- CABEÇALHO -->
        <header class="row">
            <c:import url="/resources/template/publico/menu.jsp"></c:import> 
        </header>

        <!-- CONTEÚDO -->
        <div class="row">
            <div role="main">
                <div class="col-md-4 col-md-offset-4">
		          <form id="formlogin_cadastrar" action="<c:url value='/adicionausuariologin' />" method="POST">
                    <div class="panel-body">
                    <h3 class="text-center">
                        CADASTRE-SE AGORA
                    </h3>
                    <form class="form form-signup" role="form">
                      <div class="form-group">  
                     <div class="input-group">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-certificate"></span>
                            </span>
                            <input type="text" class="form-control" placeholder="Matrícula" name="matricula"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-user"></span>
                            </span>
                            <input type="text" class="form-control" placeholder="Nome completo" name="nome" id="add_nome"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                         <span class="input-group-addon">
                             <span class="glyphicon glyphicon-envelope"></span>
                            </span>
                            <input type="text" class="form-control" placeholder="Email" name="email"/>
                        </div>
                    </div>    
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" class="form-control" placeholder="Senha" name="senha"/>
                            <input type="hidden" name="permissao"/>
                        </div>
                    </div>
                </div>
                
                <button class="btn btn-sm btn-success btn-block" type="submit" >Abrir nova conta</button>
                        <a data-toggle="modal" data-target="#myModal"><h6>Esqueceu sua senha?</h5></a>    
                </form>
            </div>
        </div>  
    </div>
</div>
        <!-- RODAPÉ 
        <footer class="row">
         
        </footer>-->
    
        <!-- MODAL PARA RESETAR SENHA -->
        <c:import url="/resources/template/publico/resetarsenha.jsp"></c:import> 
        
    <!--FIM DIV CONTAINER-->
    </div>

    <!-- Javascript do bootstrap -->
    <script src="resources/js/bootstrap.min.js"></script>
</body>
    
</html>
