package com.stansa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stansa.dao.ConsumoDetalleDAO;
import com.stansa.domain.ConsumoDetalle;
import com.stansa.domain.ReporteTonerClienteConsultaModel;

@Service
public class ConsumoDetalleServiceImpl implements ConsumoDetalleService {

	@Autowired
    public ConsumoDetalleDAO consumoDetalleDAO;

	public List<ConsumoDetalle> obtenerConsumoDetallePorIdConsumo(String id) {
		// TODO Auto-generated method stub
		return consumoDetalleDAO.obtenerConsumoDetallePorIdConsumo(id);
	}

	public List<ConsumoDetalle> obtenerConsumoDetalleReporte(ReporteTonerClienteConsultaModel model) {
		// TODO Auto-generated method stub
		return consumoDetalleDAO.obtenerConsumoDetalleReporte(model);
	}

	public List<ConsumoDetalle> obtenerConsumoDetallePorCliente(
			ReporteTonerClienteConsultaModel model) {
		// TODO Auto-generated method stub
		return consumoDetalleDAO.obtenerConsumoDetallePorCliente(model);
	}

}

