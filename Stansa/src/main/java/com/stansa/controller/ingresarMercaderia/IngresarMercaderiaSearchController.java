package com.stansa.controller.ingresarMercaderia;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stansa.BaseController.BaseSearchController;
import com.stansa.domain.MercaderiaConsultaModel;
import com.stansa.sap.FuncionesSAPService;
import com.stansa.service.MercaderiaDetalleService;
import com.stansa.service.MercaderiaService;

@Controller
@RequestMapping(value = "/ingresarMercaderia")
public class IngresarMercaderiaSearchController extends BaseSearchController{
	@Autowired
    private MercaderiaService mercaderiaService;
	@Autowired
    private MercaderiaDetalleService mercaderiaDetalleService;
	@Autowired
	private FuncionesSAPService funcionesSAPService;
	
	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		MercaderiaConsultaModel mercaderiaConsultaModel = new MercaderiaConsultaModel(this.usuario);
		return mercaderiaConsultaModel;
	}
	
	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verMercaderias";
	}
	
	@Override
	public List listarConsulta(Model model, HttpSession sesion,HttpServletRequest req){
        return mercaderiaService.listaMercaderiaConsulta((MercaderiaConsultaModel)this.formBusqueda);         
       
	}

	@Override
	public boolean setDeleteAttributes(String id) {
		try {
			mercaderiaService.eliminarMercaderia(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
