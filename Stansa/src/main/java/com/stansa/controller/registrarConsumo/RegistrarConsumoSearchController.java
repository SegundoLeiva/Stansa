package com.stansa.controller.registrarConsumo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stansa.BaseController.BaseSearchController;
import com.stansa.domain.ConsumoConsulta;
import com.stansa.domain.ConsumoConsultaModel;
import com.stansa.service.ConsumoDetalleService;
import com.stansa.service.ConsumoService;
import com.stansa.service.SedeClienteService;
import com.stansa.service.TipoContratoService;

@Controller
@RequestMapping(value = "/registrarConsumo")
public class RegistrarConsumoSearchController extends BaseSearchController{
	@Autowired
    private ConsumoService consumoService;
	@Autowired
    private ConsumoDetalleService consumoDetalleService;
	@Autowired
    private SedeClienteService sedeClienteService;
	@Autowired
    private TipoContratoService tipoContratoService;
	
	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		ConsumoConsultaModel consumoConsultaModel = new ConsumoConsultaModel();
		return consumoConsultaModel;
	}
	
	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verConsumos";
	}
	
	@Override
	public List listarConsulta(Model model, HttpSession sesion,HttpServletRequest req){

   		model.addAttribute("listaSedeCliente", this.sedeClienteService.listaSedeCliente());
   		model.addAttribute("listaTipoContrato", this.tipoContratoService.listaTipoContrato());

        return consumoService.listaConsumoConsulta((ConsumoConsultaModel)this.formBusqueda);         
	}
	
	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		try {
			consumoService.eliminarConsumo(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}