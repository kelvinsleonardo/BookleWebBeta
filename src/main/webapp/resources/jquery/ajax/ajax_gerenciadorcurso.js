$(function(){
	/* EVENTO CLICAR NO BOTAO "EDITAR" CURSO
     * Após clicar no botão "Editar" da tabela, ele pega os campos e preenche uma tela modal com os dados 
     * daquela linha escolhida.
     */
    $('button[name=editarcurso]').click(function(){
        var codigoDoCurso = $(this).closest("tr").find("td[name=tb_cod_curso]").html(); // Pegando codigo do curso da tabela 
        var nomeDoCurso = $(this).closest("tr").find("td[name=tb_nome_curso]").html(); // Pegando nome do curso da tabela
        var descDoCurso = $(this).closest("tr").find("td[name=tb_descricao_curso]").html(); // Pegando descricao do curso da tabela
        $('#edit_cod_curso').val(codigoDoCurso); // Setando codigo do curso da tabela para modal editar curso
        $('#edit_nome_curso').val(nomeDoCurso); // Setando nome do curso da tabela para modal editar curso
        $('#edit_desc_curso').val(descDoCurso); // Setando descricao do curso da tabela para modal editar curso
	})
    
    /* EVENTO CLICAR NO BOTÃO "EXCLUIR" CURSO
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação "alert", caso true é chamado o servlet
     * para excluir aquele ID selecionado na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha
     * da tabela.
     */
    $('button[name=excluircurso]').click(function(){
        var codigoDoCurso = $(this).closest("tr").find("td[name=tb_cod_curso]").html(); // Pegando codigo do curso da tabela 
        var nomeDoCurso = $(this).closest("tr").find("td[name=tb_nome_curso]").html(); // Pegando nome do curso da tabela 
        var $this = $(this); // Pegando this do excluir curso
        alertify.confirm("EXCLUSÃO DO CURSO "+nomeDoCurso, "Você tem certeza que deseja remover o curso "+nomeDoCurso+" ?", "", "").
                    autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removecurso',
                        data: 'cod_curso='+codigoDoCurso,
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
                            alertify.success("Opa! Curso "+ nomeDoCurso+" removido com sucesso!"); // Mostra mensagem de excluido
                        }
                    });
            }// Fim IF   
        } );   
	})
    
    /* EVENTO CLICAR NO RADIO "CODIGO" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "CODIGO" é mostrado um input para inserir os dados e oculta o input nome.
     */
    $('#op_pesq_cod').on('change',function(){
        $('#search_nome_curso').hide();
        $('#search_nome_curso').val("");
        $('#search_cod_curso').show();
        
    })
    
        /* EVENTO CLICAR NO RADIO "NOME" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "NOME" é mostrado um input para inserir os dados e oculta o input codigo.
     */
    $('#op_pesq_nome').on('change',function(){
        $('#search_cod_curso').hide();
        $('#search_cod_curso').val("");
        $('#search_nome_curso').show();
    })
});
