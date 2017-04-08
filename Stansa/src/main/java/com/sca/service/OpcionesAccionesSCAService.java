

package com.sca.service;

import com.sca.domain.OpcionAccionesSCA;

import java.util.List;

public interface OpcionesAccionesSCAService {

    public List<OpcionAccionesSCA> getOpcionesAccionesSCA(String idAplicacion, String idUsuario);

    
}
