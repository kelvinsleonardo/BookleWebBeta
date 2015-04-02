<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Spring Famework -->
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PT" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modelo GRID BookleWeb</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />

<!-- Javascript do bootstrap -->
<script src="resources/js/jquery-1.11.2.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>    
    
<!-- Fontes do Google -->
<link href='http://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
    
<!-- Estilos do Alertfy -->
<link rel="stylesheet" href="<c:url value="/resources/jquery/alertifyjs/alertify.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/jquery/alertifyjs/css/themes/default.min.css"/>" /> 
<script src="<c:url value="/resources/jquery/alertifyjs/alertify.min.js" />"></script>

<!-- Importação do arquivo Ajax -->
<script type="text/javascript" charset="utf-8"  src="<c:url value="/resources/jquery/ajax/ajax_livrosugerido.js" />"></script> 
    
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
            <c:import url="/resources/template/admin/menu.jsp"></c:import> 
        </header>

        <!-- BREADCRUMB 
        <ul class="breadcrumb">
          <li class="active">Home</li>
        </ul>-->
        
        <!-- CONTEÚDO -->
        <div class="row">
            <div role="main">
                <div class="col-md-8 col-md-offset-2">
                    <form action="pesquisaresultado" method="POST">
                    <div class="form-group">
                     
                <c:forEach items="${listalivros}" var="disciplina" >
                    <div class="panel panel-default ">
                      <div class="panel-heading">
                        <h3 class="panel-title text-center">${disciplina.nome_disciplina}</h3>
                      </div>
                    <c:forEach items="${disciplina.livros}" var="livro" >
                      <div class="panel-body">
                           <h5>${livro.titulo} -  ${livro.autor}</h5>
                                    <h5>${livro.local}</h5>
                                    <h5>Exemplares: ${livro.exemplares} Status: ${livro.status}</h5>
                      </div>
                     </c:forEach>
                    </div>  
                </c:forEach> 
                    
                    <div class="row">    
                        <div class="col-md-10">
                             <a href="pesquisa" class="btn btn-info btn-sm">
                                    <span class="glyphicon glyphicon-menu-left"></span>&nbsp;VOLTAR
                             </a>
                       </div>
                        
                        <div class="col-md-2">
                            <a class="btn btn-info btn-sm" href="javascript:window.print()">
                                    <span class="glyphicon glyphicon-print"></span>&nbsp;IMPRIMIR
                             </a>
                        </div>
                    </div>
                    
                    
                    
            </div>
        </div>  
    </div>
</div>
        <!-- RODAPÉ 
        <footer class="row">
            <c:import url="/resources/template/admin/rodape.jsp"></c:import> 
        </footer>--> 
    
        <!-- MODAL PARA RESETAR SENHA -->
        <c:import url="/resources/template/publico/resetarsenha.jsp"></c:import> 
        
    <!--FIM DIV CONTAINER-->
    </div>
</body>
</html>