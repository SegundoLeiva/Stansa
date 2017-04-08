package com.stansa.controller.ingresarMercaderia;

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
import com.stansa.domain.Mercaderia;
import com.stansa.domain.MercaderiaDetalle;
import com.stansa.domain.MercaderiaParametrosEntrada;
import com.stansa.service.MercaderiaDetalleService;
import com.stansa.service.MercaderiaService;
import com.stansa.service.ProductoService;

@Controller
@RequestMapping(value = "/ingresarMercaderia")
public class IngresarMercaderiaMantenimientoController extends BaseMantenimientoController{
	@Autowired
    private MercaderiaService mercaderiaService;
	@Autowired
    private MercaderiaDetalleService mercaderiaDetalleService;	
	@Autowired
    private ProductoService productoService;	

	@Override
	public String getPaginaMantenimiento() {
		// TODO Auto-generated method stub
		return "nuevaMercaderia";
	}
	
	@Override
	public Model setViewAttributes(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("listaProducto", this.productoService.listaProducto());
		return model;
	}
	
	@RequestMapping(value="/guardarMercaderia.htm", method = {RequestMethod.POST})
    @ResponseBody
	public String guardarMercaderia(HttpSession sesion,MercaderiaParametrosEntrada mercaderiaParametrosEntrada) throws IllegalStateException, IOException{
		
    	mercaderiaParametrosEntrada.setNombreUsuario(this.usuario.getIdUsuario());
    	String rpta = mercaderiaService.guardarMercaderia(mercaderiaParametrosEntrada);
		return rpta;
	}
	
	@Override
	public Model setModificarAttributes(String id,Model model) {
		// TODO Auto-generated method stub
		Mercaderia mercaderia = mercaderiaService.obtieneMercaderiaPorId(id);
		model.addAttribute("mercaderia", mercaderia);
		List<MercaderiaDetalle> listaMercaderiaDetalle = mercaderiaDetalleService.obtenerMercaderiaDetallePorIdMercaderia(id);
		if(listaMercaderiaDetalle.size()>0)model.addAttribute("listaMercaderiaDetalle",listaMercaderiaDetalle);
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
