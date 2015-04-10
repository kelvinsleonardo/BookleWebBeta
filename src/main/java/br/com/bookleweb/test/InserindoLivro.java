package br.com.bookleweb.test;


import java.io.FileNotFoundException;

import java.util.HashMap;

import javax.persistence.EntityManager;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.view.JasperViewer;

import br.com.bookleweb.factory.FabricaEntityManager;

public class InserindoLivro {
	
	public static void main(String[] args) throws JRException, FileNotFoundException {
		
		
		
		EntityManager em = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		
	
		
		em.getTransaction().begin();

		System.out.println("Generating PDF...");
		


	    JasperReport jasperReport = JasperCompileManager.compileReport("src/main/java/br/com/bookleweb/relatorios/RelatorioCursos.jrxml");      
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String, Object>(), 
	    		new JREmptyDataSource());      
	      
	    JasperViewer viewer = new JasperViewer(jasperPrint, false);  
        viewer.setVisible(true); 
        
	    JasperExportManager.exportReportToPdfFile(jasperPrint, "HelloJasper.pdf");
	                    
	    System.out.println("HelloJasper.pdf has been generated!");
		
		em.getTransaction().commit();
		 
		em.close();
	}

}
