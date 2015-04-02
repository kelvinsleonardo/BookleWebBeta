$(function(){
    // Ocultando combobox
    $('select[name=cod_disciplina]').hide();
    $('button[name=btnpesquisar]').attr('disabled', 'disabled');
    $('select[name=cod_curso]').on('change',function(){
        var codigoDoCursoComboBox = $('select[name=cod_curso]').val();
		$.ajax({
			type: 'POST',
			url: 'relacaodisciplina',
			data: 'cod_curso=' +$('select[name=cod_curso]').val(),
			statusCode:{
				404: function(){
					alert("Erro 404 :o");
				},
				500: function(){
					alert("Erro no servidor");
				}
			},
			success: function(dados){
                $('select[name=cod_disciplina]').fadeIn(1000).show();
				$('select[name=cod_disciplina] option').remove();
				$('select[name=cod_disciplina]').append('<option value="-1">Selecione a disciplina</option>')
				var pegadados = dados.split(":");
				for(var i = 0; i < pegadados.length - 1; i++){
					var cod_disciplina = pegadados[i].split("-")[0];
					var nome_disciplina = pegadados[i].split("-")[1];
					$('select[name=cod_disciplina]').append('<option value="'+cod_disciplina+'">'+nome_disciplina+'</option>')
				}
			}
			
		});
	})
    
     $('select[name=cod_disciplina]').on('change',function(){
        var codigoDaDisciplinaComboBox = $('select[name=cod_disciplina]').val(); 
        if(codigoDaDisciplinaComboBox != -1){
            $('button[name=btnpesquisar]').removeAttr('disabled');
        }else{
            $('button[name=btnpesquisar]').attr('disabled', 'disabled');
        }
         console.log(codigoDaDisciplinaComboBox);
		
	})
     
});
