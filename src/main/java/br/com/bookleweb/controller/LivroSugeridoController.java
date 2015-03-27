package br.com.bookleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.dao.DisciplinaDAO;
import br.com.bookleweb.modelo.Curso;

@Controller
public class LivroSugeridoController {

	private DisciplinaDAO disciplinaDAO;
	
	@Autowired
	public LivroSugeridoController(DisciplinaDAO disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
	}

	@RequestMapping(value= "/relacaodisciplina", method= RequestMethod.POST)
	public ModelAndView pesquisaCurso(@ModelAttribute Curso curso){
		ModelAndView mv =  new ModelAndView("/admin/home");
		mv.addObject("listadisciplinas",disciplinaDAO.pesquisaPeloCodigoCurso(curso));
		return mv;
	}
	
}
