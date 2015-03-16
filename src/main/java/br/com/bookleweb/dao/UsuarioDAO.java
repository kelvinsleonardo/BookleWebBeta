package br.com.bookleweb.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Usuario;

@Repository
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
		try{
			manager.getTransaction().begin();
			Usuario usuariobuscado = manager.find(Usuario.class, usuario.getMatricula());
			manager.remove(usuariobuscado);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}

	public Usuario procura(Usuario usuario){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		Usuario dadosusuario = manager.find(Usuario.class, usuario.getMatricula());
		
		return dadosusuario;
	}
}
