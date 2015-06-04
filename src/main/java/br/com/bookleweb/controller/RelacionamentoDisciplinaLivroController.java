package br.com.bookleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.dao.DisciplinaDAO;
import br.com.bookleweb.dao.LivroDAO;
import br.com.bookleweb.dao.RelacionamentoDisciplinaLivroDAO;
import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;

/**
 * Classe responsável por implementar Servlets de controle do relacionamento
 * livro com disciplina.
 * 
 * @author Kélvin Santiago
 *
 */

@Controller
public class RelacionamentoDisciplinaLivroController {
	
	private RelacionamentoDisciplinaLivroDAO relacionamentoDAO;
	private LivroDAO livroDAO;
	private DisciplinaDAO disciplinaDAO;
	
	/**
	 * Construtor da Classe aplicando injeção de dependencia do Spring MVC
	 * 
	 * @param relacionamentoDAO
	 * @param livroDAO
	 * @param disciplinaDAO
	 */
	@Autowired
	public RelacionamentoDisciplinaLivroController(RelacionamentoDisciplinaLivroDAO relacionamentoDAO, LivroDAO livroDAO, DisciplinaDAO disciplinaDAO) {
		this.relacionamentoDAO = relacionamentoDAO;
		this.livroDAO = livroDAO;
		this.disciplinaDAO = disciplinaDAO;
	}
	
	/**
	 * Método Servlet responsável por permitir acesso a página do gerenciador da
	 * de vínculo livro com disciplina.
	 * 
	 * @return ModelAndView - Lista de livros e Disciplinas
	 */
	@RequestMapping(value = "/relationshipdisciplinacurso")
	public ModelAndView executeAdmin(){
		ModelAndView mv = new ModelAndView("/admin/gerenciadordisciplinalivro");
		mv.addObject("listalivros",livroDAO.getlistaTodosLivros());
		mv.addObject("listadisciplinas",disciplinaDAO.getTodasDisciplinas());
		return mv;
	}
	
	/**
	 * Método Servlet responsável por controlar o adicionar vínculo livro a disicplina.
	 * 
	 * @param livro - Model livro.
	 *   
	 * @param disciplina - Model disciplina.     
	 *            
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping (value = "/adicionaLivroNaDisciplina", method= RequestMethod.POST)
	public ModelAndView adicionaLivroNaDisciplina(@ModelAttribute Livro livro, @ModelAttribute Disciplina disciplina){
		ModelAndView mv =  new ModelAndView("forward:/relationshipdisciplinacurso");
	    
		if (relacionamentoDAO.adiciona(livro, disciplina)) {
				String mensagem = "Opa! Livro vinculado com Sucesso!";
				mv.addObject("sucesso",mensagem);
			}else{
				String mensagem = "Ixi! O Livro já está cadastrado para esta disciplina!";
				mv.addObject("erro",mensagem);	
			}

		return mv;
	}
	
	/**
	 * Método Servlet responsável por controlar o remover vinculo do livro
	 * com a disciplina.
	 * 
	 * @param livro - Modelo livro
	 * 
	 * @param disciplina - Modelo disciplina
	 *            
	 * @return ModelAndView - Somente redireciona.
	 */
	@RequestMapping(value= "/removeLivroDaDisciplina", method= RequestMethod.POST)
	public ModelAndView removeLivroDaDisciplina(@ModelAttribute Livro livro, @ModelAttribute Disciplina disciplina){
		
		ModelAndView mv =  new ModelAndView("forward:/relationshipdisciplinacurso");
	    
		if (relacionamentoDAO.remove(livro, disciplina)) {
				String mensagem = "Opa! Livro removido da disciplina com sucesso";
				mv.addObject("sucesso",mensagem);
			}else{
				String mensagem = "Ixi! Não foi possível remover o livro da disciplina!";
				mv.addObject("erro",mensagem);	
			}

		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o filtro (Pesquisa) da pagina
	 * gerenciador vinculo livro com disciplina.
	 * 
	 * @param disciplina - Modelo disciplina
	 *            
	 * @param livro - Modelo livro            
	 *            
	 * @param opcaopesquisa - Filtrar pelo ISN ou Titulo
	 *            
	 * @return ModelAndView - Retorna uma lista de livros e lista de disciplinas.
	 */
	@RequestMapping(value= "/procurarelationshipdisciplinalivro", method= RequestMethod.POST)
	public ModelAndView procuraNaRelacaoPeloCodigoDisciplina(@ModelAttribute Livro livro){
		ModelAndView mv =  new ModelAndView("/admin/gerenciadordisciplinalivro");
			mv.addObject("listalivros",relacionamentoDAO.procuraNaRelacaoPeloISBN(livro));
			mv.addObject("listadisciplinas",disciplinaDAO.getTodasDisciplinas());
		return mv;
	}
	
}
