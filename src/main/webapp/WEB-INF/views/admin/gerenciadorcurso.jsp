<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PT" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modelo GRID BookleWeb</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/estilo.css" />" />
    
</head>
<body class="background-login">
    <div class="container-fluid">
        
        <!-- CABEÇALHO -->
        <header class="row">
            <c:import url="/resources/template/publico/menu.jsp"></c:import> 
        </header>

        <!-- CONTEÚDO -->
        <div class="row">
            <div role="main">
                <form action="gerenciadorcurso-do" method="POST">
                    <h3>Código Curso: </h3><input type="text" cal name="cod_curso">
                    <h3>Nome Curso: </h3><input type="text" value="" name="nome_curso">
                    <input type="submit" name="action" value="Adicionar">
                    
                </form>
            </div>
        </div>
        
        <table class="table table-bordered">
        <thead>
          <tr>
            <th>Codigo do Curso</th>
            <th>Nome do Curso</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${listacursos}" var="curso">		
            <tr>
                <td>${curso.cod_curso}</td>
                <td>${curso.nome_curso}</td>
                <td><input type="submit" name="action" value="Remover"/>Remover</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
        
        <!-- RODAPÉ 
        <footer class="row">
         
        </footer>-->
    
    <!--FIM DIV CONTAINER-->
    </div>

    <!-- Javascript do bootstrap -->
    <script src="resources/js/jquery-1.11.2.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</body>
    
</html>
