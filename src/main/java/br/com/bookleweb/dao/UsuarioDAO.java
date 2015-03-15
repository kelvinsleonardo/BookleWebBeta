package br.com.bookleweb.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.Factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Usuario;

@Repository // Repositorio para injeção de dependencia
public class UsuarioDAO {

	public Boolean adiciona(Usuario usuario){
		
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
		manager.getTransaction().begin();
		
		manager.persist(usuario);
		
		manager.getTransaction().commit();
		
		return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}

		
	}
	
	public Boolean remove(Usuario usuario){

		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		
		manager.getTransaction().begin();
		
		Usuario resultadobusca = manager.
				find(Usuario.class, usuario.getMatricula());
		
		manager.remove(resultadobusca);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		return true;
	}

	public Boolean valida(Usuario usuario){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		Usuario resultadobusca = manager.find(Usuario.class, usuario.getMatricula());

		if(resultadobusca != null){
			if(resultadobusca.getSenha().equals(usuario.getSenha())){
				return true;
			}else{
				return false;
			}
		} else{
			return false;
		}
	
	}
}
