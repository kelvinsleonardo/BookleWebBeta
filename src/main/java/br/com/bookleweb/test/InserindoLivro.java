package br.com.bookleweb.test;

import javax.persistence.EntityManager;

import br.com.bookleweb.factory.FabricaEntityManager;


public class InserindoLivro {

	public static void main(String[] args) {
		
		EntityManager em = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();

		em.getTransaction().commit();
		 
		em.close();
	}

}
