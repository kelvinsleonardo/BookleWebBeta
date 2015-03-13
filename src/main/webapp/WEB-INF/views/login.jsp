<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bookle Web Login</title>
</head>

<body>
	<h2>Executar Login</h2>
	<form action="Login">
		<h3>Matrícula</h3>
		<input type="text" name="matricula">
		<h3>Senha</h3>
		<input type="password" name="senha">
		<input type="submit" value="Login">
	</form>
	
	<h2>Adicionar Usuario</h2>
	<form action="AdicionaUsuario" method="post">
		<h3>Matrícula</h3>
		<input type="text" name="matricula">
		<h3>Senha</h3>
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
	<form action="ExcluiUsuario" method="post">
		<h3>Matrícula</h3>
		<input type="text" name="matricula">
		<input type="submit" value="Excluir">
	</form>	
	
	
</body>

</html>