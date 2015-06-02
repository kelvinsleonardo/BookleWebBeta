<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Import do Security Context -->    
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>  
<!-- Jquery Validator Form --> 
<script src="<c:url value="/resources/jquery/validator/jquery.validate.js" />"></script>
<script src="<c:url value="/resources/jquery/validator/views/gerenciadorusuario.js" />"></script>    
<!-- Modal -->
<div class="modal fade" id="modalNovaSenha" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4><strong>Alterar Senha</strong></h4>
      </div>
      <div class="modal-body">
        <form id="formusuario_alterasenha" action="alterasenhamenu" method="POST">
                <div class="panel-body">   
                    <input type="hidden" class="form-control" placeholder="Matricula" name="matricula" id="novasenha_matricula" value="<%= SecurityContextHolder.getContext().getAuthentication().getName() %>" readonly/>
                    <h5>Olá <strong>${nome_usuario_sessao}</strong> sua matrícula é <strong><%= SecurityContextHolder.getContext().getAuthentication().getName() %></strong>, se deseja alterar a senha desta conta, preencha os campos abaixo com a nova senha.</h5>
                    <br>
                    <div class="form-group">
                            <input type="password" class="form-control" placeholder="Nova senha" name="senha" id="novasenha_senha"/>
                    </div> 
                    
                    <div class="form-group">
                            <input type="password" class="form-control" placeholder="Confirme a nova senha" name="senhaconfirmacao" id="novasenha_senhaconfirmacao"/>
                    </div> 
                    
                </div>
            <div class="col-md-offset-7">
    
                <button type="submit" class="btn btn-sm btn-success" >
                    <strong> Salvar Nova Senha</strong>
                </button>
 

                 <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">
                     <strong> Cancelar</strong>
                 </button>

            </div>
        </form>
    </div>
    </div>
  </div>
</div>