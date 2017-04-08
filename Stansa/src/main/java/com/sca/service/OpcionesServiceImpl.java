package com.sca.service;

import com.sca.dao.OpcionesDAO;
import com.sca.domain.OpcionAcciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcionesServiceImpl implements OpcionesService {
    @Autowired
    private OpcionesDAO opcionesDAO;

    public List<OpcionAcciones> getOpciones(String idAplicacion, String idUsuario){
        return opcionesDAO.getOpcionesAcciones(idAplicacion, idUsuario);
    }
}
