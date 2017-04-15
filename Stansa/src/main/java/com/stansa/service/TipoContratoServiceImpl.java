package com.stansa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stansa.dao.TipoContratoDAO;
import com.stansa.domain.TipoContrato;

@Service
public class TipoContratoServiceImpl implements TipoContratoService {
    @Autowired
    public TipoContratoDAO tipoContratoDAO;

	public List<TipoContrato> listaTipoContrato() {
		return tipoContratoDAO.listaTipoContrato();
	}
	
    public TipoContrato obtieneTipoContratoPorId(String id) {
        return tipoContratoDAO.obtieneTipoContratoPorId(id);
    }
}
