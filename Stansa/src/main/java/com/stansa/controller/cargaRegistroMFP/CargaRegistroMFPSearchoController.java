package com.stansa.controller.cargaRegistroMFP;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stansa.BaseController.BaseSearchController;

@Controller
@RequestMapping(value = "/cargaRegistroMFP")
public class CargaRegistroMFPSearchoController extends BaseSearchController{

	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "cargaRegistroMFP";
	}

	@Override
	public List listarConsulta(Model model, HttpSession sesion,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
