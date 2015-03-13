package br.com.bookleweb.controller;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.Factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Usuario;

@Controller
public class UsuarioController {
	
	
	@RequestMapping("/Login")
	public String execute(){
		
		return "login";	
	}
	
	@RequestMapping("/AdicionaUsuario")
	public String adiciona(Usuario usuario){

		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(usuario);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		return "conta_adicionada";
	}
	
	@RequestMapping("/BuscaUsuario")
	public String busca(Usuario usuario){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		Usuario resultadobusca = manager.
									find(Usuario.class, usuario.getMatricula());
		 
		
		return "login";
	}

	@RequestMapping("/ExcluiUsuario")
	public String exclui(Usuario usuario){
		
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		
		manager.getTransaction().begin();
		
		Usuario resultadobusca = manager.
				find(Usuario.class, usuario.getMatricula());
		
		manager.remove(resultadobusca);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		return "login";
	}
	
}
