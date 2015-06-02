$(document).ready( function() {
  $("#formlogin_cadastrar").validate({
    // Define as regras
    rules:{
      matricula:{
        required: true, minlength: 5, number: true
      },
      nome:{
        required: true
      },
      email:{
        required: true, email: true
      },
      senha:{
        required: true, minlength: 6  
      }
    },
    // Define as mensagens de erro para cada regra
    messages:{
      matricula:{
        required: "A matrícula é obrigatória",
        number: "A matrícula deve conter somente números",
        minlength: "A matrícula deve conter, no mínimo, 5 números"
      },
      nome:{
        required: "O nome é obrigatório"
      },
      email:{
        required: "O email é obrigatório",
        email: "Insira um email válido"
      },
      senha:{
        required: "A senha é obrigatória",
        minlength: "A senha deve conter, no mínimo, 6 caracteres"
      }
    }
  });
});