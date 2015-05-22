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

public class AutenticacaoHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());
		
		//  
		UsuarioDAO usuariodao = new UsuarioDAO();
		request.getSession().setAttribute("nome_usuario_sessao", usuariodao.getNomeUsuarioLogado());
		
		
		if (roles.contains("ROLE_ALUNO")) {
			response.sendRedirect("/BookleWeb/aluno");
		}else if (roles.contains("ROLE_PROFESSOR")) {
			response.sendRedirect("/BookleWeb/professor");
		}else if  (roles.contains("ROLE_ADMIN")){
			response.sendRedirect("/BookleWeb/admin");
		}
	}
}