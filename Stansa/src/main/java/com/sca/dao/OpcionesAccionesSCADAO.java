package com.sca.dao;

import java.util.List;

import com.sca.domain.OpcionAccionesSCA;

public interface OpcionesAccionesSCADAO {
    public List<OpcionAccionesSCA> getOpcionesAccionesSCA(String idAplicacion, String idUsuario);
    //public List<String> getOpciones(String idAplicacion, String idUsuario);   
}
