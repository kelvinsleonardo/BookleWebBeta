<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BookleWeb 403</title>
    <!-- Importações de CSS com JSTL-->
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />
    <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-http">
                <h1 class="img-error-header">403</h1>
                <h1>IXI, VOCÊ NÃO TEM PRIVILÉGIOS PRA ISSO.</h1>
                <h5>Em outras palavras você está sem moral :(</h5>
                <br>
                <a class="btn btn-primary btn-sm" href="javascript:window.history.go(-1)">Voltar para a página anterior</a>
            </div>
        </div>
    </div>
</div>
    <!-- Javascript do bootstrap -->
    <script src="js/bootstrap.min.js"></script>
</html>