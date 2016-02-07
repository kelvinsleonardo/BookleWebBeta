package br.com.bookleweb.controller;

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
import br.com.bookleweb.util.DataFind;

/**
 * Classe responsável por implementar Servlets de controle que estão
 * relacionados a Livro.
 * 
 * @author Kélvin Santiago
 *
 */

@Controller
public class LivroController {

	private DisciplinaDAO disciplinaDAO;
	private LivroDAO livroDAO;

	/**
	 * Construtor da Classe aplicando injeção de dependencia do Spring MVC
	 * 
	 * @param livroDAO
	 * @param disciplinaDAO
	 */
	@Autowired
	public LivroController(LivroDAO livroDAO, DisciplinaDAO disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
		this.livroDAO = livroDAO;
	}

	/**
	 * Método Servlet responsável por permitir acesso a página do gerenciador da
	 * livro.
	 * 
	 * @return ModelAndView - Lista de livros e Disciplinas
	 */
	@RequestMapping(value = "/gerenciadorlivro")
	public ModelAndView executeLivro() {
		ModelAndView mv = new ModelAndView("/admin/gerenciadorlivro");
		mv.addObject("listalivros", livroDAO.getlistaTodosLivros());
		mv.addObject("listadisciplinas", disciplinaDAO.getTodasDisciplinas());
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o adicionar novo livro.
	 * 
	 * @param livro - Model livro.
	 *   
	 * @param disciplina - Model disciplina.     
	 *            
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/adicionalivro", method = RequestMethod.POST)
	public ModelAndView adicionaLivro(@ModelAttribute Livro livro,
			@ModelAttribute Disciplina disciplina, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorlivro");
		livro.setIsbn(DataFind.gerarId());
		if (livroDAO.adiciona(livro)) {
			String mensagem = "Opa! Livro adicionado com Sucesso!";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ixi! Erro ao cadastrar livro!";
			mv.addObject("erro", mensagem);
		}

		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o editar livro.
	 * 
	 * @param livro - Model livro
	 * 
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/editalivro", method = RequestMethod.POST)
	public ModelAndView editaDisciplina(@ModelAttribute Livro livro) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorlivro");
		if (livroDAO.edita(livro)) {
			String mensagem = "Opa! Livro editado com Sucesso!";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ixi! Erro ao editar livro!";
			mv.addObject("erro", mensagem);
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o remover livro.
	 * 
	 * @param livro - Modelo livro
	 *            
	 * @return ModelAndView - Somente redireciona.
	 */
	@RequestMapping(value = "/removelivro", method = RequestMethod.POST)
	public ModelAndView removeDisciplina(@ModelAttribute Livro livro) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadorlivro");
		livroDAO.remove(livro);
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o filtro (Pesquisa) da pagina
	 * gerenciador do livro.
	 * 
	 * @param disciplina - Modelo disciplina
	 *            
	 * @param livro - Modelo livro            
	 *            
	 * @param opcaopesquisa - Filtrar pelo ISN ou Titulo
	 *            
	 * @return ModelAndView - Retorna uma lista de livros.
	 */
	@RequestMapping(value = "/filtrolivro", method = RequestMethod.POST)
	public ModelAndView procuraNaRelacaoPeloCodigoDisciplina(
			@ModelAttribute Disciplina disciplina, @ModelAttribute Livro livro,
			@RequestParam String opcaopesquisa) {
		ModelAndView mv = new ModelAndView("/admin/gerenciadorlivro");
		opcaopesquisa = opcaopesquisa.toLowerCase();
		if (opcaopesquisa.equals("isbn")) {
			mv.addObject("listalivros", livroDAO.procuraPeloISBN(livro));

		} else if (opcaopesquisa.equals("titulo")) {
			mv.addObject("listalivros", livroDAO.procuraPeloTitulo(livro));
		}
		return mv;
	}

}
