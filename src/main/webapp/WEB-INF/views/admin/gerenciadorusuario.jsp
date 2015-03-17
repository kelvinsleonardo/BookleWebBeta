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
<form action="gerenciadorusuario-do" method="POST">
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
				<input type="submit" name="action" value="Listar" />
                <a type="button" href="gerenciadorusuario-do?action=Remover&matricula=${user.matricula}">
			</td>
		</tr>
	</table>
</form>
    
    <font color='red'>${erro}</font>
    <font color='blue'>${sucesso}</font>

    
<form action="gerenciadorusuario-do" method="POST">
    <table border="1">
        <tr>
            <th>Matricula</th>
            <th>Nome</th>
            <th>Senha</th>
            <th>Permissão</th>
        </tr>
        <tr></tr>
            <tr>
                <c:forEach items="${listausuarios}" var="user">		
                    <tr>
                        <td>${user.matricula}</td><input type="hidden" name="matricula" value="${user.matricula}"/>
                        <td>${user.nome}</td>
                        <td>${user.senha}</td>
                        <td>${user.permissao}</td>
                        <td><input type="submit" name="action" value="Remover" /></td>
                        <!--<td><a href="gerenciadorusuario-do?action=Remover&matricula=${user.matricula}">Remover por Href</a></td>-->
                    </tr>
               </c:forEach>  
            </tr>
    </table>
</form>    
    
	
</body>

</html>