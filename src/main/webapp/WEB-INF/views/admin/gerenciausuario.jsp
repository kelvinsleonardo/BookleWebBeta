<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="br.com.bookleweb.modelo.Usuario" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bookle Web Login</title>
</head>

<body>
    <center>
	<h2>Adicionar Usuario</h2>
	<form action="adicionausuario.action" method="post">
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
        <a href="javascript:;" onclick="removeusuario.action">removeuser</a>
            <font color='red'>${param.erro}</font>
            <font color='blue'>${param.sucesso}</font>
    </form>
    </center>
    
    <%
       Usuario user = (Usuario)request.getAttribute("usuario");
       %>
    
    
    <form action="gerenciausuario.do" method="POST" commandName="student">
	<table>
		<tr>
			<td>Matricula</td>
			<td><input name="matricula" value=""/></td>
		</tr>
		<tr>
			<td>Nome Completo</td>
			<td><input name="nome" /></td>
		</tr>
		<tr>
			<td>Senha</td>
			<td><input name="senha" /></td>
		</tr>
		<tr>
			<td>Permissão</td>
			<td>
                <select name="permissao">
                      <option value="ROLE_ADMIN">Admin</option>
                      <option value="ROLE_PROFESSOR">Professor</option>
                      <option value="ROLE_ALUNO">Aluno</option>
                </select></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Adicionar" />
				<input type="submit" name="action" value="Remover" />
				<input type="submit" name="action" value="Editar" />
				<input type="submit" name="action" value="Procurar" />
			</td>
		</tr>
	</table>
</form>
    
    

	
</body>

</html>