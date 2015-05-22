package br.com.bookleweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.dao.CursoDAO;
import br.com.bookleweb.dao.DisciplinaDAO;
import br.com.bookleweb.dao.LivroDAO;
import br.com.bookleweb.dao.RelationShipDisciplinaLivroDAO;
import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;

@Controller
public class LivroSugeridoController {
	
	private CursoDAO cursoDAO; 
	private DisciplinaDAO disciplinaDAO;
	
	@Autowired
	public LivroSugeridoController(DisciplinaDAO disciplinaDAO, LivroDAO livroDAO, CursoDAO cursoDAO, RelationShipDisciplinaLivroDAO relationShipDAO) {
		this.disciplinaDAO = disciplinaDAO;
		this.cursoDAO = cursoDAO;
	}
	
	@RequestMapping(value= "/pesquisa")
	public ModelAndView initPesquisa(){
		ModelAndView mv = new ModelAndView("/admin/pesquisa");
		mv.addObject("listacursos",cursoDAO.getTodosCursos());
		return mv;		
	}
	
	
	@RequestMapping(value= "/pesquisaresultado", method= RequestMethod.POST)
	public ModelAndView initPesquisaResultado(@ModelAttribute Disciplina disciplina){
		ModelAndView mv = new ModelAndView("/admin/pesquisaresultado");
		mv.addObject("listalivros",disciplinaDAO.procuraPeloCodigoDaDisciplina(disciplina));
		return mv;		
	}
	

	@RequestMapping(value= "/relacaodisciplina", method= RequestMethod.POST)
	public void pesquisaCurso(@ModelAttribute Curso curso, HttpServletResponse response ) throws IOException{
		PrintWriter out = response.getWriter();
		ArrayList<Disciplina> listadisciplinas = disciplinaDAO.procuraDisciplinaPeloCodigoDoCurso(curso);
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < listadisciplinas.size(); i++){
			sb.append(listadisciplinas.get(i).getCod_disciplina()+"-"+listadisciplinas.get(i).getNome_disciplina()+":");
		}
		out.write(sb.toString());
	}

	
}
