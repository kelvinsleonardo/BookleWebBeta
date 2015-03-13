package br.com.bookleweb.Factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaEntityManager {
	 private static EntityManagerFactory fabrica = null; 
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(fabrica == null){
			fabrica = Persistence.createEntityManagerFactory("biblioteca");
		}
		return fabrica; 
	}
}
