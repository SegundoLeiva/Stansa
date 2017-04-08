package com.sca.dao;

import java.util.List;

import com.sca.domain.OpcionAcciones;

public interface OpcionesDAO {
    public List<OpcionAcciones> getOpcionesAcciones(String idAplicacion, String idUsuario);
    public List<String> getOpciones(String idAplicacion, String idUsuario);   
}
