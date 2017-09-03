package com.stansa.dao;

import java.util.List;

import com.stansa.domain.ConsumoDetalle;
import com.stansa.domain.ReporteTonerClienteConsultaModel;

public interface ConsumoDetalleDAO {

	public void insertarConsumoDetalle(ConsumoDetalle data);
	public void eliminarConsumoDetalle(int idConsumoDetalle, String idConsumo);
	public void modificarConsumoDetalle(ConsumoDetalle data);
	public List<ConsumoDetalle> obtenerConsumoDetallePorIdConsumo(String id);
	public ConsumoDetalle obtenerConsumoDetalle(String idSolPed,String idSolPedDetalle);
	public List<ConsumoDetalle> obtenerConsumoDetalleReporte(ReporteTonerClienteConsultaModel model);
}
