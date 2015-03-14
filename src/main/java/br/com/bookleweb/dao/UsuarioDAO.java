package br.com.bookleweb.dao;

import javax.persistence.EntityManager;

import br.com.bookleweb.Factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Usuario;

public class UsuarioDAO {

	public Boolean adiciona(Usuario usuario){
		
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(usuario);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		return true;
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
