package br.com.bookleweb.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.Factory.FabricaEntityManager;
import br.com.bookleweb.dao.UsuarioDAO;
import br.com.bookleweb.modelo.Usuario;

@Controller
public class UsuarioController {
	
	
	@RequestMapping("/Login")
	public String execute(){
		return "login";
	}
	
	@RequestMapping("/AdicionaUsuario")
	public String adiciona(@Valid Usuario usuario, BindingResult result){
		if(result.hasErrors()){
			return "login";
		}
		else{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.adiciona(usuario);
		return "redirect:Login";}
	}
	
	@RequestMapping("/ValidaUsuario")
	public String busca(Usuario usuario){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.valida(usuario);
		return "login";
	}

	@RequestMapping("/RemoveUsuario")
	public String remove(Usuario usuario){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.remove(usuario);
		
		return "redirect:Login";
	}

	@RequestMapping("/ListaUsuario")
	public ModelAndView lista(){
		
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<Usuario> typedQuery = manager.createQuery("SELECT e FROM Usuario e", Usuario.class);
		
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) typedQuery.getResultList();
		
		ModelAndView mv = new ModelAndView("login", "usuarios", usuarios);
		
		return mv;	
	}

}
