package com.stansa.sap;

import org.springframework.stereotype.Service;

@Service
public class FuncionesSAPServiceImpl implements FuncionesSAPService {
	
    

    public String getProveedorDescripcion(String ruc, String sociedad) {
        
        String descripcion = "RICOH";
    
        return descripcion;
    }
    
}
