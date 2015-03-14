package br.com.bookleweb.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bookleweb.dao.UsuarioDAO;
import br.com.bookleweb.modelo.Usuario;

@Controller
public class LoginController {

	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public LoginController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@RequestMapping("/Login")
	public String execute(){
		return "login";
	}
	
	@RequestMapping("/ValidaAutenticacao")
	public String validaAutenticacao(@Valid Usuario usuario, BindingResult result, HttpSession session){
		if(result.hasErrors()){
			return "login";
		}
		else{
			if(usuarioDAO.valida(usuario)){
				session.setAttribute("usuarioLogado", usuario);
				return "redirect:Home";
			}
			return "redirect:Login";
		}
	}
	
	@RequestMapping("/Logoff")
	public String logoff(Usuario usuario, HttpSession session){
			session.invalidate();
		return "redirect:Login";
	}
	
	@RequestMapping("/Home")
	public String home(){
		return "/aluno/home";
	}
	
}
