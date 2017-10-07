package com.stansa.controller.dispositivo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stansa.BaseController.BaseSearchController;
import com.stansa.domain.ConsumoConsultaModel;
import com.stansa.domain.SedeCliente;
import com.stansa.service.ConsumoDetalleService;
import com.stansa.service.ConsumoService;
import com.stansa.service.SedeClienteService;
import com.stansa.service.TipoContratoService;

@Controller
@RequestMapping(value = "/dispositivo")
public class DispositivoSearchController extends BaseSearchController{
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
		ConsumoConsultaModel form = new ConsumoConsultaModel();
		if(!this.usuario.isEsEmpleado()){
			form.setIdSedeCliente(String.valueOf(this.usuario.getIdSedeCliente()));
		}
		return form;
	}
	
	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verDispositivos";
	}
	
	@Override
	public List listarConsulta(Model model, HttpSession sesion,HttpServletRequest req){

		List<SedeCliente> listSedeCliente = new ArrayList<SedeCliente>();
		if(this.usuario.isEsEmpleado()){
			model.addAttribute("listaSedeCliente", this.sedeClienteService.listaSedeCliente());
		}else{
			listSedeCliente.add(this.sedeClienteService.obtieneSedeClientePorId(String.valueOf(this.usuario.getIdSedeCliente())));
			model.addAttribute("listaSedeCliente", listSedeCliente);
		}
   		model.addAttribute("listaTipoContrato", this.tipoContratoService.listaTipoContrato());
   		this.mostrarBotonNuevo=false;
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