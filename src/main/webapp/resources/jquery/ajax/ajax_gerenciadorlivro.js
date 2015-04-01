$(function(){
	/* EVENTO CLICAR NO BOTAO "EDITAR" LIVRO
     * Após clicar no botão "Editar" da tabela, ele pega os campos e preenche uma tela modal com os dados 
     * daquela linha escolhida.
     */
    $('button[name=editarlivro]').click(function(){
        var nomeDaDisciplina = $(this).closest("tr").find("td[name=tb_livro_disciplina]").html();
        var codigoDaDisciplina = $(this).closest("tr").find("td[name=tb_livro_disciplina]").attr('id');
        
        var isbn = $(this).closest("tr").find("td[name=tb_isbn]").html(); // Pegando codigo do curso da tabela 
        var tituloDoLivro = $(this).closest("tr").find("td[name=tb_titulo]").html(); // Pegando nome do curso da tabela
        var autorDoLivro = $(this).closest("tr").find("td[name=tb_autor]").html(); // Pegando descricao do curso da tabela
        var descDoLivro = $(this).closest("tr").find("td[name=tb_descricao]").html(); // Pegando descricao do curso da tabela
        var localDoLivro = $(this).closest("tr").find("td[name=tb_local]").html(); // Pegando descricao do curso da tabela
        var exemplaresLivro = $(this).closest("tr").find("td[name=tb_exemplares]").html(); // Pegando descricao do curso da tabela
        var statusLivro = $(this).closest("tr").find("td[name=tb_status]").html(); // Pegando descricao do curso da tabela
        $('#edit_nome_disciplina').val(codigoDaDisciplina); // Setando Curso referente a disciplina da tabela.
        $('#edit_isbn').val(isbn); // Setando codigo do curso da tabela para modal editar curso
        $('#edit_titulo').val(tituloDoLivro); // Setando nome do curso da tabela para modal editar curso
        $('#edit_autor').val(autorDoLivro); // Setando descricao do curso da tabela para modal editar curso
        $('#edit_desc_livro').val(descDoLivro); // Setando descricao do curso da tabela para modal editar curso
        $('#edit_local').val(localDoLivro); // Setando descricao do curso da tabela para modal editar curso
        $('#edit_exemplares').val(exemplaresLivro); // Setando descricao do curso da tabela para modal editar curso
        $('#edit_status').val(statusLivro); // Setando descricao do curso da tabela para modal editar curso
	})
    
    /* EVENTO CLICAR NO BOTÃO "EXCLUIR" LIVRO
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação "alert", caso true é chamado o servlet
     * para excluir aquele ID selecionado na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha
     * da tabela.
     */
    $('button[name=excluirlivro]').click(function(){
        var isbn = $(this).closest("tr").find("td[name=tb_isbn]").html(); // Pegando codigo da disciplina da tabela
        var codDisciplina = $(this).closest("tr").find("td[name=tb_livro_disciplina]").attr('id'); // Pegando codigo da disciplina da tabela 
        console.log(codDisciplina);
        var nomeDoLivro = $(this).closest("tr").find("td[name=tb_titulo]").html(); // Pegando nome da disciplina da tabela 
        var $this = $(this); // Pegando this do excluir a linha do livro
        alertify.confirm("EXCLUSÃO DO LIVRO "+nomeDoLivro, "Você tem certeza que deseja remover o livro "+nomeDoLivro+" ?", "", "").
                    autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removelivro',
                        data: 'isbn='+isbn,
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
                            alertify.success("Opa! Livro "+ nomeDoLivro+" removido com sucesso!"); // Mostra mensagem de excluido
                        }
                    });
            }// Fim IF   
        } );   
	})
    
    /* EVENTO CLICAR NO RADIO "CODIGO" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "CODIGO" é mostrado um input para inserir os dados e oculta o input nome.
     */
    $('#op_pesq_isbn').on('change',function(){
        $('#search_titulo').hide();
        $('#search_titulo').val("");
        $('#search_isbn').show();
    })
    
        /* EVENTO CLICAR NO RADIO "NOME" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "NOME" é mostrado um input para inserir os dados e oculta o input codigo.
     */
    $('#op_pesq_titulo').on('change',function(){
        $('#search_isbn').hide();
        $('#search_isbn').val("");
        $('#search_titulo').show();
    })
    
});
