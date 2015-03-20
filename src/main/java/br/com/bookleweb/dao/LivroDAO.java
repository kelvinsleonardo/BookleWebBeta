package br.com.bookleweb.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Livro;

@Repository
public class LivroDAO {
	
	public Boolean adiciona(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			manager.persist(livro);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
	public Boolean remove(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			Livro livrobuscado = manager.find(Livro.class, livro.getIsbn());
			manager.remove(livrobuscado);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}

}
