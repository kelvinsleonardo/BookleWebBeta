package br.com.bookleweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** Classe responsável por implementar Servlets Referentes ao ROLE_ADMIN.
 * 
 * @author Kelvin Santiago
 *
 */
@Controller
public class AdminController {

	/** Método Servlet para acessar a página home.jsp do admin
	 * 
	 * @return String - Pagina /admin/home.jsp
	 */
	@RequestMapping(value = "/admin")
	public String executeAdmin(){
		return "/admin/home";		
	}
	
}
