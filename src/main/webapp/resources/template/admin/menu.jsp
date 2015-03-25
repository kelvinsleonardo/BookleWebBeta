<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Spring Famework -->
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">BOOKLEWEB</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home 
            <span class="sr-only">(current)</span></a>
        </li>
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
              Pesquisar<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="pesquisalivro">Livros</a></li>
          </ul>
        </li>
          
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
              Gerenciar<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="gerenciadorcurso">Cursos</a></li>
            <li><a href="gerenciadordisciplina">Disciplinas</a></li>
            <li><a href="gerenciadorlivro">Livros</a></li>
            <li><a href="gerenciadorusuario">Usuários</a></li>
          </ul>
        </li>
      
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
              Relatórios<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="relatoriocurso">Cursos</a></li>
            <li><a href="relatoriodisciplina">Disciplinas</a></li>
            <li><a href="relatoriolivro">Livros</a></li>
            <li><a href="relatoriousuario">Usuários</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
          <li class="dropdown"> 
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                <span class="glyphicon glyphicon-user"></span>
                 ${nome_usuario_sessao}&nbsp;-&nbsp;               
                Matrícula: <%= SecurityContextHolder.getContext().getAuthentication().getName() %>
            <span class="caret"></span>
          </a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="alterarsenha">Alterar Senha</a></li>
            <li class="divider"></li>
            <li><a href="<c:url value="/j_spring_security_logout"/>">
                <span class="glyphicon glyphicon-off"></span> Logout
                </a>
              </li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>