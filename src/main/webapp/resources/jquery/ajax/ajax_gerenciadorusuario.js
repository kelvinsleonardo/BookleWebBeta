$(function(){
	/* EVENTO CLICAR NO BOTAO "EDITAR" USUARIO
     * Após clicar no botão "Editar" da tabela, ele pega os campos e preenche uma tela modal com os dados 
     * daquela linha escolhida.
     */
    $('button[name=editarusuario]').click(function(){
        var nomeGrupoPermissao = $(this).closest("tr").find("td[name=tb_permissao]").html();
        var codigoPermissao = $(this).closest("tr").find("td[name=tb_permissao]").attr('id');
        console.log(codigoPermissao);
        var matricula = $(this).closest("tr").find("td[name=tb_matricula]").html(); // Pegando codigo do curso da tabela 
        var nome = $(this).closest("tr").find("td[name=tb_nome]").html(); // Pegando nome do curso da tabela
        var email = $(this).closest("tr").find("td[name=tb_email]").html(); // Pegando descricao do curso da tabela
        var senha = $(this).closest("tr").find("td[name=tb_senha]").html(); // Pegando descricao do curso da tabela
        $('#edit_permissao').val(codigoPermissao); // Setando Curso referente a disciplina da tabela.
        $('#edit_matricula').val(matricula); // Setando codigo do curso da tabela para modal editar curso
        $('#edit_nome').val(nome); // Setando nome do curso da tabela para modal editar curso
        $('#edit_email').val(email); // Setando descricao do curso da tabela para modal editar curso
	})
    
    $('button[name=novasenha]').click(function(){
        var matricula = $(this).closest("tr").find("td[name=tb_matricula]").html();
        var nome = $(this).closest("tr").find("td[name=tb_nome]").html();
        console.log(nome);
        $('#novasenha_matricula').val(matricula); 
        $('#novasenha_nome').val(nome); 
	})
    
    /* EVENTO CLICAR NO BOTÃO "EXCLUIR" CURSO
     * Após clicar no botão "Excluir" da tabela, é mostrado uma tela de confirmação "alert", caso true é chamado o servlet
     * para excluir aquele ID selecionado na tabela, após a exclusão do dado é mostrado uma tela de sucesso, e remove a linha
     * da tabela.
     */
    $('button[name=excluirusuario]').click(function(){
        var matricula = $(this).closest("tr").find("td[name=tb_matricula]").html(); // Pegando codigo da disciplina da tabela 
        var nome = $(this).closest("tr").find("td[name=tb_nome]").html(); // Pegando nome da disciplina da tabela 
        var $this = $(this); // Pegando this do excluir a linah da disciplina
        alertify.confirm("EXCLUSÃO DO USUARIO "+nome, "Você tem certeza que deseja remover o usuario "+nome+" ?", "", "").
                    autoCancel(10).set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removeusuario',
                        data: 'matricula='+matricula,
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
                            alertify.success("Opa! Usuario "+ nome+" removido com sucesso!"); // Mostra mensagem de excluido
                        }
                    });
            }// Fim IF   
        } );   
	})
    
    /* EVENTO CLICAR NO RADIO "CODIGO" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "CODIGO" é mostrado um input para inserir os dados e oculta o input nome.
     */
    $('#op_pesq_matricula').on('change',function(){
        $('#search_nome').hide();
        $('#search_nome').val("");
        $('#search_matricula').show();
        
    })
    
        /* EVENTO CLICAR NO RADIO "NOME" CURSO DE FILTRO DE PESQUISA
     * Após clicar no radio "NOME" é mostrado um input para inserir os dados e oculta o input codigo.
     */
    $('#op_pesq_nome').on('change',function(){
        $('#search_matricula').hide();
        $('#search_matricula').val("");
        $('#search_nome').show();
    })
    
});
