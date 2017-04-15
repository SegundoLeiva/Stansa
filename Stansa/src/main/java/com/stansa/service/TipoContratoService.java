package com.stansa.service;

import java.util.List;

import com.stansa.domain.TipoContrato;

public interface TipoContratoService {

	List<TipoContrato> listaTipoContrato();
	public TipoContrato obtieneTipoContratoPorId(String id);
}
