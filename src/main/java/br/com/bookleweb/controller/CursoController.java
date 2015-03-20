package br.com.bookleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.bookleweb.dao.CursoDAO;
import br.com.bookleweb.modelo.Curso;

@Controller
public class CursoController {

	private CursoDAO cursoDAO;
	
	// Construtor da classe com injeção de dependencia do Spring 
	@Autowired
	public CursoController(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}
	
	@RequestMapping(value = "/gerenciadorcurso")
	public String executeCurso(){
		return "/admin/gerenciadorcurso";
	}
	
	@RequestMapping(value = "/gerenciadorcurso-do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Curso curso, @RequestParam String action){
		// Converte para LowerCase;
		action = action.toLowerCase();
		
		if(action.equals("adicionar")){
			cursoDAO.adiciona(curso);
		}
		
		return "/admin/gerenciadorcurso";
	}

	
	
}
