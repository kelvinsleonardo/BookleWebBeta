<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//PT" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
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
                <form action="gerenciadordisciplina-do" method="POST">
                    <h3>Curso: </h3><select name="cod_curso">
                        <c:forEach items="${listacursos}" var="curso">		
                                    <option value="${curso.cod_curso}">${curso.nome_curso}</option>
                        </c:forEach> 
                    </select>
                    
                    <h3>Código Disciplina: </h3><input type="text" cal name="cod_disciplina">
                    <h3>Nome Disciplina: </h3><input type="text" value="" name="nome_disciplina">
                    <input type="submit" name="action" value="Adicionar">
                </form>
            </div>
        </div>
        
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
