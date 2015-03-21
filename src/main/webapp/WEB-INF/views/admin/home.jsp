<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PT" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Usuario</title>
    
<!-- Estilos do Alertfy -->
<link rel="stylesheet" href="<c:url value="/resources/jquery/alertifyjs/alertify.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/jquery/alertifyjs/css/themes/default.min.css"/>" /> 
<script src="<c:url value="/resources/jquery/alertifyjs/alertify.min.js" />"></script>
</head>
<body>
	<h2>TELA PRINCIPAL - RULES ADMINISTRADOR</h2>
    <script>
        alertify.alert("", "Bem vindo ${nome_usuario_sessao}").set('OK!')
    </script>
        <h3>Bem vindo(a) ${nome_usuario_sessao} <a href="<c:url value="/j_spring_security_logout"/>">Logout</a> </h3>

    <li><a href="gerenciadorusuario">Gerenciar Usuarios</a></li>
    <li><a href="gerenciadorcurso">Gerenciar Cursos</a></li>
    <li><a href="gerenciadordisciplina">Gerenciar Disciplinas</a></li>
    <li><a href="gerenciadorlivro">Gerenciar Livros</a></li>
    
  
    </br>
    

</body>
</html>