<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Bookle Web</title>
</head>
<body>

<center>
        </br>
        <h2>Login Bookle Web</h2>
        <h5>Insira seus dados de login</h5>
		<form action="ValidaAutenticacao" method="post">
			Matrícula: <input type="text" name="matricula">
            Senha:     <input type="password" name="senha">
                       <input type="submit" value="Entrar"></br>
                       <form:errors path="usuario.matricula"/>
		</form>
</center>

</body>
</html>