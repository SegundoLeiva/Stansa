
package com.stansa.dao;

import java.util.List;

import com.stansa.domain.OpcionApp;

public interface OpcionesAppDAO {
    public List<OpcionApp> getOpcionesApp(String idAplicacion,String opciones);
}
