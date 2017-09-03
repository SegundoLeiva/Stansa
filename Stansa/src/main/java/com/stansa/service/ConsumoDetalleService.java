package com.stansa.service;

import java.util.List;

import com.stansa.domain.ConsumoDetalle;
import com.stansa.domain.ReporteTonerClienteConsultaModel;

public interface ConsumoDetalleService {

	public List<ConsumoDetalle> obtenerConsumoDetallePorIdConsumo(String id);
	public List<ConsumoDetalle> obtenerConsumoDetalleReporte(ReporteTonerClienteConsultaModel model);
}
