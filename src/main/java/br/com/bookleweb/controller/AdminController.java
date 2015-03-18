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
	
	@RequestMapping(value = "/modelobootstrap")
	public String executeModeloBootstrap(){
		return "/admin/index";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {
		 
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Ixi! :o " + user.getName() 
			+ ", você não tem permissão para acessar esta pagina!");
		} else {
			model.addObject("msg", 
			"Você não tem permissão para acessar essa pagina!");}
		model.setViewName("publico/errors/403");
		return model;
	}
	
	@RequestMapping(value = "/404")
	public ModelAndView pageNotFound(Principal user) {
		 
		ModelAndView model = new ModelAndView();
		model.addObject("msg","Ixi! Égua seu coléga, não encontramos essa página!");
		model.setViewName("publico/errors/404");
		return model;
	}
	
}
