package com.sca.local.dao;

import com.sca.local.domain.OpcionPantallaSistema;

import java.util.List;

public interface OpcionesPantallaSistemaDAO {

   OpcionPantallaSistema getById(int idOpcion);
   public List<OpcionPantallaSistema> getAccionesInOpciones(String opciones);
}
