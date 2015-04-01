package br.com.bookleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.dao.DisciplinaDAO;
import br.com.bookleweb.dao.LivroDAO;
import br.com.bookleweb.dao.RelationShipDisciplinaLivroDAO;
import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;


@Controller
public class RelationshipDisciplinaLivroController {
	
	private RelationShipDisciplinaLivroDAO relationShipDAO;
	private LivroDAO livroDAO;
	private DisciplinaDAO disciplinaDAO;
	
	@Autowired
	public RelationshipDisciplinaLivroController(RelationShipDisciplinaLivroDAO relationShipDAO, LivroDAO livroDAO, DisciplinaDAO disciplinaDAO) {
		this.relationShipDAO = relationShipDAO;
		this.livroDAO = livroDAO;
		this.disciplinaDAO = disciplinaDAO;
	}
	
	@RequestMapping(value = "/relationshipdisciplinacurso")
	public ModelAndView executeAdmin(){
		ModelAndView mv = new ModelAndView("/admin/gerenciadordisciplinalivro");
		mv.addObject("listalivros",livroDAO.getlistaTodosLivros());
		mv.addObject("listadisciplinas",disciplinaDAO.getTodasDisciplinas());
		return mv;
	}
	
	
	@RequestMapping (value = "/adicionaLivroNaDisciplina", method= RequestMethod.POST)
	public ModelAndView adicionaLivroNaDisciplina(@ModelAttribute Livro livro, @ModelAttribute Disciplina disciplina){
		ModelAndView mv =  new ModelAndView("forward:/relationshipdisciplinacurso");
	    
		if (relationShipDAO.adiciona(livro, disciplina)) {
				String mensagem = "Opa! Livro vinculado com Sucesso!";
				mv.addObject("sucesso",mensagem);
			}else{
				String mensagem = "Ixi! O Livro já está cadastrado para esta disciplina!";
				mv.addObject("erro",mensagem);	
			}

		return mv;
	}
	
	@RequestMapping(value= "/removeLivroDaDisciplina", method= RequestMethod.POST)
	public ModelAndView removeLivroDaDisciplina(@ModelAttribute Livro livro, @ModelAttribute Disciplina disciplina){
		
		ModelAndView mv =  new ModelAndView("forward:/relationshipdisciplinacurso");
	    
		if (relationShipDAO.remove(livro, disciplina)) {
				String mensagem = "Opa! Livro removido da disciplina com sucesso";
				mv.addObject("sucesso",mensagem);
			}else{
				String mensagem = "Ixi! Não foi possível remover o livro da disciplina!";
				mv.addObject("erro",mensagem);	
			}

		return mv;
	}

	@RequestMapping(value= "/procurarelationshipdisciplinalivro", method= RequestMethod.POST)
	public ModelAndView procuraNaRelacaoPeloCodigoDisciplina(@ModelAttribute Disciplina disciplina, @ModelAttribute Livro livro,@RequestParam String opcaopesquisa){
		ModelAndView mv =  new ModelAndView("/admin/gerenciadordisciplinalivro");
		opcaopesquisa = opcaopesquisa.toLowerCase();
		if(opcaopesquisa.equals("cod_disciplina")){
			mv.addObject("listalivros",relationShipDAO.procuraNaRelacaoPeloCodigoDaDisciplina(disciplina));
		}
		else if(opcaopesquisa.equals("isbn")){
			mv.addObject("listalivros",relationShipDAO.procuraNaRelacaoPeloISBN(livro));
		}
		return mv;
	}
	
	
}
