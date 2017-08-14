package com.stansa.controller.cargaRegistroMFP;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
		this.mostrarBotonBuscar=false;
		return null;
	}

	@Override
	public boolean setDeleteAttributes(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@RequestMapping(value="/obtenerArchivo.htm", method = {RequestMethod.POST})
    @ResponseBody
	public String obtenerArchivo(
			@RequestParam("file1") MultipartFile file2,
			@RequestParam("prueba1") String prueba1) throws IllegalStateException, IOException{
		
		try {
			Workbook workbook = Workbook.getWorkbook(new File("E:\\ARCATA_OBREROS.xls"));
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
		return "";
	}

}
