package com.stansa.controller.entregaPedido;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stansa.BaseController.BaseSearchController;
import com.stansa.domain.EntregaPedidoModel;
import com.stansa.service.ConsumoDetalleService;
import com.stansa.service.ConsumoService;
import com.stansa.service.SedeClienteService;

@Controller
@RequestMapping(value = "/entregaPedido")
public class EntregaPedidoSearchController extends BaseSearchController{
	@Autowired
    private ConsumoService consumoService;
	@Autowired
    private ConsumoDetalleService consumoDetalleService;
	@Autowired
    private SedeClienteService sedeClienteService;
	
	@Override
	public Object getFormBusqueda() {
		// TODO Auto-generated method stub
		EntregaPedidoModel entregaPedidoModel = new EntregaPedidoModel();
		return entregaPedidoModel;
	}
	
	@Override
	public String getPaginaSearch() {
		// TODO Auto-generated method stub
		return "verEntregaPedidos";
	}
	
	@Override
	public List listarConsulta(Model model, HttpSession sesion,HttpServletRequest req){
		this.mostrarBotonNuevo = false;
   		model.addAttribute("listaSedeCliente", this.sedeClienteService.listaSedeCliente());
        return consumoService.listaEntregaPedidoConsulta((EntregaPedidoModel)this.formBusqueda);         
	}
	
	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}