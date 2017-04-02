package com.hochschild.insumoQuimico.controller.ingresarMercaderia;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hochschild.insumoQuimico.BaseController.BaseSearchController;
import com.hochschild.insumoQuimico.domain.MercaderiaConsultaModel;
import com.hochschild.insumoQuimico.sap.FuncionesSAPService;
import com.hochschild.insumoQuimico.service.MercaderiaDetalleService;
import com.hochschild.insumoQuimico.service.MercaderiaService;

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
