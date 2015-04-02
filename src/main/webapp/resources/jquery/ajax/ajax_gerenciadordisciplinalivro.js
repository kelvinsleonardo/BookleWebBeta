$(function(){
    /* EVENTO CLICAR NO BOTÃO "EXCLUIR" LIVRO
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação "alert", caso true é chamado o servlet
     * para excluir aquele ID selecionado na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha
     * da tabela.
     */
    $('button[name=excluirlivrodadisciplina]').click(function(){
        var isbn = $(this).closest("tr").find("td[name=tb_isbn]").html(); // Pegando codigo da disciplina da tabela
        var codDisciplina = $(this).closest("tr").find("td[name=tb_cod_disciplina]").html(); // Pegando codigo da disciplina da tabela 
        var nomeDoLivro = $(this).closest("tr").find("td[name=tb_titulo]").html(); // Pegando nome da disciplina da tabela 
        var nomeDaDisciplina = $(this).closest("tr").find("td[name=tb_nome_disciplina]").html(); // Pegando nome da disciplina da tabela 
        var $this = $(this); // Pegando this do excluir a linha do livro
        alertify.confirm("EXCLUSÃO DO LIVRO "+nomeDoLivro, "Você tem certeza que deseja remover o livro "+nomeDoLivro+" da disciplina "+nomeDaDisciplina+" ?", "", "").
                    autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removeLivroDaDisciplina',
                        data: {isbn:isbn,cod_disciplina:codDisciplina},
                        statusCode:{
                            404: function(){
                                alert("Erro 404");
                            },
                            500: function(){
                                alert("Erro no servidor");
                            }
                        },
                        success: function(response){
                            $this.closest('tr').remove(); //Remove linha do curso excluido 
                            alertify.success("Opa! Livro "+ nomeDoLivro+" foi removido da disciplina "+nomeDaDisciplina+" com sucesso!"); // Mostra mensagem de excluido
                        }
                    });
            }// Fim IF   
        } );   
	})
    
    /* EVENTO CLICAR NO RADIO "CODIGO" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "CODIGO" é mostrado um input para inserir os dados e oculta o input nome.
     */
    $('#op_pesq_isbn').on('change',function(){
        $('#search_cod_disciplina').hide();
        $('#search_cod_disciplina').val("");
        $('#search_isbn').show();
    })
    
        /* EVENTO CLICAR NO RADIO "NOME" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "NOME" é mostrado um input para inserir os dados e oculta o input codigo.
     */
    $('#op_pesq_cod_disciplina').on('change',function(){
        $('#search_isbn').hide();
        $('#search_isbn').val("");
        $('#search_cod_disciplina').show();
    })
    
});