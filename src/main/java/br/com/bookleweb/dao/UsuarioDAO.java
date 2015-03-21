package br.com.bookleweb.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Usuario;

@Repository
public class UsuarioDAO {
	
	public Boolean adiciona(Usuario usuario){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			manager.merge(usuario);
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

	public Boolean isRegistrado(Usuario usuario){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		Usuario dadosusuario = manager.find(Usuario.class, usuario.getMatricula());
		if(dadosusuario == null){
			return false;
		}else{
			return true;
		}
	}
	
	public ArrayList<Usuario> lista(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Usuario> typedQuery = manager.createQuery("FROM Usuario", Usuario.class);
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) typedQuery.getResultList();
		return usuarios;
	}

	public String getNomeUsuarioLogado(){
		Integer matriculasessaologado = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		Usuario dadosusuario = manager.find(Usuario.class, matriculasessaologado);
		String nomeusuario = dadosusuario.getNome();
		return nomeusuario;
	}
	
}
