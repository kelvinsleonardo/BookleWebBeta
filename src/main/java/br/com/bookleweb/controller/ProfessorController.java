package br.com.bookleweb.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

	@RequestMapping(value = "/professor")
	public String executeProfessor(){
		return "/professor/home";
	}
	
	
}
