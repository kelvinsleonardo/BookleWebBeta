<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalAdicionaDisciplina" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Adicionar Disciplina</h4>
      </div>
      <div class="modal-body">
        <form id="formlogin" action="adicionadisciplina" method="POST">
                <div class="panel-body">  
                    
                    <div class="form-group">
                        
                        <select name="cod_curso" class="form-control">
                            <c:forEach items="${listacursos}" var="curso" >		
                                Selecione o curso: <option value="${curso.cod_curso}">${curso.nome_curso}</option>
                            </c:forEach> 
                        </select>
                        
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Codigo" name="cod_disciplina" id="add_cod_disciplina"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nome" name="nome_disciplina" id="add_nome_disciplina"/>
                    </div>  
                    
                     <div class="form-group">
                            <textarea class="form-control" rows="5" placeholder="Descrição sobre a Disciplina" name="desc_disciplina"
                                      id="add_desc_disciplina"></textarea>
                    </div>
                </div>
            <button class="btn btn-sm btn-info btn-block" type="submit" >Adicionar Novo</button>
        </form>
    </div>
    </div>
  </div>
</div>