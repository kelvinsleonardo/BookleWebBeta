$(function(){
    $('select[name=curso]').on('change',function(){
        var codigoDoCursoComboBox = $('select[name=curso]').val();
        console.log(codigoDoCursoComboBox);
		$.ajax({
			type: 'POST',
			url: 'relacaodisciplina',
			data: 'cod_curso=' +$('select[name=curso]').val(),
			statusCode:{
				404: function(){
					alert("Pagina nao encontrada Andar");
				},
				500: function(){
					alert("Erro no servidor");
				}
			},
			success: function(dados){
                console.log("Success Return Ajax");
				/*$('select[name=disciplina] option').remove(); // Limpa combobox Disciplina
				$('select[name=disciplina]').append('<option value="default">Selecione o apartamento</option>')
				var pegadados = dados.split(":");
				for(var i = 0; i < pegadados.length - 1; i++){
					var nomeapartamento = pegadados[i];
					$('select[name=apartamento]').append('<option value="'+nomeapartamento+'">'+nomeapartamento+'</option>')
				}*/
			}
			
		});
	})
     
});
