<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">
            <a class="logo" href="#">BOOKLEWEB</a>
        </h4>
      </div>
      <div class="modal-body">
        <form id="formlogin" action="<c:url value='/resetarsenha' />" method="POST">
                    <div class="panel-body">
                        <label class="text-center">Olá, se você já cadastrou sua conta em nosso sistema, e precisa efetuar a alteração de senha, informe seus dados de matrícula e email que logo enviaremos sua senha no email informado.
                        </label>  
                    <form class="form form-signup" role="form">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-certificate"></span>
                            </span>
                            <input type="text" class="form-control" placeholder="Matrícula" name="matricula"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                         <span class="input-group-addon">
                             <span class="glyphicon glyphicon-envelope"></span>
                            </span>
                            <input type="text" class="form-control" placeholder="Email" name="email"/>
                        </div>
                    </div>    
                
            <button class="btn btn-sm btn-success btn-block" type="submit" >Enviar Solicitação</button>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
</div>