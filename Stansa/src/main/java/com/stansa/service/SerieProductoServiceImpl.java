package com.stansa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stansa.dao.SerieProductoDAO;
import com.stansa.domain.SerieProducto;

@Service
public class SerieProductoServiceImpl implements SerieProductoService {
    @Autowired
    public SerieProductoDAO serieProductoDAO;

	public void insertarSerieProducto(SerieProducto data) {
		// TODO Auto-generated method stub
		serieProductoDAO.insertarSerieProducto(data);
	}

	public void modificarSerieProducto(SerieProducto data) {
		// TODO Auto-generated method stub
		serieProductoDAO.modificarSerieProducto(data);
	}

	public SerieProducto obtenerSerieProducto(String idMercaderia, String numeroSerie) {
		// TODO Auto-generated method stub
		return serieProductoDAO.obtenerSerieProducto(idMercaderia, numeroSerie);
	}


}
