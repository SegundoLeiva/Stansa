

package com.sca.service;

import com.sca.domain.OpcionAcciones;

import java.util.List;

/**
 *
 * @author Edson
 */
public interface OpcionesService {

    public List<OpcionAcciones> getOpciones(String idAplicacion, String idUsuario);

    
}
