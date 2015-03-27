<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalEditaDisciplina" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Editar Disciplina</h4>
      </div>
      <div class="modal-body">
        <form id="formlogin" action="editadisciplina" method="POST">
                <div class="panel-body">   
                    
                    <div class="form-group">
                        <select name="cod_curso" class="form-control" id="edit_nome_curso">
                            <c:forEach  var="curso" items="${listacursos}">		
                                Selecione o curso: <option value="${curso.cod_curso}">${curso.nome_curso}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="cod_disciplina" id="edit_cod_disciplina" readonly/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="nome_disciplina" id="edit_nome_disciplina"/>
                    </div>  
                    
                </div>
            <div class="col-md-offset-9">
    
                   <button type="submit" class="btn btn-sm btn-success" >Editar</button>
 

                   <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">Cancelar</button>

            </div>
        </form>
    </div>
    </div>
  </div>
</div>