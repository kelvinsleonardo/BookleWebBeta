<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Usuario</title>
</head>
<body>
	<h2>TELA PRINCIPAL - RULES ADMINISTRADOR</h2>
	
	
         Bem vindo(a) 
    <li><a href="gerenciausuario">Cadatrar Usuario</a></li>
    <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
  
    </br>
    Nome do usuario: <%= SecurityContextHolder.getContext().
							getAuthentication().getName() %>

</body>
</html>