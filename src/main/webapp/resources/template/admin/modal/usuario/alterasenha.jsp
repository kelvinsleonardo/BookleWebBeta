<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalNovaSenha" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Altera senha Usuario</h4>
      </div>
      <div class="modal-body">
        <form id="formlogin" action="alterasenha" method="POST">
                <div class="panel-body">   
                    
                    <div class="form-group">
                            <input type="number" class="form-control" placeholder="Matricula" name="matricula" id="edit_matricula" readonly/>
                    </div>
                    
                     <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nome" name="nome" id="edit_nome" readonly/>
                    </div>
                    
                     <div class="form-group">
                            <input type="password" class="form-control" placeholder="Senha Antiga" name="senha" id="edit_senha"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="password" class="form-control" placeholder="Senha Nova" name="senha" id="edit_senha"/>
                    </div> 
                    
                    <div class="form-group">
                            <input type="password" class="form-control" placeholder="Repita a Senha" name="senha" id="edit_senha"/>
                    </div> 
                    
                </div>
            <div class="col-md-offset-9">
    
                   <button type="submit" class="btn btn-sm btn-success" >Criar</button>
 

                   <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">Cancelar</button>

            </div>
        </form>
    </div>
    </div>
  </div>
</div>