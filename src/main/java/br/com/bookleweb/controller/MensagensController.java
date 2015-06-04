package br.com.bookleweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MensagensController {
	
	/** Servlet responsável por apresentar a página de erro 403
	 * 
	 * @return String - Redireciona para a página de erro 403
	 */
	@RequestMapping(value = "/403")
	public String accessDenied() {
		return "publico/errors/403";
	}
	
	/** Servlet responsável por apresentar a página de erro 404
	 * 
	 * @return String - Redireciona para a página de erro 404
	 */
	@RequestMapping(value = "/404")
	public String pageNotFound() {
		return "publico/errors/404";
	}
	
}
