package com.stansa.dao;

import java.util.List;

import com.stansa.domain.TipoContrato;

public interface TipoContratoDAO {

	List<TipoContrato> listaTipoContrato();
	public TipoContrato obtieneTipoContratoPorId(String id);
}
