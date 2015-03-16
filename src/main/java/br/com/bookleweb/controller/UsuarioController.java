package br.com.bookleweb.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;





import br.com.bookleweb.dao.UsuarioDAO;
import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Usuario;

@Controller
public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	
	// Construtor da classe com injeção de dependencia do Spring 
	@Autowired
	public UsuarioController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	// Servlet para acessar página gerenciausuario.jsp
	@RequestMapping(value = "/gerenciausuario")
	public String executeTelaGerenciaUsuario(){
		return "/admin/gerenciausuario";
		
	}
	
	@RequestMapping(value="/gerenciausuario.do", method=RequestMethod.POST)
	public ModelAndView doActions(@ModelAttribute Usuario usuario, @RequestParam String action){
		ModelAndView objeto = new ModelAndView("redirect:/gerenciausuario");
		if(action.toLowerCase().equals("adicionar")){
			if(usuarioDAO.adiciona(usuario)){
				String mensagem = "Usuário cadastrado com Sucesso!";
				objeto.addObject("sucesso", mensagem);
			}else{
				String mensagem = "Erro ao cadastrar usuário, matrícula já existe.";
				objeto.addObject("erro", mensagem);
			}
		}
		else if(action.toLowerCase().equals("editar")){
			System.out.println("CLICOU EM EDITAR");
		}
		else if(action.toLowerCase().equals("remover")){
			System.out.println(usuario.getMatricula());
			if(usuarioDAO.remove(usuario)){
				String mensagem = "Usuário removido com sucesso!";
				objeto.addObject("sucesso", mensagem);
			}else{
				String mensagem = "Erro ao remover usuário";
				objeto.addObject("erro", mensagem);

			}
		}
		else if(action.toLowerCase().equals("procurar")){
			Usuario usuariopesquisado = usuarioDAO.procura(usuario);
			objeto.addObject("usuario", usuariopesquisado);
		}
		
		return objeto;
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
