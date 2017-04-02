package com.hochschild.insumoQuimico.session;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hochschild.insumoQuimico.domain.OpcionApp;
import com.hochschild.insumoQuimico.domain.Usuario;

public class ApplicationSessionInterceptor implements HandlerInterceptor {

	 
	public void sessionCreated(HttpSessionEvent event) {
	   System.out.println("Session Created");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
	    System.out.println("Session Destroyed");
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		HttpSession session = request.getSession(true);
		Usuario usuarioSession = (Usuario) session.getAttribute("session_usuario");
		if(usuarioSession==null){
			response.sendRedirect("../expirarSession.htm");
			return false;
		}else{
			String controller = request.getRequestURI().split("/")[2];
			//--------------------------------------------------
			
			List<OpcionApp> opciones = usuarioSession.getLst_opciones();
			for (OpcionApp opcionApp : opciones) {
				if(opcionApp.getIdPadre()>0){
					if(controller.equals(opcionApp.getLinkOpcion().split("/")[1]))session.setAttribute("index", opcionApp.getOrden());
					if(controller.equals("home"))session.setAttribute("index", null);
				}			
			}
		}	
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {	
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object arg2, Exception arg3) throws Exception {
		HttpSession session = request.getSession(true);
		Usuario usuarioSession = (Usuario) session.getAttribute("session_usuario");
		if(usuarioSession==null){
			response.sendRedirect("../expirarSession.htm");
		}	
	}
 }