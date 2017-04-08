package com.stansa.sap;

import java.util.ResourceBundle;


public class ConexionSAP{

	public static String esLoginSAPValido(String usuario, String password){
		
		String mensaje=null;

        ResourceBundle bundle = ResourceBundle.getBundle("sap");
        String mandante = bundle.getString("sap.mandante").trim();
//        String usuario = bundle.getString("sap.usuario").trim();
//        String strPasswordSAP = bundle.getString("sap.password").trim();
        String idioma = bundle.getString("sap.idioma").trim();
        String ipSAP = bundle.getString("sap.host").trim();
        String numSistema = bundle.getString("sap.sistema").trim();


        
		return "prueba";
	}

   
}