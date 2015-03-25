<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Modal -->
<div class="modal fade" id="modalAdicionaCurso" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Adicionar Curso</h4>
      </div>
      <div class="modal-body">
        <form id="formlogin" action="adicionacurso" method="POST">
                <div class="panel-body">  
                    
                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Codigo" name="cod_curso" id="add_cod_curso"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nome" name="nome_curso" id="add_nome_curso"/>
                    </div>  
                    
                     <div class="form-group">
                            <textarea class="form-control" rows="5" placeholder="Descrição sobre o Curso" name="descricao_curso"
                                      id="add_desc_curso"></textarea>
                    </div>
                </div>
            <button class="btn btn-sm btn-info btn-block" type="submit" >Adicionar Novo</button>
        </form>
    </div>
    </div>
  </div>
</div>