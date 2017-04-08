package com.stansa.controller.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stansa.sap.FuncionesSAPService;
import com.stansa.util.Constantes;

@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {

	@Autowired
	private FuncionesSAPService funcionesSAPService;
	
	@RequestMapping(value="/getProveedorDescripcion.htm", method = {RequestMethod.POST})
	@ResponseBody
	public String getProveedorDescripcion(@RequestParam("rucProveedor") String rucProveedor) {
		
		String resultado = funcionesSAPService.getProveedorDescripcion(rucProveedor, Constantes.SOCIEDAD_PROVEEDOR);

		return resultado;

	}
	
}
