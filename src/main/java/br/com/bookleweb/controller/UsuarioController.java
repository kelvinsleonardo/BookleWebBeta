package br.com.bookleweb.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bookleweb.modelo.Usuario;

@Controller
public class UsuarioController {
	
	@RequestMapping("/Login")
	public String execute(){
		System.out.println("Executando Tela Login");
		return "login";	
	}
	
	@RequestMapping("/AdicionaUsuario")
	public String adiciona(Usuario usuario){
		
		EntityManagerFactory factorymanager = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager manager = factorymanager.createEntityManager();
		
		System.out.println("Matricula: "+usuario.getMatricula());
		System.out.println("Senha: "+usuario.getSenha());
		
		
		manager.getTransaction().begin();
		
		manager.persist(usuario);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		System.out.println("Adicionando usuario no banco");
		
		return "conta_adicionada";
	}
}
