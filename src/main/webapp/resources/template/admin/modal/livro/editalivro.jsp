<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalEditaLivro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Editar Livro</h4>
      </div>
      <div class="modal-body">
        <form id="formlogin" action="editalivro" method="POST">
                <div class="panel-body">   
                    
                    <div class="form-group">
                        <select name="cod_disciplina" class="form-control" id="edit_nome_disciplina">
                            <c:forEach  var="disciplina" items="${listadisciplinas}">		
                                Selecione o curso: <option value="${disciplina.cod_disciplina}">${disciplina.nome_disciplina}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="isbn" id="edit_isbn" readonly/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="titulo" id="edit_titulo"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="autor" id="edit_autor"/>
                    </div> 
                    
                     <div class="form-group">
                            <textarea class="form-control" rows="5" name="desc_livro" id="edit_desc_livro"  ></textarea>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="local" id="edit_local"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="exemplares" id="edit_exemplares"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" name="status" id="edit_status"/>
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