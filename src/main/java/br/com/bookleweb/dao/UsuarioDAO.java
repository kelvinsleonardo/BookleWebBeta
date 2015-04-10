package br.com.bookleweb.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Usuario;
import br.com.bookleweb.util.CriptografiaSenha;

@Repository
public class UsuarioDAO {
	
	public Boolean adiciona(Usuario usuario){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			usuario.setSenha(CriptografiaSenha.md5(usuario.getSenha()));
			manager.persist(usuario); 
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
	public Boolean edita(Usuario usuario){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			Usuario usuariobuscado = manager.find(Usuario.class, usuario.getMatricula());
			usuario.setSenha(usuariobuscado.getSenha());
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
	
	public ArrayList<Usuario> getListaTodosUsuarios(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Usuario> typedQuery = manager.createNamedQuery("Usuario.pesquisaTodosUsuarios", Usuario.class);
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) typedQuery.getResultList();
		return usuarios;
	}

	public String getNomeUsuarioLogado(){
		Integer matriculasessaologado = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		Usuario dadosusuario = manager.find(Usuario.class, matriculasessaologado);
		String nomeusuariocompleto = dadosusuario.getNome();
		String strUpperCase = nomeusuariocompleto.substring(0, nomeusuariocompleto.indexOf(" "));
		String strLowerCase = strUpperCase.toLowerCase();
		String strFinalUsuario = StringUtils.capitalize(strLowerCase); 
		return strFinalUsuario;
	}
	
	public ArrayList<Usuario> pesquisaPelaMatricula(Usuario usuario){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Usuario> typedQuery = manager.createNamedQuery("Usuario.pesquisaPelaMatricula",Usuario.class);
		typedQuery.setParameter("matricula", usuario.getMatricula());// Setando parametro da Query
		ArrayList<Usuario> usuarioArrayList = (ArrayList<Usuario>) typedQuery.getResultList();  // Pega resultado
		return usuarioArrayList;
	}
	
	public ArrayList<Usuario> pesquisaPeloNome(Usuario usuario){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Usuario> typedQuery = manager.createNamedQuery("Usuario.pesquisaPeloNome",Usuario.class);
		typedQuery.setParameter("nome", "%"+usuario.getNome()+"%");// Setando parametro da Query
		ArrayList<Usuario> usuarioArrayList = (ArrayList<Usuario>) typedQuery.getResultList();  // Pega resultado
		return usuarioArrayList;
	}
	
	
}
