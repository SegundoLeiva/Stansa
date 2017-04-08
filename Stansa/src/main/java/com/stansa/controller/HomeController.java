package com.stansa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stansa.domain.Usuario;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
  
	    
	    @RequestMapping(value = "/bienvenida.htm")
	    public String bienvenida(HttpSession sesion){
	    	 Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");
	         if (usuarioSession != null){  
	        	 
	        	 return "panelPrincipal";
	         }else{
	             return "redirect:/logout.htm";
	         }        
	    }
}
