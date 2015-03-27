package br.com.bookleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.dao.CursoDAO;

@Controller
public class AdminController {

	private CursoDAO cursoDAO;
	
	@Autowired
	public AdminController(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}
	
	@RequestMapping(value = "/admin")
	public ModelAndView executeAdmin(){
		ModelAndView mv = new ModelAndView("/admin/home");
		mv.addObject("listacursos",cursoDAO.getlistaTodosCursos());
		return mv;		
	}
	
}
