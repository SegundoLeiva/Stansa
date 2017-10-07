package com.stansa.service;

import com.stansa.domain.SerieProducto;

public interface SerieProductoService {

	public void insertarSerieProducto(SerieProducto data);
	public void modificarSerieProducto(SerieProducto data);
	public SerieProducto obtenerSerieProducto(String idMercaderia, String numeroSerie);
}
