<!-- Import java-->
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Import JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="modalAdicionaLivro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header text-center">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4>Adicionar Livro</h4>
      </div>
      <div class="modal-body">
        <form id="formlogin" action="adicionalivro" method="GET">
                <div class="panel-body">  
                    
                    <div class="form-group">
                        <!--
                        <select name="cod_disciplina" class="form-control">
                            <c:forEach items="${listadisciplinas}" var="disciplina" >		
                                Selecione o curso: <option value="${disciplina.cod_disciplina}">${disciplina.nome_disciplina}</option>
                            </c:forEach> 
                        </select>
                        -->
                    </div>
                    
                  
                    
                    <select name="listaescolhida" multiple class="form-control">                   
                        <c:forEach  var="disciplina" items="${listadisciplinas}">		
                           <option id="${disciplina.cod_disciplina}" value="${disciplina.cod_disciplina}">${disciplina.nome_disciplina}</option>
                        </c:forEach>
                    </select>
                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="ISBN" name="isbn" id="add_isbn"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Titulo" name="titulo" id="add_titulo"/>
                    </div>
                    
                    <div class="form-group">
                            <input type="text" class="form-control" placeholder="Autor" name="autor" id="add_autor"/>
                    </div> 
                    
                     <div class="form-group">
                        <textarea class="form-control" rows="5" placeholder="Descrição sobre o Livro" name="desc_livro"
                                      id="add_desc_livro"></textarea>
                    </div>
                
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Local" name="local" id="add_local"/>
                    </div>
                    
                    <div class="form-group">
                        <input type="number" class="form-control" placeholder="Exemplares" name="exemplares" id="add_exemplares"/>
                    </div>
                    
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Status" name="status" id="add_status"/>
                    </div>
                
                    
                </div>
            <button class="btn btn-sm btn-info btn-block" type="submit" >Adicionar Novo</button>
        </form>
    </div>
    </div>
  </div>
</div>