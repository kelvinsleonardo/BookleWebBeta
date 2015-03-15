package br.com.bookleweb.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminController {

	@RequestMapping(value = "/admin")
	public String executeAdmin(){
		return "/admin/home";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		 
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Olá " + user.getName() 
			+ ", você não tem permissão para acessar esta pagina!");
		} else {
			model.addObject("msg", 
			"Você não tem permissão para acessar essa pagina!");}
		model.setViewName("publico/403");
		return model;
	}
}
