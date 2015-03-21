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
      <a class="navbar-brand logo" href="#">BOOKLEWEB</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      

        <div class="navbar-text pull-right">
       
			<form action="j_spring_security_check" method="POST" class="form-inline" >
			  <div class="form-group">
			    <input type="text" name="j_username" class="form-control" placeholder="Usuario" value="${param.usuario}">
			  </div>
			  <div class="form-group">
			    <input type="password" name="j_password" class="form-control" placeholder="Senha" value="${param.senha}">
			  </div>
			  <button type="submit" class="btn btn-default">Entrar</button>
			</form>       

      </div>

    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>