package br.com.bookleweb.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlunoController {

	@RequestMapping(value = "/aluno")
	public String executeAluno(){
		return "/aluno/home";
	}
	
	
}
