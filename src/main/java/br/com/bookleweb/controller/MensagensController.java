package br.com.bookleweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MensagensController {

	@RequestMapping(value = "/modelobootstrap")
	public String executeModeloBootstrap(){
		return "/admin/index";
	}
	
	@RequestMapping(value = "/403")
	public String accessDenied() {
		return "publico/errors/403";
	}
	
	@RequestMapping(value = "/404")
	public String pageNotFound() {
		return "publico/errors/404";
	}
	
}
