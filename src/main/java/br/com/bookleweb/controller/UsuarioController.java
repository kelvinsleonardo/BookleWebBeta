package br.com.bookleweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.bookleweb.dao.UsuarioDAO;
import br.com.bookleweb.modelo.Usuario;

@Controller
public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	
	// Construtor da classe com inje��o de dependencia do Spring 
	@Autowired
	public UsuarioController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	// Servlet para acessar p�gina gerenciausuario.jsp
	@RequestMapping(value = "/gerenciadorusuario")
	public String executeTelaGerenciaUsuario(){
		return "/admin/gerenciadorusuario";
		
	}
	
	@RequestMapping(value="/gerenciadorusuario-do", method=RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute Usuario usuario, @RequestParam String action){
		
		ModelAndView objeto = new ModelAndView("forward:/listartodosusuarios");
		action = action.toLowerCase();
		
		if(action.equals("adicionar")){
			if(usuarioDAO.adiciona(usuario)){
				String mensagem = "Usu�rio cadastrado com Sucesso!";
				objeto.addObject("sucesso", mensagem);
			}else{
				String mensagem = "Erro ao cadastrar usu�rio, matr�cula j� existe.";
				objeto.addObject("erro", mensagem);
			}
		}
		else if(action.equals("editar")){
			System.out.println("CLICOU EM EDITAR");
		}
		else if(action.equals("remover")){
			if(usuarioDAO.remove(usuario)){
				String mensagem = "Usu�rio removido com sucesso!";
				objeto.addObject("sucesso", mensagem);
				return objeto;
			}else{
				String mensagem = "Erro ao remover usu�rio";
				objeto.addObject("erro", mensagem);
			}
		}
		else if(action.equals("procurar")){

		}
		
		else if(action.equals("listar")){
			ArrayList<Usuario> listausuarios = usuarioDAO.lista();
			objeto.addObject("listausuarios",listausuarios);
			
		}
		
		return objeto;
	}

	@RequestMapping(value = "/listartodosusuarios")
	public ModelAndView doListarUsuarios(){
		ModelAndView objeto = new ModelAndView("forward:/gerenciadorusuario");
		ArrayList<Usuario> listausuarios = usuarioDAO.lista();
		objeto.addObject("listausuarios",listausuarios);
		return objeto;
	}
	
	@RequestMapping(value = "/adicionausuario", method=RequestMethod.POST)
	public ModelAndView adicionaUsuario(@ModelAttribute Usuario usuario){
		ModelAndView mv = new ModelAndView("/login");
		
		if(usuarioDAO.isRegistrado(usuario)){
			if(usuarioDAO.adiciona(usuario)){
				String sucesso = "Opa, usuário cadastrado com sucesso!";
				mv.addObject("sucesso",sucesso);		
			}
			else{
				String erro = "Ixi, ocorreu um erro ao registrar usuario!";
				mv.addObject("erro", erro);
			}
		}else{
			String erro = "Não encontramos sua matrícula no sistema.";
			mv.addObject("erro", erro);
		}
		
		return mv;
	}
	
}
