package br.com.bookleweb.controller;


import java.io.IOException;
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
	
	private final String CAMINHO_RELATORIO_CURSO = "src/main/java/br/com/bookleweb/relatorios/RelatorioCursos.jrxml";
	private final String CAMINHO_RELATORIO_DISCIPLINA = "src/main/java/br/com/bookleweb/relatorios/RelatorioDisciplinas.jrxml";
	private final String CAMINHO_RELATORIO_LIVRO = "src/main/java/br/com/bookleweb/relatorios/RelatorioLivros.jrxml";
	private final String CAMINHO_RELATORIO_USUARIO = "src/main/java/br/com/bookleweb/relatorios/RelatorioUsuarios.jrxml";
	
	
	/** Servlet responsável por gerar relatório de todos os cursos.
	 * 
	 * @param response
	 * @throws JRException
	 * @throws IOException
	 */
	@RequestMapping(value = "/relatoriocurso")
	public void geraRelatorioCurso(HttpServletResponse response) throws JRException, IOException{

		Connection conexao = FabricaEntityManager.getConnectionDoEntityManager();
		
	    JasperReport jasperReport = JasperCompileManager.compileReport(CAMINHO_RELATORIO_CURSO);           
	    
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
		
		Connection conexao = FabricaEntityManager.getConnectionDoEntityManager();
		
	    JasperReport jasperReport = JasperCompileManager.compileReport(CAMINHO_RELATORIO_DISCIPLINA);           
	    
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
		
		Connection conexao = FabricaEntityManager.getConnectionDoEntityManager();
		
	    JasperReport jasperReport = JasperCompileManager.compileReport(CAMINHO_RELATORIO_LIVRO);           
	    
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
		
		Connection conexao = FabricaEntityManager.getConnectionDoEntityManager();
		
	    JasperReport jasperReport = JasperCompileManager.compileReport(CAMINHO_RELATORIO_USUARIO);           
	    
		JasperPrint print = JasperFillManager.fillReport(jasperReport,new HashMap<String, Object>(),conexao);

		JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
		
	}

	
}