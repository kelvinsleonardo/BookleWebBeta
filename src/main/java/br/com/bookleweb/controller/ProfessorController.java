package br.com.bookleweb.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

/** Classe responsável por implementar Servlets Referentes ao ROLE_PROFESSOR.
 * 
 * @author Kelvin Santiago
 *
 */

@Controller
public class ProfessorController {

	/** 
	 * Método Servlet para acessar a página home.jsp do professor
	 * @return String - Pagina /admin/home.jsp
	 */
	@RequestMapping(value = "/professor")
	public String executeProfessor(){
		return "/admin/home";
	}
	
	
}
