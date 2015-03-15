package br.com.bookleweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.bookleweb.modelo.Usuario;

@Controller
public class LoginController {

	/* 
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public LoginController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	*/

	@RequestMapping(value = {"/","/login",""})
	public String execute(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logoff(Usuario usuario, HttpSession session){
			session.invalidate();
		return "redirect:Login";
	}
}
