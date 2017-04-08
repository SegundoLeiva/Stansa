package com.stansa.service;

import java.util.List;

import com.stansa.domain.OpcionApp;

public interface OpcionesAppService {
    //public List<OpcionApp> getOpciones(String opciones);
    
    public List<OpcionApp> listaOpcionesApp(String idAplicacion, String idUsuario);
}
