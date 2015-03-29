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
import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;

@Controller
public class LivroSugeridoController {
	
	private CursoDAO cursoDAO; 
	private DisciplinaDAO disciplinaDAO;
	private LivroDAO livroDAO;
	
	@Autowired
	public LivroSugeridoController(DisciplinaDAO disciplinaDAO, LivroDAO livroDAO, CursoDAO cursoDAO) {
		this.disciplinaDAO = disciplinaDAO;
		this.livroDAO = livroDAO;
		this.cursoDAO = cursoDAO;
	}
	
	@RequestMapping(value= "/pesquisa")
	public ModelAndView initPesquisa(){
		ModelAndView mv = new ModelAndView("/admin/pesquisa");
		mv.addObject("listacursos",cursoDAO.getlistaTodosCursos());
		return mv;		
	}
	

	@RequestMapping(value= "/relacaodisciplina", method= RequestMethod.POST)
	public void pesquisaCurso(@ModelAttribute Curso curso, HttpServletResponse response ) throws IOException{
		PrintWriter out = response.getWriter();
		ArrayList<Disciplina> listadisciplinas = disciplinaDAO.pesquisaPeloCodigoCurso(curso);
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < listadisciplinas.size(); i++){
			sb.append(listadisciplinas.get(i).getCod_disciplina()+"-"+listadisciplinas.get(i).getNome_disciplina()+":");
		}
		out.write(sb.toString());
	}


	@RequestMapping(value= "/relacaolivro", method= RequestMethod.POST)
	public void pesquisaLivro(@ModelAttribute Disciplina disciplina, HttpServletResponse response ) throws IOException{
		PrintWriter out = response.getWriter();
		ArrayList<Livro> listalivros = livroDAO.pesquisaPeloCodigoDisciplina(disciplina);
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < listalivros.size(); i++){
			sb.append(listalivros.get(i).getIsbn()+"-"+listalivros.get(i).getTitulo()+":");
		}
		out.write(sb.toString());
	}
	
}
