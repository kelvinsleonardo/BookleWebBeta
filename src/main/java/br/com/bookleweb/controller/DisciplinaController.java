package br.com.bookleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.dao.CursoDAO;
import br.com.bookleweb.dao.DisciplinaDAO;
import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;

@Controller
public class DisciplinaController {

	private DisciplinaDAO disciplinaDAO;
	
	// Construtor da classe com injeção de dependencia do Spring 
	@Autowired
	public DisciplinaController(DisciplinaDAO disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
	}
	
	@RequestMapping(value = "/gerenciadordisciplina")
	public ModelAndView executeDisciplina(){
		CursoDAO cursoDAO = new CursoDAO();
		ModelAndView mv = new ModelAndView("/admin/gerenciadordisciplina");
		mv.addObject("listacursos",cursoDAO.getlistaTodosCursos());
		return mv;
	}
	
	@RequestMapping(value = "/gerenciadordisciplina-do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Disciplina disciplina, @ModelAttribute Curso curso,@RequestParam String action){
		// Converte para LowerCase;
		action = action.toLowerCase();
		if(action.equals("adicionar")){
			disciplinaDAO.adiciona(disciplina);
		}
		
		return "redirect:/gerenciadordisciplina";
	}

	
	
}
