package br.com.bookleweb.controller;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bookleweb.factory.FabricaEntityManager;

/**
 * Classe responsável por implementar Servlets para gerar relatórios.
 * 
 * @author Kélvin Santiago
 *
 */

@Controller
public class RelatorioController {
	
	private final String CAMINHO_RELATORIO_CURSO = "/br/com/bookleweb/relatorios/RelatorioCursos.jrxml";
	private final String CAMINHO_RELATORIO_DISCIPLINA = "/br/com/bookleweb/relatorios/RelatorioDisciplinas.jrxml";
	private final String CAMINHO_RELATORIO_LIVRO = "/br/com/bookleweb/relatorios/RelatorioLivros.jrxml";
	private final String CAMINHO_RELATORIO_USUARIO = "/br/com/bookleweb/relatorios/RelatorioUsuarios.jrxml";
	
	
	/** Servlet responsável por gerar relatório de todos os cursos.
	 * 
	 * @param response
	 * @throws JRException
	 * @throws IOException
	 */
	@RequestMapping(value = "/relatoriocurso")
	public void geraRelatorioCurso(HttpServletResponse response) throws JRException, IOException{

		InputStream inputStreamURLCurso =this.getClass().getResourceAsStream(CAMINHO_RELATORIO_CURSO);
		
		Connection conexao = FabricaEntityManager.getConnectionDoEntityManager();
		
		response.setContentType("application/pdf");
		
	    JasperReport jasperReport = JasperCompileManager.compileReport(inputStreamURLCurso);           
	    
		JasperPrint print = JasperFillManager.fillReport(jasperReport,new HashMap<String, Object>(),conexao);

		JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
		
	}
	
	/** Servlet responsável por gerar relatório de todas as disciplinas.
	 * 
	 * @param response
	 * @throws JRException
	 * @throws IOException
	 */
	@RequestMapping(value = "/relatoriodisciplina")
	public void geraRelatorioDisciplina(HttpServletResponse response) throws JRException, IOException{
		
		InputStream inputStreamURLDisciplina =this.getClass().getResourceAsStream(CAMINHO_RELATORIO_DISCIPLINA);
		
		Connection conexao = FabricaEntityManager.getConnectionDoEntityManager();
		
		response.setContentType("application/pdf");
		
	    JasperReport jasperReport = JasperCompileManager.compileReport(inputStreamURLDisciplina);           
	    
		JasperPrint print = JasperFillManager.fillReport(jasperReport,new HashMap<String, Object>(),conexao);

		JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
		
	}
	
	/** Servlet responsável por gerar relatório de todos os livros.
	 * 
	 * @param response
	 * @throws JRException
	 * @throws IOException
	 */
	@RequestMapping(value = "/relatoriolivro")
	public void geraRelatorioLivro(HttpServletResponse response) throws JRException, IOException{
		
		InputStream inputStreamURLLivro =this.getClass().getResourceAsStream(CAMINHO_RELATORIO_LIVRO);
		
		Connection conexao = FabricaEntityManager.getConnectionDoEntityManager();
		
		response.setContentType("application/pdf");
		
	    JasperReport jasperReport = JasperCompileManager.compileReport(inputStreamURLLivro);           
	    
		JasperPrint print = JasperFillManager.fillReport(jasperReport,new HashMap<String, Object>(),conexao);

		JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
		
	}
	
	/** Servlet responsável por gerar relatório de todos os usuarios.
	 * 
	 * @param response
	 * @throws JRException
	 * @throws IOException
	 */
	@RequestMapping(value = "/relatoriousuario")
	public void geraRelatorioUsuario(HttpServletResponse response) throws JRException, IOException{
		
		InputStream inputStreamURLUsuario =this.getClass().getResourceAsStream(CAMINHO_RELATORIO_USUARIO);
		
		Connection conexao = FabricaEntityManager.getConnectionDoEntityManager();
		
		response.setContentType("application/pdf");
		
	    JasperReport jasperReport = JasperCompileManager.compileReport(inputStreamURLUsuario);           
	    
		JasperPrint print = JasperFillManager.fillReport(jasperReport,new HashMap<String, Object>(),conexao);

		JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
		
	}

	
}