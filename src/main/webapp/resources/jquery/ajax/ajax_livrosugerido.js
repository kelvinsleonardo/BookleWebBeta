$(function(){
    // Ocultando combobox
    $('select[name=disciplina]').hide();
    $('select[name=livro]').hide();
    $('select[name=curso]').on('change',function(){
        var codigoDoCursoComboBox = $('select[name=curso]').val();
		$.ajax({
			type: 'POST',
			url: 'relacaodisciplina',
			data: 'cod_curso=' +$('select[name=curso]').val(),
			statusCode:{
				404: function(){
					alert("Erro 404 :o");
				},
				500: function(){
					alert("Erro no servidor");
				}
			},
			success: function(dados){
                $('select[name=disciplina]').fadeIn(1000).show();
				$('select[name=disciplina] option').remove();
                $('select[name=livro] option').remove();// Limpa combobox Disciplina
				$('select[name=disciplina]').append('<option value="-1">Selecione a disciplina</option>')
				$('select[name=livro]').append('<option value="-1">Selecione o livro</option>')
				var pegadados = dados.split(":");
				for(var i = 0; i < pegadados.length - 1; i++){
					var cod_disciplina = pegadados[i].split("-")[0];
					var nome_disciplina = pegadados[i].split("-")[1];
					$('select[name=disciplina]').append('<option value="'+cod_disciplina+'">'+nome_disciplina+'</option>')
				}
			}
			
		});
	})
    
     $('select[name=disciplina]').on('change',function(){
        var codigoDaDisciplinaComboBox = $('select[name=disciplina]').val();
		$.ajax({
			type: 'POST',
			url: 'relacaolivro',
			data: 'cod_disciplina=' +$('select[name=disciplina]').val(),
			statusCode:{
				404: function(){
					alert("Erro 404");
				},
				500: function(){
					alert("Erro no servidor");
				}
			},
			success: function(dados){
                $('select[name=livro]').fadeIn(1000).show();
				$('select[name=livro] option').remove(); // Limpa combobox Disciplina
				$('select[name=livro]').append('<option value="-1">Selecione o livro</option>')
				var pegadados = dados.split(":");
                for(var i = 0; i < pegadados.length - 1; i++){
					var isbn = pegadados[i].split("-")[0];
					var titulo = pegadados[i].split("-")[1];
                    
					$('select[name=livro]').append('<option value="'+isbn+'">'+titulo+'</option>')
				}
			}
			
		});
	})
     
});
