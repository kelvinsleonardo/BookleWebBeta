package br.com.bookleweb.util;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import br.com.bookleweb.dao.UsuarioDAO;

/** Classe Responsável por ter métodos de Sucesso depois da autenticação 
 * do login feito pelo Framework Spring Security
 * 
 * @author Kelvin Santiago
 *
 */
public class AutenticacaoHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());
		
		  
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		// Criando sessão para guardar nome do usuario
		request.getSession().setAttribute("nome_usuario_sessao", usuariodao.getNomeUsuarioLogado());
		
		// De acordo com o tipo de permissão é redirecionado para a página relacionada.
		if (roles.contains("ROLE_ALUNO")) {
			response.sendRedirect("/BookleWeb/aluno");
		}else if (roles.contains("ROLE_PROFESSOR")) {
			response.sendRedirect("/BookleWeb/professor");
		}else if  (roles.contains("ROLE_ADMIN")){
			response.sendRedirect("/BookleWeb/admin");
		}
	}
}