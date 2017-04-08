package com.stansa.service;

import java.util.List;

import com.stansa.domain.MercaderiaDetalle;

public interface MercaderiaDetalleService {

	public List<MercaderiaDetalle> obtenerMercaderiaDetallePorIdMercaderia(String id);
	public List<MercaderiaDetalle> obtenerMercaderiaDetalleReporte(String idUnidadMinera,String anio,String mes);
}
