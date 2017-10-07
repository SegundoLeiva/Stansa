package com.stansa.controller.dispositivo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stansa.BaseController.BaseMantenimientoController;
import com.stansa.domain.Consumo;
import com.stansa.domain.ConsumoDetalle;
import com.stansa.domain.ConsumoParametrosEntrada;
import com.stansa.domain.Usuario;
import com.stansa.service.ConsumoDetalleService;
import com.stansa.service.ConsumoService;
import com.stansa.service.ProductoService;
import com.stansa.service.SedeClienteService;

@Controller
@RequestMapping(value = "/dispositivo")
public class DispositivoMantenimientoController extends BaseMantenimientoController{
	
	@Autowired
    private ConsumoService consumoService;
	@Autowired
    private ConsumoDetalleService consumoDetalleService;
	@Autowired
    private SedeClienteService sedeClienteService;
	@Autowired
    private ProductoService productoService;		
	
	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevoDispositivo";
	}
	
	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listaSedeCliente", this.sedeClienteService.listaSedeCliente());
		model.addAttribute("listaProducto", this.productoService.listaProducto());
        return model;
	}
	
	@RequestMapping(value="/guardarConsumo.htm", method = {RequestMethod.POST})
    @ResponseBody
	public String guardarConsumo(HttpSession sesion,ConsumoParametrosEntrada consumoParametrosEntrada) throws IllegalStateException, IOException{
		
    	Usuario usuarioSession = (Usuario) sesion.getAttribute("session_usuario");	
    	consumoParametrosEntrada.setNombreUsuario(usuarioSession.getIdUsuario());
    	String rpta = consumoService.guardarConsumo(consumoParametrosEntrada);
		return rpta;
	}
	
	@Override
	public Model setModificarAttributes(String id,Model model) {
		// TODO Auto-generated method stub
			
		Consumo consumo = consumoService.obtieneConsumoPorId(id);
		model.addAttribute("consumo", consumo);       
		List<ConsumoDetalle> listaConsumoDetalle = consumoDetalleService.obtenerConsumoDetallePorIdConsumo(id);
		if(listaConsumoDetalle.size()>0)model.addAttribute("listaConsumoDetalle",listaConsumoDetalle);
		
		model.addAttribute("listaSedeCliente", this.sedeClienteService.listaSedeCliente());
		model.addAttribute("listaProducto", this.productoService.listaProducto());
		
		return model;
	}

	@Override
	public Object getFormMantenimiento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setGrabarAttributes() {
		// TODO Auto-generated method stub
		return false;
	}
	
}