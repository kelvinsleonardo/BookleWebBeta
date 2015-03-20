package br.com.bookleweb.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Disciplina;

@Repository
public class DisciplinaDAO {
	
	public Boolean adiciona(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{

			manager.getTransaction().begin();
			manager.persist(disciplina);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
	public Boolean remove(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			Disciplina disciplinabuscado = manager.find(Disciplina.class, disciplina.getCod_disciplina());
			manager.remove(disciplinabuscado);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}

}
