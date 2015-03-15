package br.com.bookleweb.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.Factory.FabricaEntityManager;
import br.com.bookleweb.dao.UsuarioDAO;
import br.com.bookleweb.modelo.Usuario;

@Controller
public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	
	@Autowired // Injeção de Dependencia
	public UsuarioController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	@RequestMapping("/AdicionaUsuario")
	public ModelAndView adiciona(@Valid Usuario usuario, BindingResult result){
			if(usuarioDAO.adiciona(usuario)){
				ModelAndView mv = new ModelAndView("login", "sucesso", "Usuario cadastrado com sucesso");
				return mv;
			}else{
				ModelAndView mv = new ModelAndView("login", "erro", "Erro ao cadastrar usuario");
				return mv;
			}
		
	}
	
	@RequestMapping("/RemoveUsuario")
	public String remove(Usuario usuario){
		usuarioDAO.remove(usuario);
		
		return "redirect:Login";
	}

	@RequestMapping(value = "/listausuario")
	public ModelAndView lista(){
		
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		
		TypedQuery<Usuario> typedQuery = manager.createQuery("SELECT e FROM Usuario e", Usuario.class);
		
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) typedQuery.getResultList();
		
		ModelAndView mv = new ModelAndView("/admin/listausuario", "usuarios", usuarios);
		
		return mv;	
	}

}
