package br.com.bookleweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bookleweb.Factory.FabricaEntityManager;
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
		
		FabricaEntityManager.getEntityManager().getTransaction().begin();
		
		FabricaEntityManager.getEntityManager().persist(usuario);
		
		FabricaEntityManager.getEntityManager().getTransaction().commit();
		
		FabricaEntityManager.getEntityManager().close();
		
		return "conta_adicionada";
	}
	
	@RequestMapping("/BuscaUsuario")
	public String busca(Usuario usuario){
		
		Usuario resultadobusca = FabricaEntityManager.getEntityManager().
									find(Usuario.class, usuario.getMatricula());
		
		System.out.println(resultadobusca.getSenha());    
		
		return "login";
	}

	@RequestMapping("/ExcluiUsuario")
	public String exclui(Usuario usuario){
		
		Usuario resultadobusca = FabricaEntityManager.getEntityManager().
				find(Usuario.class, usuario.getMatricula());
		
		FabricaEntityManager.getEntityManager().getTransaction().begin();
		
		FabricaEntityManager.getEntityManager().remove(resultadobusca);
		
		FabricaEntityManager.getEntityManager().getTransaction().commit();
		
		FabricaEntityManager.getEntityManager().close();
		
		return "login";
	}
}
