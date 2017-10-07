package com.stansa.dao;

import com.stansa.domain.SerieProducto;

public interface SerieProductoDAO {

	public void insertarSerieProducto(SerieProducto data);
	public void modificarSerieProducto(SerieProducto data);
	public void eliminarSerieProducto(String idMercaderia, String numeroSerie);
	public SerieProducto obtenerSerieProducto(String idMercaderia, String numeroSerie);
}
