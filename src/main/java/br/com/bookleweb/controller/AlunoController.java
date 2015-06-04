package br.com.bookleweb.controller;

/** Classe responsável por implementar Servlets Referentes ao ROLE_ALUNO.
 * 
 * @author Kelvin Santiago
 *
 */
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlunoController {

	/** Método Servlet para acessar a página home.jsp do aluno
	 * 
	 * @return String - Pagina /admin/home.jsp
	 */
	@RequestMapping(value = "/aluno")
	public String executeAluno(){
		return "/admin/home";
	}
	
	
}
