package br.com.bookleweb.Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaEntityManager {
	private static EntityManagerFactory fabrica = null; 
	private static EntityManager manager = null;
	  
	public static synchronized EntityManager getEntityManager() {

		if (manager == null){
			//Obtém o factory a partir da unidade de persistência.
		    fabrica = Persistence.createEntityManagerFactory("biblioteca");
		    //Cria um entity manager.
		    manager = fabrica.createEntityManager();
		 } 
	  	return manager; 
	}
}
