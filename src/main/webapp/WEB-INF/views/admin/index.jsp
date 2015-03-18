<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modelo GRID BookleWeb</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">    
</head>
<body>
    
    <!-- Container Geral da página -->
    <div class"container-fluid">
        
        <!-- Div Cabeçalho -->
        <header class="row" >
            <div class="col-md-12" style="background-color:#3217E3">
                <h1>Cabeçalhos</h1>
            </div>
        </header>

        <!-- Div Conteúdo -->
        <div class="row">
            <div class="col-md-8" style="background-color:#2179C2">
                <h1>Conteúdo</h1>
            </div>
            
            <div class="col-md-4" style="background-color:#BF3037">
                <h1>Sidebar</h1>
            </div>
        </div>

        <!-- Div Rodapé -->
        <footer class="row">
            <div class="col-md-12" style="background-color:#073E6B">
                <h1>Rodapé</h1>
            </div>
        </footer>
    </div>

    <!-- Javascript do bootstrap -->
    <script src="js/bootstrap.min.js"></script>
</body>
    
</html>