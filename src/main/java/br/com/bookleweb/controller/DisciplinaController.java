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

@Controller
public class DisciplinaController {

	private DisciplinaDAO disciplinaDAO;
	private CursoDAO cursoDAO;
	
	// Construtor da classe com injeção de dependencia do Spring 
		@Autowired
		public DisciplinaController(DisciplinaDAO disciplinaDAO, CursoDAO cursoDAO) {
			this.disciplinaDAO = disciplinaDAO;
			this.cursoDAO = cursoDAO;
		}
		
		@RequestMapping(value = "/gerenciadordisciplina")
		public ModelAndView executeDisciplina(){
			ModelAndView mv = new ModelAndView("/admin/gerenciadordisciplina");
			mv.addObject("listadisciplinas",disciplinaDAO.getTodasDisciplinas());
			mv.addObject("listacursos",cursoDAO.getTodosCursos());
			return mv;
		}
		
		@RequestMapping(value= "/adicionadisciplina", method= RequestMethod.POST)
		public ModelAndView adicionaDisciplina(@ModelAttribute Disciplina disciplina,@ModelAttribute Curso curso){
			ModelAndView mv =  new ModelAndView("forward:/gerenciadordisciplina");
			if(disciplinaDAO.adiciona(disciplina, curso)){
				String mensagem = "Opa! Disciplina adicionada com Sucesso!";
				mv.addObject("sucesso",mensagem);
			}else{
				String mensagem = "Ixi! Erro ao cadastrar disciplina!";
				mv.addObject("erro",mensagem);	
			}
			return mv;
		}
		
		@RequestMapping(value= "/editadisciplina", method= RequestMethod.POST)
		public ModelAndView editaDisciplina(@ModelAttribute Disciplina disciplina, @ModelAttribute Curso curso){
			ModelAndView mv =  new ModelAndView("forward:/gerenciadordisciplina");
			if(disciplinaDAO.edita(disciplina, curso)){
				String mensagem = "Opa! Disciplina editada com Sucesso!";
				mv.addObject("sucesso",mensagem);
			}else{
				String mensagem = "Ixi! Erro ao editar disciplina!";
				mv.addObject("erro",mensagem);	
			}
			return mv;
		}
		
		@RequestMapping(value= "/removedisciplina", method= RequestMethod.POST)
		public ModelAndView removeDisciplina(@ModelAttribute Disciplina disciplina){
			ModelAndView mv =  new ModelAndView("forward:/gerenciadordisciplina");
			disciplinaDAO.remove(disciplina);
			return mv;
		}
		
		@RequestMapping(value= "/pesquisadisciplina", method= RequestMethod.POST)
		public ModelAndView pesquisaDisciplina(@ModelAttribute Disciplina disciplina, @RequestParam String opcaopesquisa){
			ModelAndView mv =  new ModelAndView("/admin/gerenciadordisciplina");
			opcaopesquisa = opcaopesquisa.toLowerCase();
			if(opcaopesquisa.equals("codigo")){
				mv.addObject("listadisciplinas",disciplinaDAO.procuraPeloCodigoDaDisciplina(disciplina));
				
			}
			else if(opcaopesquisa.equals("nome")){
				mv.addObject("listadisciplinas",disciplinaDAO.procuraPeloNomeDaDisciplina(disciplina));
			}
			return mv;
		}
		
	
	
}
