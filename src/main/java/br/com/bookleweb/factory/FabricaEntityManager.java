package br.com.bookleweb.factory;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class FabricaEntityManager {
	
	private static EntityManagerFactory fabrica = null;
	private static Connection conn = null;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(fabrica == null){
			fabrica = Persistence.createEntityManagerFactory("biblioteca");
		}
		return fabrica; 
	}
	
	public static Connection getConnectionDoEntityManager(){
		try{
			EntityManager em = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
			Session secao = em.unwrap(Session.class);
			SessionFactoryImplementor sfi = (SessionFactoryImplementor) secao.getSessionFactory();
			@SuppressWarnings("deprecation")
			ConnectionProvider cp = sfi.getConnectionProvider();
			conn = cp.getConnection();
			
		}catch(Exception e){
			System.err.print(e);
		}
		return conn;
	}
	
}
