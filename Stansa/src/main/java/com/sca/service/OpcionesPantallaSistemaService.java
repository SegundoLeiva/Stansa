package com.sca.service;

import com.sca.local.domain.OpcionPantallaSistema;

import java.util.List;

public interface OpcionesPantallaSistemaService {
    public void getOpcionesPantalla(String idAplicacion, String idUsuario);
    public List<OpcionPantallaSistema> getListaOpcionesSIO(String opciones);
}
