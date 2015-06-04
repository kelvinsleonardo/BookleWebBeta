package br.com.bookleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.dao.CursoDAO;
import br.com.bookleweb.dao.DisciplinaDAO;
import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;

/**
 * Classe responsável por implementar Servlets de controle que estão
 * relacionados a Disciplina.
 * 
 * @author Kélvin Santiago
 *
 */

@Controller
public class DisciplinaController {

	private DisciplinaDAO disciplinaDAO;
	private CursoDAO cursoDAO;

	/**
	 * Construtor da Classe aplicando injeção de dependencia do Spring MVC
	 * 
	 * @param cursoDAO
	 * @param disciplinaDAO
	 */
	@Autowired
	public DisciplinaController(DisciplinaDAO disciplinaDAO, CursoDAO cursoDAO) {
		this.disciplinaDAO = disciplinaDAO;
		this.cursoDAO = cursoDAO;
	}

	/**
	 * Método Servlet responsável por permitir acesso a página do gerenciador da
	 * disciplina.
	 * 
	 * @return ModelAndView - Lista de cursos e Disciplinas
	 */
	@RequestMapping(value = "/gerenciadordisciplina")
	public ModelAndView executeDisciplina() {
		ModelAndView mv = new ModelAndView("/admin/gerenciadordisciplina");
		mv.addObject("listadisciplinas", disciplinaDAO.getTodasDisciplinas());
		mv.addObject("listacursos", cursoDAO.getTodosCursos());
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o adicionar nova disciplina.
	 * 
	 * @param curso - Model curso.
	 *   
	 * @param disciplina - Model disciplina.     
	 *            
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/adicionadisciplina", method = RequestMethod.POST)
	public ModelAndView adicionaDisciplina(
			@ModelAttribute Disciplina disciplina, @ModelAttribute Curso curso) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadordisciplina");
		if (disciplinaDAO.adiciona(disciplina, curso)) {
			String mensagem = "Opa! Disciplina adicionada com Sucesso!";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ixi! Erro ao cadastrar disciplina!";
			mv.addObject("erro", mensagem);
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o editar disciplina.
	 * 
	 * @param disciplina - Model disciplina
	 * 
	 * @return ModelAndView - Retorna uma mensagem de sucesso, ou erro.
	 */
	@RequestMapping(value = "/editadisciplina", method = RequestMethod.POST)
	public ModelAndView editaDisciplina(@ModelAttribute Disciplina disciplina,
			@ModelAttribute Curso curso) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadordisciplina");
		if (disciplinaDAO.edita(disciplina, curso)) {
			String mensagem = "Opa! Disciplina editada com Sucesso!";
			mv.addObject("sucesso", mensagem);
		} else {
			String mensagem = "Ixi! Erro ao editar disciplina!";
			mv.addObject("erro", mensagem);
		}
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o remover disciplina.
	 * 
	 * @param disciplina - Modelo disciplina
	 *            
	 * @return ModelAndView - Somente redireciona.
	 */
	@RequestMapping(value = "/removedisciplina", method = RequestMethod.POST)
	public ModelAndView removeDisciplina(@ModelAttribute Disciplina disciplina) {
		ModelAndView mv = new ModelAndView("forward:/gerenciadordisciplina");
		disciplinaDAO.remove(disciplina);
		return mv;
	}

	/**
	 * Método Servlet responsável por controlar o filtro (Pesquisa) da pagina
	 * gerenciador do curso.
	 * 
	 * @param disciplina - Model disciplina
	 *            
	 * @param opcaopesquisa - Filtrar pelo Codigo ou Nome
	 *            
	 * @return ModelAndView - Retorna uma lista de cursos e disciplinas.
	 */
	@RequestMapping(value = "/pesquisadisciplina", method = RequestMethod.POST)
	public ModelAndView pesquisaDisciplina(
			@ModelAttribute Disciplina disciplina,
			@RequestParam String opcaopesquisa) {
		ModelAndView mv = new ModelAndView("/admin/gerenciadordisciplina");
		opcaopesquisa = opcaopesquisa.toLowerCase();
		if (opcaopesquisa.equals("codigo")) {
			mv.addObject("listadisciplinas",
					disciplinaDAO.procuraPeloCodigoDaDisciplina(disciplina));
		} else if (opcaopesquisa.equals("nome")) {
			mv.addObject("listadisciplinas",
					disciplinaDAO.procuraPeloNomeDaDisciplina(disciplina));
		}
		mv.addObject("listacursos", cursoDAO.getTodosCursos());
		return mv;
	}

}
