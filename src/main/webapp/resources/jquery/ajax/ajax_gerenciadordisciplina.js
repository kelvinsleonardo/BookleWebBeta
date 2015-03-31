$(function(){
	/* EVENTO CLICAR NO BOTAO "EDITAR" DISCIPLINA
     * Após clicar no botão "Editar" da tabela, ele pega os campos e preenche uma tela modal com os dados 
     * daquela linha escolhida.
     */
    $('button[name=editardisciplina]').click(function(){
        var nomeDoCurso = $(this).closest("tr").find("td[name=tb_curso_disciplina]").html();
        var codigoDoCurso = $(this).closest("tr").find("td[name=tb_curso_disciplina]").attr('id');
        var codigoDaDisc = $(this).closest("tr").find("td[name=tb_cod_disciplina]").html(); // Pegando codigo do curso da tabela 
        var nomeDaDisc = $(this).closest("tr").find("td[name=tb_nome_disciplina]").html(); // Pegando nome do curso da tabela
        var descDaDisc = $(this).closest("tr").find("td[name=tb_desc_disciplina]").html(); // Pegando descricao do curso da tabela
        $('#edit_nome_curso').val(codigoDoCurso); // Setando Curso referente a disciplina da tabela.
        $('#edit_cod_disciplina').val(codigoDaDisc); // Setando codigo do curso da tabela para modal editar curso
        $('#edit_nome_disciplina').val(nomeDaDisc); // Setando nome do curso da tabela para modal editar curso
        $('#edit_desc_disciplina').val(descDaDisc); // Setando descricao do curso da tabela para modal editar curso
	})
    
    /* EVENTO CLICAR NO BOTÃO "EXCLUIR" CURSO
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação "alert", caso true é chamado o servlet
     * para excluir aquele ID selecionado na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha
     * da tabela.
     */
    $('button[name=excluirdisciplina]').click(function(){
        var codigoDaDisc = $(this).closest("tr").find("td[name=tb_cod_disciplina]").html(); // Pegando codigo da disciplina da tabela 
        var nomeDaDisc = $(this).closest("tr").find("td[name=tb_nome_disciplina]").html(); // Pegando nome da disciplina da tabela 
        var $this = $(this); // Pegando this do excluir a linah da disciplina
        alertify.confirm("EXCLUSÃO DA DISCIPLINA "+nomeDaDisc, "Você tem certeza que deseja remover o curso "+nomeDaDisc+" ?", "", "").
                    autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removedisciplina',
                        data: 'cod_disciplina='+codigoDaDisc,
                        statusCode:{
                            404: function(){
                                alert("/404");
                            },
                            500: function(){
                                alert("Erro no servidor");
                            }
                        },
                        success: function(response){
                            $this.closest('tr').remove(); //Remove linha do curso excluido 
                            alertify.success("Opa! Disciplina "+ nomeDaDisc+" removida com sucesso!"); // Mostra mensagem de excluido
                        }
                    });
            }// Fim IF   
        } );   
	})
    
    /* EVENTO CLICAR NO RADIO "CODIGO" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "CODIGO" é mostrado um input para inserir os dados e oculta o input nome.
     */
    $('#op_pesq_cod').on('change',function(){
        $('#search_nome_disciplina').hide();
        $('#search_nome_disciplina').val("");
        $('#search_cod_disciplina').show();
        
    })
    
        /* EVENTO CLICAR NO RADIO "NOME" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "NOME" é mostrado um input para inserir os dados e oculta o input codigo.
     */
    $('#op_pesq_nome').on('change',function(){
        $('#search_cod_disciplina').hide();
        $('#search_cod_disciplina').val("");
        $('#search_nome_disciplina').show();
    })
    
});
