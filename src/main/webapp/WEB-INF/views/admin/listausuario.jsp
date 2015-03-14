<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Usuario</title>
</head>
<body>
    <form action="Home">
        <input type="submit" value="Voltar ao Home">
    </form>
	<form action="ListaUsuario">
	<h2>Dados Usuarios Login</h2>
	<input type="submit" value="Gerar Lista">
	<table>
			<tr>
				<th>Matricula</th>
				<th>Nome</th>
				<th>Senha</th>
			</tr>
	<c:forEach items="${usuarios}" var="user">		
			<tr>
				<td>${user.matricula}</td>
				<td>${user.nome}</td>
				<td>${user.senha}</td>
			</tr>
	</c:forEach>
	</table>
	</form>
</body>
</html>