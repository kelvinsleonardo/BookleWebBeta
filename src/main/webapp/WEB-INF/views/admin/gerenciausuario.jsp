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
    <center>
	<h2>Adicionar Usuario</h2>
	<form action="adicionausuario" method="post">
		<h3>Matrícula</h3>
		Matricula:<input type="text" name="matricula"></br>
        Nome:<input type="text" name="nome"></br>
		Senha: <input type="password" name="senha"></br>
        Tipo de usuario: <select name="permissao">
              <option value="ROLE_ADMIN">Admin</option>
              <option value="ROLE_PROFESSOR">Professor</option>
              <option value="ROLE_ALUNO">Aluno</option>
        </select></br>
		<input type="submit" value="Cadastrar"></br>
        <form:errors path="usuario.matricula"/></br>
        <form:errors path="usuario.senha"/></br>       
            ${erro}
            ${sucesso}
	</form>	
	</center>
	
</body>

</html>