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
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bookleweb.factory.FabricaEntityManager;


@Controller
public class RelatorioController {
	
	@RequestMapping(value = "/relatoriocurso")
	public void geraRelatorioCurso(HttpServletResponse response) throws JRException, IOException{
		// Pegando conexão do entityManager e convertendo para Connection
		Connection conn = FabricaEntityManager.getConnectionDoEntityManager();
		// Compilando relatorio
	    JasperReport jasperReport = JasperCompileManager.compileReport("src/main/java/br/com/bookleweb/relatorios/RelatorioCursos.jrxml");           
	    
		JasperPrint print = JasperFillManager.fillReport(jasperReport,new HashMap<String, Object>(),conn);

		JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
		
	}
	
	@RequestMapping(value = "/relatoriodisciplina")
	public void geraRelatorioDisciplina(HttpServletResponse response) throws JRException, IOException{
		// Pegando conexão do entityManager e convertendo para Connection
		Connection conn = FabricaEntityManager.getConnectionDoEntityManager();
		// Compilando relatorio
	    JasperReport jasperReport = JasperCompileManager.compileReport("src/main/java/br/com/bookleweb/relatorios/RelatorioDisciplinas.jrxml");           
	    
		JasperPrint print = JasperFillManager.fillReport(jasperReport,new HashMap<String, Object>(),conn);

		JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
		
	}
	
	@RequestMapping(value = "/relatoriolivro")
	public void geraRelatorioLivro(HttpServletResponse response) throws JRException, IOException{
		// Pegando conexão do entityManager e convertendo para Connection
		Connection conn = FabricaEntityManager.getConnectionDoEntityManager();
		// Compilando relatorio
	    JasperReport jasperReport = JasperCompileManager.compileReport("src/main/java/br/com/bookleweb/relatorios/RelatorioLivros.jrxml");           
	    
		JasperPrint print = JasperFillManager.fillReport(jasperReport,new HashMap<String, Object>(),conn);

		JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
		
	}
	
	@RequestMapping(value = "/relatoriousuario")
	public void geraRelatorioUsuario(HttpServletResponse response) throws JRException, IOException{
		// Pegando conexão do entityManager e convertendo para Connection
		Connection conn = FabricaEntityManager.getConnectionDoEntityManager();
		// Compilando relatorio
	    JasperReport jasperReport = JasperCompileManager.compileReport("src/main/java/br/com/bookleweb/relatorios/RelatorioUsuarios.jrxml");           
	    
		JasperPrint print = JasperFillManager.fillReport(jasperReport,new HashMap<String, Object>(),conn);

		JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
		
	}

	
}
