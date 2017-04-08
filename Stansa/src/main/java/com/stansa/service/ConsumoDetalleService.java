package com.stansa.service;

import java.util.List;

import com.stansa.domain.ConsumoDetalle;

public interface ConsumoDetalleService {

	public List<ConsumoDetalle> obtenerConsumoDetallePorIdConsumo(String id);
	public List<ConsumoDetalle> obtenerConsumoDetalleReporte(String idUnidadMinera,String anio,String mes);
}
