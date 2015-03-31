package br.com.bookleweb.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.dao.DisciplinaDAO;
import br.com.bookleweb.dao.LivroDAO;
import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;

@Controller
public class LivroController {

	private DisciplinaDAO disciplinaDAO;
	private LivroDAO livroDAO;
	
	// Construtor da classe com injecao de dependencia do Spring 
		@Autowired
		public LivroController(LivroDAO livroDAO, DisciplinaDAO disciplinaDAO) {
			this.disciplinaDAO = disciplinaDAO;
			this.livroDAO = livroDAO;
		}
		
		@RequestMapping(value = "/gerenciadorlivro")
		public ModelAndView executeLivro(){
			ModelAndView mv = new ModelAndView("/admin/gerenciadorlivro");
			mv.addObject("listalivros",livroDAO.getlistaTodosLivros());
			mv.addObject("listadisciplinas",disciplinaDAO.getTodasDisciplinas());
			return mv;
		}
		
		@RequestMapping(value= "/adicionalivro")
		public ModelAndView adicionaLivro(@ModelAttribute Livro livro, @ModelAttribute Disciplina disciplina, HttpServletRequest request){
			ModelAndView mv =  new ModelAndView("forward:/gerenciadorlivro");
			String[] itensDisciplina =  request.getParameterValues("listaescolhida");
			
			Disciplina disc;
			ArrayList<Disciplina> arrayDisc = new ArrayList<Disciplina>();
			
			if(itensDisciplina != null){
				for(int i = 0; i < itensDisciplina.length; i++){
					disc = new Disciplina();
					System.out.println("CODIGO DISC: "+Integer.parseInt(itensDisciplina[i]));
					disc.setCod_disciplina(Integer.parseInt(itensDisciplina[i]));
					arrayDisc.add(disc);
				}
			}
			livro.setDisciplinas(arrayDisc);
	        if (livroDAO.adiciona(livro)) {
				String mensagem = "Opa! Livro adicionado com Sucesso!";
				mv.addObject("sucesso",mensagem);
			}else{
				String mensagem = "Ixi! Erro ao cadastrar livro!";
				mv.addObject("erro",mensagem);	
			}
			return mv;
		}
		
		@RequestMapping(value= "/editalivro", method= RequestMethod.POST)
		public ModelAndView editaDisciplina(@ModelAttribute Livro livro, @ModelAttribute Disciplina disciplina){
			ModelAndView mv =  new ModelAndView("forward:/gerenciadorlivro");
			if(livroDAO.edita(livro,disciplina)){
				String mensagem = "Opa! Livro editado com Sucesso!";
				mv.addObject("sucesso",mensagem);
			}else{
				String mensagem = "Ixi! Erro ao editar livro!";
				mv.addObject("erro",mensagem);	
			}
			return mv;
		}
		
		@RequestMapping(value= "/removelivro", method= RequestMethod.POST)
		public ModelAndView removeDisciplina(@ModelAttribute Livro livro){
			ModelAndView mv =  new ModelAndView("forward:/gerenciadorlivro");
			livroDAO.remove(livro);
			return mv;
		}
		
		@RequestMapping(value= "/pesquisalivro", method= RequestMethod.POST)
		public ModelAndView pesquisaDisciplina(@ModelAttribute Livro livro, @RequestParam String opcaopesquisa){
			ModelAndView mv =  new ModelAndView("/admin/gerenciadorlivro");
			opcaopesquisa = opcaopesquisa.toLowerCase();
			if(opcaopesquisa.equals("isbn")){
				mv.addObject("listalivros",livroDAO.pesquisaPeloISBN(livro));
				mv.addObject("listadisciplinas",disciplinaDAO.getTodasDisciplinas());
				
			}
			else if(opcaopesquisa.equals("titulo")){
				mv.addObject("listalivros",livroDAO.pesquisaPeloTitulo(livro));
				mv.addObject("listadisciplinas",disciplinaDAO.getTodasDisciplinas());
			}
			return mv;
		}
		
	
	
}
