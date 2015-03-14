<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bookle Web Login</title>
</head>

<body>
	<h2>Valida Usuario</h2>
	<form action="ValidaUsuario">
		<h3>Matrícula</h3>
		<input type="text" name="matricula">
		<h3>Senha</h3>
		<input type="password" name="senha">
		<input type="submit" value="Validar">
	</form>
	
	<h2>Adicionar Usuario</h2>
	<form action="AdicionaUsuario" method="post">
		<h3>Matrícula</h3>
		<form:errors path="usuario.matricula"/>
		<input type="text" name="matricula">
		<h3>Senha</h3>
		<form:errors path="usuario.senha"/>
		<input type="password" name="senha">
		<input type="submit" value="Cadastrar">
	</form>

	<h2>Buscar Usuario</h2>
	<form action="BuscaUsuario" method="post">
		<h3>Matrícula</h3>
		<input type="text" name="matricula">
		<input type="submit" value="Buscar">
	</form>	

	<h2>Excluir Usuario</h2>
	<form action="RemoveUsuario" method="post">
		<h3>Matrícula</h3>
		<input type="text" name="matricula">
		<input type="submit" value="Excluir">
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