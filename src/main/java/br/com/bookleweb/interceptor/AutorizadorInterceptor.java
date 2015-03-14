package br.com.bookleweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception{
		
		String uri = request.getRequestURI();
		
		if(uri.endsWith("Login") || uri.endsWith("ValidaAutenticacao") || uri.endsWith("resources")){
			return true;
		}
	
		if(uri.endsWith("/")){
			response.sendRedirect("Login");
			return false;
		}
		
		if(request.getSession().getAttribute("usuarioLogado")!= null){
			return true;
		}else{
			response.sendRedirect("Login");
			return false;
		}
		
	}
	
}
