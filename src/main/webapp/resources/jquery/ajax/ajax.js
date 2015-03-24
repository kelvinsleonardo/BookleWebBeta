$(function(){
	$('button[name=editarcurso]').click(function(){
        var codigoDoCurso = $(this).closest("tr").find("td[name=tb_cod_curso]").html(); // Pegando codigo do curso da tabela 
        var nomeDoCurso = $(this).closest("tr").find("td[name=tb_nome_curso]").html(); // Pegando nome do curso da tabela
        var descDoCurso = $(this).closest("tr").find("td[name=tb_descricao_curso]").html(); // Pegando descricao do curso da tabela
        $('input[name=cod_curso]').val(codigoDoCurso); // Setando codigo do curso da tabela para modal editar curso
        $('input[name=nome_curso]').val(nomeDoCurso); // Setando nome do curso da tabela para modal editar curso
        $('textarea[name=descricao_curso]').val(descDoCurso); // Setando descricao do curso da tabela para modal editar curso
	})
    
    $('button[name=excluircurso]').click(function(){
        var codigoDoCurso = $(this).closest("tr").find("td[name=tb_cod_curso]").html(); // Pegando codigo do curso da tabela 
        var nomeDoCurso = $(this).closest("tr").find("td[name=tb_nome_curso]").html(); // Pegando nome do curso da tabela 
        alertify.confirm('a callback will be invoked on ok.').set('onok', function(closeEvent){ 
            if (closeEvent) {
                $.ajax({
                        type: 'POST',
                        url: 'removecurso',
                        data: 'cod_curso='+codigoDoCurso,
                        statusCode:{
                            404: function(){
                                alert("Pagina nao encontrada");
                            },
                            500: function(){
                                alert("Erro no servidor");
                            }
                        },
                        success: function(response){
                            alert("excluido"+response);
                        }

                    });
                
                
                
                
            }   
        } ); 
                 
        
	})
    
});
