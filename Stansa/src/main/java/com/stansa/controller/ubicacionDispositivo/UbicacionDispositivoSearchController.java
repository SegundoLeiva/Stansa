package com.stansa.controller.ubicacionDispositivo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stansa.BaseController.BaseSearchController;
import com.stansa.domain.ReporteTonerClienteConsultaModel;
import com.stansa.domain.SedeCliente;
import com.stansa.service.ConsumoDetalleService;
import com.stansa.service.SedeClienteService;

@Controller
@RequestMapping(value = "/ubicacionDispositivo")
public class UbicacionDispositivoSearchController extends BaseSearchController{

	@Autowired
    private ConsumoDetalleService consumoDetalleService;
	@Autowired
    private SedeClienteService sedeClienteService;
	
	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		ReporteTonerClienteConsultaModel form = new ReporteTonerClienteConsultaModel();
		if(!this.usuario.isEsEmpleado()){
			form.setIdSedeCliente(String.valueOf(this.usuario.getIdSedeCliente()));
		}
		return form;
	}
	
	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verUbicacionDispositivo";
	}
	
	@Override
	public List listarConsulta(Model model, HttpSession sesion,HttpServletRequest req){
		this.mostrarBotonNuevo=false;
		this.mostrarBotonBuscar=false;
		List<SedeCliente> listSedeCliente = new ArrayList<SedeCliente>();
		if(this.usuario.isEsEmpleado()){
			model.addAttribute("listaSedeCliente", this.sedeClienteService.listaSedeCliente());
		}else{
			listSedeCliente.add(this.sedeClienteService.obtieneSedeClientePorId(String.valueOf(this.usuario.getIdSedeCliente())));
			model.addAttribute("listaSedeCliente", listSedeCliente);
		}
		model.addAttribute("esEmpleado", this.usuario.isEsEmpleado());
        return consumoDetalleService.obtenerConsumoDetallePorCliente((ReporteTonerClienteConsultaModel)this.formBusqueda);         
       
	}

	@Override
	public boolean setDeleteAttributes(String id) {

		return false;

	}

}
