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

import br.com.bookleweb.dao.DisciplinaDAO;
import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;

@Controller
public class LivroSugeridoController {

	private DisciplinaDAO disciplinaDAO;
	
	@Autowired
	public LivroSugeridoController(DisciplinaDAO disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
	}

	@RequestMapping(value= "/relacaodisciplina", method= RequestMethod.POST)
	public void pesquisaCurso(@ModelAttribute Curso curso, HttpServletResponse response ) throws IOException{
		
		PrintWriter out = response.getWriter();
		ArrayList<Disciplina> listadisciplinas = disciplinaDAO.pesquisaPeloCodigoCurso(curso);
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < listadisciplinas.size(); i++){
			sb.append(listadisciplinas.get(i).getNome_disciplina()+":");
		}
		out.write(sb.toString());
	}
	
}
