<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Dados Usuarios</h2>
	<table>
	<c:forEach items="${usuarios}" var="user">
			<tr>
				<td>${user.matricula}</td>
				<td>${user.nome}</td>
				<td>${user.senha}</td>
			</tr>
	</c:forEach>
	</table>

</body>
</html>