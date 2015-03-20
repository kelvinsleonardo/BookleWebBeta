package br.com.bookleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.bookleweb.dao.LivroDAO;
import br.com.bookleweb.modelo.Livro;

@Controller
public class LivroController {

	private LivroDAO livroDAO;
	
	// Construtor da classe com injeção de dependencia do Spring 
	@Autowired
	public LivroController(LivroDAO livroDAO) {
		this.livroDAO = livroDAO;
	}
	
	@RequestMapping(value = "/gerenciadorlivro")
	public String executeLivro(){
		return "/admin/gerenciadorlivro";
	}
	
	@RequestMapping(value = "/gerenciadorlivro-do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Livro livro, @RequestParam String action){
		// Converte para LowerCase;
		action = action.toLowerCase();
		
		if(action.equals("adicionar")){
			livroDAO.adiciona(livro);
		}
		
		return "/admin/gerenciadorlivro";
	}

	
	
}
